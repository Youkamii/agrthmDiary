import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;
import java.util.*;
import java.util.stream.Stream;

public class Solutions {



	// x만큼 간격이 있는 n개의 숫자
	// 1030
	public long[] solution1(int x, int n) {

		long[] answer = new long[n];
		for (long i = 0; i < n; i++)
			answer[(int)i] = (x * (i + 1));
		return answer;
	}

	// 평균 구하기
	// 1030
	public double solution2(int[] arr) {
		double answer = 0;
		for(int i : arr)
			answer += i;
		return answer / arr.length;
	}

	// 나머지가 1이 되는 수 찾기
	public int solution3(int n) {
		int answer = 1;
		while (answer++ < n) { if (n % answer == 1) return answer; }
		return answer;
	} //1031

	// 문자열을 정수로 바꾸기
	public static int solution4(String s) {
		int answer;
		answer = Integer.parseInt(s);
		return answer;
	} //1031

	// 문자열을 정수로 바꾸기 ver.2
	public static int solution4_1(String s) {
		int answer = 0;
		boolean flag = false;

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '+')
				continue;
			else if (s.charAt(i) == '-') {
				flag = true;
				continue;
			}
			answer = answer * 10 + s.charAt(i) - 48;
		}
		return flag ? answer * -1 : answer;
	} //1031

	// p와 y의 개수
	// 1030
	public static boolean solution5(String s) {
		int pH = 0;
		for (int i = 0; i < s.length(); i++) {

			if (s.charAt(i) == 'p' || s.charAt(i) == 'P')
				pH++;
			else if (s.charAt(i) == 'y' || s.charAt(i) == 'Y')
				pH--;
		}
		return (pH == 0) ? true : false;
	}

	// 자릿수 더하기
	public int solution6(int n) {
		int answer = 0;
		while (n > 0) {
			answer += n % 10;
			n /= 10;
		}
		return answer;
	} //1031

	// 제곱근 판별
	//1101
	public static long solution7(long n) {
		long answer = 1;
		while(((answer * answer) <= n)){
			if ((answer * answer) == n)
				return (answer + 1) * (answer + 1); // Math.pow
			answer++;
		}
		return -1;
	}

	//정수 내림차순으로 배치하기.
	public static long solution8(long n) {

		int lengthNum = 1;
		long tmp = n;
		long answer = 0;

		for (int i = 0; 0 != (tmp /= 10) ; i++){ lengthNum++; }

		long[] answerArray = new long[lengthNum];

		for (int i = 0; i < lengthNum ; i++ ) {
			if (10 < n)
				answerArray[i] = (n % 10);
			else
				answerArray[i] = n;
			n /= 10;
		}

		long sortTmp = 0;

		for (int i = 0; i < lengthNum; i++) {
			for (int j = 0; j < lengthNum -1; j++) {
				if (answerArray[i] > answerArray[j]) {
					sortTmp = answerArray[i];
					answerArray[i] = answerArray[j];
					answerArray[j] = sortTmp;
				}
			}
		}

		for (long l : answerArray)
			answer = answer * 10 + l;

		return answer;
	}

	//정수 내림차순으로 정렬하기 Ver.2
	public static long solution8_1(long n) {

		long answer = 0L;

//		int length = (int)Math.log10(n) + 1;

		char[] tmp = Long.toString(n).toCharArray();

		Arrays.sort(tmp);

//		for (int i = 0; i < length; i ++)

		for (int i = (int)Math.log10(n) + 1; 0 < i; i--) {
			answer = answer * 10 + ((tmp[i - 1] - 48));
		}

		return answer;
	}

	//정수 내림차순으로 정렬하기 Ver.4
	public static long solution8_3(long n) {

		long answer = 0L;

//		int length = (int)Math.log10(n) + 1;

		char[] tmp = Long.toString(n).toCharArray();

		Arrays.sort(tmp);

//		for (int i = 0; i < length; i ++)

		for (int i = (int)Math.log10(n) + 1; 0 < i; i--) {
			answer = answer * 10 + ((tmp[i - 1] - 48));
		}

		return answer;
	}

	//정수 내림차순으로 배치하기 Ver.3
	//1101
	public static long solution8_2(long n) {

		int lengthNum = 1;
		long tmp = n;
		long answer = 0;

		for (int i = 0; 0 != (tmp /= 10) ; i++){ lengthNum++; }

		long[] answerArray = new long[lengthNum];

		for (int i = 0; i < lengthNum ; i++ ) {
			if (10 < n)
				answerArray[i] = (n % 10);
			else
				answerArray[i] = n;
			n /= 10;
		}

		Arrays.sort(answerArray);

		for (int i = lengthNum; 0 < i; i--) {
			answer = answer * 10 + ((answerArray[i - 1]));
		}

		return answer;
	}

	//하샤드 수
	//1101
	public static boolean solution9(int x) {

		int tmp = x;
		int sum = 0;

		while (tmp > 0) {
			sum += tmp % 10;
			tmp /= 10;
		}

		return (x % sum) == 0;
	}

	// 두 정수 사이의 합
	//1106
	public static long solution10(int a, int b) {

		long answer = 0;

		if (a > b) {
			for (int i = 0; a >= b; i++)
				answer += b++;
			return answer;
		} else if (b > a) {
			for (int i = 0; b >= a; i++)
				answer += a++;
			return answer;
		}
		return a;
	}

	// 콜라츠 추측
	//1106
	public static int solution11(int num) {

		long tmp = num; // 오버플로우

		for (int i = 0; i < 500; i++) {
			if (tmp == 1)
				return i;
			else if ((tmp % 2) == 0)
				tmp /= 2;
			else
				tmp = tmp * 3 + 1;
		}

		return -1;
	}

	//서울에서 김서방 찾기
	//1106
	public static String solution12(String[] seoul) {

		for (int i = 0; i < seoul.length; i++) {
			if (seoul[i].equals("Kim"))
				return ("김서방은 " + i + "에 있다");
		}
		return "여기 없나본데?";
	}

	//음양 더하기
	//1107
	public int solution13(int[] absolutes, boolean[] signs) {

		int tmp;
		int answer = 0;

		for (int i = 0; i < absolutes.length; i++) {
			tmp = absolutes[i];
			if (!(signs[i]))
				tmp *= -1;
			answer += tmp;
		}

		return answer;
	}

	//나누어 떨어지는 숫자 배열
	//1107
	public int[] solution14(int[] arr, int divisor) {

		int[] answer;
		List<Integer> integerList = new ArrayList<>();

		for (int i = 0; i < arr.length; i++) {
			if(arr[i] % divisor == 0)
				integerList.add(arr[i]);
		}

		integerList.sort(Comparator.naturalOrder());
		answer = integerList.stream().mapToInt(i -> i).toArray();

		return (integerList.isEmpty()) ? new int[]{-1} : answer;
	}

	//핸드폰 번호 가리기
	//1108
	public static String solution15(String phone_number) {

		char[] tmp = phone_number.toCharArray();
		for (int i = 0; i < phone_number.length(); i++) {
			if (i < phone_number.length() - 4)
				tmp[i] = '*';
		}
		return String.valueOf(tmp);
	}

	//없는 숫자 더하기
	//1107
	public int solution16(int[] numbers) {
		int answer = 45;
		for(int i : numbers)answer -= i;
		return answer;
	} // 이중 for문 버려



	//제일 작은 수 제거하기
	//1108
	public static int[] solution17(int[] arr) {
		int minPoint = 0;
		List<Integer> tmp = new ArrayList<>();

		if (arr.length == 1)
			return new int[]{-1};

		minPoint = arr[0];

		for (int i = 0; i < arr.length; i++)
			if (minPoint > arr[i]) minPoint = arr[i];

		for (int i = 0; i < arr.length; i++)
			if (!(minPoint == arr[i])) tmp.add(arr[i]);

		return tmp.stream().mapToInt(i -> i).toArray();
	}

	// 가운데 글자 가져오기
	//1108
	public String solution18(String s) {

		char[] tmp = s.toCharArray();
		String answer = "";
		int length = s.length();

		if ((length % 2) == 0)
			answer += tmp[length/2 - 1];
		answer += tmp[length/2];

		return answer;
	}

	//수박
	//1109
	public static String solution19(int n) {

		String answer = "";

		for (int i = 0; i < n; i++)
			answer += (i % 2 == 0) ? "수" : "박";

		return answer;
	}

	//내적
	//1109
	public int solution20(int[] a, int[] b) {

		int answer = 0;
		for (int i = 0; i < a.length; i++)
			answer += a[i] * b[i];
		return answer;
	}


	//약수의 개수와 덧셈
	//1109
	public static int solution21(int left, int right) {
		int answer = 0;

		for(int i = left; i <= right; i++) {
			if ((int)Math.sqrt(i) * (int)Math.sqrt(i) == i)
				answer -= i;
			else
				answer += i;
		}
		return answer;
	}

	// 문자열 내림차순으로 배치하기
	//1110
	public static String solution22(String s) {
		String answer = "";
		char[] tmp = s.toCharArray();
		Arrays.sort(tmp);
		for (int i = s.length() - 1; 0 <= i; i--)
			answer = answer + tmp[i];
		return answer;
	}

	// 문자열 내림차순으로 배치하기 2
	//1110
	public static String solution22_1(String s) {
		char[] tmp = s.toCharArray();
		Arrays.sort(tmp);
		return new StringBuilder(new String (tmp)).reverse().toString();
	}



	// 완전탐색_ 카펫 //2
	public static int[] solution23(int brown, int yellow) {
		int maxX = (brown / 2) - 2;
		int x = (brown / 2) - 3;

		// brown/2 - 2 = x * y
		// x * y = yellow
		// x-- = yellow - 1
		//가로가 세로보다 길다 ( y < x + 1 )

		for (int y = 1; y < x + 1; y++) {
			if ((x * y) == yellow)
				return new int[]{x + 2,y + 2};
			x--;
		}
		return null;
	}

	//최댓값과 최솟값 //2
	public static String solution24(String s) {

		String answer = "";
		int Max;
		int min;

		int tmpArray[] = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();

		Max = tmpArray[0];
		min = tmpArray[0];

		for (int i = 0; i < tmpArray.length; i ++)
		{
			if (Max < tmpArray[i])
				Max = tmpArray[i];
			if (min > tmpArray[i])
				min = tmpArray[i];
		}

		return min + " " + Max;
	}

	//최댓값과 최솟값 Ver.2 //2
	public static String solution24_1(String s) {
		int Max = -2147483648;
		int min = 2147483647;

		int tmpArray[] = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();

		for (int i : tmpArray) {
			if (Max < i)
				Max = i;
			if (min > i)
				min = i;
		}

		return min + " " + Max;
	}

	//JadenCase 문자열 만들기 //2
//	public static String solution25(String s) {
//
//		String answer = "";
//
//		char[] tmpArray = s.toCharArray();
//
//		for (int i = 0; i < tmpArray.length; i++) {
//			if (tmpArray[i] == ' ') {
//				if(i + 1 < tmpArray.length && 'a' <= tmpArray[i + 1] && tmpArray[i + 1] <= 'z') {
//					tmpArray[i + 1] -= 32;
//				}
//			} else if ('a' < tmpArray[i] && tmpArray[i] < 'z') {
//				if(i > 0 && ' ' == tmpArray[i - 1]) {
//					break;
//				} else if (i + 1 < tmpArray.length)
//					tmpArray[i + 1] += 32;
//			}
//			answer += tmpArray[i];
//		}
//
//		return answer;
//	}

	//JadenCase 문자열 만들기 //2
	public static String solution25(String s) {

		String answer = "";
		char[] tmpArray = s.toCharArray();

		if ('a' <= tmpArray[0] && tmpArray[0] <= 'z')
			tmpArray[0] -= 32;
		for (int i = 0; i < tmpArray.length; i++){
			if (i != 0 && tmpArray[i - 1] == ' ' && 'a' <= tmpArray[i] && tmpArray[i] <= 'z')
				tmpArray[i] -= 32;
			else if (i != 0 && tmpArray[i - 1] != ' ' && 'A' <= tmpArray[i] && tmpArray[i] <= 'Z')
				tmpArray[i] += 32;
		}

		return new String(tmpArray);
	}


	//최솟값 만들기 //2
	public int solution26(int []A, int []B)
	{
		Arrays.sort(A);
		Arrays.sort(B);
		int answer = 0;

		int length = A.length;

		for (int i = 0; i < length; i++)
			answer += A[i] * B[length - i - 1];

		return answer;
	}

	// 정수삼각형 //3

	public static int solution27(int[][] triangle) {
		int answer = 0;
		int target = 0;

		for (int i = 1; i < triangle.length; i++) {
			if (target + 1 < triangle[i].length && triangle[i][target] < triangle[i][target + 1]) {
				answer += triangle[i][target + 1];
				target++;
			}
			else
				answer += triangle[i][target];
			System.out.println((int)triangle[i][target]);
		}
		return answer;
	}

// 정수삼각형Ver.2 //3
	public static int solution27_1(int[][] triangle) {
		for (int i = triangle.length - 1; i > 0; i--) {
			for (int j = 0; j < triangle[i - 1].length; j++) {
				if (triangle[i][j] + triangle[i - 1][j] > triangle[i][j + 1] + triangle[i - 1][j])
					triangle[i - 1][j] = triangle[i][j] + triangle[i - 1][j];
				else
					triangle[i - 1][j] = triangle[i][j + 1] + triangle[i - 1][j];
			}
		}
		return triangle[0][0];
	}
	// 정수삼각형Ver.2 + 1 //3

	// 정수삼각형Ver.3 //3
	public static int solution27_2(int[][] triangle) {
		for (int i = triangle.length - 1; i > 0; i--) {
			for (int j = 0; j < triangle[i - 1].length; j++)
				triangle[i - 1][j] = returnBigger(triangle[i][j] + triangle[i - 1][j], triangle[i][j + 1] + triangle[i - 1][j]);
			}
		return triangle[0][0];
	}
	// 정수삼각형Ver.3 + 1 //3
	public static int returnBigger(int i, int j){
		if (i > j)
			return i;
		else
			return j;
	}

	//부족한 금액 계산하기
	//1110
	public static long solution28(int price, int money, int count) {

		long answer = money * -1;
		//(count * (count + 1) / 2
		for (int i = 0; i < count; i++)
			answer += (long)price * (i + 1);

		return answer > 0 ? answer : 0;
	}

	//모음 사전 //2
	public static int solution29(String word) {
	// 	A B C D E F G
		int[] intArray = new int[5];
		char[] tmp = word.toCharArray();
		int answer;
//
//		int why;


		for (int i = 0; i < tmp.length; i++) {
			switch (tmp[i]) {
				case 'A':
					intArray[i] = 0;
					break;
				case 'E':
					intArray[i] = 1;
					break;
				case 'I':
					intArray[i] = 2;
					break;
				case 'O':
					intArray[i] = 3;
					break;
				case 'U':
					intArray[i] = 4;
					break;
			}
		}

		answer = intArray[0] * 781 + intArray[1] * 156 + intArray[2] * 31 + intArray[3] * 6 + intArray[4];
//		why = answer;
		for(char c : tmp)
			answer++;
//
//		System.out.println(answer);
//		System.out.println(why);
//		System.out.println(" ");

		return answer;
	}

	// 가장 큰 수 //2
	public static String solution30(int[] numbers) {

		String[] strArray = new String[numbers.length];

		for (int i = 0; i < numbers.length; i++)
			strArray[i] = String.valueOf(numbers[i]);

		Arrays.sort(strArray, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return (o2 + o1).compareTo(o1 + o2);
			}
		});



		if (strArray[0].equals("0"))
			return "0";

//		if (strArray[0] == "0")
//			return "0";

		StringBuilder answer = new StringBuilder();
		for (String s : strArray) {
			answer.append(s);
		}

		return answer.toString();
	}

	// 최대공약수와 최소공배수
	public static int[] solution31(int n, int m) {
		int[] answer = {};
		List<Integer> nList = new ArrayList<>();
		List<Integer> mList = new ArrayList<>();
		int length;

		int gcd = 1;
		int lcm = 1;

		if (n > m)
			length = n/2 + 1;
		else
			length = m/2 + 1;

		for (int i = 1; i < length; i++) {
			if ((n % i) == 0)
				nList.add(i);
			if ((m % i) == 0)
				mList.add(i);
		}

		for (int i = 0; i < length; i++) {
			if (nList.get(i) == mList.get(i))
				gcd = nList.get(i);

		}
		return answer;
	}

	//문자열 다루기 기본
	//1110
	public boolean solution32(String s) {

		char[] tmpArray = s.toCharArray();

		if (s.length() != 4 && s.length() != 6) {
			return false;
		}

		for (int i : tmpArray) {
			if (!('0' <= i && i <= '9')) {
				return false;
			}
		}

		return true;
	}

	// H-INDEX //2
//	public static int solution33(int[] citations) {
//		int answer = 0;
//		boolean flag = false;
//		int totalPaper = citations.length;
//		int totalCount = 0;
//
//		for (int i : citations) {
//			if (i < totalPaper)
//				flag = true;
//			totalCount += i;
//		}
//
//		if (flag) {
//			for (int i = totalCount / totalPaper; i < totalPaper / 2; i++) {
//				answer = i;
//				int bigger = 0;
//
//				for (int target : citations) {
//					if (target > answer)
//						bigger++;
//				}
//
//				if (bigger == answer)
//					break;
//			}
//		} else {
//			for (int i = totalCount / totalPaper + 1; i > 0 / 2; i--) {
//				answer = i;
//				int bigger = 0;
//
//				for (int target : citations) {
//					if (target > answer)
//						bigger++;
//				}
//
//				if (bigger == answer)
//					break;
//			}
//		}
//
//		return answer;
//	}

	// H-INDEX //2
	public static int solution33(int[] citations) {
		int answer = 0;
		int hIndex;
		int citationsLength = citations.length;

		for (int i = 1; i <= citationsLength; i++) {
			hIndex = 0;

			for (int j : citations)
				if (j >= i)	hIndex++;

			if (hIndex >= i) answer = i;
		}

		return answer;
	}

	//행렬의 덧셈
	//1113
	public int[][] solution34(int[][] arr1, int[][] arr2) {
		int[][] answer = arr1;

		for (int i = 0; i < arr1.length; i++) {
			for (int j = 0; j < arr1[i].length; j++) {
				answer[i][j] = arr1[i][j] + arr2[i][j];
			}
		}

		return answer;
	}

//	 직사각형 별 찍기
//	1113
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int a = sc.nextInt();
//		int b = sc.nextInt();
//
//		for (int i = 0; i < b; i++) {
//			for (int j = 0; j < a; j++)
//				System.out.print('*');
//			if (i != b-1)
//				System.out.println();
//		}
//	}

	// 최대 공약수와 최소 공배수
	//1113
	public int[] solution35(int n, int m) {
		int gcd = euclidean35(n, m);
		int lcm = n * m / gcd;

		return new int[]{gcd, lcm};
	}

	public int euclidean35 (int n, int m) {
		int j = 1;

		while ( j > 0 ) {
			j = n % m;
			n = m;
			m = j;
		}

		return n;
	}

	//3진법 뒤집기 ////
	//1113
	public static int solution36(int n) {
		int answer = 0;

		List<Integer> ternary = new ArrayList<>();

		while (n > 0) {
			ternary.add(n % 3);
			n /= 3;
		}

		int[] arrayTernary = ternary.stream().mapToInt(i -> i).toArray();

		int base = 0;
		for (int i = arrayTernary.length  - 1; i >= 0; i--)
			answer += arrayTernary[i] * (int)Math.pow(3, base++);

		return answer;
	}

	//3진법 뒤집기
	//1113
	public static int solution36_1(int n) {
		int answer = 0;

		List<Integer> ternary = new ArrayList<>();

		while (n > 0) {
			ternary.add(n % 3);
			n /= 3;
		}

		int base = 0;
		for (int i = ternary.size() - 1; i >= 0; i--)
			answer += ternary.get(i) * (int)(Math.pow(3, base++));

		return answer;
	}

	//이상한 문자 만들기
	//1114
	public String solution37(String s) {
		StringBuilder answer = new StringBuilder();
		int metBlank = 0;
		char[] tmpS = s.toCharArray();

		for (int i = 0; i < tmpS.length; i++) {
			char c = tmpS[i];


			if (tmpS[i] == ' ') {
				answer.append(c);
				metBlank = 0;
			} else {
				if (metBlank % 2 == 0)
					answer.append(Character.toUpperCase(c));
				else
					answer.append(Character.toLowerCase(c));
				metBlank++;
			}
		}
		return answer.toString();
	}

	//삼총사
	//1114
	public static int solution38(int[] number) {
		int answer = 0;

		for (int first = 0; first < number.length - 2; first++) {
			for (int second = first + 1; second < number.length - 1; second++) {
				for (int third = second + 1; third < number.length; third++) {
					if (number[first] + number[second] + number[third] == 0)
						answer++;
				}
			}
		}

		return answer;
	}

	//크기가 작은 부분 문자열
	//1114
	public static int solution39(String t, String p) {
		int answer = 0;
		char[] tmpT = t.toCharArray();
		Long target;
		Long longP = Long.parseLong(p);

		for (int i = 0; i <= t.length() - p.length(); i++) {
			target = 0L;
			for (int j = 0; j < p.length(); j++) {
				target = target * 10 + tmpT[i + j] - 48;
			}
			if (target <= longP)
				answer++;
		}

		return answer;
	}

	// 전화번호 목록 //2
	public boolean solution40(String[] phone_book) {
		Arrays.sort(phone_book);

		for (int i = 0; i < phone_book.length - 1; i++) {
			if (phone_book[i + 1].startsWith(phone_book[i]))
				return false;
		}
		return true;
	}

	// 최소직사각형
	//1115
	public int solution41(int[][] sizes) {
		int x = 0;
		int y = 0;

		for (int[] i : sizes) {
			Arrays.sort(i);
			if (i[0] > x)
				x = i[0];
			if (i[1] > y)
				y = i[1];
		}

		return x * y;
	}

	//시저암호
	//1115
	public static String solution42(String s, int n) {
		char[] tmpS = s.toCharArray();
		StringBuilder answer = new StringBuilder();

		for (char c : tmpS)
			answer.append(ceasar(c,n));

		return answer.toString();
	}

	public static char ceasar(char c, int n) {
		if ('a' <= c && c <= 'z') {
			c += n;
			if (c > 'z')
				c -= 26;
		} else if ('A' <= c && c <= 'Z') {
			c += n;
			if (c > 'Z')
				c -= 26;
		}
		return c;
	}

	//숫자 문자열과 영단어
	//1115
	public int solution43(String s) {
		int answer = 0;
		int[] arrayTmp;

		while (!s.isEmpty()) {
			answer *= 10;

			if (!('0' <= s.charAt(0) && s.charAt(0) <= '9')) {
				arrayTmp = stringToNumber(s);
				answer += arrayTmp[0];
				s = s.substring(arrayTmp[1]);
			} else {
				answer += s.charAt(0) - '0';
				s = s.substring(1);
			}
		}
		return answer;
	}

	public int[] stringToNumber(String s) {
		String[] numberString = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
		int i;
		int j = 0;

		for (i = 0; i < numberString.length; i++) {
			if (s.startsWith(numberString[i]))
				break;
		}

		j = switch (i) {
			case 0, 4, 5, 9 -> 4;
			case 1, 2, 6 -> 3;
			case 3, 7, 8 -> 5;
			default -> j;
		};

		return new int[] {i, j};
	}

	// 문자열 내 마음대로 정렬하기
	//1116
	public String[] solution44(String[] strings, int n) {



		Arrays.sort(strings, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				if (o1.charAt(n) != o2.charAt(n))
					return o1.charAt(n) - o2.charAt(n);
				return o1.compareTo(o2);
			}
		});
		return strings;
	}

//	public String[] solution44(String[] strings, int n) {
//		String[] answer = new String[strings.length];
//
//		String[][] mapString = new String[strings.length][2];
//
//		for (int i = 0; i < strings.length; i++) {
//			mapString[i][0] = strings[i].substring(n);
//			mapString[i][1] = String.valueOf(i);
//		}
//
//		Arrays.sort(mapString);
//
//		for (String[] s : mapString) {
//			answer[Integer.parseInt(s.[1])] = s;
//		}
//		return answer;
//	}



	//의상 //2
//	public int solution(String[][] clothes) {
//		int answer = 0;
//		int count;
//		String cType = "";
//
//
//		String[] clothesType = new String[clothes.length];
//
//		for (int i = 0; i < clothesType.length; i++)
//			clothesType[i] = clothes[i][1];
//
//		Arrays.sort(clothesType);
//
//		for (String s : clothesType) {
//			if (!(cType.equals(s)))
//				cType = s;
//
//		}
//
//
//
//		return answer;
//	}
	public int solution45(String[][] clothes) {
		int answer = 1;
		HashMap<String, Integer> clothesMap = new HashMap<>();
		String type;

		for (String[] cloth : clothes) {
			type = cloth[1];
			clothesMap.put(type, clothesMap.getOrDefault(type, 1) + 1);
		}

		for (int count : clothesMap.values())
			answer *= count;

		return answer - 1;
	}

	// k번째 수
	//1116
	public int[] solution46(int[] array, int[][] commands) {
		int [] answer = new int[commands.length];

		for (int i = 0; i < commands.length; i++) {
			int[] tmp = new int[commands[i][1] - commands[i][0] + 1];

			int count = 0;
			for (int j = commands[i][0]; j <= commands[i][1]; j++)
				tmp[count++] = array[j - 1];

			Arrays.sort(tmp);

			answer[i] = tmp[commands[i][2] - 1];
		}

		return answer;
	}

	//기능개발 /2
	public static int[] solution47(int[] progresses, int[] speeds) {
		List<Integer> answerList = new ArrayList<>();
		int[] jobDone = new int[progresses.length];

		for (int i = 0; i < progresses.length; i++)
			jobDone[i] = ((100 - progresses[i] - 1) / speeds[i] + 1);

		int count = 1;
		int longestDay = jobDone[0];

		for (int i = 1; i < jobDone.length; i++) {
			if (longestDay >= jobDone[i])
				count++;
			else {
				answerList.add(count);
				count = 1;
				longestDay = jobDone[i];
			}
		}

		answerList.add(count);

		int[] answer = new int[answerList.size()];

		for (int i = 0; i < answer.length; i++)
			answer[i] = answerList.get(i);

		return answer;
	}

	//두개 뽑아서 더하기
	public int[] solution48(int[] numbers) {
		Set<Integer> answer = new HashSet<>();

		for (int i = 0; i < numbers.length - 1; i++) {
			for (int j = i + 1; j < numbers.length; j++)
				answer.add(numbers[i] + numbers[j]);
		}

		return answer.stream().sorted().mapToInt(i -> i).toArray();
	}

	// 가장 가까운 글자
	public int[] solution49(String s) {
		int[] answer = new int[s.length()];
		char[] tmpS = s.toCharArray();

		Map<Character, Integer> words = new HashMap<>();

		for (int i = 0; i < tmpS.length; i++) {
			if (words.containsKey(tmpS[i]))
				answer[i] = i - words.get(tmpS[i]);
			else
				answer[i] = -1;
			words.put(tmpS[i], i);
		}

		return answer;
	}
}






















