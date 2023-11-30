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

		for (int i = 0; i < terms.length; i++) {
			termsArray[i] = terms[i].split(" ");
		}

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
		boolean jobDone;

		public Plan(String subject, int timeInMinute, int duration) {
			this.subject = subject;
			this.timeInMinute = timeInMinute;
			this.duration = duration;
			this.jobDone = false;
		}
	}




}

// import java.util.*;

















