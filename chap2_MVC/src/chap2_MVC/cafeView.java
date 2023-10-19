package chap2_MVC;

import java.util.Scanner;

public class cafeView {
	//cafeModel �̶�� Ŭ������ ������ ���� ���� ��������� ī�� ���� �߰��� 
	public cafeModel model;
	
	//model �Ű������� ���� �� �ִ� �����ڸ� ����������
	public cafeView(cafeModel model) {
		this.model = model;
	}
//name, address, phone_number, operating_hours
	public void addCafeName() {
		Scanner sc = new Scanner(System.in);
		System.out.println("ī�� ������ �Է��ϼ���.");
		System.out.println("��ȣ�� : ");
		String name = sc.nextLine();
		System.out.println("�ּ� : ");
		String address = sc.nextLine();
		System.out.println("����ó : ");
		String phone_number = sc.nextLine();
		System.out.println("��ð� : ");
		String operating_hours = sc.nextLine();
		
		//ī�� �𵨿��� insertCafe() ��� �޼��带 ������ �;� ��!
		model.insertCafe(name, address, phone_number, operating_hours);
		System.out.println("ī�䰡 ���������� �߰��Ǿ����ϴ�!");
		
	}

	public void updateMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("�޴� ������ ������Ʈ�ϼ���.");
		System.out.println("������ �޴� ���� : ");
		String desription = sc.nextLine();
		System.out.println("�޴� ID : ");
		int menu_id = sc.nextInt();
		System.out.println("ī�� ID: ");
		int cafe_id = sc.nextInt();
		
		//model�� �ִ� updateMenu�� ������ �ͼ� ����ڰ� �ۼ��� ���� ���� �߰��ϱ�
		model.updateMenu(desription, menu_id, cafe_id);
		System.out.println("�޴� ������ ���������� ������Ʈ�Ǿ����ϴ�!");
	}
	
	public void updateCafe() {
		Scanner sc = new Scanner(System.in);
		System.out.println("ī�� ��ð��� ������Ʈ�ϼ���.");
		System.out.println("������ ��ð� : ");
		String operating_hours = sc.nextLine();
		System.out.println("ī�� ID: ");
		int cafe_id = sc.nextInt();
		
		model.updateCafe(cafe_id, operating_hours);
		System.out.println("ī�� ��ð��� ���������� ������Ʈ�Ǿ����ϴ�!");
	}
	
	public void deleteCafe() {
		Scanner sc = new Scanner(System.in);
		System.out.println("ī�並 �����ϰڽ��ϴ�.");
		System.out.println("������ ī���� ���̵� �Է��ϼ���.");
		int cafeId = Integer.parseInt(sc.nextLine());
		//int cafeId_other = sc.nextInt();
		
		model.deleteCafe(cafeId);
		System.out.println("ī�䰡 �����Ǿ����ϴ�.");
	}
	
	public void deleteMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("�޴��� �����ϰڽ��ϴ�.");
		System.out.println("������ �޴��� ���̵� �Է��ϼ���.");
		int menuId = Integer.parseInt(sc.nextLine());
		
		model.deleteCafe(menuId);
		System.out.println("�޴��� �����Ǿ����ϴ�.");
	}
}

