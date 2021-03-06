package edu.mum.cs.cs544.ocr.controller;


import edu.mum.cs.cs544.ocr.domain.Category;
import edu.mum.cs.cs544.ocr.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

/**
 * @author Oluwajoba Adegboye
 */
@Controller
@RequestMapping("/admin/category")
public class AdminCategoryController {
	@Autowired
	CategoryService categoryService;

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public @ResponseBody
	Category addCategory(@Valid @RequestBody Category category) {
		int categoryId = categoryService.save(category);
		category.setId(categoryId);
		return category;
	}
}
