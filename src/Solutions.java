import javax.sound.midi.Soundbank;
import java.security.Key;
import java.sql.SQLOutput;
import java.util.*;
import java.util.stream.Collectors;
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
// 스페이스, 딜리트
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
				answer += s.charAt(0) - '0'; // -48
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

	//푸드 파이트 대회
//	public String solution50(int[] food) {
//		List<Integer> foodList = new ArrayList<>();
//		int[] kcal = new int[food.length - 1];
//
//		for (int i = 1; i < food.length; i++)
//			kcal[i - 1] = food[i] / 2;
//
////		int heavy= 1;
////
////		for (int k : kcal) {
////			for (int j = 0; j < k; j++)
////				foodList.add(heavy);
////			heavy++;
////		}
//
//		for (int i = 0; i < kcal.length; i++) {
//			for (int j = 0; j < kcal[i]; j++)
//				foodList.add(i + 1);
//		}
//
//		foodList.add(0);
//
//		for (int i = foodList.size() - 2; i >= 0; i--)
//			foodList.add(foodList.get(i));
//
//		return foodList.stream().map(String::valueOf).collect(Collectors.joining());
//	}
	//푸드 파이트 대회
	public String solution50(int[] food) {
		StringBuilder foodTable = new StringBuilder();

		for (int i = 1; i < food.length; i++) {
			for (int j = 0; j < food[i] / 2; j++)
				foodTable.append(i);
		}
//		for (int i = 1; i < food.length; i++)
//			foodTable.append(String.valueOf(i).repeat(Math.max(0, food[i] / 2)));

		foodTable.append("0");

		for (int i = food.length - 1; i > 0; i--) {
			for (int j = 0; j < food[i] / 2; j++)
				foodTable.append(i);
		}

		return foodTable.toString();
	}

	//콜라 문제
	public static int solution51(int a, int b, int n) {
		int answer = 0;

		while ( n >= a ) {
			answer += n / a * b;
			n = n / a * b + n % a;
		}

		return answer;
	}

	// 프로세스 //2
	public int solution52(int[] priorities, int location) {

		int answer = 0;

		Queue<Integer> queue = new LinkedList<>();
		for (int priority : priorities)
			queue.offer(priority);

		while (!queue.isEmpty()) {

			int current = queue.poll();

			if (queue.stream().anyMatch(p -> p > current)) {
				queue.offer(current);
				if (location == 0)
					location = queue.size() - 1;
				else location--;
			} else {
				answer++;
				if (location == 0)
					return answer;
				location--;
			}
		}

		return answer;
	}

	// 하노이의 탑 //2
	public static int[][] solution53(int n) {
		List<int[]> traceHanoi = new ArrayList<>();

		Hanoi(n,1, 2, 3, traceHanoi);

		return traceHanoi.toArray(new int[traceHanoi.size()][]);
	}

	public static void Hanoi(int n, int first, int second, int third, List<int[]> result) {
		if (n == 0)
			return;

		Hanoi(n - 1, first, third, second, result);
		System.out.print(first + " ");
		Hanoi(n - 1, second, first, third, result);
	}

	// 카드 뭉치
	public static String solution54(String[] cards1, String[] cards2, String[] goal) {
		List<String> c1List = new ArrayList<String>(Arrays.asList(cards1));
		List<String> c2List = new ArrayList<String>(Arrays.asList(cards2));

		for (String target : goal) {
			if (!c1List.isEmpty() && c1List.get(0).equals(target))
				c1List.remove(0);
			else if (!c2List.isEmpty() && c2List.get(0).equals(target))
				c2List.remove(0);
			else
				return "No";
		}
		return "Yes";
	}

	// 달력
	public String solution55(int a, int b) {
		String[] days = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};
		int[] monthDays = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		int totalDays = b - 1;

		for (int i = 0; i < a - 1; i++)
			totalDays += monthDays[i];

		return days[totalDays % 7];
	}

	//명예의 전당
	public int[] solution56(int k, int[] score) {
		Queue<Integer> hall = new PriorityQueue<>();
		int[] result = new int[score.length];

		for (int i = 0; i < score.length; i++) {
			if (hall.size() < k)
				hall.offer(score[i]);
			else {
				if (score[i] > hall.peek()) {
					hall.poll();
					hall.offer(score[i]);
				}
			}
			result[i] = hall.peek();
		}
		return result;
	}

	//과일 장수
	public static int solution57(int k, int m, int[] score) {

		Arrays.sort(score);

		int[] box = new int[m];
		int i = score.length - 1;
		int minValue = k;
		int count = m;
		int answer = 0;

		while ( i >= 0 ) {
			if (count > 0) {
				count--;
				if (score[i] < minValue)
					minValue = score[i];
			}

			if ( count == 0 ) {
				answer += minValue * m;
				count = m;
			}
			i--;
		}
		return answer;
	}

	//모의고사
	public static int[] solution58(int[] answers) {
		int[] minsu = new int[answers.length];
		int[] yeonghee = new int[answers.length];
		int[] taeho = new int[answers.length];

		int[] yArray = new int[]{2, 1, 2, 3, 2, 4, 2, 5};
		int[] tArray = new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
		for (int i = 0; i < minsu.length; i++) {
			minsu[i] = (i % 5) + 1;
			yeonghee[i] = yArray[i % yArray.length];
			taeho[i] = tArray[i % tArray.length];
		}

		int minsuScore = 0;
		int yeongheeScore = 0;
		int taehoScore = 0;

		for (int i = 0; i < answers.length; i++) {
			if (answers[i] == minsu[i])	minsuScore++;
			if (answers[i] == yeonghee[i])	yeongheeScore++;
			if (answers[i] == taeho[i])	taehoScore++;
		}

		int highestScore = Math.max(minsuScore, Math.max(yeongheeScore, taehoScore));

		List<Integer> answer = new ArrayList<>();
		if (minsuScore == highestScore)	answer.add(1);
		if (yeongheeScore == highestScore)	answer.add(2);
		if (taehoScore == highestScore)	answer.add(3);

		return answer.stream().mapToInt(i -> i).toArray();
	}

	// [3차] 방금 그 곡
	public static String solution59(String m, String[] musicinfos) {

		//"ABCDEFG"
		// ["12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"]

		m = sharp(m);

		String answer = "(None)";
		int longestPlayTime = 0;

		String[] music;
		int playTime;
		String fullsong;

		for (String flow : musicinfos) {
			music = flow.split(",");
			playTime = playTime(music[0], music[1]);
			fullsong = fullSong(music[3], playTime);

			if (fullsong.contains(m) && playTime > longestPlayTime) {
				longestPlayTime = playTime;
				answer = music[2];
			}
		}

		return answer;
	}

	public static int playTime(String a, String b) {
		String[] songStrat = a.split(":");
		String[] songEnd = b.split(":");

		return (Integer.parseInt(songEnd[0]) * 60 + Integer.parseInt(songEnd[1]))
				- (Integer.parseInt(songStrat[0]) * 60 + Integer.parseInt(songStrat[1]));
	}

	public static String fullSong (String music, int playTime) {
		StringBuilder fullsong = new StringBuilder();
		char[] musicArray = music.toCharArray();

		int j = 0;
		for (int i = 0; i < playTime; i++) {
			fullsong.append(musicArray[j]);
			j++;
			if (j >= musicArray.length)
				j = 0;
		}

		return fullsong.toString();
	}

	public static String sharp(String music) {
		music = music.replaceAll("C#", "c");
		music = music.replaceAll("D#", "d");
		music = music.replaceAll("F#", "f");
		music = music.replaceAll("G#", "g");
		music = music.replaceAll("A#", "a");
		return music;
	}

	//소수 만들기
	public int solution60(int[] nums) {
		int answer = 0;

		for (int i = 0; i < nums.length - 2; i++) {
			for (int j = i + 1; j < nums.length - 1; j++) {
				for (int k = j + 1; k < nums.length; k++) {
					int sum = nums[i] + nums[j] + nums[k];
					if (isPrime(sum)) answer++;
				}
			}
		}
		return answer;
	}
	public boolean isPrime(int number) {
		//if (number < 2) return false;
		for (int i = 2; i * i <= number; i++)
			if (number % i == 0) return false;

		return true;
	}


	// 순위 검색
	public int[] solution61(String[] info, String[] query) {

		int[] pass = new int[query.length];
		int count;

		for (int i = 0; i < query.length; i++) {
			count = 0;

			for (int j = 0; j < info.length; j++) {
				if (documentInterview(info[j].split(" "), query[i].split(" and | ")))
					count++;
			}

			pass[i] = count;
		}

		return pass;


//		String[] applicant;
//		int appNum;
//		List<Integer> pass = new ArrayList<>();
//
//		for (int i = 0; i < info.length; i++) {
//			appNum = i + 1;
//			applicant = info[i].split(" ");
//			//[java, backend, junior, pizza, 150]
//
//			if (documentInterview(applicant, query))
//				pass.add(appNum);
//		}
//
////		return pass.stream().mapToInt(i -> i).toArray();
//		int[] passArray = new int[pass.size()];
//		for (int i = 0; i < passArray.length; i ++)
//			passArray[i] = pass.get(i);
//		return passArray;
	}

	public boolean documentInterview (String[] applicant, String[] query) {

		for (int i = 0; i < 4; i++)	{
			if (!query[i].equals("-") && !applicant[i].equals(query[i]))
				return false;

			//java backend junior pizza 150
			//java backend 	-	 pizza 100"
		}
		return Integer.parseInt(applicant[4]) >= Integer.parseInt(query[4]);


//		String[] detailQuery;
//		boolean flag;
//
//		for (int i = 0; i < query.length; i++) {
//			detailQuery = query[i].split(" and ");
//			flag = true;
//
//			for (int j = 0; j < detailQuery.length - 1; j++) {
//				if (!detailQuery[j].equals("-") && !applicant[j].equals(detailQuery[j])) {
//					flag = false;
//					break;
//				}
//			}
//
//			if (flag && Integer.parseInt(applicant[4]) >= Integer.parseInt(detailQuery[detailQuery.length - 1])) {
//				return true;
//			}
//		}
//
//		return false;


//		for (int i = 0; i < query.length; i++) {
//			String[] detailQuery = query[i].split(" and | ");
//			boolean isMatched = true;
//
//			for (int j = 0; j < 4; j++) { // 4개의 조건 (언어, 직군, 경력, 소울푸드)
//				if (!detailQuery[j].equals("-") && !detailQuery[j].equals(applicant[j])) {
//					isMatched = false;
//					break;
//				}
//			}
//
//			// 점수 비교 (조건이 일치할 경우에만)
//			if (isMatched && Integer.parseInt(applicant[4]) < Integer.parseInt(detailQuery[4])) {
//				isMatched = false;
//			}
//
//			if (isMatched) {
//				return true;
//			}
//		}
//
//		return false;
//	}
	}

//	//덧칠하기
//	public int solution62(int n, int m, int[] section) {
//		int answer = 0;
//		int done = 0;
//
////		int answer2 = 0;
////		int done2 = section.length;
//
//		for (int i = 0; i < section.length; i++) {
//			if (done < section[i]) {
//				answer ++;
//				done += section[i] + m - 1;
//			}
//		}
//
////		for (int i = section.length - 1; i > 0; i--) {
////			if (done2 > section[i]) {
////				answer ++;
////				done2 = section[i] - m;
////			}
////		}
//
//
//
//		return answer;
//	}

	//덧칠하기
	public int solution62(int n, int m, int[] section) {
		int answer = 0;
		int end;
		int done = 0;

//		for (int i = 0; i < section.length; i++) {
//			end = section[i] + m - 1;
//			answer++;
//			i = end;
//		}

		while (done < section.length) {
			end = section[done] + m - 1; //칠
			answer++; // 붓 횟수

			while (done < section.length && section[done] <= end)
				done++;
		}

		return answer;
	}

	// 괄호 회전하기
	public int solution63(String s) {
		int answer = 0;

		for (int i = 0; i < s.length(); i++) {
			if (rolling(s, i))
				answer++;
		}

		return answer;
	}

	public boolean rolling (String s, int i) {
		Stack<Character> stack = new Stack<>();

//		String tmpLeft = s.substring(0, i + 1);
//		String tmpRight = s.substring(i + 1, s.length());

		char[] tmpArray = (s.substring(i + 1, s.length()) + s.substring(0, i + 1)).toCharArray();

		for (char c : tmpArray) {
			if (c == '(' || c == '{' || c == '[')
				stack.push(c);
			else if (c == ')' && !stack.isEmpty() && stack.peek() == '(')
				stack.pop();
			else if (c == '}' && !stack.isEmpty() && stack.peek() == '{')
				stack.pop();
			else if (c == ']' && !stack.isEmpty() && stack.peek() == '[')
				stack.pop();
			else
				return false;
		}

		return stack.empty();
	}

	//기사단원의 무기
	public int solution64(int number, int limit, int power) {
		int answer = 0;
		int knightPower;

		for (int i = 1; i <= number; i++) {
			knightPower = div(i);
			if (knightPower > limit)
				answer += power;
			else
				answer += knightPower;
		}

		return answer;
	}

	public int div(int number) {
		int count = 0;

		for (int i = 1; i <= Math.sqrt(number); i++) {
			if (number % i == 0){
				count++;
				if (i != number /i)
					count++;
			}
		}

		return count;
	}

	// 로또의 최고 순위와 최저 순위
	public int[] solution65(int[] lottos, int[] win_nums) {

		int zero = 0;
		int match = 0;

		for (int i : lottos) {
			if (i == 0)
				zero++;
			else {
				for (int j : win_nums) {
					if (i == j)
						match++;
				}
			}
		}

		int lowRank = 7 - match;
		int highRank = lowRank - zero;

		lowRank = lowRank > 6 ? 6 : lowRank;
		highRank = highRank > 6 ? 6 : highRank;

		return new int[]{highRank, lowRank};
	}


	// 옹알이 (2) // 50점
	public int solution66(String[] babbling) {
		int answer = 0;

		for (String b : babbling) {
			String modified = b.replaceAll("aya|ye|woo|ma", "");

			if (modified.isEmpty())
				answer++;
		}

		return answer;
	}

	// 옹알이 (2) // 55점
	public int solution66_1(String[] babbling) {
		int answer = 0;
		char babyJustSaid = ' ';
		boolean babyCantBabbleIt;

		for (String b : babbling) {
			char[] tmp = b.replaceAll("aya", "1")
					.replace("ye", "2")
					.replace("woo", "3")
					.replace("ma", "4")
					.toCharArray();

			babyCantBabbleIt = true;

			for (char c : tmp) {
				if (babyJustSaid == c) {
					babyCantBabbleIt = false;
					break;
				}

				if (c != '1' && c != '2' && c != '3' && c != '4') {
					babyCantBabbleIt = false;
					break;
				}

				babyJustSaid = c;
			}

			if (babyCantBabbleIt)
				answer++;
		}

		return answer;
	}

	// 옹알이 (2)
	public int solution66_2(String[] babbling) {
		int answer = 0;

		for (String b : babbling) {
			String replaced = b.replaceAll("aya", "1")
					.replaceAll("ye", "2")
					.replaceAll("woo", "3")
					.replaceAll("ma", "4");

			if (replaced.matches("^[1234]+$") &&
					!replaced.contains("11") &&
					!replaced.contains("22") &&
					!replaced.contains("33") &&
					!replaced.contains("44")) {
				answer++;
			}
		}

		return answer;
	}

	// 숫자 짝궁  // 시간 초과
	public String solution67(String X, String Y) {
		StringBuilder answer =new StringBuilder();
		List<Character> tmp = new ArrayList<>();

		char[] tmpX = X.toCharArray();
		char[] tmpY = Y.toCharArray();

		for (char x : tmpX) {
			for (int i = 0; i < tmpY.length; i++) {
				if (x == tmpY[i]) {
					tmp.add(x);
					tmpY[i] = 'x';
					break;
				}
			}
		}

		if (tmp.isEmpty())
			return "-1";

		Collections.sort(tmp, Collections.reverseOrder());

		for (char c : tmp)
			answer.append(c);

		String result = answer.toString();
		if (result.matches("0+"))
			return "0";

		return result;
	}

	// 숫자 짝궁
	public String solution67_1(String X, String Y) {
		Map<Character, Integer> tmpX = new HashMap<>();
		Map<Character, Integer> tmpY = new HashMap<>();
		List<Character> commonNumbers = new ArrayList<>();
		StringBuilder answer = new StringBuilder();


		for (char c : X.toCharArray())
			tmpX.put(c, tmpX.getOrDefault(c, 0) + 1);

		for (char c : Y.toCharArray())
			tmpY.put(c, tmpY.getOrDefault(c, 0) + 1);

		for (char c : tmpX.keySet()) {
			if (tmpY.containsKey(c)) {
				int min = Math.min(tmpX.get(c), tmpY.get(c));
				for (int i = 0; i < min; i++)
					commonNumbers.add(c);
			}
		}

		if (commonNumbers.isEmpty())
			return "-1";

		Collections.sort(commonNumbers, Collections.reverseOrder());

		for (char c : commonNumbers)
			answer.append(c);

		return answer.toString().matches("0+") ? "0" : answer.toString();
	}

	// 체육복
	public int solution68(int n, int[] lost, int[] reserve) {
		int[] spare = new int[n];
		int answer = 0;

		for (int i : lost)
			spare[i - 1]--;
		for (int i : reserve)
			spare[i - 1]++;

		for (int i = 0; i < spare.length; i++) {
			if (spare[i] == -1) {
				if (i > 0 && spare[i - 1] == 1) {
					spare[i]++;
					spare[i - 1]--;
				} else if (i < spare.length - 1 && spare[i + 1] == 1) {
					spare[i]++;
					spare[i + 1]--;
				}
			}
		}

		for (int i : spare)
			if (i >= 0) answer++;
		return answer;
	}

}

// import java.util.*;
























