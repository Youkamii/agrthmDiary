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
//		}

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

			if (지금이니)
				answer++;

		}

		return answer;

	}

}