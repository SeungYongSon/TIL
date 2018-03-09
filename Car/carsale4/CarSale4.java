package carsale4;
// 인스턴스 변수의 직접 접근
class CarDealer{
	String carName;
	final int PRICE;
	int inventory;
	int account = 0;
	
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


public class CarSale4 {
	public static void main(String[] args) {
		CarDealer dealer1 = new CarDealer("Grandeur", 3500, 10);
		CarDealer dealer2 = new CarDealer("Genesis", 5500, 5);
		
		CarBuyer buyer = new CarBuyer();
		
		// 로직 오류가 있는 코드들
		// 직접 인스턴스가 가지고 있는 필드 변수들을 접근해서 값을 바꿈.
		// 이는 메세지 패싱을 무시하고 짠 코드다. 결국 버그가 터지고 만다.
		// 아무튼 이런 경우를 대비해서 정보 은닉을 써야한다.
		buyer.money -= 1000;
		dealer1.account += 1000;
		buyer.owner = true;
		dealer1.inventory -= 3;
		
		dealer1.saleResult();
		dealer2.saleResult();
		
		buyer.buyResult();
	}
}
