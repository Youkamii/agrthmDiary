import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Solutions3 {

//	public String[] solution100(String[] orders, int[] course) {
//		Map<Integer, Map<String, Integer>> courseMap = new HashMap<>();
//		for (String order : orders) {
//			for (int courseSize : course) {
//				combination("", order, 0, courseSize, courseMap);
//			}
//		}
//
//		ArrayList<String> answerList = new ArrayList<>();
//		for (int courseSize : course) {
//			Map<String, Integer> menuMap = courseMap.getOrDefault(courseSize, new HashMap<>());
//
//			int maxOrder = 2;
//			for (Map.Entry<String, Integer> entry : menuMap.entrySet()) {
//				if (entry.getValue() >= 2) {
//					maxOrder = Math.max(maxOrder, entry.getValue());
//				}
//			}
//
//			for (Map.Entry<String, Integer> entry : menuMap.entrySet()) {
//				if (entry.getValue() == maxOrder && entry.getValue() >= 2) {
//					answerList.add(entry.getKey());
//				}
//			}
//		2}

	// 메뉴 리뉴얼
	public String[] solution100(String[] orders, int[] course) {
		String[] answer = {};
		return answer;
	}


	// List<String> menuUnit

	// for (String s : erders)
	// menuUnit.add s
	// getOrDefault menuUnit
	//  List.size >= 2 && value >= 2

	// Map <Integer, Map<Integer,List<String>>>

	// 할인 행사
	public int solution101(String[] want, int[] number, String[] discount) {

		// want	number	discount	result
		//["banana", "apple", "rice", "pork", "pot"]	[3, 2, 2, 2, 1]
		// ["chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"]	3

		int answer = 0;

		Map<String, Integer> iWantIT = new HashMap<>();
		for (int i = 0; i < want.length; i++)
			iWantIT.put(want[i], number[i]);

		// 남은 날짜가 원하는 기간 미만
		for (int i = 0; i <= discount.length - 10; i++) {
			Map<String, Integer> discountSchedule = new HashMap<>();
			for (int j = i; j < i + 10; j++)
				discountSchedule.put(discount[j], discountSchedule.getOrDefault(discount[j], 0) + 1);

			Boolean 지금이니 = true;
			for (String item : iWantIT.keySet()) {
				if (discountSchedule.getOrDefault(item, 0) < iWantIT.get(item)) {
					지금이니 = false;
					break;
				}
			}
//			if (iWantIT.equals(discountSchedule))
//				지금이니 = false; 이딴거 안된다.

			// 맵은 순서 보장,

			if (지금이니)
				answer++;

		}

		return answer;

	}

	// 튜플
	public int[] solution101(String s) {
		Map<String,Integer> myMap = new HashMap<>();
		String[] tuples = s.replaceAll("[{}]", " ").trim().split(" , ");
		// 괄호 정규식, " , " 기준으로 split
		// replace replaceAll replayFirst   },{ ->  " , "
		//2 2,1 2,1,3 2,1,3,4



		for (String tuple : tuples) {
			for (String num : tuple.split(","))
				myMap.put(num, myMap.getOrDefault(num, 0) + 1);
		} // 남은 , 기준으로 split, put

		// 친구 집인데 거의 아지트

		int[] answer = new int[myMap.size()];

		for (String key : myMap.keySet())
			answer[myMap.size() - myMap.get(key)] = Integer.parseInt(key);
		// 튜플의 순서는 등장한 빈도

		return answer;
	}

	int answer103;
	int numbersLength103;
	int[] numbers103;

	public int solution103(int[] numbers, int target) {
		answer103 = 0;
		numbersLength103 = numbers.length;
		numbers103 = numbers;

		dfs103Controller (target, 0, 0);

		return answer103;
	}

	public void dfs103Controller (int target, int nowDepth, int currentSum) {
		if (nowDepth == numbersLength103) {
			if (currentSum == target) {
				answer103++;
			}
			return;
		}

		dfs103Controller(target, nowDepth + 1, currentSum + numbers103[nowDepth]);
		dfs103Controller(target, nowDepth + 1, currentSum - numbers103[nowDepth]);
	}

	public int[] solution104(int []arr) {
		Queue<Integer> answerQueue = new LinkedList<>();
		int beforeN = -1;

		for (int i : arr) {
			if (!answerQueue.contains(i) || beforeN != i) {
				answerQueue.add(i);
				beforeN = i;
			}
		}

		return answerQueue.stream().mapToInt(i->i).toArray();
	}
}

