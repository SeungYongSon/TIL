import java.util.Arrays;
// 깊은 복사, 얕은 복사
public class ShallowCopyDeepcopyArrays {

	public static void main(String[] args) {
		char[] arr = {'I', 'A', 'M', 'H', 'A', 'P', 'P', 'Y'};
		//System.out.println(Arrays.toString(arr));
		
		// 얕은 복사 - 복사할 원본 변수의 주소를 대상 변수에 복사하는 것이다.
		// 결국 원본 변수의 데이터가 바뀌면 대상 변수의 데이터도 바뀌게 된다.
		char[] arr1 = new char[arr.length];
		arr1 = arr;
		System.out.println(Arrays.toString(arr1));
		arr[0] = 'A';
		System.out.println(Arrays.toString(arr1));
		
		
		// 깊은 복사 - 원본 변수의 데이터를 복사하여 대상  변수에 새롭게 생성하는 것이다.
		// 원본 변수의 데이터가 바뀌어도 대상 변수의 데이터는 바뀌지 않는다.
		
		//방법 copyOf() 사용
		char[] arr2 = Arrays.copyOf(arr, arr.length);
		arr2[0] = 'W'; 
		System.out.println(Arrays.toString(arr2));
		System.out.println(Arrays.toString(arr)); // arr 의 값은 바뀌지 않는다.
		// 결국 arr2 는 깊은 복사를 했다는 것을 알 수 있다.
	
		
		//방법2 copyOfRange() 사용
		//깊은 복사
		char[] arr3 = Arrays.copyOfRange(arr, 1, 3);
		System.out.println(Arrays.toString(arr3));
		
		//방법3 System.arraycopy() 사용
		//깊은복사
		char[] arr4 = new char[arr.length];
		System.arraycopy(arr, 0, arr4, 0, arr.length);
		
		for(int i = 0; i< arr4.length; i++) {
			System.out.println("arr4[" + i + "]=" + arr4[i]);
		}
	}
}
