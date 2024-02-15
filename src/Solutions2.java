import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Solutions2 {

	public static int[] solution69(String msg) {
		List<Integer> answerArray = new ArrayList<>();

		Map<String, Integer> dictionary = new HashMap<>();
		char[] msgArray = msg.toCharArray();
		String lzwBukkit = "";

		for (int i = 0; i < 26; i++)
			dictionary.put(String.valueOf((char) ('A' + i)), i + 1);

		for (int i = 0; i < msgArray.length; i++) {

			lzwBukkit += msgArray[i];

			if (!dictionary.containsKey(lzwBukkit) || i == msg.length() - 1) {
				if (!dictionary.containsKey(lzwBukkit)) {
					answerArray.add(dictionary.get(lzwBukkit.substring(0, lzwBukkit.length() - 1)));
					dictionary.put(lzwBukkit, dictionary.size() + 1);
					lzwBukkit = String.valueOf(msg.charAt(i));
				} else {
					answerArray.add(dictionary.get(lzwBukkit));
					if (i < msg.length() - 1) {
						lzwBukkit = "";
					}
				}
			}
		}

		int[] answer = new int[answerArray.size()];
		for (int i = 0; i < answerArray.size(); i++)
			answer[i] = answerArray.get(i);

		return answer;
	}

	//문자열 나누기
	public int solution70(String s) {
		int answer = 0;
		char firstC;
		int cCount;

		while (!s.isEmpty()) {
			firstC = s.charAt(0);
			cCount = 0;


			for (int i = 0; i < s.length(); i++) {

				if (s.charAt(i) == firstC)
					cCount++;
				else
					cCount--;

				if (cCount == 0) {
					answer++;
					s = s.substring(i + 1);
					break;
				}
			}

			if (cCount != 0) {
				answer++;
				break;
			}
		}
		return answer;
	}


	// 대충만든 번호판
	public int[] solution71(String[] keymap, String[] targets) {
		int[] answer = {};



		return answer;
	}

	// 둘만의 암호
	public String solution72(String s, String skip, int index) {
		StringBuilder answer = new StringBuilder();

		for (char ch : s.toCharArray()) {
			int count = 0;
			char current = ch;

			while (count < index) {
				current++;

				if (current > 'z')
					current = 'a';

				if (skip.indexOf(current) == -1)
					count++;

			}

			answer.append(current);
		}

		return answer.toString();
	}

	// 햄버거
	public int solution73(int[] ingredient) {
		Queue<Integer> dishIngredient = new LinkedList<>();
		int[] dish = new int[4];
		int answer = 0;

		for (int i = 0; i < ingredient.length; i++) {
			dishIngredient.add(ingredient[i]);
			if (dishIngredient.size() >= 4 && i < ingredient.length - 3) {

				for (int j = 0; j < 4; j++)
					dish[j] = dishIngredient.poll();

				if (isItGoodBugger(dish))
					answer++;
				else {
					for (int j = 0; j < 4; j--)
						dishIngredient.add(dish[j]);
				}
			}
		}

		return answer;
	}

	public boolean isItGoodBugger(int[] dish) {

		int[] goodBugger = new int[]{1, 3, 2, 1};

		for (int i = 0; i < dish.length; i++) {
			if (dish[i] != goodBugger[i])
				return false;
		}

		return true;
	}

	// 햄버거
	public int solution73_1(int[] ingredient) {
		Queue<Integer> dishIngredient = new LinkedList<>();
		int answer = 0;

		for (int i : ingredient) {
			dishIngredient.add(i);

			if (dishIngredient.size() >= 4) {
				List<Integer> tmpDish = new LinkedList<>(dishIngredient);

				if (tmpDish.get(0) == 1 && tmpDish.get(1) == 2 && tmpDish.get(2) == 3 && tmpDish.get(3) == 1) {
					answer++;

					for (int j = 0; j < 4; j++)
						dishIngredient.poll();

				}
			}
		}
		return answer;

	}

	// 햄버거 // 완
	public int solution73_2(int[] ingredient) {
		int goodBugger = 0;
		List<Integer> dishIngredient = new ArrayList<>();

		for (int i : ingredient) {
			dishIngredient.add(i);

			if (dishIngredient.size() > 3) {
				if (dishIngredient.get(dishIngredient.size() - 1) == 1
						&& dishIngredient.get(dishIngredient.size() - 2) == 3
						&& dishIngredient.get(dishIngredient.size() - 3) == 2
						&& dishIngredient.get(dishIngredient.size() - 4) == 1) {

					goodBugger++;

					for (int j = 0; j < 4; j++)
						dishIngredient.remove(dishIngredient.size() - 1);

				}
			}
		}
		return goodBugger;
	}

	// 성격 유형 검사하기
	public static String solution74(String[] survey, int[] choices) {
		StringBuilder answer = new StringBuilder();
		int[] score = new int[4];

		for (int i = 0; i < survey.length; i++) {
			char c = survey[i].charAt(1);

			switch (c) {
				case 'R' ->	score[0] += choices[i] - 4;
				case 'T' -> score[0] -= choices[i] - 4;

				case 'C' -> score[1] += choices[i] - 4;
				case 'F' -> score[1] -= choices[i] - 4;

				case 'J' -> score[2] += choices[i] - 4;
				case 'M' -> score[2] -= choices[i] - 4;

				case 'A' -> score[3] += choices[i] - 4;
				case 'N' -> score[3] -= choices[i] - 4;
			}
		}

		answer.append(score[0] >= 0 ? "R" : "T");
		answer.append(score[1] >= 0 ? "C" : "F");
		answer.append(score[2] >= 0 ? "J" : "M");
		answer.append(score[3] >= 0 ? "A" : "N");

		return answer.toString();
	}


	// 바탕화면 정리
	public int[] solution75(String[] wallpaper) {
		int min_x = Integer.MAX_VALUE;
		int min_y = Integer.MAX_VALUE;
		int max_x = -1;
		int max_y = -1;

		for (int i = 0; i < wallpaper.length; i++) {
			for (int j = 0; j < wallpaper[i].length(); j++) {
				if (wallpaper[i].charAt(j) == '#') {
					min_x = Math.min(min_x, i);
					min_y = Math.min(min_y, j);
					max_x = Math.max(max_x, i);
					max_y = Math.max(max_y, j);
				}
			}
		}

		max_x += 1;
		max_y += 1;

		return new int[]{min_x, min_y, max_x, max_y};
	}

	//개인정보 수집 유효기간
	public int[] solution76(String today, String[] terms, String[] privacies) {
		List<Integer> answer = new ArrayList<>();

		// today	terms	privacies	result
		//"2022.05.19"	["A 6", "B 12", "C 3"]	["2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"]	[1, 3]
		//"2020.01.01"	["Z 3", "D 5"]	["2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z"]	[1, 4, 5]

		String[][] termsArray = new String[terms.length][2];
		String[][] privaciesArray = new String[privacies.length][4];
		// A, 6
		// A, 2021.05.02

		for (int i = 0; i < terms.length; i++)
			termsArray[i] = terms[i].split(" ");

		for (int i = 0; i < privacies.length; i++) {
			privaciesArray[i][0] = String.valueOf(privacies[i].charAt(11));
			privaciesArray[i][1] = privacies[i].substring(0, 10);
		}

		for (int i = 0; i < privaciesArray.length; i++) {
			for (int j = 0; j < termsArray.length; j++) {
				if (privaciesArray[i][0].equals(termsArray[j][0])) {
					if (checkDDay(today, termsArray[j][1], privaciesArray[i][1]))
						answer.add(i + 1); // 1부터 시작
				}
			}
		}

		int[] answerArray = new int[answer.size()];
		for (int i = 0; i < answer.size(); i++)
			answerArray[i] = answer.get(i);

		return answerArray;
	}

	public boolean checkDDay(String today, String termsArray, String privaciesDateStr) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");

		// "2023.11.30" - > Date 변환
		// yy.MM.dd
		// "23.11.30 -> Date
		// "yyyy.MM.dd" // "yyMMdd" // 231130

		LocalDate todayDate = LocalDate.parse(today, formatter);
		LocalDate privacyDate = LocalDate.parse(privaciesDateStr, formatter);

		LocalDate expiryDate = privacyDate.plusMonths(Integer.parseInt(termsArray));

		return expiryDate.isBefore(todayDate) || expiryDate.isEqual(todayDate);
	}


	// 달리기 경주
	public String[] solution77(String[] players, String[] callings) {
		Map<String, Integer> playerRanks = new HashMap<>();
		String tmpName;
		int tmpRank;

		for (int i = 0; i < players.length; i++)
			playerRanks.put(players[i], i);

		for (String name : callings) {
			tmpRank = playerRanks.get(name);
			tmpName = players[tmpRank - 1];

			players[tmpRank - 1] = name;
			players[tmpRank] = tmpName;

			playerRanks.put(name, tmpRank - 1);
			playerRanks.put(tmpName, tmpRank);
		}

		// tmp = a
		//  a = b
		//  b = a

		return players;
	}

	// 과제 진행하기
//	class Plan {
//		String subject;
//		int timeInMinute;
//		int duration;
//		boolean jobDone = false;
//		public Plan(String subject, int timeInMinute, int duration) {
//			this.subject = subject;
//			this.timeInMinute = timeInMinute;
//			this.duration = duration;
//		}
//	}


//	public String[] solution78_1(String[][] plans) {
//		List<Plan> planList = new ArrayList<>();
//		List<String> answerList = new ArrayList<>();
//		Stack<Plan> pausedPlans = new Stack<>();
//
//		for (String[] p : plans)
//			planList.add(new Plan(p[0],
//					returnMinute(p[1]),
//					Integer.parseInt(p[2])));
//
//		planList.sort(Comparator.comparingInt(p -> p.timeInMinute));
//
//		int currentTime = planList.get(0).timeInMinute;
//		Plan currentPlan = null;
//		int timeToNextPlan;
//
//		for (int i = 0; i < planList.size(); i++) {
//
//			if (currentPlan != null) { // 현재 하고 있는 과제가 없으면
//				timeToNextPlan = planList.get(i).timeInMinute - currentTime;
//				// 다음 과제까지의 시간을 잽니다.
//				if (currentPlan.duration <= timeToNextPlan) {
//					// 다음 과제까지의 시간이 충분하다면
//					currentTime += currentPlan.duration;
//					answerList.add(currentPlan.subject);
//					currentPlan = null;
//				} else {
//					currentPlan.duration -= timeToNextPlan;
//					// 현재 과제의 남은 진행 시간 - 다음 과제까지의 시간
//					currentTime = planList.get(i).timeInMinute;
//					// 다음 과제로 넘어갑니다
//					pausedPlans.push(currentPlan);
//					// 하다 멈춘 과제를 Stack에 저장
//				}
//			}
//
//			currentPlan = planList.get(i);
//		}
//
//		// 마지막 순서 과제
//		if (currentPlan != null) {
//			currentTime += currentPlan.duration;
//			answerList.add(currentPlan.subject);
//		}
//
//
//
//		// 남은 과제 정리
//		while (!pausedPlans.isEmpty())
//			answerList.add(pausedPlans.pop().subject);
//
//		String[] answer = new String[answerList.size()];
//		answerList.toArray(answer);
//
//		return answer;
//	}

	public int returnMinute(String s) {
		String[] parts = s.split(":");
		return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
	}





    // 과제 진행하기
	public String[] solution78_1(String[][] plans) {
		List<Plan> planList = new ArrayList<>();

		List<String> answerList = new ArrayList<>();
		Stack<Plan> pausedPlans = new Stack<>();



		// 시간 -> 분 기준으로 바꾼다.
		// 시간을 기준으로 sort
		// 1분씩 과제 시간으로 보내면서 다음 과제랑 비교
		// 1. 시계 count 올리기, 2. 진행 시간 내리기 3. 시계 count와 다음 과제 비교
		// 모든 과제 한바퀴 돌았으면
		// 반대로 내려오면서 남은 과제 이름 담기


		for (String[] p : plans) {
			planList.add(new Plan(p[0],
					returnMinute(p[1]),
					Integer.parseInt(p[2])));
		}


		planList.sort(Comparator.comparingInt(p -> p.timeInMinute));

		int currentTime = planList.get(0).timeInMinute;

//		for (int i = 0; i < planList.size() - 1; i++) {
//			while (currentTime < planList.get(i + 1).timeInMinute) {
//				planList.get(i).duration--;
//				currentTime++;
//			}
//			if (planList.get(i).duration <= 0) {
//				planList.get(i).jobDone = true;
//				answerList.add(planList.get(i).subject);
//			}
//		}
//
//		for (int i = planList.size() - 1; i >= 0; i--) {
//			if (!(planList.get(i).jobDone))
//				answerList.add(planList.get(i).subject);
//		}

		for (int i = 0; i < planList.size(); i++) {

			Plan currentPlan = planList.get(i);

			while (currentTime < currentPlan.timeInMinute) {
				if (!pausedPlans.isEmpty()) {
					Plan pausedPlan = pausedPlans.pop();
					pausedPlan.duration--;
					if (pausedPlan.duration == 0) {
						answerList.add(pausedPlan.subject);
					} else {
						pausedPlans.push(pausedPlan);
					}
				}
				currentTime++;
			}

			while (currentPlan.duration > 0
					&& (i == planList.size() - 1 || currentTime < planList.get(i + 1).timeInMinute)) {
				currentPlan.duration--;
				currentTime++;
			}

			if (currentPlan.duration == 0) {
				answerList.add(currentPlan.subject);
			} else {
				pausedPlans.push(currentPlan);
			}
		}


		while (!pausedPlans.isEmpty()) {
			Plan pausedPlan = pausedPlans.pop();
			answerList.add(pausedPlan.subject);
		}





		String[] answer = new String[answerList.size()];
		for (int i = 0; i < answer.length; i++)
			answer[i] = answerList.get(i);

		return answer;
	}

	class Plan {
		String subject;
		int timeInMinute;
		int duration;


		public Plan(String subject, int timeInMinute, int duration) {
			this.subject = subject;
			this.timeInMinute = timeInMinute;
			this.duration = duration;

		}
	}

	// 신고 결과 받기
	public int[] solution79(String[] id_list, String[] report, int k) {
		Map<String, User79> user = new HashMap<>();
		int[] answer = new int[id_list.length];
		//Map k v

		for (String s : id_list) {
			User79 nullList = new User79();
			user.put(s, nullList);
		}

		for (String s : report) {
			String[] reporting = s.split(" ");

			String reporte_R_Id = reporting[0]; // 신고자
			String reporte_D_Id = reporting[1]; // 신고당한 사람

			User79 reporter = user.get(reporte_R_Id);
			User79 reported = user.get(reporte_D_Id);

			// 중복신고
			if (!reporter.reportUser.contains(reporte_D_Id)) {
				reporter.reportUser.add(reporte_D_Id);
				reported.whoReportMe.add(reporte_R_Id);
			}
		}

		for (int i = 0; i < answer.length; i++) {
			User79 mailedUser = user.get(id_list[i]);

			for (String reportedId : mailedUser.reportUser) {
				User79 reported = user.get(reportedId);

				if (reported.whoReportMe.size() >= k)
					answer[i]++;

			}
		}



		return answer;
	}
	class User79 {
		List<String> reportUser;
		List<String> whoReportMe;

    	public User79() {
			this.reportUser = new ArrayList<>();
			this.whoReportMe = new ArrayList<>();
		}
	}

	// 공원 산책
	public int[] solution80(String[] park, String[] routes) {
		String[][] map = new String[park.length][park[0].length()];

		int[] whereIsMyDoggy = new int[2];

		// ["SOO","OOO","OOO"]	["E 2","S 2","W 1"]
		// "SXO" "OSX" E 0 < distance == 1
		// "OOO"
		// "OOO"

		for (int i = 0; i < park.length; i++) {
			map[i] = park[i].split("");
			for (int j = 0; j < map[i].length; j++) {
				if (Objects.equals(map[i][j], "S"))
					whereIsMyDoggy = new int[]{i, j};
			}
		}

		for (String s : routes) {
			String[] order = s.split(" ");
			String direction = order[0];
			int distance = Integer.parseInt(order[1]);


			if (canITMove(direction, whereIsMyDoggy, map, distance)) {
				while (distance > 0) {
					switch (direction) {
						case "E" -> whereIsMyDoggy[1]++;
						case "W" -> whereIsMyDoggy[1]--;
						case "N" -> whereIsMyDoggy[0]--;
						case "S" -> whereIsMyDoggy[0]++;
					}
					distance--;
				}
			}
		}
		return whereIsMyDoggy;
	}
	public boolean canITMove(String direction, int[] whereIsMyDoggy, String[][] map, int distance) {
		int currentY = whereIsMyDoggy[0];
		int currentX = whereIsMyDoggy[1];

		switch (direction) {
			case "E":
				for (int i = 1; i <= distance; i++) {
					if (currentX + i >= map[0].length || Objects.equals(map[currentY][currentX + i], "X"))
						return false;
				}
				break;
			case "W":
				for (int i = 1; i <= distance; i++) {
					if (currentX - i < 0 || Objects.equals(map[currentY][currentX - i], "X"))
						return false;
				}
				break;
			case "N":
				for (int i = 1; i <= distance; i++) {
					if (currentY - i < 0 || Objects.equals(map[currentY - i][currentX], "X"))
						return false;
				}
				break;
			case "S":
				for (int i = 1; i <= distance; i++) {
					if (currentY + i >= map.length || Objects.equals(map[currentY + i][currentX], "X"))
						return false;
				}
				break;
		}

		return true;
	}

	//최댓값과 최솟값
	public String solution81(String s) {
		String[] arrayS = s.split(" ");
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;

		for (String sInt : arrayS) {
			int tmpInt = Integer.parseInt(sInt);
			if (tmpInt < min)
				min = tmpInt;
			if (tmpInt > max)
				max = tmpInt;
		}

		return min + " " + max;
	}

	// 조이스틱
	public int solution82(String name) {
		// {A , B , C}
		char[] targetNameArray = name.toCharArray();
		int totalMoveCount = 0;
		int nameLength = targetNameArray.length;
		int minLeftRight = nameLength - 1;

		for (int i = 0; i < nameLength; i++) {
			totalMoveCount += joystickMoveCounter(targetNameArray[i]);

			int nextIndex = i + 1;
			while (nextIndex < nameLength && targetNameArray[nextIndex] == 'A')
				nextIndex++;

			minLeftRight = Math.min(minLeftRight, i + nameLength - nextIndex +
					Math.min(i, nameLength - nextIndex));
		}

		totalMoveCount += minLeftRight;

		return totalMoveCount;
	}

//	public int rightORLeft(char[] targetNameArray) {
//		int length = targetNameArray.length;
//		int minMove = length - 1;
//
//		for (int i = 0; i < length; i++) {
//			int next = i + 1;
//			while (next < length && targetNameArray[next] == 'A') {
//				next++;
//			}
//
//			int move = 2 * i + length - next;
//			minMove = Math.min(minMove, move);
//		}
//
//		return minMove;
//	}

	//char[] aToM = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M'};
	//char[] zToN = {'Z', 'Y', 'X', 'W', 'V', 'U', 'T', 'S', 'R', 'Q', 'P', 'O', 'N'};


	public int joystickMoveCounter(char c) {
		return Math.min(c - 'A', 'Z' - c + 1);
	}
//	public int joystickMoveCounter (char c) {
//		if (c >= 'A' && c < 'N')
//			return c - 'A';
//		else if (c > 'N' && c <= 'Z')
//			return 'Z' - c + 1;
//		return 0;
//	}

//	public int joystickMoveCounter (char c) {
//
//		int count = 0;
//		char myA;
//
//		if (c < 'M') {
//			myA = 'A';
//
//			while(myA != c) {
//				count++;
//				myA++;
//			}
//		} else if (c > 'N') {
//			count = 1;
//			myA = 'Z';
//
//			while(myA != c) {
//				count++;
//				myA--;
//			}
//		}
//
//		return count;
//	}

	// 피보나치
	public int solution83(int n) {
		return Fibonacci_2(n);
	}

	public int Fibonacci_1 (int n) {
		if (n <= 1)
			return n;
		else
			return Fibonacci_1(n - 1) + Fibonacci_1(n - 2);
	}

	public int Fibonacci_2 (int n) {
		if (n <= 1)
			return n;

		int tmp;
		int num1 = 1;
		int num2 = 1;
		// 1 1 2 3 5 8 13
		for (int i = 2; i < n; i++) {
			tmp = num2;
			num2 = (num1 + num2) % 1234567;
			num1 = tmp;
		}
		return num1;
	}

	//이진 변환 반복하기
	public int[] solution84(String s) {
		int removeZero = 0;
		int diversionCount = 0;

		while (!s.equals("1")) {
			diversionCount++;

			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) == '0')
					removeZero++;
			}
			s = s.replace("0", "");
			s = Integer.toBinaryString(s.length());
		}

		// Integer.toString(s.length(), 8)

		return new int[] {diversionCount, removeZero};
	}

	//예상대진표
	public int solution85(int n, int a, int b)
	{
		// 총 경기 수는 항상 n - 1 번

		int matchCount = 1;

		if ( b > a ) {

			while (n >= 1) {

				if ((a % 2 == 1) && (a + 1 == b))
					return matchCount;

				if (a % 2 == 1)
					a++;
				if (b % 2 == 1)
					b++;

				a /= 2;
				b /= 2;
				n /= 2;
				matchCount++;
			}
		} else {
			while (n >= 1) {

				if ((b % 2 == 1) && (b + 1 == a))
					return matchCount;

				if (a % 2 == 1)
					a++;
				if (b % 2 == 1)
					b++;

				a /= 2;
				b /= 2;
				n /= 2;
				matchCount++;
			}
		}


		return matchCount;
	}

	// N개의 최소공배수
	public int solution86(int[] arr) {
		int answer = arr[0];

		for (int i = 1; i < arr.length; i ++) {
			answer = euclidean86 (answer, arr[i]);
		}

		return answer;
	}

	public int euclidean86(int answer, int next) {
		long lcm = (long) answer * next;
		int tmp = 1;

		while ( tmp > 0 ) {
			tmp = answer % next;
			answer = next;
			next = tmp;
		}

		return (int)lcm / answer;
	}

//	public int[] solution87(int n, long k) {
//		Set<List<Integer>> permutations = new HashSet<>();
//		List<Integer> numbers = new ArrayList<>();
//		for (int i = 1; i <= n; i++) {
//			numbers.add(i);
//		}
//		generatePermutations(new ArrayList<>(), numbers, permutations);
//
//		int[] answer = permutations.stream().findAny().get((int) k);
//		return ;
//	}

	// 줄 서는 방법
	public static int[] solution87(int n, long k) {
		int[] answer = new int[n];
		ArrayList<Integer> numbers = new ArrayList<>();

		k--;
		long factorial = 1;

		for (int i = 1; i <= n; i++) {
			factorial *= i;
			numbers.add(i);
		}

		for (int i = 0; i < n; i++) {
			factorial /= (n - i);
			int index = (int) (k / factorial);
			answer[i] = numbers.remove(index);
			k %= factorial;
		}

		// DP
		// BFS
		// DFS

		return answer;
	}

	// 멀리 뛰기
	public long solution88(int n) {

		long a = 1;
		long b = 1;
		long tmp;

		for (int i = 1; i <= n; i++) {
			tmp = a;
			a = (a + b) % 1234567;
			b = tmp;
		}

		return a;
	}

	// 1 1 2 3 5 8 13 21 34
	// 1 1 2 3 4 5 6? 7?

	//6칸
	// 1 1 1 1 1 1
//1
	// 2 1 1 1 1
	// 1 2 1 1 1
	// 1 1 2 1 1
	// 1 1 1 2 1
	// 1 1 1 1 2
//5
	// 2 2 1 1
	// 2 1 2 1
	// 2 1 1 2
	// 1 2 2 1
	// 1 2 1 2
	// 1 1 2 2
//6
	// 2 2 2
//1

	// 호텔 대실
	public int solution89(String[][] book_time) {
		List<int[]> booking = new ArrayList<>();

		for (String[] time : book_time) {
			int start = returnMinute89(time[0]);
			int end = returnMinute89(time[1]) + 10;
			booking.add(new int[]{start, end});
		}
		Collections.sort(booking, Comparator.comparingInt(a -> a[0]));

		PriorityQueue<Integer> rooms = new PriorityQueue<>();

		for (int[] reservation : booking) {
			if (!rooms.isEmpty() && rooms.peek() <= reservation[0])
				rooms.poll();
			rooms.offer(reservation[1]);
		}
		return rooms.size();
	}
	// 입실 퇴실
	public int returnMinute89(String s) {
		String[] parts = s.split(":");
		return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
	}

	// 귤 고르기
//	public static int solution90(int k, int[] tangerine) {
//		int answer = 0;
//		int sameCount = 0;
//		int currentSize = 0;
//
//		Arrays.sort(tangerine);
//
//		for (int i = tangerine.length - 1; i >= 0; i--) {
//			if (currentSize != tangerine[i]) {
//				currentSize = tangerine[i];
//				sameCount = 1;
//				answer++;
//			} else {
//				sameCount++;
//			}
//
//
//		}
//
//		return answer;
//	}

	// 귤 고르기
	public static int solution90(int k, int[] tangerine) {
		int answer = 0;
		Map<Integer, Integer> tangerineSize = new HashMap<>();
		for (int size : tangerine)
			tangerineSize.put(size, tangerineSize.getOrDefault(size, 0) + 1);

		List<Map.Entry<Integer, Integer>> entries = new ArrayList<>(tangerineSize.entrySet());

		entries.sort((a, b) -> b.getValue().compareTo(a.getValue()));

		int box = 0;
		for (Map.Entry<Integer, Integer> entry : entries) {
			if (box >= k) break;
			box += entry.getValue();
			answer++;
		}

		return answer;
	}

	// 연속 부분 수열 합의 개수
//	public int solution91(int[] elements) {
//		Set<Integer> answer = new HashSet<>();
//
//		for (int cases = 1; cases <= elements.length; cases++) {
//			for (int i = 0; i < elements.length - cases; i++) {
//				int sum = 0;
//				for (int j = i; j < i + cases; j++) {
//					sum += elements[j];
//				}
//				answer.add(sum);
//			}
////			if (cases > 1) {
////				int sum = 0;
////				int currentCases = cases
////				while (currentCases > 0) {
////					sum += elements[elements.length - 1 - currentCases];
////					currentCases--;
////				}
////
////			}
//		}
//
//		return answer.size();
//	}

	public int solution91(int[] elements) {
		Set<Integer> answer = new HashSet<>();
		int Length = elements.length;
		int[] doubleElements = new int[Length * 2];

		for (int i = 0; i < Length * 2; i++)
			doubleElements[i] = elements[i % Length];

		for (int cases = 1; cases <= Length; cases++) {
			for (int i = 0; i < Length * 2 - cases; i++) {
				int sum = 0;
				for (int j = i; j < i + cases; j++) {
					sum += doubleElements[j];
				}
				answer.add(sum);
			}
		}
		return answer.size();
	}

	// n^2 배열 자르기
	public int[] solution92(int n, long left, long right) {
//		List<Integer> answerList = new ArrayList<>();

		StringBuilder answerBuilder = new StringBuilder();



		int[] answer = new int[(int)(right - left)];
//		for (long i = 0; i + left < right; i++)
//			answer[(int)i] = answerList.get((int)(left + i));
		return answer;
	}

	public int[] solution92_1(int n, long left, long right) {
		int[] answer = new int[(int)(right - left + 1)];

		for (long i = left; i <= right; i++)
			answer[(int)(i - left)] = (int)(Math.max(i / n, i % n) + 1);

		return answer;
	}

	public static long solution93(String expression) {
		List<String> equationList = new ArrayList<>();
		StringBuilder tmp = new StringBuilder();

		for (int i = 0; i < expression.length(); i++) {
			char c = expression.charAt(i);
			if (c >= '0' && c <= '9')
				tmp.append(c);
			else {
				if (!tmp.isEmpty()) {
					equationList.add(tmp.toString());
					tmp = new StringBuilder();
				}
				equationList.add(Character.toString(c));
			}
		} // 숫자 연산자 구분
		equationList.add(tmp.toString());

		List<String> operators = Arrays.asList("+", "-", "*");
		Collections.sort(operators);

		long answer = 0;
		do {
			long result = calculate(new ArrayList<>(equationList), operators);
			answer = Math.max(answer, Math.abs(result));
		} while (nextPermutation(operators));

		return answer;
	}
	private static long calculate(List<String> elements, List<String> operators) {
		for (String op : operators) {
			for (int i = 0; i < elements.size(); i++) {
				if (elements.get(i).equals(op)) {
					long a = Long.parseLong(elements.get(i - 1));
					long b = Long.parseLong(elements.get(i + 1));
					long res = op.equals("+") ? a + b : (op.equals("-") ? a - b : a * b);
					elements.set(i - 1, String.valueOf(res));
					elements.remove(i);
					elements.remove(i);
					i--;
				}
			}
		}
		return Long.parseLong(elements.get(0));
	}

	private static boolean nextPermutation(List<String> list) {
		int i = list.size() - 2;
		while (i >= 0 && list.get(i).compareTo(list.get(i + 1)) >= 0) {
			i--;
		}
		if (i < 0) return false;

		int j = list.size() - 1;
		while (list.get(i).compareTo(list.get(j)) >= 0) {
			j--;
		}

		Collections.swap(list, i, j);
		Collections.reverse(list.subList(i + 1, list.size()));
		return true;
	}


	public static int solution94(int[][] data, int col, int row_begin, int row_end) {
		int answer = 0;

		Arrays.sort(data, new Comparator<int[]>() {
			@Override
			public int compare(int[] a, int[] b) {
				if (a[col - 1] != b[col - 1])
					return Integer.compare(a[col - 1], b[col - 1]);
				else
					return Integer.compare(b[0], a[0]);
			}
		});

		for (int i = row_begin; i <= row_end; i++) {
			int sum = 0;
			for (int j = 0; j < data[i - 1].length; j++) {
				sum += data[i - 1][j] % i;
			}
			answer ^= sum;
		}

		return answer;

		// {4, 2, 9}, {2, 2, 6}, {1, 5, 10}, {3, 8, 3}



		//정렬된 데이터에서 S_i를 i 번째 행의 튜플에 대해 각 컬럼의 값을 i 로 나눈 나머지들의 합으로 정의합니다.
		//row_begin ≤ i ≤ row_end 인 모든 S_i를 누적하여 bitwise XOR 한 값을 해시 값으로서 반환합니다.

		// 2 % 2 + 2 % 2 + 6 % 2 = 0

		//S_2 = (2 mod 2) + (2 mod 2) + (6 mod 2) = 0 입니다.
		//S_3 = (1 mod 3) + (5 mod 3) + (10 mod 3) = 4 입니다.

		//따라서 해시 값은 S_2 XOR S_3 = 4 입니다.


	}


	// 빛의 경로 사이클

	public int rows95, cols95;
	public String[] grid95;
	public boolean[][][] visited95;
	public int[] solution95(String[] grid) {

		grid95 = grid;
		rows95 = grid.length;
		cols95 = grid[0].length();
		visited95 = new boolean[rows95][cols95][4];

		List<Integer> cycles = new ArrayList<>();

		for (int i = 0; i < rows95; i++) {
			for (int j = 0; j < cols95; j++) {
				for (int k = 0; k < 4; 	   k++) {
					cycles.add(findCycle95(i, j, k));
				}
			}
		}

		return cycles.stream().sorted().mapToInt(i -> i).toArray();
	}

	public int findCycle95 (int row, int col, int dir) {
		int answer = 0;

		while (!visited95[row][col][dir]) {
			visited95[row][col][dir] = true;
			answer++;

			if (grid95[row].charAt(col) == 'L') dir = (dir + 3) % 4;
			else if (grid95[row].charAt(col) == 'R') dir = (dir + 1) % 4;

			row = (dir == 0) ? (row + 1) % rows95 : (dir == 2) ? (row - 1 + rows95) % rows95 : row;
			col = (dir == 1) ? (col - 1 + cols95) % cols95 : (dir == 3) ? (col + 1) % cols95 : col;
		}

		return answer;
	}


	// 여행 경로





	public int solution96(String[][] maps) {
		// 입력값 〉	[[1, 0, 1, 1, 1],
		// 			[1, 0, 1, 0, 1],
		// 			[1, 0, 1, 1, 1],
		// 			[1, 1, 1, 0, 1],
		// 			[0, 0, 0, 0, 1]]
		// 기댓값 〉	11

		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};

		// int[] xy {-1, 0 , 1, 0, -1}

		Boolean[][] isVisited = new Boolean[maps.length][maps[0].length];
		Queue<int[]> queue = new LinkedList<>();

		isVisited[0][0] = true;
		queue.add(new int[]{0, 0, 1});

		while (!queue.isEmpty()) {
			int[] current = queue.poll();
			int x = current[0];
			int y = current[1];
			int L = current[2];

			if (x == maps.length - 1 && y == maps[0].length - 1)
				return L;

			for (int i = 0; i < 4; i++) {
				int nextX = x + dx[i];
				int nextY = y + dy[i];

//				if (nextX < 0 || nextY < 0 ||
//						nextX >= maps.length || nextY >= maps[0].length ||
//						maps[nextX][nextY] == 0 || isVisited[nextX][nextY] != null)
//					continue;

				isVisited[nextX][nextY] = true;
				queue.add(new int[]{nextX, nextY, L + 1});
			}
		}
		return -1;
	}

	// 큰 수 만들기
	public String solution97(String number, int k) {

		Stack<Character> stack = new Stack<>();
		StringBuilder answer = new StringBuilder();

		for (int i = 0; i < number.length(); i++) {
			char c = number.charAt(i);
			while (!stack.isEmpty() && stack.peek() < c && k > 0) {
				stack.pop();
				k--;
			}
			stack.push(c);
		}

		while (!stack.isEmpty())
			answer.append(stack.pop());
		answer.reverse();

		if (k != 0)
			answer.setLength(answer.length() - k);

		return answer.toString();
	}

//	public String solution97(String number, int k) {
//		StringBuilder answer = new StringBuilder();
//
//		for (int i = 0; i < number.length() - k; i++) {
//			char charInt = '0';
//
//			for (int j = 0; j <= )
//
//
//		}
//
//
//
//		String answer = "";
//		return answer;
//	}


}


// import java.util.*;

















