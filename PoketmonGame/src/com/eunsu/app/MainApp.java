package com.eunsu.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.eunsu.service.InventoryServiceDAO;
import com.eunsu.service.PoketmonServiceDAO;
import com.eunsu.service.SkilServiceDAO;
import com.eunsu.vo.Poketmon;
import com.eunsu.vo.Skil;

public class MainApp {
	Scanner scn = new Scanner(System.in);
	PoketmonServiceDAO psd = new PoketmonServiceDAO();
	SkilServiceDAO ssd = new SkilServiceDAO();
	InventoryServiceDAO isd = new InventoryServiceDAO();
	List<Poketmon> list = new ArrayList<>();

	boolean run = true;
	boolean result = true;

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
				break;
			case 2:
				for (int i = 0; i < list.size(); i++) {
					if (list.get(i).getChoice() == 1) {
						System.out.println("--------------------------");
						System.out.println("포켓몬        타입         체력");
						System.out.println("--------------------------");
						System.out.printf("%s%9s%12dHp\n", list.get(i).getName(), list.get(i).getType(),
								list.get(i).getHp());
						System.out.println("--------------------------");
						System.out.println("1.자세히보기(이름 입력)  2.돌아가기");
						System.out.println("--------------------------");
						System.out.print("선택 >> ");
						String no = scn.nextLine();

						if (list.get(i).getName().equals(no)) {
							List<Skil> skils = ssd.poketmonSkil();
							for (int j = 0; j < skils.size(); j++) {
								System.out.println("---------------------------");
								System.out.println("포켓몬        스킬         데미지");
								System.out.println("---------------------------");
								// 파이리의 스킬 내역 불러오기
								System.out.printf("%s%9s%20d\n", list.get(i).getName(), list.get(i).getType(),
										skils.get(j).getDamage());
							}
						}
					}
				}
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
			case 6:
				break;
			default:
				System.out.println("1 ~ 6번까지 선택해주세요!!");
			}
		}
	} // execute

	public void fristMain() {
		list = psd.PoketmonList();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getChoice() == 1) {
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
			list = psd.PoketmonList(); 

			switch (selectPoketmon) {
			case 1:
				for (int i = 0; i < list.size(); i++) {
					if (list.get(i).getName().equals("파이리")) {
						if (psd.poketmonChoice("파이리")) {
							System.out.println("파이리로 결정되었습니다!");
							break;
						}
					}
				}
				break;
			case 2:
				for (int i = 0; i < list.size(); i++) {
					if (list.get(i).getName().equals("꼬부기")) {
						if (psd.poketmonChoice("꼬부기")) {
							System.out.println("꼬부기로 결정되었습니다!");
							break;
						}
					}
				}
				break;
			case 3:
				for (int i = 0; i < list.size(); i++) {
					if (list.get(i).getName().equals("피카츄")) {
						if (psd.poketmonChoice("피카츄")) {
							System.out.println("피카츄로 결정되었습니다!");
							break;
						}
					}
				}
				break;
			case 4:
				for (int i = 0; i < list.size(); i++) {
					if (list.get(i).getName().equals("이상해씨")) {
						if (psd.poketmonChoice("이상해씨")) {
							System.out.println("이상해씨로 결정되었습니다!");
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
	}
}
