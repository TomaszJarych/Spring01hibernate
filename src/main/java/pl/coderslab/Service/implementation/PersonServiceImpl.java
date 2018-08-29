package pl.coderslab.Service.implementation;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.coderslab.DAO.PersonDao;
import pl.coderslab.Service.PersonService;
import pl.coderslab.dto.PersonDto;
import pl.coderslab.entity.Person;

@Service
public class PersonServiceImpl implements PersonService {

	private final PersonDao dao;

	@Autowired
	public PersonServiceImpl(PersonDao dao) {
		this.dao = dao;
	}

	@Override
	public PersonDto save(PersonDto dto) {
		Person person = new Person(dto);
		dao.saveToDB(person);
		return person.toDto();
	}

	@Override
	public PersonDto find(Long id) {
		return dao.findById(id).toDto();
	}

	@Override
	public PersonDto update(PersonDto dto) {
		Person person = new Person(dto);
		dao.updateEntity(person);
		return person.toDto();
	}

	@Override
	public void remove(Long id) {
		Person person = dao.findById(id);
		dao.delete(person);

	}

	@Override
	public Collection<PersonDto> getAll() {
		return dao.findAll().stream().map(Person::toDto)
				.collect(Collectors.toList());
	}

}
