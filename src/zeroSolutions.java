public class zeroSolutions {

	//두 수의 차
	public int solution1(int num1, int num2) {
		return num1 - num2;
	}

	//두 수의 곱
	public int solution(int num1, int num2) {
		return num1 * num2;
	}


	public static int solution2(int n) {
		int answer = 0;

		for (int i = 1; i <= n; i++){
			if (i % 2 == 0)
				answer += i;
		}

		return answer;
	}
}
