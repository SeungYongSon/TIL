package carsale2;
// ��ü������ ���Ǽ��踦 �ݿ��Ѵ�.
class CarDealer{
	String carName;
	int PRICE; 
	/*
	CarSale1����  �ִ� final int PRICE �� Carsale2������ int PRICE �� �ٲ�. 
	�̴� �ڵ����� ���������� ���� ���� �ݿ� �� �� ������ ���ǿ����� �ڵ����� ���� ��� �ٲ��� ����.(�ᱹ final�� ����Ѵ�.) 
	�ٽø��� ���ǹݿ� ����. CarSale3 ���� �� �ѹ��� ���� �ٲ� �� �ְ� �ذ�å�� ����. CarSale3 �� ����.
	*/
	int inventory;
	int account = 0;
	
	public void intMember(String carName, int price, int inventory) { // ���� �ݿ� �κ�
		this.carName = carName;
		this.PRICE = price;
		this.inventory = inventory;
	}
	
	public boolean carSale(int money) {
		boolean receipt = false;
		account += money;
		inventory -= 1;
		receipt = true;
		return receipt;
	}
	
	public void saleResult() {
		System.out.println("���� ���� " + inventory + " �� �̸� �Ǹž��� " + account + " ���� �Դϴ�.");
	}
}

class CarBuyer{
	int money = 15000;
	boolean owner = false;
	
	public void buyCar(CarDealer dealer, int price) {
		owner = dealer.carSale(price);
		money -= price;
	}
	
	public void buyResult() {
		System.out.println("���� ���� ���� ���´� " + owner + " �̸� ������ �ܾ��� " + money + " ���� �Դϴ�.");
	}
}

public class CarSale2 {
	public static void main(String[] args) {
		CarDealer dealer1 = new CarDealer();
		dealer1.intMember("Grandeur", 3500, 10); // ����ó�� �������� ���� ����.
		CarDealer dealer2 = new CarDealer();
		dealer2.intMember("Genesis", 5500, 5); // ����ó�� �������� ���� ����
		
		CarBuyer buyer = new CarBuyer();
		
		buyer.buyCar(dealer1, 3500);
		buyer.buyCar(dealer2, 5500);
		
		dealer1.saleResult();
		dealer2.saleResult();
		
		buyer.buyResult();
	}
}
