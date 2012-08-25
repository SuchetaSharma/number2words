package com.spring3.wording.service;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

public class NumberToWordsTest {
	NumberToWords numberToWords = new NumberToWords();
	
	@Test
	public void shouldConvertNumberToWords() {
		assertThat(numberToWords.convert(100), is("One Hundred "));
		assertThat(numberToWords.convert(10), is("Ten "));
		assertThat(numberToWords.convert(999), is("Nine Hundred and Ninty Nine "));
		assertThat(numberToWords.convert(5678), is("Five Thousand Six Hundred and Seventy Eight "));
		assertThat(numberToWords.convert(56945781), is("Fifty Six Million Nine Hundred and Forty Five Thousand Seven Hundred and Eighty One "));
	}
}
