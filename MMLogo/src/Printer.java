public class Printer {
	public static void main(String[] args) {
		printMM(3);
	}

	/**
	 * Методът printММ приема широчината на буквите и принтира MM в конзолата. Време
	 * за изпълнеие: O(width^2) Памет: O(1)
	 * 
	 * @param width - широчината на буквите
	 */
	public static void printMM(final int width) {

		// Всяко от двете М-та (те са еднакви) се състои от width + 1 реда и width * 5
		// колони.
		// Тоест двете М-та имат общо width * 10 колони.

		final int rows = width + 1;
		final int cols = width * 5;

		// Правим малко изчисления преди цикъла, за да не се изпълняват напразно
		// многократно.
		final int width2 = width * 2;
		final int width3 = width * 3;
		final int width4 = width * 4;

		for (int x = 0; x < rows; x++) {

			// Принтираме реда два пъти, защото имаме 2 идентични М-та.
			for (int p = 0; p < 2; p++) {
				for (int y = 0; y < cols; y++) {

					// За да начертая буквата М съставям алгоритъм, в който задавам звездите на
					// нулев ред и в следващите редове правя диагонални проекции на звездите от
					// нулевия ред.

					// Всички елементи на 0 ред с номер на колоната принадлежащ на [width, width*2)
					// или [width*3, width*4) са '*'.

					// За следващите редове проверяваме дали y - x или y + x попада в поне един от
					// интервалите [width,
					// width*2) или [width*3 , width*4).

					final int leftDiag = y - x;
					final int rightDiag = y + x;

					if ((leftDiag >= width && leftDiag < width2) || (rightDiag >= width3 && rightDiag < width4)
							|| (leftDiag >= width3 && leftDiag < width4)
							|| (rightDiag >= width && rightDiag < width2)) {
						System.out.print("*");
					} else {
						System.out.print("-");
					}
				}
			}
			// Нов ред
			System.out.println();

		}
	}
}
