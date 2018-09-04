package pl.coderslab.DAO.Implementation;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import pl.coderslab.DAO.CategoryDao;
import pl.coderslab.entity.Category;

@Component
@Transactional
public class CategoryDaoImpl extends AbstractDAO<Category, Long> implements CategoryDao {

    @Override
    public Category findById(Long id) {
	return entityManager.find(Category.class, id);
    }

    @Override
    public Collection<Category> findAll() {
	return entityManager.createQuery("SELECT c FROM Category c").getResultList();
    }

}
