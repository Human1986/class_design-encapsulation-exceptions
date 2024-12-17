package jom.com.softserve.s1.task4;

class Operation {
	public static int squareRectangle(int a, int b) {
		if (a <= 0 || b <= 0) throw new IllegalArgumentException("Both arguments should be more than zero");
		return a * b;
	}

	public static int trySquareRectangle(int a, int b) {
		int square;
		try {
			square = squareRectangle(a, b);
		} catch (IllegalArgumentException e) {
			return - 1;
		}
		return square;
	}
}