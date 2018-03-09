package carsale1;
// �޼��� �н� : Ŭ���� ���� ����� �޼����� ȣ��� �����Ѵ�.
// �� �� �����ϸ� ���� �ٸ� A, B Ŭ������ �ִٰ� �ϸ� A�� B�� ���� ���� �ϰ�ʹٸ� B������ �޼��带 ȣ�� �����μ� �����ϴ� �Ŵ�.
// �� �ڵ忡�� �� ���ư� �پ��� ���� ��� �� �� �ְ� ���Ǽ��踦 �ݿ��� ���̴�. CarSale2 �� ����.
class CarDealer {
	String carName = "Grandeur";
	final int PRICE = 3500;
	int inventory = 10;
	int account = 0;
	
	public boolean carSale(int money) {
		boolean receipt = false;
		account += money;
		inventory -= 1;
		receipt = true;
		return receipt;
	}
	
	public void saleResult() {
		System.out.println("���� ���� " + inventory + "�� �̸� �Ǹž��� " + account + "�����Դϴ�.");
	}
}

class CarBuyer{
	int money = 5000;
	boolean owner = false;
	
	public void buyCar(CarDealer dealer, int price) {
		owner = dealer.carSale(price);
		money -= price;
	}
	
	public void buyResult() {
		System.out.println("���� ���� �������´� " + owner + " �̸� ���� �� �ܾ��� " + money + " �����Դϴ�.");
	}
}

public class CarSale1{
	public static void main(String[] args) {
		CarDealer dealer = new CarDealer();
		CarBuyer buyer = new CarBuyer();
		
		// �޼��� ��� �κ�
		buyer.buyCar(dealer, 3500); // buyCar �̶�� �޼��带 ���� ���� ��� ��.
		dealer.saleResult(); // saleResult �޼��带 ���� ����� �����.
		buyer.buyResult(); // saleResult �޼��带 ���� ����� �����.
	}
}