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

}

// import java.util.*;