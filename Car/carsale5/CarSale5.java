package carsale5;

// 정보 은닉
//
// private 를 통해 CarSale4 와 같이 인스턴스 변수를 통해 변수에 직접 접근하지 않게 막음.
// 대신 getter , setter 메서드를 통해 접근 할 수 있게 바꿈.
// 정보 은닉은 접근제어 와 캡슐화 대해 관련 있음.
class CarDealer{
	private String carName;
	private final int PRICE;
	private int inventory;
	private int account = 0;
	
	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	public int getInventory() {
		return inventory;
	}

	public void setInventory(int inventory) {
		this.inventory = inventory;
	}

	public int getAccount() {
		return account;
	}

	public void setAccount(int account) {
		this.account = account;
	}

	public int getPRICE() {
		return PRICE;
	}
	
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
		System.out.println("현재 재고는 " + inventory + " 대 이며 판매액은 " + account + " 만원 입니다.");
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
		System.out.println("현재 차량 소유 상태는 " + owner + " 이며 구매후 잔액은 " + money + " 만원 입니다.");
	}
}


public class CarSale5 {
	public static void main(String[] args) {
		CarDealer dealer1 = new CarDealer("Grandeur", 3500, 10);
		CarDealer dealer2 = new CarDealer("Genesis", 5500, 5);
		
		CarBuyer buyer = new CarBuyer();
		
		/*
		buyer.money -= 1000;
		dealer1.account += 1000;
		buyer.owner = true;
		dealer1.inventory -= 3;
		*/
		
		dealer1.saleResult();
		dealer2.saleResult();
		
		buyer.buyResult();
	}
}
