package com.revature.eval.java.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class EvaluationService {

	/**
	 * 1.A Speed Converter - Convert to MilesPerHour
	 * 
	 * Write a method called toMilesPerHour that has 1 parameter of type double with
	 * the name kilometersPerHour. This method needs to return the rounded value of
	 * the calculation of type long.
	 * 
	 * If the parameter kilometersPerHour is less than 0, the method toMilesPerHour
	 * needs to return -1 to indicate an invalid value.
	 * 
	 * Otherwise if it is positive, calculate the value of miles per hour, round it
	 * and return it. For conversion and rounding use Math.round().
	 */
	static class SpeedConverter {

		public static long toMilesPerHour(double kilometersPerHour) {
			return kilometersPerHour >= 0 ? Math.round(kilometersPerHour * 0.621371192) : -1;
		}

		/**
		 * 1.B Speed Converter - Print Conversion
		 * 
		 * Write another method called printConversion with 1 parameter of type double
		 * with the name kilometersPerHour. This method needs to return a String and
		 * needs to calculate milesPerHour from the kilometersPerHour parameter.
		 * 
		 * The String should print in the format: "XX km/h = YY mi/h"
		 * 
		 * XX represents the original value kilometersPerHour. YY represents the rounded
		 * milesPerHour from the kilometersPerHour parameter.
		 * 
		 * If the parameter kilometersPerHour is < 0, then print the text "Invalid
		 * Value"
		 */
		public static String printConversion(double kilometersPerHour) {
			return kilometersPerHour < 0
					? "Invalid Value"
					: kilometersPerHour + " km/h = " + toMilesPerHour(kilometersPerHour) + " mi/h";
		}
	}

	/**
	 * 2. MegaBytes and KiloBytes
	 * 
	 * Write a method called printMegaBytesAndKiloBytes that has 1 parameter of type
	 * int with the name kiloBytes.
	 * 
	 * The method should return a String and it needs to calculate the megabytes and
	 * remaining kilobytes from the kilobytes parameter.
	 * 
	 * Then it needs to print a message in the format "XX KB = YY MB and ZZ KB".
	 * 
	 * XX represents the original value kiloBytes. YY represents the calculated
	 * megabytes. ZZ represents the calculated remaining kilobytes.
	 * 
	 * For examples, when the parameter kiloBytes is 2500 it needs to print "2500 KB
	 * = 2 MB and 452 KB"
	 * 
	 * If the parameter kiloBytes is less than 0 then print the text "Invalid
	 * Value".
	 */
	public String printMegaBytesAndKiloBytes(int divisor) {
		final int MEGABYTE_SIZE = 1024;
		return divisor < 0
				? "Invalid Value"
				: divisor + " KB = " + divisor / MEGABYTE_SIZE + " MB and " + divisor % MEGABYTE_SIZE + " KB";
	}

	/**
	 * 3. Barking Dog
	 * 
	 * We have a dog that loves to bark. We need to wake up if the dog is barking at
	 * night!
	 * 
	 * Write a method shouldWakeUp that has 2 parameters.
	 * 
	 * 1st parameter should be of type boolean and be named "barking". It represents
	 * if our dog is currently barking. 2nd parameter represents the hour of the day
	 * and is of type int with the name hourOfDay and has a valid range of 0-23.
	 * 
	 * We have to wake up if the dog is barking before 8 or after 22 hours, so in
	 * that case return true.
	 * 
	 * In all other cases return false.
	 * 
	 * If the hourOfDay parameter is less than 0 or greater than 23, return false.
	 */
	public boolean shouldWakeUp(boolean isBarking, int hourOfDay) {
		return isBarking && // dog is barking
				(hourOfDay >= 0 && hourOfDay <= 23) && // hour is valid
				(hourOfDay < 8 || hourOfDay > 22); // hour is between 8 and 22
	}

	/**
	 * 4. DecimalComparator
	 * 
	 * Write a method areEqualByThreeDecimalPlaces with two parameters of type
	 * double.
	 * 
	 * The method should return boolean and it needs to return true if two double
	 * numbers are the same up to three decimal places.
	 * 
	 * Otherwise, return false;
	 */
	public boolean areEqualByThreeDecimalPlaces(double firstNum, double secondNum) {
		return Math.abs(firstNum - secondNum) < 0.001;
	}

	/**
	 * 5. Teen Number Checker
	 * 
	 * We'll say that a number is "teen" if it is in the range 13 -19 (inclusive).
	 * Write a method named hasTeen with 3 parameters of type int.
	 * 
	 * The method should return boolean and it needs to return true if ONE of the
	 * parameters is in range 13(inclusive) - 19 (inclusive). Otherwise return
	 * false.
	 */
	static class TeenNumberChecker {

		public static boolean hasTeen(int x, int y, int z) {
			return isTeen(x) || isTeen(y) || isTeen(z);
		}

		// We can initialize isTeen method first
		// Then pass the parameter to hasTeen method
		public static boolean isTeen(int number) {
			return number >= 13 && number <= 19;
		}
	}

	/**
	 * 6. Minutes To Years and Days Calculator
	 * 
	 * Write a method printYearsAndDays with parameter of type long named minutes.
	 * The method should return a string and it needs to calculate the
	 * years and days from the minutes parameter.
	 * 
	 * If the parameter is less than 0, print text "Invalid Value".
	 * 
	 * Otherwise, if the parameter is valid then it needs to print a message in the
	 * format "XX min = YY y and ZZ d".
	 * 
	 * XX represents the original value minutes. YY represents the calculated years.
	 * ZZ represents the calculated days.
	 */
	public String printYearsAndDays(long minutes) {
		final int MINUTES_IN_YEAR = 525600;
		final int MINUTES_IN_DAY = 1440;
		if (minutes < 0) {
			return "Invalid Value";
		}
		int years = (int) (minutes / MINUTES_IN_YEAR);
		int days = (int) ((minutes % MINUTES_IN_YEAR) / MINUTES_IN_DAY);
		return minutes + " min = " + years + " y and " + days + " d";
	}

	/**
	 * 7. Number In Word
	 * 
	 * Write a method called printNumberInWord. The method has one parameter number
	 * which is the whole number. The method needs to print "ZERO", "ONE", "TWO",
	 * ... "NINE", "OTHER" if the int parameter number is 0, 1, 2, .... 9 or other
	 * for any other number including negative numbers. You can use if-else
	 * statement or switch statement whatever is easier for you.
	 */
	public String printNumberInWord(int number) {
		final String[] STRING_REPRESENTATION = {
				"ZERO", "ONE", "TWO", "THREE", "FOUR", "FIVE", "SIX", "SEVEN", "EIGHT", "NINE"
		};
		return number < 0 || number > 9 ? "OTHER" : STRING_REPRESENTATION[number];
	}

	/**
	 * 8. Greatest Common Divisor
	 * 
	 * Write a method named getGreatestCommonDivisor with two parameters of type int
	 * named first and second.
	 * 
	 * If one of the parameters is < 10, the method should return -1 to indicate an
	 * invalid value. The method should return the greatest common divisor of the
	 * two numbers (int).
	 * 
	 * The greatest common divisor is the largest positive integer that can fully
	 * divide each of the integers (i.e. without leaving a remainder).
	 * 
	 * For example 12 and 30: 12 can be divided by 1, 2, 3, 4, 6, 12 30 can be
	 * divided by 1, 2, 3, 5, 6, 10, 15, 30
	 * 
	 * The greatest common divisor is 6 since both 12 and 30 can be divided by 6,
	 * and there is no resulting remainder.
	 */
	public int getGreatestCommonDivisor(int a, int b) {
		return (a < 10 || b < 10) ? -1 : __getGreatestCommonDivisor__(a, b);
	}

	// helper function to allow for returning -1 if invalid
	private int __getGreatestCommonDivisor__(int a, int b) {
		// Euclidean division method
		return b == 0 ? a : __getGreatestCommonDivisor__(b, a % b);
	}

	/**
	 * 9. First and Last Digit Sum
	 * 
	 * Write a method named sumFirstAndLastDigit with one parameter of type int
	 * called number.
	 * 
	 * The method needs to find the first and the last digit of the parameter number
	 * passed to the method, using a loop and return the sum of the first and the
	 * last digit of that number.
	 * 
	 * If the number is negative then the method needs to return -1 to indicate an
	 * invalid value.
	 */
	public int sumFirstAndLastDigit(int num) {
		// if negative, return -1
		if (num < 0) {
			return -1;
		}

		// store last digit
		int last = num % 10;

		// first digit
		while (num > 10) {
			num /= 10;
		}

		return last + num;
	}

	/**
	 * 10. Reverse String
	 * 
	 * Without using the StringBuilder or StringBuffer class, write a method that
	 * reverses a String. Example: reverse("example"); -> "elpmaxe"
	 */
	public String reverse(String string) {
		String returnString = "";
		for (int i = string.length() - 1; i >= 0; i--) {
			returnString += string.charAt(i);
		}
		return returnString;
	}

	/**
	 * 11. Acronyms
	 * 
	 * Convert a phrase to its acronym. Techies love their TLA (Three Letter
	 * Acronyms)! Help generate some jargon by writing a program that converts a
	 * long name like Portable Network Graphics to its acronym (PNG).
	 */
	public String acronym(String phrase) {
		String[] words = phrase.split("[ -]");
		String acronym = "";
		for (String word : words) {
			acronym += word.charAt(0);
		}
		return acronym.toUpperCase();
	}

	/**
	 * 12. Triangles
	 * 
	 * Determine if a triangle is equilateral, isosceles, or scalene. An equilateral
	 * triangle has all three sides the same length. An isosceles triangle has at
	 * least two sides the same length.
	 * 
	 * (It is sometimes specified as having exactly two sides the same length, but
	 * for the purposes of this exercise we'll say at least two.) A scalene triangle
	 * has all sides of different lengths.
	 */
	static class Triangle {
		private double a;
		private double b;
		private double c;

		public Triangle() {
			super();
		}

		public Triangle(double a, double b, double c) {
			this();
			this.a = a;
			this.b = b;
			this.c = c;
		}

		public double getSideOne() {
			return a;
		}

		public void setSideOne(double sideOne) {
			this.a = sideOne;
		}

		public double getSideTwo() {
			return b;
		}

		public void setSideTwo(double sideTwo) {
			this.b = sideTwo;
		}

		public double getSideThree() {
			return c;
		}

		public void setSideThree(double sideThree) {
			this.c = sideThree;
		}

		public boolean isEquilateral() {
			return a == b && b == c;
		}

		public boolean isIsosceles() {
			return (a == b || b == c || c == a);
		}

		public boolean isScalene() {
			return (a != b) && (b != c) && (c != a);
		}

	}

	/**
	 * 13. Scrabble Score
	 * 
	 * Given a word, compute the scrabble score for that word.
	 * 
	 * --Letter Values-- Letter Value
	 * 
	 * A, E, I, O, U, L, N, R, S, T = 1;
	 * D, G = 2;
	 * B, C, M, P = 3
	 * F, H, V, W, Y = 4
	 * K = 5
	 * J, X = 8
	 * Q, Z = 10;
	 * 
	 * Examples
	 * "cabbage" should be scored as worth 14 points:
	 * 
	 * 3 points for C, 1 point for A, twice 3 points for B, twice 2 points for G, 1
	 * point for E And to total:
	 * 
	 * 3 + 2*1 + 2*3 + 2 + 1 = 3 + 2 + 6 + 3 = 5 + 9 = 14
	 */
	public int getScrabbleScore(String string) {
		// this creating a map of ascii values to their respective scores, most ascii
		// chars are 0
		// a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z
		final int[] scores = { 1, 3, 3, 2, 1, 4, 2, 4, 1, 8, 5, 1, 3, 1, 1, 3, 10, 1, 1, 1, 1, 4, 4, 8, 4, 10 };
		int[] scoreMap = new int[128];

		// ignore case by adding lower case and upper case scores at the same time
		for (int i = 0; i < scores.length; i++) {
			scoreMap[i + 'A'] = scores[i]; // init uppercase values
			scoreMap[i + 'a'] = scores[i]; // init lowercase values
		}
		// this sums up the scores of that characters
		int score = 0;
		for (char element : string.toCharArray()) {
			score += scoreMap[element];
		}
		return score;
	}

	/**
	 * 14. Clean the Phone Number
	 * 
	 * Clean up user-entered phone numbers so that they can be sent SMS messages.
	 * 
	 * The North American Numbering Plan (NANP) is a telephone numbering system used
	 * by many countries in North America like the United States, Canada or Bermuda.
	 * All NANP-countries share the same international country code: 1.
	 * 
	 * NANP numbers are ten-digit numbers consisting of a three-digit Numbering Plan
	 * Area code, commonly known as area code, followed by a seven-digit local
	 * number. The first three digits of the local number represent the exchange
	 * code, followed by the unique four-digit number which is the subscriber
	 * number.
	 * 
	 * The format is usually represented as
	 * 
	 * 1 (NXX)-NXX-XXXX where N is any digit from 2 through 9 and X is any digit
	 * from 0 through 9.
	 * 
	 * Your task is to clean up differently formatted telephone numbers by removing
	 * punctuation and the country code (1) if present.
	 * 
	 * For example, the inputs
	 * 
	 * +1 (613)-995-0253
	 * 613-995-0253
	 * 1 613 995 0253
	 * 613.995.0253
	 * should all produce
	 * the output
	 * 
	 * 6139950253
	 * 
	 * Note: As this exercise only deals with telephone numbers used in
	 * NANP-countries, only 1 is considered a valid country code.
	 */
	public String cleanPhoneNumber(String string) throws IllegalArgumentException {
		string = string.replaceAll("[^0-9]", "");
		if ((string.length() > 11) || // too many digits
				(string.length() < 10) || // not enough digits
				(string.length() == 11 && !string.startsWith("1"))) // invalid country code
		{
			throw new IllegalArgumentException();
		}
		return string.substring(string.length() - 10, string.length());

	}

	/**
	 * 15. Recurring Word Counter
	 * 
	 * Given a phrase, count the occurrences of each word in that phrase.
	 * 
	 * For example for the input "olly olly in come free" olly: 2 in: 1 come: 1
	 * free: 1
	 */
	public Map<String, Integer> wordCount(String string) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		String[] words = string.split("[ ,.!;:?-]");
		for (String word : words) {
			word = word.trim();
			if (map.containsKey(word)) {
				map.put(word, map.get(word) + 1);
			} else {
				map.put(word, 1);
			}
		}
		return map;
	}

	/**
	 * 16. Armstrong Number
	 * 
	 * An Armstrong number is a number that is the sum of its own digits each raised
	 * to the power of the number of digits.
	 * 
	 * For example:
	 * 
	 * 9 is an Armstrong number, because 9 = 9^1 = 9 10 is not an Armstrong number,
	 * because 10 != 1^2 + 0^2 = 2 153 is an Armstrong number, because: 153 = 1^3 +
	 * 5^3 + 3^3 = 1 + 125 + 27 = 153 154 is not an Armstrong number, because: 154
	 * != 1^3 + 5^3 + 4^3 = 1 + 125 + 64 = 190 Write some code to determine whether
	 * a number is an Armstrong number.
	 */
	public boolean isArmstrongNumber(int input) {
		int[] digits = splitInt(input); // normally I would just use the int.toString() method, but this is more
																		// efficient
		Double sum = 0.0;
		for (int digit : digits) {
			sum += Math.pow(digit, digits.length);
		}
		return input == sum;
	}

	/**
	 * Splits a number into an array of individual digits. For example, the number
	 * 123456789 would return [1, 2, 3, 4, 5, 6, 7, 8, 9] if a negative number is
	 * passed it will return an array of negative digits.
	 * 
	 * @param input an integer to split into digits
	 * @return int array of digits in order of most significant to least significant
	 * @author SaberSams
	 */
	static int[] splitInt(int input) {
		int[] digits = new int[10];
		int i = 9;
		do {
			digits[i] = input % 10;
			input /= 10;
			i--;
		} while (input != 0);

		return Arrays.copyOfRange(digits, i + 1, 10);
	}

	/**
	 * 17. Prime Factors
	 * 
	 * Compute the prime factors of a given natural number. A prime number is only
	 * evenly divisible by itself and 1.
	 * 
	 * Note that 1 is not a prime number.
	 */
	public List<Long> calculatePrimeFactorsOf(long l) {
		List<Long> factors = new ArrayList<Long>();
		for (long i = 2; i <= l; i++) {
			while (l % i == 0) {
				factors.add(i);
				l /= i;
			}
		}
		return factors;
	}

	/**
	 * takes a number as an argument and checks if its prime
	 * 
	 * @param number = the number to check
	 * @return true if prime
	 */
	private static boolean isPrime(long number) {
		if (number <= 1) {
			return false;
		}

		for (long i = 2; i * i <= number; i++) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 18. Calculate Nth Prime
	 * 
	 * Given a number n, determine what the nth prime is.
	 * 
	 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see
	 * that the 6th prime is 13.
	 * 
	 * If your language provides methods in the standard library to deal with prime
	 * numbers, pretend they don't exist and implement them yourself.
	 */
	public int calculateNthPrime(int k) throws IllegalArgumentException {
		if (k < 1) {
			throw new IllegalArgumentException();
		}

		int i = 2;
		for (int j = 0; j < k; i++) {
			if (isPrime(i)) {
				j++;
			}
		}

		return i - 1;
	}

	/**
	 * 19. Pangram
	 * 
	 * Determine if a sentence is a pangram. A pangram (Greek: παν γράμμα, pan
	 * gramma, "every letter") is a sentence using every letter of the alphabet at
	 * least once. The best known English pangram is:
	 * 
	 * The quick brown fox jumps over the lazy dog.
	 * 
	 * The alphabet used consists of ASCII letters a to z, inclusive, and is case
	 * insensitive. Input will not contain non-ASCII symbols.
	 */
	public boolean isPangram(String string) {
		// string = string.toLowerCase();
		/*
		 * this is find for small strings or ones where you will find all letters of the
		 * alphabet quickly
		 * for (char c = 'a'; c <= 'z'; c++) {
		 * if (string.indexOf(c) == -1) {
		 * return false;
		 * }
		 * }
		 * return true;
		 */
		// this method has a time complexity of N
		boolean[] asciMap = new boolean[128];
		for (char c : string.toCharArray()) {
			asciMap[c] = true;
		}

		for (char c = 'A'; c <= 'Z'; c++) {
			// if neither the lowercase nor uppercase version of the letter was found return
			// false
			if (!(asciMap[c] || asciMap[c + 32])) {
				return false;
			}
		}
		return true;

	}

	/**
	 * 20. Sum of Multiples
	 * 
	 * Given a number, find the sum of all the unique multiples of particular
	 * numbers up to but not including that number.
	 * 
	 * If we list all the natural numbers below 20 that are multiples of 3 or 5, we
	 * get 3, 5, 6, 9, 10, 12, 15, and 18.
	 * 
	 * The sum of these multiples is 78.
	 */
	public int getSumOfMultiples(int i, int[] set) {
		HashSet<Integer> multiples = new HashSet();
		for (int number : set) {
			for (int j = number; j < i; j += number) {
				if (j % number == 0) {
					multiples.add(j);
				}
			}
		}
		int sum = 0;
		for (int number : multiples) {
			sum += number;
		}
		return sum;
	}

	/**
	 * 21. Three Magic Numbers
	 * 
	 * You work at a casino in Las Vegas. Your job is to program a slot machine to
	 * return 3 random numbers using the java.util.Random class.
	 * 
	 * Write a method to return an int array of 3 random numbers between 1 - 100.
	 * Generate the 3 random numbers (1 - 100 inclusive) using the java.util.Random
	 * class.
	 */

	public int[] threeLuckyNumbers() {
		return new int[] {
				guessingGame(0, 100),
				guessingGame(0, 100),
				guessingGame(0, 100)
		};
	}

	/**
	 * 22. Easy Guessing Game
	 * 
	 * Generates a number between the given range:
	 * 
	 * @param minimum
	 * @param maximum (inclusive)
	 * @return random int
	 *         You must use the Math.random class to generate a random number
	 *         between x and
	 *         y.
	 */
	public int guessingGame(int minimum, int maximum) {
		return (int) Math.floor(Math.random() * (maximum - minimum + 1) + minimum);
	}
}
