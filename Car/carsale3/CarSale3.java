package carsale3;
// ������
//
// ���� CarSale4 �� ����. ���α׷��� ������ ������ ���װ� �ִ�. Ȯ�� �غ���.
class CarDealer{
	String carName;
	final int PRICE; // final �� �ٽ� ����. �Ʊ� ������� ���� �� �ٲٰ� ��.
	int inventory;
	int account = 0;
	
	// �����ڸ� ���� �ʱ�ȭ �ϹǷ� PRICE�� ���� �ѹ��� �ٲ�. �̴� ���� �� �ٲ�� ���ǹݿ��� ������.
	public CarDealer(String carName, int price, int inventory) { 
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

public class CarSale3 {
	public static void main(String[] args) {
		CarDealer dealer1 = new CarDealer("Grandeur", 3500, 10); // �ν��Ͻ� ��Ű�鼭 �����ڸ� ���� �ʵ���� �ʱ�ȭ ��Ŵ.
		CarDealer dealer2 = new CarDealer("Genesis", 5500, 5); // �ν��Ͻ� ��Ű�鼭 �����ڸ� ���� �ʵ���� �ʱ�ȭ ��Ŵ.
		
		CarBuyer buyer = new CarBuyer();
		
		buyer.buyCar(dealer1, 3500);
		buyer.buyCar(dealer2, 5500);
		
		dealer1.saleResult();
		dealer2.saleResult();
		
		buyer.buyResult();
	}
}
