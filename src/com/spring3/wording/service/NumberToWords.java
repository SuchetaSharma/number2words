package com.spring3.wording.service;

public class NumberToWords {

	private static final String[] UNITS = { "One", "Two", "Three", "Four",
			"Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve",
			"Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen",
			"Eighteen", "Nineteen" };

	private static final String[] TENS = { "Ten", "Twenty", "Thirty", "Forty",
			"Fifty", "Sixty", "Seventy", "Eighty", "Ninty" };

	private static final String[] THOUSANDS = { "", "Thousand", "Million",
			"Billion", "Trillion", "Quadrillion", "Quintillion", "Sextillion" };

	public String convert(long number) {
		StringBuilder sb = new StringBuilder();
		if (number == 0) {
			return "Zero";
		}
		if (number < 0) {
			sb.append("Negative ");
			number = Math.abs(number);
		}
		long log = 1000000000000000000L, sub = number;
		int i = 7;
		do {
			sub = number / log;
			number = number % log;
			log = log / 1000;
			i--;
			if (sub != 0) {
				
				sb.append(hundredsInWords((int) sub));
				sb.append(" ");
				sb.append(THOUSANDS[i]);
				if (number != 0) {
					sb.append(" ");
				}
			}
		} while (number != 0);
		return sb.toString();
	}

	private static String hundredsInWords(int n) {
		if (n < 1 || n > 999) {
			throw new AssertionError(n);
		}
		StringBuilder sb = new StringBuilder();
		if (n > 99) {
			sb.append(UNITS[(n / 100) - 1]);
			sb.append(" Hundred");
			n = n % 100;
			if (n != 0) {
				sb.append(" ");
			}
			if(n <= 99 && n > 0){
				sb.append("and ");
			}
		}
		if (n > 19) {
			sb.append(TENS[(n / 10) - 1]);
			n = n % 10;
			if (n != 0) {
				sb.append(" ");
			}
		}
		if (n > 0) {
			sb.append(UNITS[n - 1]);
		}
		return sb.toString();
	}
}
