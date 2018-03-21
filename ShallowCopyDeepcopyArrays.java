import java.util.Arrays;
// ���� ����, ���� ����
public class ShallowCopyDeepcopyArrays {

	public static void main(String[] args) {
		char[] arr = {'I', 'A', 'M', 'H', 'A', 'P', 'P', 'Y'};
		//System.out.println(Arrays.toString(arr));
		
		// ���� ���� - ������ ���� ������ �ּҸ� ��� ������ �����ϴ� ���̴�.
		// �ᱹ ���� ������ �����Ͱ� �ٲ�� ��� ������ �����͵� �ٲ�� �ȴ�.
		char[] arr1 = new char[arr.length];
		arr1 = arr;
		System.out.println(Arrays.toString(arr1));
		arr[0] = 'A';
		System.out.println(Arrays.toString(arr1));
		
		
		// ���� ���� - ���� ������ �����͸� �����Ͽ� ���  ������ ���Ӱ� �����ϴ� ���̴�.
		// ���� ������ �����Ͱ� �ٲ� ��� ������ �����ʹ� �ٲ��� �ʴ´�.
		
		//��� copyOf() ���
		char[] arr2 = Arrays.copyOf(arr, arr.length);
		arr2[0] = 'W'; 
		System.out.println(Arrays.toString(arr2));
		System.out.println(Arrays.toString(arr)); // arr �� ���� �ٲ��� �ʴ´�.
		// �ᱹ arr2 �� ���� ���縦 �ߴٴ� ���� �� �� �ִ�.
	
		
		//���2 copyOfRange() ���
		//���� ����
		char[] arr3 = Arrays.copyOfRange(arr, 1, 3);
		System.out.println(Arrays.toString(arr3));
		
		//���3 System.arraycopy() ���
		//��������
		char[] arr4 = new char[arr.length];
		System.arraycopy(arr, 0, arr4, 0, arr.length);
		
		for(int i = 0; i< arr4.length; i++) {
			System.out.println("arr4[" + i + "]=" + arr4[i]);
		}
	}
}
