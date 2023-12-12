import java.util.StringTokenizer;
class Solution {
	private static final int[] MOVES = { -1, 0, 1, 0, -1 };

	public int[] solution(String[] park, String[] routes) {
		char[][] map = new char[park.length][park[0].length()];

		int[] startingPosition = findStartingPosition(park, map);

		for (String route : routes) {
			startingPosition = moveMap(startingPosition, route, map);
		}
		return startingPosition;
	}

	private int[] findStartingPosition(String[] park, char[][] map) {
		int[] startingPosition = new int[2];
		for (int i = 0; i < park.length; i++) {
			map[i] = park[i].toCharArray();
			for (int j = 0; j < map[i].length; j++) {
				if (map[i][j] == 'S') {
					startingPosition[0] = i;
					startingPosition[1] = j;
				}
			}
		}
		return startingPosition;
	}

	public static int[] moveMap(int[] currentPosition, String route, char[][] map) {
		StringTokenizer st = new StringTokenizer(route);
		int dir = dirNumber(st.nextToken());
		int dis = Integer.parseInt(st.nextToken());
		int nx = currentPosition[0];
		int ny = currentPosition[1];

		for (int i = 0; i < dis; i++) {
			nx += MOVES[dir];
			ny += MOVES[dir + 1];
			if (isOutOfIndex(nx, ny, map)) {
				return currentPosition;
			}
			if (map[nx][ny] == 'X') {
				return currentPosition;
			}
		}
		return new int[] { nx, ny };
	}

	private static boolean isOutOfIndex(int row, int col, char[][] map) {
		if (row < 0 | col < 0 | row >= map.length | col >= map[0].length) {
			return true;
		}
		return false;
	}

	private static int dirNumber(String dir) {
		switch (dir) {
			case "N":
				return 0;
			case "E":
				return 1;
			case "S":
				return 2;
			default:
				return 3;
		}
	}
}