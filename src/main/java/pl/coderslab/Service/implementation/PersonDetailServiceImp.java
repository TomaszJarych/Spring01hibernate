package pl.coderslab.Service.implementation;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.coderslab.DAO.PersonDetailDao;
import pl.coderslab.Service.PersonDetailService;
import pl.coderslab.dto.PersonDetailDto;
import pl.coderslab.entity.PersonDetail;

@Service
public class PersonDetailServiceImp implements PersonDetailService {

	private final PersonDetailDao dao;
	@Autowired
	public PersonDetailServiceImp(PersonDetailDao dao) {
		this.dao = dao;
	}
	@Override
	public PersonDetailDto save(PersonDetailDto dto) {
		PersonDetail detail = new PersonDetail(dto);
		dao.saveToDB(detail);
		return detail.toDto();
	}
	@Override
	public PersonDetailDto find(Long id) {

		return dao.findById(id).toDto();
	}
	@Override
	public PersonDetailDto update(PersonDetailDto dto) {
		PersonDetail detail = new PersonDetail(
				dao.findById(dto.getId()).toDto());
		dao.updateEntity(detail);
		return detail.toDto();
	}
	@Override
	public void remove(Long id) {
		PersonDetail detail = dao.findById(id);
		dao.delete(detail);
	}
	@Override
	public Collection<PersonDetailDto> getAll() {
		return dao.findAll().stream().map(PersonDetail::toDto)
				.collect(Collectors.toList());
	}

}
