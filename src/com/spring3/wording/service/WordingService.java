package com.spring3.wording.service;

public class WordingService {
	private final NumberToWords numberToWords;

	public WordingService(NumberToWords numberToWords) {
		this.numberToWords = numberToWords;
	}

	public String numberToWord(long num) {
		return numberToWords.convert(num);
	}
}