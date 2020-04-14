package f_recursion.D_towers_$;

/**
 * 汉偌塔问题
 */
public class TowersApp {
	static int nDisks = 3;

	public static void main(String[] args) {
		doTowers(3, 'A', 'B', 'C');
	}

	private static void doTowers(int topN, char from, char inter, char to) {
		if (topN == 1)
			System.out.println("Disk 1 from " + from + " to " + to);
		else {
			doTowers(topN - 1, from, to, inter);
			System.out.println("Disk " + topN + " from " + from + " to " + to);
			doTowers(topN - 1, inter, from, to);
		}
	}
}
