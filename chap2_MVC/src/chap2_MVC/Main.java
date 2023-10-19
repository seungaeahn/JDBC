package chap2_MVC;

public class Main {
	
	public static void main(String[] args) {
		cafeModel model = new cafeModel();
		cafeView view = new cafeView(model);
		//controller
		cafeController controller = new cafeController(model, view);
		
		//view.addCafeName();
		//view.updateMenu();
		//view.updateCafe();
		//view.deleteCafe();
		view.deleteMenu();
		
		
		
	}

}
