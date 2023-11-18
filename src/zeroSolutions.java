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
	public double solution(int[] numbers) {
		double answer = 0;

		for(int i = 0; i < numbers.length; i++)
			answer += numbers[i];

		return answer/numbers.length;
	}
}
