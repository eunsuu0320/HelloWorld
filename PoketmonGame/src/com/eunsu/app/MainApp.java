package com.eunsu.app;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.eunsu.service.InventoryServiceDAO;
import com.eunsu.service.PoketmonServiceDAO;
import com.eunsu.service.SkilServiceDAO;
import com.eunsu.vo.Inventory;
import com.eunsu.vo.Poketmon;
import com.eunsu.vo.Skil;

public class MainApp {
	Scanner scn = new Scanner(System.in);
	PoketmonServiceDAO psd = new PoketmonServiceDAO();
	SkilServiceDAO ssd = new SkilServiceDAO();
	InventoryServiceDAO isd = new InventoryServiceDAO();

	List<Poketmon> poketmon = new ArrayList<>();
	List<Inventory> inven = isd.invenSelect();
	List<Skil> skils = ssd.poketmonSkil();

	Inventory inventory = new Inventory(inven.get(0).getPoketball(), inven.get(0).getSnack(), inven.get(0).getStar(),
			inven.get(0).getMoney());

	boolean run = true;

	public void execute() {
		fristMain();

		while (run) {
			System.out.println("----------------------------------------------------------------------------------");
			System.out.println("1.가방 2.포켓몬 3.상점 4.여행떠나기 5.새로 시작하기 6.게임종료(자동저장) 7.(체육관관장만나기(추후시간남으면))");
			System.out.println("----------------------------------------------------------------------------------");
			System.out.print("선택 >> ");
			int selectNo = Integer.parseInt(scn.nextLine());

			switch (selectNo) {
			case 1:
				System.out.println("-------------------------");
				System.out.println("포켓볼    스낵    별      코인");
				System.out.println("-------------------------");
				inven = isd.invenSelect();
				System.out.printf("%d개 %5d개 %4d개 %7dG\n\n", inventory.getPoketball(), inventory.getSnack(),
						inventory.getStar(), inventory.getMoney());
				break;
			case 2:
				myPoketmon();
				break;
			case 3:
				store();
				break;
			case 4:
				travel();
				break;
			case 5:
				reset();
				break;
			case 6:
				isd.plusInven(inventory);
				run = false;
				break;
			default:
				System.out.printf("1 ~ 6번까지 선택해주세요!!\n\n");
			}
		}
		System.out.println("게임을 종료합니다.");
	} // execute

	// 처음 시작 화면
	public void fristMain() {
		boolean result = true;
		poketmon = psd.PoketmonList();
		for (int i = 0; i < poketmon.size(); i++) {
			if (poketmon.get(i).getChoice() == 1) {
				result = false;
			}
		}
		if (result) {
			System.out.println("-------------------------------");
			System.out.println("환영합니다! 시작 포켓몬을 선택해 주세요.");
			System.out.println("1.파이리 2.꼬부기 3.피카츄 4.이상해씨");
			System.out.println("-------------------------------");
			System.out.print("선택 >> ");
			int selectPoketmon = Integer.parseInt(scn.nextLine());
			poketmon = psd.PoketmonList();

			switch (selectPoketmon) {
			case 1:
				startPack("파이리");
				break;
			case 2:
				startPack("꼬부기");
				break;
			case 3:
				startPack("피카츄");
				break;
			case 4:
				startPack("이상해씨");
				break;
			default:
				System.out.println("1 ~ 4번만 선택하세요!");
				break;
			}
		}
	} // firstMain

	// 첫 포켓몬 선택 시 스타터팩
	public void startPack(String name) {
		for (int i = 0; i < poketmon.size(); i++) {
			if (poketmon.get(i).getName().equals(name)) {
				if (psd.poketmonChoice(name)) {
					System.out.printf("%s로 결정되었습니다!\n", name);
					inventory.setMoney(500);
					inventory.setPoketball(5);
					System.out.printf("스타터로 포켓볼 5개, 500코인을 획득했습니다!\n\n");
					break;
				}
			}
		} // for
	}

	// 내 포켓몬 조회
	public void myPoketmonSelect() {
		System.out.println("------------------------------");
		System.out.println("포켓몬         타입          체력");
		System.out.println("------------------------------");

		poketmon = psd.PoketmonList();
		for (int i = 0; i < poketmon.size(); i++) {
			if (poketmon.get(i).getChoice() == 1) {
				System.out.printf("%s%10s%13dHp\n", poketmon.get(i).getName(), poketmon.get(i).getType(),
						poketmon.get(i).getHp());
			}
		}
	}

	// 내 포켓몬 스킬 조회
	public void skilSelect(String name) {
		for (int i = 0; i < poketmon.size(); i++) {
			if (poketmon.get(i).getName().equals(name)) {
				skils = ssd.poketmonSkil();
				System.out.println("---------------------------");
				System.out.println("포켓몬        스킬        데미지");
				System.out.println("---------------------------");
				for (int j = 0; j < skils.size(); j++) {
					// 스킬 내역 불러오기
					if (poketmon.get(i).getSkil1().equals(skils.get(j).getSkilName())
							|| poketmon.get(i).getSkil2().equals(skils.get(j).getSkilName())
							|| poketmon.get(i).getSkil3().equals(skils.get(j).getSkilName())) {
						System.out.printf("%s%10s%10d\n", poketmon.get(i).getName(), skils.get(j).getSkilName(),
								skils.get(j).getDamage());
					}
				} // j for
			}
		} // i for
	}

	// 내 포켓몬 조회 및 세부 기능들
	public void myPoketmon() {
		while (true) {
			myPoketmonSelect();

			System.out.println();
			System.out.println("--------------------------------------");
			System.out.println("1.자세히보기(이름 입력)  2.간식주기  3.돌아가기");
			System.out.println("--------------------------------------");
			System.out.print("선택 >> ");
			String no = scn.nextLine();

			try {
				if (Integer.parseInt(no) == 2) {
					System.out.print("간식을 줄 포켓몬을 입력하세요. >> ");
					String pName = scn.nextLine();

					for (int i = 0; i < poketmon.size(); i++) {
						if (poketmon.get(i).getName().equals(pName)) {
							if (inventory.getSnack() != 0) {
								if (poketmon.get(i).getHp() >= 100) {
									System.out.printf("%s의 체력이 가득차있습니다!", poketmon.get(i).getName());
								} else {
									inventory.setSnack(inventory.getSnack() - 1);
									psd.changeHp(poketmon.get(i).getHp() + 30, poketmon.get(i).getName());
									isd.plusInven(inventory);
									System.out.printf("\n ••• ヾ(•ω•`)o\n %s에게 간식을 먹였습니다! 체력이 30 증가하였습니다!\n",
											poketmon.get(i).getName());
								}
								break;
							} else {
								System.out.println("보유하고 있는 스낵이 없습니다!");
							}
						}
					}
				} else if (Integer.parseInt(no) == 3) {
					break;
				}
			} catch (Exception e) {
				for (int i = 0; i < poketmon.size(); i++) {
					skilSelect(no);
				} // i for
			}
			System.out.println();
		}
	} // myPoketmonSelect

	// 상점
	public void store() {
		while (true) {
			System.out.println("-----------------------------------------------");
			System.out.println("            구매하려는 아이템을 선택해주세요.            ");
			System.out.println("   1.포켓볼 100G  2.스낵 50G  3.별 500G  4.돌아가기   ");
			System.out.println("-----------------------------------------------");
			System.out.print("선택 >> ");
			int no = Integer.parseInt(scn.nextLine());
			if (no == 4) {
				break;
			} else {
				System.out.print("구매할 수량을 입력하세요 >> ");
				int count = Integer.parseInt(scn.nextLine());

				if (no == 1) {
					if (inventory.getMoney() == 0 || inventory.getMoney() < count * 100) {
						System.out.printf("코인이 부족하거나 없습니다!\n\n");
					} else {
						inventory.setPoketball(inventory.getPoketball() + count);
						inventory.setMoney(inventory.getMoney() - (count * 100));
						System.out.printf("성공적으로 구매하였습니다!\n\n");
					}
				} else if (no == 2) {
					if (inventory.getMoney() == 0 || inventory.getMoney() < count * 50) {
						System.out.printf("코인이 부족하거나 없습니다!\n\n");
					} else {
						inventory.setSnack(inventory.getSnack() + count);
						inventory.setMoney(inventory.getMoney() - (count * 50));
						System.out.printf("성공적으로 구매하였습니다!\n\n");
					}

				} else if (no == 3) {
					if (inventory.getMoney() == 0 || inventory.getMoney() < count * 500) {
						System.out.printf("코인이 부족하거나 없습니다!\n\n");
					} else {
						inventory.setStar(inventory.getStar() + count);
						inventory.setMoney(inventory.getMoney() - (count * 500));
						System.out.printf("성공적으로 구매하였습니다!\n\n");
					}
				} else {
					System.out.println("1 ~ 4 까지의 숫자를 입력해주세요!");
				}
			}
		}
	} // store

	// 여행 떠나기
	public void travel() {
		Poketmon pcPoketmon = new Poketmon();
		Poketmon myPoketmon = new Poketmon();

		for (int i = 0; i < poketmon.size(); i++) {
			int random = (int) (Math.random() * (poketmon.size()));
			pcPoketmon = poketmon.get(random);
		}

		try {
			Thread.sleep(600);
			System.out.printf("•  ");
			Thread.sleep(600);
			System.out.printf("•  ");
			Thread.sleep(600);
			System.out.printf("•  \n");

			System.out.println("----------------");
			delay("야생의 " + pcPoketmon.getName() + " 등장!!\n");

			System.out.println("----------------");
			System.out.println("1.싸우기  2.도망가기");
			System.out.println("----------------");
			System.out.print("선택 >> ");
			int no = Integer.parseInt(scn.nextLine());

			switch (no) {
			case 1:
				myPoketmonSelect();
				System.out.println("-------------------------------------");
				System.out.print("전장에 나갈 포켓몬을 이름을 입력하세요!! >> ");
				String myPoName = scn.nextLine();
				for (int i = 0; i < poketmon.size(); i++) {
					if (poketmon.get(i).getChoice() == 1 && poketmon.get(i).getName().equals(myPoName)) {
						myPoketmon = poketmon.get(i);
					}
				}

				while (true) {
					System.out.println("-----------------------------");
					System.out.printf("%s와 %s는 싸우기 시작했다!\n", pcPoketmon.getName(), myPoketmon.getName());
					System.out.println("-----------------------------");
					System.out.printf("%25s\n%25dHp\n\n %5s\n%5dHp\n", pcPoketmon.getName(), pcPoketmon.getHp(),
							myPoketmon.getName(), myPoketmon.getHp());
					System.out.println("-----------------------------");

					System.out.println("내 차례!");
					System.out.println("1.스킬쓰기 2.잡기");
					int sOc = Integer.parseInt(scn.nextLine());
					
					switch (sOc) {
					case 1:
						skilSelect(myPoName);
						System.out.printf("스킬을 입력해!! >> ");
						String skName = scn.nextLine();
						for (int i = 0; i < skils.size(); i++) {
							if (skils.get(i).getSkilName().equals(skName)) {
								pcPoketmon.setHp(pcPoketmon.getHp() - skils.get(i).getDamage());
								delay("\n" + pcPoketmon.getName() + "이(가) " + skils.get(i).getDamage()
										+ "Hp 만큼 데미지를 입었다!!\n");
							}
						}
						break;
					case 2:
						delay("나는 포켓볼을 이용해 포획을 시도했다 !!");		
						if (inventory.getPoketball() != 0) {
							int persent = (int) (Math.random() * 10) + 1;
							if (persent >= 4) {
								inventory.setPoketball(inventory.getPoketball() - 1);
								// 잡았을 때 포켓볼 1개 삭제 했고, 그 포켓몬 choice를 1로 변경은 해야함, 처음 화면으로 돌아가기도 했다.
								delay("포획 성공!! 넌 내꺼야!");
								execute();
								break;
							} else {
								delay("포획에 실패했다 ..");	
								break;
							}
						} else if (inventory.getPoketball() <= 0) {
							delay("포켓볼이 없어서 잡을 수 없어!!");
							break;
						}
						
					}
					System.out.println("------------");
					System.out.printf("%s 차례!!\n", pcPoketmon.getName());
					System.out.println();
					delay("•••••\n");
					System.out.println();
					while (true) {
						int ran = (int) (Math.random() * skils.size());
						if (skils.get(ran).getSkilName().equals(pcPoketmon.getSkil1())
								|| skils.get(ran).getSkilName().equals(pcPoketmon.getSkil2())
								|| skils.get(ran).getSkilName().equals(pcPoketmon.getSkil3())) {
							delay(pcPoketmon.getName() + "이(가) " + skils.get(ran).getSkilName() + "를 사용했다!!\n");
							myPoketmon.setHp(myPoketmon.getHp() - skils.get(ran).getDamage());
							delay(myPoketmon.getName() + "이(가) " + skils.get(ran).getDamage() + "Hp 만큼 데미지를 입었다!!\n\n");
							break;
						}
					}
					if (pcPoketmon.getHp() <= 0) {
						System.out.println("싸움에서 승리했다 !!");
					    int num = (int) (Math.random() * 100) + 1;
					    inventory.setMoney(inventory.getMoney() + num);
						System.out.printf("%dG의 코인을 획득했다!\n", num);
						break;
					} else if (myPoketmon.getHp() <= 0) {
						System.out.println("싸움에서 패배했다 ..");
						int num = (int) (Math.random() * 100) + 1;
					    inventory.setMoney(inventory.getMoney() - num);
						System.out.printf("%dG의 코인을 잃었다 ..\n", num);
						break;
					}
				} // while
				break;
			case 2:
				break;
			default:
				System.out.println("1번과 2번 중에서 선택하세요 !!");
			}

		} catch (

		InterruptedException e) {
			e.printStackTrace();
		}

	}

	// 초기화
	public void reset() {
		while (true) {
			System.out.println("-------------------");
			System.out.println("정말 처음부터 하시겠습니까?");
			System.out.println("    1.네  2.아니요    ");
			System.out.println("-------------------");
			System.out.print("선택 >> ");
			int no = Integer.parseInt(scn.nextLine());
			if (no == 1) {
				inventory = new Inventory(0, 0, 0, 0);
				isd.plusInven(inventory);
				psd.choiceRemove();
				for (int i = 0; i < poketmon.size(); i++) {
					psd.changeHp(100, poketmon.get(i).getName());
				}
				System.out.printf("성공적으로 초기화 하였습니다. 처음 화면으로 돌아갑니다.\n\n");
				fristMain();
				break;
			} else if (no == 2) {
				System.out.printf("계속해서 게임을 즐기세요!\n\n");
				break;
			} else {
				System.out.printf("1번과 2번 중에서 선택 해주세요.\n\n");
				continue;
			}
		}
	} // reset;

	// 딜레이
	public void delay(String str) {
		for (int i = 0; i < str.length(); i++) {
			try {
				Thread.sleep(100);
				System.out.print(str.charAt(i));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
