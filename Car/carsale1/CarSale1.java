package carsale1;
// 메세지 패싱 : 클래스 간의 관계는 메서드의 호출로 제한한다.
// 좀 더 설명하면 서로 다른 A, B 클래스가 있다고 하면 A가 B에 대해 접근 하고싶다면 B에대한 메서드를 호출 함으로서 접근하는 거다.
// 이 코드에서 더 나아가 다양한 차를 사고 팔 수 있게 현실세계를 반영할 것이다. CarSale2 를 보자.
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
		System.out.println("현재 재고는 " + inventory + "대 이며 판매액은 " + account + "만원입니다.");
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
		System.out.println("현재 차량 소유상태는 " + owner + " 이며 구매 후 잔약은 " + money + " 만원입니다.");
	}
}

public class CarSale1{
	public static void main(String[] args) {
		CarDealer dealer = new CarDealer();
		CarBuyer buyer = new CarBuyer();
		
		// 메세지 페싱 부분
		buyer.buyCar(dealer, 3500); // buyCar 이라는 메서드를 통해 차를 사고 팜.
		dealer.saleResult(); // saleResult 메서드를 통해 결과를 출력함.
		buyer.buyResult(); // saleResult 메서드를 통해 결과를 출력함.
	}
}