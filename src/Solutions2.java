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
			privaciesArray[i][1] = privacies[i].substring(0, 10); // 날짜 문자열 직접 저장
		}

		for (int i = 0; i < privaciesArray.length; i++) {
			for (int j = 0; j < termsArray.length; j++) {
				if (privaciesArray[i][0].equals(termsArray[j][0])) { // 문자열 비교는 equals 사용
					if (checkDDay(today, termsArray[j], privaciesArray[i][1]))
						answer.add(i + 1);
				}
			}
		}

		int[] answerArray = new int[answer.size()];
		for (int i = 0; i < answer.size(); i++)
			answerArray[i] = answer.get(i);

		return answerArray;
	}

	public boolean checkDDay(String today, String[] termsArray, String privaciesDateStr) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
		LocalDate todayDate = LocalDate.parse(today, formatter);
		LocalDate privacyDate = LocalDate.parse(privaciesDateStr, formatter);

		int monthsToAdd = Integer.parseInt(termsArray[1]);
		LocalDate expiryDate = privacyDate.plusMonths(monthsToAdd);

		return expiryDate.isBefore(todayDate) || expiryDate.isEqual(todayDate);
	}


	// 달리기 경주
	public String[] solution77(String[] players, String[] callings) {
		Map<Integer, String> rankPlayers = new HashMap<>();
		int tmpRank;
		String tmpName;

		for (int i = 0; i < players.length; i++)
			rankPlayers.put(i + 1, players[i]);

		for (String name : callings) {
			for (Map.Entry<Integer, String> entry : rankPlayers.entrySet()) {
				if (entry.getValue().equals(name)) {
					tmpRank = entry.getKey();
					tmpName = rankPlayers.get(tmpRank - 1);
					rankPlayers.put(tmpRank, tmpName);
					rankPlayers.put(tmpRank - 1, name);
					break;
				}
			}
		}

		String[] arrayAnswer = new String[rankPlayers.size()];
		for (int i = 0; i < rankPlayers.size(); i++)
			arrayAnswer[i] = rankPlayers.get(i + 1);

		return arrayAnswer;
	}





}

// import java.util.*;

















