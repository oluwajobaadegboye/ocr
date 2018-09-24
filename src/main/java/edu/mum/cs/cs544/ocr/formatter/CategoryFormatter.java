package edu.mum.cs.cs544.ocr.formatter;


import edu.mum.cs.cs544.ocr.domain.Category;
import edu.mum.cs.cs544.ocr.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class CategoryFormatter implements Formatter<Category> {

	@Autowired
	private CategoryService categoryService;

	@Override
	public String print(Category c, Locale locale) {
		return c.getId() + "";
	}

	@Override
	public Category parse(String text, Locale locale) {
		System.out.println("parse category " + text);
		Category category = categoryService.getById(Integer.parseInt(text));
		return category;
	}

}
