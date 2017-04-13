package pl.ndt.manager.utils;

import java.util.Random;

public class PasswordGenerator {

	/**
	 * Generates 8 char password from ASCII small letters, big letters and
	 * numbers.
	 * 
	 * @return Password.
	 */
	public String generatePasword() {

		Random rand = new Random();
		StringBuilder stringBuilder = new StringBuilder();
		int[] valuesTab = new int[62];
		int randValue = 0;
		int counter = 0;

		for (int i = 0; i < 10; i++) {
			valuesTab[i] = 48 + counter;
			counter++;
		}

		counter = 0;
		for (int i = 10; i < 36; i++) {
			valuesTab[i] = 65 + counter;
			counter++;
		}

		counter = 0;
		for (int i = 36; i < 62; i++) {
			valuesTab[i] = 97 + counter;
			counter++;
		}

		for (int i = 0; i < 8; i++) {
			randValue = rand.nextInt(62);
			stringBuilder.append((char) valuesTab[randValue]);
		}

		return stringBuilder.toString();
	}
}
