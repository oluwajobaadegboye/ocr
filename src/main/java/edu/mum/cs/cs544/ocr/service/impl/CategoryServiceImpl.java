package edu.mum.cs.cs544.ocr.service.impl;


import edu.mum.cs.cs544.ocr.domain.Category;
import edu.mum.cs.cs544.ocr.repository.CategoryRepository;
import edu.mum.cs.cs544.ocr.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public List<Category> findAll() {
		List<Category> list = new ArrayList<>();
		categoryRepository.findAll().forEach((Category c) -> list.add(c));
		return list;
	}

	@Override
	public Category getById(int id) {
		return categoryRepository.findById(id).orElse(null);
	}

	@Override
	public int save(Category category) {
		return categoryRepository.save(category).getId();
	}

}
