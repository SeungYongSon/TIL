/*
 * �̱���
 * 
 * �ϳ��� ���ø����̼� ������  �� �Ѹ� �����Ǵ� ��ü
 * ������ ���� �� �� ����
 * 
 * ����� ���
 * 1. �ܺο��� new �����ڷ� �����ڸ� ȣ���� �� ������ ����
 * 	  - private ���������ڸ� ������ �տ� ���δ�.
 * 2. Ŭ���� �ڽ��� Ÿ������ ���� �ʵ� ����
 *    - �ڽ��� ��ü�� ������ �ʱ�ȭ
 *    - private ���� �����ڸ� �ٿ� �ܺο��� �ʵ� �� ���� ���ϰ� ���´�.
 * 3. �ܺο��� ȣ���� �� �ִ� ���� �޼ҵ��� getInstance() ����
 *    - ���� �ʵ忡�� �����ϰ� �ִ� �ڽ��� ��ü ���� ��Ų��.
 */

class SingletonTest{
	private static SingletonTest sgt = new SingletonTest(); // �ڽ��� Ÿ���� ���� �ʵ带 �ϳ� ����, �ڽ��� ��ü�� ������ �ʱ�ȭ
	private int cnt = 0;
	private SingletonTest() {} // �ܺο��� ȣ���� �� ���� -> ��ü ������ �� �ѹ�
	
	public static SingletonTest getInstance() { // ��ü�� �����ϴ� �� �ƴ϶� Ŭ������ �����ؾ� �ǹǷ� static
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
		System.out.println("�޼ҵ�X ȣ�� �� " + count);
	}
	
	public void methodY() {
		SingletonTest st = SingletonTest.getInstance();
		int count = st.getNextInt();
		System.out.println("�޼ҵ�Y ȣ�� �� " + count);
	}
}
