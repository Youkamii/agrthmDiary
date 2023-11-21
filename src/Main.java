import java.util.*;

// Shift을(를) 두 번 눌러 전체 검색 대화상자를 열고 'show whitespaces'를 입력한 다음,


// Enter를 누르세요. 그러면 코드 내에서 공백 문자를 확인할 수 있습니다.
public class Main {
	public static void main(String[] args) {
		// 캐럿을 강조 표시된 텍스트에 놓고 Alt+Enter을(를) 누르면
		// IntelliJ IDEA의 수정 제안을 볼 수 있습니다.


//		for (int i : Solutions.solution17(new int[]{6,4,3,2,1}))
//			System.out.println(i);
//
//		int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
//    	System.out.println(Solutions.solution27_1(triangle));
//		System.out.println(Solutions.solution29("EIO"));
//		int[] testArray = {95, 90, 99, 99, 80, 99};
//		int[] testArray2 = {1, 1, 1, 1, 1, 1};
//		int[] testArray3 = {93,30,55};
//		int[] testArray4 = {1,30,5};
//
//		int[] testArray5 = {1, 3, 4, 6};
//		String testString = "3141592";
//		String testString2 = "271";
//		System.out.println(Arrays.toString(Solutions.solution47(testArray, testArray2)));
//		System.out.println(Arrays.toString(Solutions.solution47(testArray3, testArray4)));
////
//		System.out.println(Solutions.solution47(testArray, testArray2));

//		int[][] result = Solutions.solution53(3);
//		for (int i = 0; i < result.length; i++) {
//			System.out.println(Arrays.toString(result[i]));
//	}
//		System.out.println(zeroSolutions.solution2(10));
		System.out.println("start");
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int[][] matrix = new int[N][N];

			// 행렬 입력 받기
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					matrix[i][j] = sc.nextInt();
				}
			}

			// 회전된 행렬 출력
			System.out.println("#" + test_case);
			for (int i = 0; i < N; i++) {
				zeroSolutions.printRotated(matrix, 90, i);
				System.out.print(" ");
				zeroSolutions.printRotated(matrix, 180, i);
				System.out.print(" ");
				zeroSolutions.printRotated(matrix, 270, i);
				System.out.println();
			}
		}
	}

}