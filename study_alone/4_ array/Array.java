import java.util.Arrays;
import java.util.Scanner;

public class Array {
	public static void main(String[] args) {
		/**
		 * 문제: 배열의 용도와 배열을 선언하는 방법에 대해서 작성해보시오.
		 * 아래 코드에서 배열의 생성이 틀린 것을 찾아보시오.
		 * 이 문제는 배열의 개념과 역할 그리고 배열을 사용하기 위해 선언하는 방법에 대해서 아는지를 묻는 문제이다.
		 * 
		 * 답변: 배열은 여러개의 연속된 데이터를 메모리에 나열해서 저장하는 것을 말한다.
		 * 연속된 데이터를 저장해야하기 때문에 일일히 선언을 해줄 필요가 없다,
		 * 그리고 밑의 예제 전부 다 정상적인 코드다.
		 */
		int[] sales_table = new int[100];
		int sales_table2[] = new int[100];
		int[] sales_table3;
		sales_table3 = new int[100];
		int sales_table4[];
		sales_table4 = new int[100];

		System.out.println(sales_table);
		System.out.println(sales_table2);
		System.out.println(sales_table3);
		System.out.println(sales_table4);

		/**
		 * 문제: 배열과 인덱스의 관계에 대해서 설명하고 배열의 초깃값은 어떻게 세팅되는지 말해보시오.
		 * 크기 10의 정수형 배열을 생성하고 인덱스로 배열 공간의 값을 출력해보시오.
		 * 이 문제는 JAVA의 배열 및 인덱스 사용법 그리고 배열 생성시 초깃값이 어떻게 정해지는지를 묻는 문제이다.
		 * 
		 * 답변: 예제 코드에서의 배열의 초기값은 0으로 세팅되는 것을 확인했다.
		 * 배열의 인덱스는 배열의 몇번째 위치에 있는지에 대한 것을 이야기한다.
		 */
		int[] scores = new int[10];

		System.out.println(scores[0]);
		System.out.println(scores[9]);
		System.out.println(sales_table[10]);
		
		/**
		 * 문제: 배열 요소에 데이터 값을 넣으려면 어떻게 해야하는지 작성해보시오.
		 * 이 문제는 배열을 생성한 후에 데이터 값을 입력하는 방법에 대해서 아는지를 묻는 문제이다.
		 * 
		 * 답변: 선언한 배열에 자료형에 맞는 값을 할당해야 한다.
		 */
		scores[0] = 3;
		scores[1] = 11;
		scores[2] = 22;
		scores[3] = 33;
		scores[4] = 44;
		scores[5] = 44;

		System.out.println(scores[0]);
		System.out.println(scores[1]);
		System.out.println(scores[2]);
		System.out.println(scores[3]);
		System.out.println(scores[4]);
		System.out.println(scores[5]);

		/**
		 * 문제: 크기 5의 정수형 배열을 선언하고 55, 88, 60, 100, 90으로 각 요소의 값을 초기화하시오.
		 * 이 문제는 배열 선언과 동시에 특정 값으로 초기화 할 수 있는지를 묻는 문제이다.
		 * 이때, 2가지 방식으로 초기화를 할 수 있는데 모두 작성해보시오.
		 * 아래 코드중 틀린 것을 찾아 말해보시오.
		 * 
		 * 답변: 아래 두개의 코드가 선언과 동시에 배열에 값을 할당하는 코드다.
		 */
		int[] arr = { 55, 88, 60, 100, 90 };
		int[] arr2 = new int[] { 55, 88, 60, 100, 90 };
		
		System.out.println(arr);
		System.out.println(arr2);
		// 이 방식의 경우 new int[]와 같이 선언해줘야 함.
		// int[] arr3;
		// arr3 = { 55, 88, 60, 100, 90 };

		/**
		 * 문제: 배열 요소의 값을 반복문을 사용하여 모두 출력하시오.
		 * 이 문제는 배열 원소의 값을 for문과 같은 반복문을 사용하여 출력할 수 있는지를 묻는 문제이다.
		 * 
		 * 답변: 아래 코드 참고
		 */
		int[] sale = { 33, 52, 93, 100, 87 };
		for (int idx = 0; idx < sale.length; idx++) {
			System.out.print(sale[idx]);
			System.out.print(' ');
		}
		System.out.println();

		/**
		 * 문제: 크기 5의 정수형과 실수형 배열을 생성하고 각각의 주소 값을 출력해보시오.
		 * 주소 값은 다른 말로 참조 값이라고도 한다.
		 * 이 문제는 배열 변수에 들어있는 값이 참조형 타입인지에 대해서 알고 있는지를 묻는 문제이다.
		 * 
		 * 답변: 아래 코드의 두 변수를 출력하면 메모리 주소가 출력된다.
		 * 메모리 주소를 찾아가면 그 값에 대한 정보를 출력할 수 있다.
		 */
		int[] array = { 1, 2, 3, 4, 5 };
		double[] array2 = { 1.1, 2.2, 3.3, 4.4, 5.5 };

		System.out.println(array);
		System.out.println(array2);

		/**
		 * 문제: 배열의 값들을 for문과 같은 반복문을 사용하지 않고 한꺼번에 출력하는 코드를 작성하시오.
		 * 이 문제는 반복문이 아닌 메서드로 배열의 요소 값들을 출력하는 방법에 대해서 아는지를 묻는 문제이다.
		 * 
		 * 답변: java.util.Arrays 패키지에 toString() 메서드를 사용하면 메서드로 출력할 수 있다.
		 */
		int[] ARR = { 238, 382, 491, 229, 943, 254, 843 };
		System.out.println(Arrays.toString(ARR));

		/**
		 * 문제: 다음중 다중 배열의 선언으로 맞는 것을 골라보시오.
		 * 이 문제는 배열 선언을 여러 개 해야하는 경우 한줄에 모두 선언하고 만들 수 있는지를 묻는 문제이다.
		 * 
		 * 답변: 밑의 세개 모두 선언이 되는 코드이다.
		 */
		// int[] a, b, c;
		// int d[], e[], f[];
		// int g[], h, i;

		/**
		 * 문제: 배열을 복사하는 메서드를 말해보고 관련된 예제 코드를 구현해보시오.
		 * 이 문제는 배열 복사시 사용하는 메서드명과 사용법에 대해서 알고 있는지를 묻는 문제이다.
		 * 
		 * 답변: System.arraycopy를 사용하면 됨.
		 * 매개변수로는 원본, 원본에서 복사를 시작할 위치, 복사본, 복사본에서 복사를 시작할 위치, 얼마만큼 복사를 할지 결정
		 * 이렇게 5가지이다.
		 */
		int[] ar = { 1, 2, 3, 4, 5 };
		int[] ar2 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		
		// System.arraycopy( ar, 2, ar2, 4, 3 ); // [1, 2, 3, 4, 3, 4, 5, 8, 9, 10]
		System.arraycopy(ar, 0, ar2, 4, 3); // [1, 2, 3, 4, 1, 2, 3, 8, 9, 10]
		System.out.println(Arrays.toString(ar));
		System.out.println(Arrays.toString(ar2));

		/**
		 * 문제: 사용자의 입력을 받아 2차원 배열을 생성하고 값을 입력하는 코드를 구현하시오.
		 * 이때 중첩 반복문을 사용하여 출력도 같이 해보시오.
		 * 이 문제는 배열의 생성시 사용자로부터 입력을 받아서 2차원 배열을 만들 수 있는지를 묻는 문제이다.
		 * 
		 * 답변: 
		 */
		// 사용자의 입력을 받는 변수 할당
		Scanner sc = new Scanner(System.in);
		System.out.print("행의 갯수를 입력하고 [Enter] 치세요 = ");
		int row = sc.nextInt(); // 행 입력
		System.out.print("열의 갯수를 입력하고 [Enter] 치세요 = ");
		int col = sc.nextInt(); // 열 입력
		
		// 입력받고 출력할 2차원 배열
		char[][] gameMap = new char[row][col];
		// 입력받을 문자열 저장 (row만큼 공간이 필요.)
		String[] inpuStrings = new String[row];
		
		for (int rowIdx = 0; rowIdx < row; rowIdx++) {
			System.out.println( (rowIdx + 1) + "번째 행에 입력할 문자 " + col + "개를 입력하고 [Enter] 치세요 = ");
			inpuStrings[rowIdx] = sc.next(); // 문자열 입력
			for (int colIdx = 0; colIdx < col; colIdx++) {
				// 2차원 배열에 입력받은 문자열을 문자 하나하나 쪼개서 입력함.
				gameMap[rowIdx][colIdx] = inpuStrings[rowIdx].charAt(colIdx);
			}
		}
		sc.close();
		
		System.out.println();
		System.out.println("------------------------------");
		for (int rowIdx = 0; rowIdx < row; rowIdx++) {
			for (int colIdx = 0; colIdx < col; colIdx++) {
				System.out.print(gameMap[rowIdx][colIdx]);
			}
			System.out.println();
		}
		System.out.println("------------------------------");
	}
}