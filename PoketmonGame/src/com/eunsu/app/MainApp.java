package com.eunsu.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.eunsu.service.InventoryServiceDAO;
import com.eunsu.service.PoketmonServiceDAO;
import com.eunsu.service.SkilServiceDAO;
import com.eunsu.service.UserInventoryServiceDAO;
import com.eunsu.service.UserPoketmonServiceDAO;
import com.eunsu.service.UsersServiceDAO;
import com.eunsu.vo.Inventory;
import com.eunsu.vo.Poketmon;
import com.eunsu.vo.Skil;
import com.eunsu.vo.UserInventory;
import com.eunsu.vo.UserPoketmon;
import com.eunsu.vo.Users;

public class MainApp {
	Scanner scn = new Scanner(System.in);
	PoketmonServiceDAO psd = new PoketmonServiceDAO();
	SkilServiceDAO ssd = new SkilServiceDAO();
	InventoryServiceDAO isd = new InventoryServiceDAO();
	UsersServiceDAO usd = new UsersServiceDAO();
	UserInventoryServiceDAO uisd = new UserInventoryServiceDAO();
	UserPoketmonServiceDAO upsd = new UserPoketmonServiceDAO();

	List<Poketmon> poketmon = new ArrayList<>();
	List<Inventory> inven = isd.invenSelect();
	List<Skil> skils = ssd.poketmonSkil();
	List<Users> users = new ArrayList<>();
	List<UserPoketmon> uPokets = new ArrayList<>();

	Users loginUser; // 현재 로그인한 유저 정보
	Inventory inventory = new Inventory(inven.get(0).getPoketball(), inven.get(0).getSnack(), inven.get(0).getStar(),
			inven.get(0).getMoney());

	boolean run = true;
	boolean result = false;

	public void execute() {
		users();

		fristMain();

		while (true) {
			System.out.println("----------------------------------------------------------");
			System.out.println(" 1.가방 2.포켓몬 3.상점 4.여행떠나기 5.새로 시작하기 6.로그아웃 7.게임종료 ");
			System.out.println("----------------------------------------------------------");
			System.out.print("선택 >> ");
			int selectNo = tryCatch(scn.nextLine());

			if (selectNo == 0) {
				continue;
			}

			switch (selectNo) {
			case 1:
				System.out.println("---------------------------");
				System.out.println(" 포켓볼    스낵   스타      코인");
				System.out.println("---------------------------");
				inven = isd.invenSelect();
				System.out.printf("%2d개 %5d개 %4d개 %7dG\n\n", inventory.getPoketball(), inventory.getSnack(),
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
				result = false;
				isd.plusInven(inventory);
				// 여기에 user의 진행 사항을 아이디 맞는 곳에 저장하는 코드 작성해야함.
				poketmon = psd.PoketmonList();
				uPokets = upsd.uPoketSelect(loginUser.getId());

				for (int i = 0; i < poketmon.size(); i++) {
					if (poketmon.get(i).getChoice() == 1) {
						for (UserPoketmon uPok : uPokets) {
							if (uPok.getPoketmonName().equals(poketmon.get(i).getName())) {
								UserPoketmon uPoket = new UserPoketmon();
								uPoket.setId(loginUser.getId());
								uPoket.setPoketmonName(poketmon.get(i).getName());
								uPoket.setHp(poketmon.get(i).getHp());
								upsd.uPoketUpdate(uPoket);
								result = true;
								break;
							}
						}
						if (!result) {
							UserPoketmon uPoket = new UserPoketmon();
							uPoket.setId(loginUser.getId());
							uPoket.setPoketmonName(poketmon.get(i).getName());
							uPoket.setHp(poketmon.get(i).getHp());
							upsd.uPoketInsert(uPoket); // 저장 서비스 호출
						}
					}
				}
				UserInventory userInven = new UserInventory();
				userInven.setId(loginUser.getId());
				userInven.setMyPoketball(inventory.getPoketball());
				userInven.setMySnack(inventory.getSnack());
				userInven.setMyStar(inventory.getStar());
				userInven.setMyMoney(inventory.getMoney());
				uisd.userInventoryInsert(userInven);

				psd.choiceRemove();

				inventory.setPoketball(0);
				inventory.setSnack(0);
				inventory.setStar(0);
				inventory.setMoney(0);
				isd.plusInven(inventory);
				System.out.printf("로그아웃 합니다.\n\n");
				execute();
				return;
			case 7:
				isd.plusInven(inventory);
				// 여기에 user의 진행 사항을 아이디 맞는 곳에 저장하는 코드 작성해야함.
				System.out.println("프로그램을 종료합니다. 진행 사항은 저장됩니다.");
				System.exit(0);
			default:
				System.out.printf("1 ~ 6번까지 선택해주세요!!\n\n");
			}
		}
	} // execute

	// 실행 화면
	public void users() {
//		if ()
		while (run) {
			System.out.println("-----------------------------------------------");
			System.out.println(" 1.로그인  2.회원가입  3.아이디찾기  4.비밀번호찾기  5.종료 ");
			System.out.println("-----------------------------------------------");
			System.out.print("선택헤주세요. >> ");
			int no = tryCatch(scn.nextLine());

			if (no == 0) {
				continue;
			}

			switch (no) {
			case 1:
				result = false;

				System.out.print("아이디를 입력해주세요. >> ");
				String id = scn.nextLine();

				System.out.print("비밀번호를 입력해주세요. >> ");
				String password = scn.nextLine();

				users = usd.userSelect();

				for (int i = 0; i < users.size(); i++) {
					if (users.get(i).getId().equals(id) && users.get(i).getPassword().equals(password)) {
						loginUser = users.get(i); // 로그인한 유저 정보 저장
						System.out.printf("%s님, 게임을 시작합니다!\n", users.get(i).getName());
						result = true;
						return;
					}
				}
				if (!result) {
					System.out.println("아이디 또는 비밀번호가 일치하지 않습니다!");
				}
				break;
			case 2:
				System.out.print("아이디를 입력해주세요. >> ");
				id = scn.nextLine();

				System.out.print("비밀번호를 입력해주세요. >> ");
				password = scn.nextLine();

				System.out.print("이름을 입력해주세요. >> ");
				String name = scn.nextLine();

				System.out.print("전화번호를 '-' 포함하여 입력해주세요. >> ");
				String phone = scn.nextLine();

				Users user = new Users();
				user.setId(id);
				user.setPassword(password);
				user.setName(name);
				user.setPhone(phone);

				if (usd.insertUser(user)) {
					System.out.println("회원가입에 성공하였습니다!");
				} else {
					System.out.println("올바른 입력값을 넣어주세요!");
					break;
				}
				break;
			case 3:
				result = false;
				users = usd.userSelect();

				System.out.print("찾으려는 아이디의 이름을 입력해주세요. >> ");
				name = scn.nextLine();

				for (int i = 0; i < users.size(); i++) {
					if (users.get(i).getName().equals(name)) {
						System.out.print("찾으려는 아이디의 전화번호를 '-' 포함하여 입력해주세요. >> ");
						phone = scn.nextLine();
						if (users.get(i).getPhone().equals(phone)) {
							System.out.printf("찾으시는 아이디는 %s 입니다.", users.get(i).getId());
							result = true;
						} else {
							System.out.println("전화번호가 일치하지 않습니다.");
							result = true;
						}
					}
				}

				if (!result) {
					System.out.println("일치하는 이름이 없습니다!");
				}

				break;
			case 4:
				result = false;
				users = usd.userSelect();

				System.out.print("찾으려는 비밀번호의 아이디를 입력해주세요. >> ");
				id = scn.nextLine();

				for (int i = 0; i < users.size(); i++) {
					if (users.get(i).getId().equals(id)) {
						System.out.print("찾으려는 비밀번호의 이름을 입력해주세요. >> ");
						name = scn.nextLine();
						if (users.get(i).getName().equals(name)) {
							System.out.print("찾으려는 비밀번호의 전화번호를 '-' 포함하여 입력해주세요. >> ");
							phone = scn.nextLine();
							if (users.get(i).getPhone().equals(phone)) {
								System.out.printf("찾으시는 비밀번호는 %s 입니다. 로그인 후 비밀번호를 변경해 주세요.",
										users.get(i).getPassword());
								result = true;
							} else {
								System.out.println("전화번호가 일치하지 않습니다.");
								result = true;
							}
						} else {
							System.out.println("이름이 일치하지 않습니다.");
							result = true;
						}
					}
				}

				if (!result) {
					System.out.println("일치하는 아이디가 없습니다.");
				}

				break;
			case 5:
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
				break;
			}
		}
	} // users

	// 게임 시작 화면
	public void fristMain() {
		boolean result = true;

		poketmon = psd.PoketmonList();

		for (int i = 0; i < poketmon.size(); i++) {
			if (poketmon.get(i).getChoice() == 1) {
				result = false;
			}
		}

		if (result) {
			while (true) {
				System.out.println("-------------------------------");
				System.out.println("환영합니다! 시작 포켓몬을 선택해 주세요.");
				System.out.println("1.파이리 2.꼬부기 3.피카츄 4.이상해씨");
				System.out.println("-------------------------------");
				System.out.print("선택 >> ");
				int selectPoketmon = tryCatch(scn.nextLine());

				if (selectPoketmon == 0) {
					continue;
				}
				poketmon = psd.PoketmonList();

				switch (selectPoketmon) {
				case 1:
					startPack("파이리");
					return;
				case 2:
					startPack("꼬부기");
					return;
				case 3:
					startPack("피카츄");
					return;
				case 4:
					startPack("이상해씨");
					return;
				default:
					System.out.println("1 ~ 4번만 선택하세요!");
					break;
				}
			}
		}
	} // firstMain

	// 첫 포켓몬 선택 시 스타터팩
	public void startPack(String name) {
		for (int i = 0; i < poketmon.size(); i++) {
			if (poketmon.get(i).getName().equals(name)) {
				if (psd.poketmonChoice(name)) {
					System.out.printf("%s로 결정되었습니다!\n", name);
					inventory.setPoketball(5);
					inventory.setStar(1);
					inventory.setMoney(500);
					System.out.printf("스타터로 포켓볼 5개, 스타 1개, 500코인을 획득했습니다!\n\n");
					isd.plusInven(inventory);
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
			if (poketmon.get(i).getChoice() == 1) {
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
							result = true;
						}
					} // j for
					break;
				}
			}
		} // i for
		if (!result) {
			System.out.printf("\n%s은(는) 내 포켓몬이 아닙니다!\n\n", name);
		}
	} // skilSelect

	// 내 포켓몬 조회 및 세부 기능들
	public void myPoketmon() {
		result = false;
		boolean holy = true;
		while (holy) {
			myPoketmonSelect();

			System.out.println();
			System.out.println("--------------------------------------");
			System.out.println(" 1.자세히보기  2.간식주기  3.별주기  4.돌아가기 ");
			System.out.println("--------------------------------------");
			System.out.print("선택 >> ");
			int no = tryCatch(scn.nextLine());

			if (no == 0) {
				continue;
			}

			switch (no) {
			case 1:
				System.out.print("자세히 볼 포켓몬을 입력하세요. >> ");
				skilSelect(scn.nextLine());
				break;
			case 2:
				result = false;

				System.out.print("간식을 줄 포켓몬을 입력하세요. >> ");
				String pName = scn.nextLine();

				for (int i = 0; i < poketmon.size(); i++) {
					if (poketmon.get(i).getChoice() == 1) {
						if (poketmon.get(i).getName().equals(pName)) {
							if (inventory.getSnack() != 0) {
								if (poketmon.get(i).getHp() >= 100) {
									delay(poketmon.get(i).getName() + "의 체력이 가득차있습니다!\n\n");
									result = true;
								} else if (poketmon.get(i).getHp() <= 0) {
									delay(poketmon.get(i).getName() + "의 체력이 바닥나 간식을 먹일 수 없습니다! 스타를 주세요!\n\n");
									result = true;
								} else {
									inventory.setSnack(inventory.getSnack() - 1);
									if ((poketmon.get(i).getHp() + 30) > 100) {
										psd.changeHp(100, poketmon.get(i).getName());
									} else {
										psd.changeHp(poketmon.get(i).getHp() + 30, poketmon.get(i).getName());
									}
									isd.plusInven(inventory);
									delay("\n • • •   ヾ(•ω•`)o\n " + poketmon.get(i).getName()
											+ "에게 간식을 먹였습니다! 체력이 30 증가하였습니다!\n");
									result = true;
								}
								break;
							} else {
								System.out.println("보유하고 있는 스낵이 없습니다!");
								result = true;
								break;
							}
						}
					}
				}
				if (!result) {
					System.out.printf("\n%s은(는) 내 포켓몬이 아닙니다!\n", pName);
				}
				break;
			case 3:
				result = false;
				System.out.print("별을 줄 포켓몬을 입력하세요. >> ");
				String starPoketmon = scn.nextLine();

				for (int i = 0; i < poketmon.size(); i++) {
					if (poketmon.get(i).getChoice() == 1) {
						if (poketmon.get(i).getName().equals(starPoketmon)) {
							if (poketmon.get(i).getHp() == 0) {
								if (inventory.getStar() != 0) {
									inventory.setStar(inventory.getStar() - 1);
									psd.changeHp(100, poketmon.get(i).getName());
									delay("\n  • • •   ヾ(•ω•`)o " + poketmon.get(i).getName() + " 부활 !!\n\n");
									isd.plusInven(inventory);
									result = true;
								} else {
									delay("~(>_<。)＼ 가지고 있는 별이 없습니다...\n");
									result = true;
									break;
								}
							} else if (poketmon.get(i).getHp() == 100) {
								delay("체력이 가득차있습니다!!\n");
								result = true;
								break;
							} else if (poketmon.get(i).getHp() > 0) {
								delay("체력회복이 가능합니다! 간식을 먹여주세요!!\n");
								result = true;
								break;
							}
						}
					}
				} // for
				if (!result) {
					System.out.printf("\n%s은(는) 내 포켓몬이 아닙니다!\n", starPoketmon);
				}
				break;
			case 4:
				holy = false;
				break;
			}
			System.out.println();
		}
	} // myPoketmonSelect

	// 상점 chatGPT 버전
	public void store() {
		while (true) {
			System.out.println("-----------------------------------------------");
			System.out.println("            구매하려는 아이템을 선택해주세요.            ");
			System.out.println("   1.포켓볼 100G  2.스낵 20G  3.별 300G  4.돌아가기   ");
			System.out.println("-----------------------------------------------");
			System.out.print("선택 >> ");
			int no = tryCatch(scn.nextLine());
			if (no == 0)
				continue;
			if (no == 4)
				break;
			if (no < 1 || no > 4) {
				System.out.println("1 ~ 4까지의 숫자를 입력해주세요!");
				continue;
			}

			System.out.print("구매할 수량을 입력하세요 >> ");
			int count;
			try {
				count = Integer.parseInt(scn.nextLine());
				if (count < 1 || count > 10) {
					System.out.println("한 번에 1개에서 10개까지만 구입할 수 있습니다!");
					continue;
				}
			} catch (NumberFormatException e) {
				System.out.println("숫자를 입력해주세요! (1~10 사이)");
				continue;
			}

			int price = switch (no) {
			case 1 -> 100;
			case 2 -> 20;
			case 3 -> 300;
			default -> 0;
			};

			if (inventory.getMoney() < price * count) {
				System.out.println("코인이 부족하거나 없습니다!\n");
				continue;
			}

			// 아이템 지급
			switch (no) {
			case 1 -> inventory.setPoketball(inventory.getPoketball() + count);
			case 2 -> inventory.setSnack(inventory.getSnack() + count);
			case 3 -> inventory.setStar(inventory.getStar() + count);
			}

			inventory.setMoney(inventory.getMoney() - price * count);
			System.out.println("성공적으로 구매하였습니다!\n");
		}

		isd.plusInven(inventory);
	}

	// 여행 떠나기 chatGPT 버전
	public void travel() {
		Poketmon pcPoketmon;
		while (true) {
			pcPoketmon = poketmon.get((int) (Math.random() * poketmon.size()));
			if (pcPoketmon.getChoice() != 1) {
				break;
			}
		}

		delay("\n•  •  •  •  •  •\n");

		delay(pcPoketmon.getType().equals("전설")
				? "---------------------------------\n(っ °Д °;)っ 전설의 포켓몬 " + pcPoketmon.getName() + " 등장 !!!!\n"
				: "----------------\n야생의 " + pcPoketmon.getName() + " 등장!!\n");

		int choice;
		while (true) {
			System.out.println("----------------\n1.싸우기  2.도망가기\n----------------");
			System.out.print("선택 >> ");
			choice = tryCatch(scn.nextLine());
			if (choice == 1 || choice == 2)
				break;
		}

		if (choice == 2 && (int) (Math.random() * 10) < 6) {
			delay("휴... 다행히 도망쳤다.\n\n");
			return;
		} else if (choice == 2) {
			delay("도망치지 못했다! 싸울 수 밖에!!\n\n");
		}

		Poketmon myPoketmon;
		while (true) {
			myPoketmonSelect();
			System.out.print("전장에 나갈 포켓몬의 이름을 입력하세요!! >> ");
			String name = scn.nextLine();
			myPoketmon = poketmon.stream().filter(p -> p.getChoice() == 1 && p.getName().equals(name)).findFirst()
					.orElse(null);
			if (myPoketmon == null) {
				System.out.println("\n내 포켓몬 중에서 선택해야해 !!\n");
			} else if (myPoketmon.getHp() == 0) {
				System.out.printf("%s는 체력이 없어서 싸울 수 없어!!\n", myPoketmon.getName());
			} else {
				break;
			}
		}

		System.out.printf("-----------------------------\n%s와 %s는 싸우기 시작했다!\n-----------------------------\n",
				pcPoketmon.getName(), myPoketmon.getName());

		while (true) {
			System.out.printf("%25s\n%25dHp\n\n %5s\n%5dHp\n-----------------------------\n", pcPoketmon.getName(),
					pcPoketmon.getHp(), myPoketmon.getName(), myPoketmon.getHp());

			System.out.println("내 차례!\n1.스킬쓰기 2.잡기");
			System.out.print("선택 >> ");
			int action = tryCatch(scn.nextLine());

			if (action == 1) {
				Skil chosen = null;
				while (true) {
					skilSelect(myPoketmon.getName());
					System.out.print("스킬을 입력해!! >> ");
					String skName = scn.nextLine();
					chosen = skils.stream().filter(s -> s.getSkilName().equals(skName)).findFirst().orElse(null);
					if (chosen != null)
						break;
					System.out.println("그런 스킬은 없어 !!!!");
				}

				double multi = vsDouble(myPoketmon.getType(), pcPoketmon.getType());
				int dmg = (int) (chosen.getDamage() * multi);
				pcPoketmon.setHp(pcPoketmon.getHp() - dmg);

				if (multi == 0.7)
					delay("효과는 별로였다...\n");
				else if (multi == 1.4)
					delay("효과는 굉장했다!!!\n");

				delay(pcPoketmon.getName() + "은(는) " + dmg + "Hp 만큼 데미지를 입었다!\n");

				if (pcPoketmon.getHp() <= 0) {
					delay("\n싸움에서 승리했다 !!\n");
					int coin = (int) (Math.random() * 301) + 150;
					inventory.setMoney(inventory.getMoney() + coin);
					System.out.printf("%dG의 코인을 획득했다!\n\n", coin);
					psd.changeHp(100, pcPoketmon.getName());
					psd.changeHp(myPoketmon.getHp(), myPoketmon.getName());
					isd.plusInven(inventory);
					break;
				}

			} else if (action == 2) {
				delay("나는 포켓볼을 이용해 포획을 시도했다 !!\n");

				if (inventory.getPoketball() <= 0) {
					delay("포켓볼이 없어서 잡을 수 없어!!\n");
				} else {
					inventory.setPoketball(inventory.getPoketball() - 1);
					int chance = (int) (Math.random() * 10) + 1;
					boolean success = (pcPoketmon.getType().equals("전설") && chance <= 2)
							|| (pcPoketmon.getHp() <= 30 && chance <= 6) || chance <= 4;

					if (success) {
						delay("포획 성공!! 넌 내꺼야!\n");
						psd.poketmonChoice(pcPoketmon.getName());
						psd.changeHp(pcPoketmon.getHp(), pcPoketmon.getName());
						psd.changeHp(myPoketmon.getHp(), myPoketmon.getName());
						int coin = (int) (Math.random() * 301) + 150;
						inventory.setMoney(inventory.getMoney() + coin);
						System.out.printf("%dG의 코인을 획득했다!\n\n", coin);
						isd.plusInven(inventory);
						run = false;
						execute();
						break;
					} else {
						delay("포획에 실패했다 ..\n");
					}
				}
			}

			// 적 턴
			System.out.println("------------\n" + pcPoketmon.getName() + " 차례!!");
			delay("\n•••••\n\n");

			Skil skill;
			while (true) {
				skill = skils.get((int) (Math.random() * skils.size()));
				if (skill.getSkilName().equals(pcPoketmon.getSkil1())
						|| skill.getSkilName().equals(pcPoketmon.getSkil2())
						|| skill.getSkilName().equals(pcPoketmon.getSkil3()))
					break;
			}

			delay(pcPoketmon.getName() + "이(가) " + skill.getSkilName() + "를 사용했다!!\n");
			double multi = vsDouble(pcPoketmon.getType(), myPoketmon.getType());
			int dmg = (int) (skill.getDamage() * multi);
			myPoketmon.setHp(myPoketmon.getHp() - dmg);

			if (multi == 0.7)
				delay("효과는 별로였다...\n");
			else if (multi == 1.4)
				delay("효과는 굉장했다!!!\n");

			delay(myPoketmon.getName() + "은(는) " + dmg + "Hp 만큼 데미지를 입었다!\n");

			if (myPoketmon.getHp() <= 0) {
				delay("\n싸움에서 패배했다 ..\n");
				int penalty = (int) (Math.random() * 101) + 1;
				if ((inventory.getMoney() - penalty) <= 0) {
					delay("더 이상 잃을 코인이 없어 ...\n");
					break;
				}
				inventory.setMoney(inventory.getMoney() - penalty);
				psd.changeHp(0, myPoketmon.getName());
				System.out.printf("%dG의 코인을 잃었다 ..\n\n", penalty);
				break;
			}
		}
	}

	// 상성
	public double vsDouble(String type1, String type2) {
		if (type1.equals("불")) {
			if (type2.equals("불") || type2.equals("물")) {
				return 0.7;
			} else if (type2.equals("풀")) {
				return 1.4;
			} else if (type2.equals("전기") || type2.equals("전설")) {
				return 1;
			}
		} else if (type1.equals("물")) {
			if (type2.equals("물") || type2.equals("풀")) {
				return 0.7;
			} else if (type2.equals("불")) {
				return 1.4;
			} else if (type2.equals("전기") || type2.equals("전설")) {
				return 1;
			}
		} else if (type1.equals("풀")) {
			if (type2.equals("풀") || type2.equals("불")) {
				return 0.7;
			} else if (type2.equals("물")) {
				return 1.4;
			} else if (type2.equals("전기") || type2.equals("전설")) {
				return 1;
			}
		} else if (type1.equals("전기")) {
			if (type2.equals("전기") || type2.equals("풀")) {
				return 0.7;
			} else if (type2.equals("물")) {
				return 1.4;
			} else if (type2.equals("불") || type2.equals("전설")) {
				return 1;
			}
		} else if (type1.equals("전설")) {
			if (type2.equals("전기") || type2.equals("불") || type2.equals("물") || type2.equals("풀")
					|| type2.equals("전설")) {
				return 1;
			}
		}
		return 0;
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

	// tryCatch
	public int tryCatch(String next) {
		int no;
		try {
			no = Integer.parseInt(next);
			return no;
		} catch (NumberFormatException e) {
			System.out.println("올바른 번호를 입력하세요!");
			return 0;
		}
	}
}
