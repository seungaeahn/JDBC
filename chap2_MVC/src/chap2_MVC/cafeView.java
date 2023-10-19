package chap2_MVC;

import java.util.Scanner;

public class cafeView {
	//cafeModel 이라는 클래스를 가지고 오기 위해 멤버변수로 카페 모델을 추가함 
	public cafeModel model;
	
	//model 매개변수를 받을 수 있는 생성자를 만들어줘야함
	public cafeView(cafeModel model) {
		this.model = model;
	}
//name, address, phone_number, operating_hours
	public void addCafeName() {
		Scanner sc = new Scanner(System.in);
		System.out.println("카페 정보를 입력하세요.");
		System.out.println("상호명 : ");
		String name = sc.nextLine();
		System.out.println("주소 : ");
		String address = sc.nextLine();
		System.out.println("연락처 : ");
		String phone_number = sc.nextLine();
		System.out.println("운영시간 : ");
		String operating_hours = sc.nextLine();
		
		//카페 모델에서 insertCafe() 라는 메서드를 가지고 와야 함!
		model.insertCafe(name, address, phone_number, operating_hours);
		System.out.println("카페가 성공적으로 추가되었습니다!");
		
	}

	public void updateMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("메뉴 설명을 업데이트하세요.");
		System.out.println("수정할 메뉴 설명 : ");
		String desription = sc.nextLine();
		System.out.println("메뉴 ID : ");
		int menu_id = sc.nextInt();
		System.out.println("카페 ID: ");
		int cafe_id = sc.nextInt();
		
		//model에 있는 updateMenu를 가지고 와서 사용자가 작성한 수정 내용 추가하기
		model.updateMenu(desription, menu_id, cafe_id);
		System.out.println("메뉴 설명이 성공적으로 업데이트되었습니다!");
	}
	
	public void updateCafe() {
		Scanner sc = new Scanner(System.in);
		System.out.println("카페 운영시간을 업데이트하세요.");
		System.out.println("수정할 운영시간 : ");
		String operating_hours = sc.nextLine();
		System.out.println("카페 ID: ");
		int cafe_id = sc.nextInt();
		
		model.updateCafe(cafe_id, operating_hours);
		System.out.println("카페 운영시간이 성공적으로 업데이트되었습니다!");
	}
	
	public void deleteCafe() {
		Scanner sc = new Scanner(System.in);
		System.out.println("카페를 삭제하겠습니다.");
		System.out.println("삭제할 카페의 아이디를 입력하세요.");
		int cafeId = Integer.parseInt(sc.nextLine());
		//int cafeId_other = sc.nextInt();
		
		model.deleteCafe(cafeId);
		System.out.println("카페가 삭제되었습니다.");
	}
	
	public void deleteMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("메뉴를 삭제하겠습니다.");
		System.out.println("삭제할 메뉴의 아이디를 입력하세요.");
		int menuId = Integer.parseInt(sc.nextLine());
		
		model.deleteCafe(menuId);
		System.out.println("메뉴가 삭제되었습니다.");
	}
}

