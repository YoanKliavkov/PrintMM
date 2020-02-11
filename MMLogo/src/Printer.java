public class Printer {
	public static void main(String[] args) {
		printMM(5);
	}

	/**
	 * Методът printММ приема широчината на буквите и принтира MM в конзолата.
	 * Време за изпълнеие: O(width^2)
	 * Памет: O(1)
	 * 
	 * @param width - широчината на буквите
	 */
	public static void printMM(final int width) {

		// Всяко от двете М-та (те са еднакви) се състоят от width + 1 реда и width * 5
		// колони
		// Тоест двете М-та имат общо width * 10 колони

		final int rows = width + 1;
		final int cols = width * 5;

		for (int x = 0; x < rows; x++) {

			// принтираме реда два пъти, защото имаме 2 идентични М-та
			for (int p = 0; p < 2; p++) {
				for (int y = 0; y < cols; y++) {

					final int leftDiag = y - x;
					final int rightDiag = y + x;

					// За да разберем дали трябва да принтираме '-' или '*' прекарваме мисловен
					// диагонал
					// от вмоментащната точка с координати (x, y) към ред 0. Получават се две точки
					// (0, y - x) и (0, y + x).
					// Ако поне една от тези точки съответства на '*', то принтираме '*', в противен
					// случаи принтираме -.
					// Ясно се вижда че точките на ред 0 отговарящо на '*' са в колоните [width,
					// 2*width) и [3*width, 4*width).

					if ((leftDiag >= width && leftDiag < 2 * width) || (rightDiag >= 3 * width && rightDiag < 4 * width)
							|| (leftDiag >= 3 * width && leftDiag < 4 * width)
							|| (rightDiag >= width && rightDiag < 2 * width)) {
						System.out.print("*");
					} else {
						System.out.print("-");
					}
				}
			}
			
			//Нов ред
			System.out.println();
		}

	}

}
