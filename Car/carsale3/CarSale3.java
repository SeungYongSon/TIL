package carsale3;
// 생성자
//
// 이제 CarSale4 를 보자. 프로그램은 오류가 없지만 버그가 있다. 확인 해보자.
class CarDealer{
	String carName;
	final int PRICE; // final 을 다시 붙임. 아까 방법으로 값을 못 바꾸게 됨.
	int inventory;
	int account = 0;
	
	// 생성자를 통해 초기화 하므로 PRICE의 값을 한번만 바꿈. 이는 값이 안 바뀌게 현실반영에 성공함.
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

public class CarSale3 {
	public static void main(String[] args) {
		CarDealer dealer1 = new CarDealer("Grandeur", 3500, 10); // 인스턴스 시키면서 생성자를 통해 필드들을 초기화 시킴.
		CarDealer dealer2 = new CarDealer("Genesis", 5500, 5); // 인스턴스 시키면서 생성자를 통해 필드들을 초기화 시킴.
		
		CarBuyer buyer = new CarBuyer();
		
		buyer.buyCar(dealer1, 3500);
		buyer.buyCar(dealer2, 5500);
		
		dealer1.saleResult();
		dealer2.saleResult();
		
		buyer.buyResult();
	}
}
