package pl.coderslab.Service.implementation;

import java.util.Collection;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.coderslab.DAO.CategoryDao;
import pl.coderslab.Service.CategoryService;
import pl.coderslab.dto.CategoryDTO;
import pl.coderslab.entity.Category;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryDao categoryDao;

    @Autowired
    public CategoryServiceImpl(CategoryDao categoryDao) {
	this.categoryDao = categoryDao;
    }

    @Override
    public CategoryDTO save(CategoryDTO dto) {
	Category category = toCategoryEntity(dto);
	return categoryDao.saveToDB(category).toDto();
    }

    @Override
    public CategoryDTO find(Long id) {
	return categoryDao.findById(id).toDto();
    }

    @Override
    public CategoryDTO update(CategoryDTO dto) {
	Category category = toCategoryEntity(dto);
	return categoryDao.updateEntity(category).toDto();
    }

    @Override
    public void remove(Long id) {
	Category category = categoryDao.findById(id);
	categoryDao.delete(category);
    }

    @Override
    public Collection<CategoryDTO> getAll() {
	return categoryDao.findAll().stream()
		.filter(Objects::nonNull)
		.map(Category::toDto)
		.collect(Collectors.toList());
    }

    protected Category toCategoryEntity(CategoryDTO dto) {
	Category category;
	if (dto.getId() == null) {
	    category = new Category();
	} else {
	    if (categoryDao.findById(dto.getId()) != null) {
		category = categoryDao.findById(dto.getId());
	    } else {
		category = new Category();
	    }
	}
	if (dto.getId() != null) {
	    category.setId(dto.getId());
	}
	if (dto.getName() != null) {
	    category.setName(dto.getName());
	}
	if (dto.getDescription() != null) {
	    category.setDescription(dto.getDescription());

	}
	return category;
    }

}
