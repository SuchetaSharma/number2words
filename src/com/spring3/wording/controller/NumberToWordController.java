package com.spring3.wording.controller;

import java.io.IOException;
import java.io.Writer;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring3.wording.service.WordingService;

@Controller
public class NumberToWordController {
	private final WordingService wordingService;

	public NumberToWordController(WordingService wordingService) {
		this.wordingService = wordingService;
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/{id}")
	public @ResponseBody void  numberToWord(@PathVariable Long id, Writer writer) throws IOException {
		writer.write(wordingService.numberToWord(id)); 
	}
}
