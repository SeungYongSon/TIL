package carsale2;
// 객체지향은 현실세계를 반영한다.
class CarDealer{
	String carName;
	int PRICE; 
	/*
	CarSale1에서  있던 final int PRICE 가 Carsale2에서는 int PRICE 로 바뀜. 
	이는 자동차가 여러가지인 것을 현실 반영 한 것 이지만 현실에서는 자동차의 값은 계속 바뀌지 않음.(결국 final을 써야한다.) 
	다시말해 현실반영 실패. CarSale3 에서 단 한번만 값을 바꿀 수 있게 해결책이 있음. CarSale3 를 보자.
	*/
	int inventory;
	int account = 0;
	
	public void intMember(String carName, int price, int inventory) { // 현실 반영 부분
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

public class CarSale2 {
	public static void main(String[] args) {
		CarDealer dealer1 = new CarDealer();
		dealer1.intMember("Grandeur", 3500, 10); // 현실처럼 여러가지 차를 만듬.
		CarDealer dealer2 = new CarDealer();
		dealer2.intMember("Genesis", 5500, 5); // 현실처럼 여러가지 차를 만듬
		
		CarBuyer buyer = new CarBuyer();
		
		buyer.buyCar(dealer1, 3500);
		buyer.buyCar(dealer2, 5500);
		
		dealer1.saleResult();
		dealer2.saleResult();
		
		buyer.buyResult();
	}
}
