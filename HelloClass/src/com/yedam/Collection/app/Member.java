package com.yedam.Collection.app;

public class Member {
	// 필드
	private String memberId;
	private String memberName;
	private String phone;
	private int point;

	// 생성자.
	public Member(String memberId, String memberName, String phone, int point) {
		super();
		this.memberId = memberId;
		this.memberName = memberName;
		this.phone = phone;
		this.point = point;
	}
	
	// 이름, 연락처, 포인트 출력하는 메소드.
	public void showInfo () {
		System.out.printf("이름은 %s, 연락처는 %s, 포인트는 %d\n", memberName, phone, point);
	}

	// 메소드(getter, setter)
	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberName() {
		return memberName;
	} 

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}
}