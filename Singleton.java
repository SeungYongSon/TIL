/*
 * 싱글톤
 * 
 * 하나의 어플리케이션 내에서  단 한만 생성되는 객체
 * 디자인 패턴 중 한 종류
 * 
 * 만드는 방법
 * 1. 외부에서 new 연산자로 생성자를 호출할 수 업도록 막기
 * 	  - private 접근제한자를 생성자 앞에 붙인다.
 * 2. 클래스 자신의 타입으로 정적 필드 선언
 *    - 자신의 객체를 생성해 초기화
 *    - private 접근 제한자를 붙여 외부에서 필드 값 변경 못하게 막는다.
 * 3. 외부에서 호출할 수 있는 정적 메소드인 getInstance() 선언
 *    - 정적 필드에서 참조하고 있는 자신의 객체 리턴 시킨다.
 */

class SingletonTest{
	private static SingletonTest sgt = new SingletonTest(); // 자신의 타입인 정적 필드를 하나 선언, 자신의 객체를 생성해 초기화
	private int cnt = 0;
	private SingletonTest() {} // 외부에서 호출할 수 없음 -> 객체 생성은 단 한번
	
	public static SingletonTest getInstance() { // 객체로 접근하는 게 아니라 클래스로 접근해야 되므로 static
		return sgt;
	}
	
	public int getNextInt() {
		return cnt += 1;
	}
}

public class Singleton {

	public static void main(String[] args) {
		Singleton s = new Singleton();
		s.methodX();
		s.methodY();
	}
	
	public void methodX() {
		SingletonTest st = SingletonTest.getInstance();
		int count = st.getNextInt();
		System.out.println("메소드X 호출 뒤 " + count);
	}
	
	public void methodY() {
		SingletonTest st = SingletonTest.getInstance();
		int count = st.getNextInt();
		System.out.println("메소드Y 호출 뒤 " + count);
	}
}
