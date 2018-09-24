package edu.mum.cs.cs544.ocr.repository;


import edu.mum.cs.cs544.ocr.domain.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Integer> {

}
