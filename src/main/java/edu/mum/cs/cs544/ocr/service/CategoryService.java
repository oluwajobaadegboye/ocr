package edu.mum.cs.cs544.ocr.service;


import edu.mum.cs.cs544.ocr.domain.Category;

import java.util.List;

public interface CategoryService {
	List<Category> findAll();

	Category getById(int id);

	int save(Category category);
}
