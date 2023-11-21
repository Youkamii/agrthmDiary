import java.util.Arrays;
import java.util.Scanner;

public class zeroSolutions {

	//두 수의 차
	public int solution1(int num1, int num2) {
		return num1 - num2;
	}

	//두 수의 곱
	public int solution2(int num1, int num2) {
		return num1 * num2;
	}

	// 몫 구하기
	public int solution3(int num1, int num2) {
		return num1 / num2;
	}

	//나이 출력
	public int solution4(int age) {
		return 2023 - age;
	}

	//숫자 비교하기
	public int solution5(int num1, int num2) {
		return (num1 == num2) ? 1 : -1;
	}

	// 두 수의 합
	public int solution6(int num1, int num2) {
		return num1 + num2;
	}

	//두 수의 나눗셈
	public int solution7(int num1, int num2) {
		return num1 * 1000 / num2;
	}

	//각도기
	public int solution8(int angle) {
		if (angle < 90)
			return 1;
		else if (angle == 90)
			return 2;
		else if (angle < 180)
			return 3;
		else
			return 4;
	}

	// 짝수의 합
	public static int solution9(int n) {
		int answer = 0;

		for (int i = 1; i <= n; i++){
			if (i % 2 == 0)
				answer += i;
		}

		return answer;
	}

	// 배열의 평균값
	public double solution10(int[] numbers) {
		double answer = 0;

		for(int i = 0; i < numbers.length; i++)
			answer += numbers[i];

		return answer/numbers.length;
	}

	public int solution(int[] numbers) {

		Arrays.sort(numbers);

		return numbers[numbers.length -1] * numbers[numbers.length -2];
	}


	// 특정 각도로 회전한 행렬의 행을 출력하는 함수
	public static void printRotated(int[][] matrix, int angle, int row) {
		int N = matrix.length;
		switch (angle) {
			case 90:
				for (int i = N - 1; i >= 0; i--) {
					System.out.print(matrix[i][row]);
				}
				break;
			case 180:
				for (int i = N - 1; i >= 0; i--) {
					System.out.print(matrix[N - 1 - row][i]);
				}
				break;
			case 270:
				for (int i = 0; i < N; i++) {
					System.out.print(matrix[i][N - 1 - row]);
				}
				break;
		}
	}

}
