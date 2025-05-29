package com.eunsu.app;

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
	List<Inventory> inven = new ArrayList<>();
	List<Skil> skils = ssd.poketmonSkil();

	boolean run = true;

	public void execute() {
		fristMain();

		while (run) {
			System.out.println("---------------------------------------------------------------------------");
			System.out.println("1.가방 2.포켓몬 3.상점 4.여행떠나기 5.새로 시작하기 6.게임종료 7.(체육관관장만나기(추후시간남으면))");
			System.out.println("---------------------------------------------------------------------------");
			System.out.print("선택 >> ");
			int selectNo = Integer.parseInt(scn.nextLine());

			switch (selectNo) {
			case 1:
				System.out.println("-------------------------");
				System.out.println("포켓볼    스낵    별      코인");
				System.out.println("-------------------------");
				inven = isd.invenSelect();
				for (int i = 0; i < inven.size(); i++) {
					System.out.printf("%d개 %5d개 %4d개 %7dG\n\n", inven.get(i).getPoketball(), inven.get(i).getSnack(),
							inven.get(i).getStar(), inven.get(i).getMoney());
				}
				break;
			case 2:
				myPoketmonSelect();
				break;
			case 3:
				store();
				break;
			case 4:
				break;
			case 5:
				reset();
				break;
			case 6:
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
				for (int i = 0; i < poketmon.size(); i++) {
					if (poketmon.get(i).getName().equals("파이리")) {
						if (psd.poketmonChoice("파이리")) {
							System.out.println("파이리로 결정되었습니다!");
							Inventory in = new Inventory(5, 0, 0, 500);
							isd.plusInven(in);
							System.out.printf("스타터로 포켓볼 5개, 500코인을 획득했습니다!\n\n");
							break;
						}
					}
				} // for
				break;
			case 2:
				for (int i = 0; i < poketmon.size(); i++) {
					if (poketmon.get(i).getName().equals("꼬부기")) {
						if (psd.poketmonChoice("꼬부기")) {
							System.out.println("꼬부기로 결정되었습니다!");
							Inventory in = new Inventory(5, 0, 0, 500);
							isd.plusInven(in);
							System.out.printf("스타터로 포켓볼 5개, 500코인을 획득했습니다!\n\n");
							break;
						}
					}
				}
				break;
			case 3:
				for (int i = 0; i < poketmon.size(); i++) {
					if (poketmon.get(i).getName().equals("피카츄")) {
						if (psd.poketmonChoice("피카츄")) {
							System.out.println("피카츄로 결정되었습니다!");
							Inventory in = new Inventory(5, 0, 0, 500);
							isd.plusInven(in);
							System.out.printf("스타터로 포켓볼 5개, 500코인을 획득했습니다!\n\n");
							break;
						}
					}
				}
				break;
			case 4:
				for (int i = 0; i < poketmon.size(); i++) {
					if (poketmon.get(i).getName().equals("이상해씨")) {
						if (psd.poketmonChoice("이상해씨")) {
							System.out.println("이상해씨로 결정되었습니다!");
							Inventory in = new Inventory(5, 0, 0, 500);
							isd.plusInven(in);
							System.out.printf("스타터로 포켓볼 5개, 500코인을 획득했습니다!\n\n");
							break;
						}
					}
				}
				break;
			default:
				System.out.println("1 ~ 4번만 선택하세요!");
				break;
			}
		}
	} // firstMain

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
		} // i for
		
		System.out.println();
		System.out.println("--------------------------------------");
		System.out.println("1.자세히보기(이름 입력)  2.간식주기  3.돌아가기");
		System.out.println("--------------------------------------");
		System.out.print("선택 >> ");
		String no = scn.nextLine();

		for (int i = 0; i < poketmon.size(); i++) {
			if (poketmon.get(i).getName().equals(no)) {
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
		if (Integer.parseInt(no) == 2)

		{
			System.out.println("---------------------------");
			System.out.println("간식을 줄 포켓몬을 입력하세요.");
			System.out.println("---------------------------");
		} else if (Integer.parseInt(no) == 3) {

		}

		System.out.println();
	} // myPoketmonSelect

	// 상점
	public void store() {
		System.out.println("-----------------------------------------------");
		System.out.println("            구매하려는 아이템을 선택해주세요.            ");
		System.out.println("   1.포켓볼 100G  2.스낵 50G  3.별 500G  4.돌아가기   ");
		System.out.println("-----------------------------------------------");
		System.out.print("선택 >> ");
		int no = Integer.parseInt(scn.nextLine());
		System.out.print("구매할 수량을 입력하세요 >> ");
		int count = Integer.parseInt(scn.nextLine());

		inven = isd.invenSelect();
		if (no == 1) {
			Inventory in = new Inventory();

			for (int i = 0; i < inven.size(); i++) {
				int pkb = inven.get(i).getPoketball();
				int sk = inven.get(i).getSnack();
				int st = inven.get(i).getStar();
				int mon = inven.get(i).getMoney();
				if (inven.get(i).getMoney() == 0 || inven.get(i).getMoney() < count * 100) {
					System.out.println("코인이 부족합니다!");
				} else {
					in.setPoketball(pkb + count);
					in.setSnack(sk);
					in.setStar(st);
					in.setMoney(mon - (count * 100));
					isd.plusInven(in);
					System.out.println("성공적으로 구매하였습니다!");
				}
			}
		} else if (no == 2) {
			Inventory in = new Inventory();

			for (int i = 0; i < inven.size(); i++) {
				int pkb = inven.get(i).getPoketball();
				int sk = inven.get(i).getSnack();
				int st = inven.get(i).getStar();
				int mon = inven.get(i).getMoney();
				if (inven.get(i).getMoney() == 0 || inven.get(i).getMoney() < count * 100) {
				} else {
					in.setPoketball(pkb);
					in.setSnack(sk + count);
					in.setStar(st);
					in.setMoney(mon - (count * 50));
					isd.plusInven(in);
					System.out.println("성공적으로 구매하였습니다!");
				}
			}
		} else if (no == 3) {
			Inventory in = new Inventory();

			for (int i = 0; i < inven.size(); i++) {
				int pkb = inven.get(i).getPoketball();
				int sk = inven.get(i).getSnack();
				int st = inven.get(i).getStar();
				int mon = inven.get(i).getMoney();
				if (inven.get(i).getMoney() == 0 || inven.get(i).getMoney() < count * 100) {
				} else {
					in.setPoketball(pkb);
					in.setSnack(sk);
					in.setStar(st + count);
					in.setMoney(mon - (count * 500));
					isd.plusInven(in);
					System.out.println("성공적으로 구매하였습니다!");
				}
			}
		} else if (no == 4) {

		} else {
			System.out.println("1 ~ 3 까지의 숫자를 입력해주세요!");
		}
	} // store

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
				Inventory in = new Inventory(0, 0, 0, 0);
				isd.plusInven(in);
				psd.choiceRemove();
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
}
