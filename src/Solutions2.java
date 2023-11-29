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

	// 햄버거 // 완료
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

}

// import java.util.*;

















