package pl.coderslab.Service.implementation;

import java.util.Collection;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.coderslab.DAO.PublisherDao;
import pl.coderslab.Repository.PublisherRepository;
import pl.coderslab.Service.PublisherService;
import pl.coderslab.dto.PublisherDto;
import pl.coderslab.entity.Publisher;

@Service
public class PublisherServiceImpl implements PublisherService {

    private final PublisherDao dao;
    private final PublisherRepository publisherRepository;

    @Autowired
    public PublisherServiceImpl(PublisherDao dao, PublisherRepository publisherRepository) {
	this.dao = dao;
	this.publisherRepository = publisherRepository;
    }

    @Override
    public PublisherDto save(PublisherDto dto) {
	Publisher publisher = toPublisherEntity(dto);
	dao.saveToDB(publisher);
	return publisher.toDto();
    }

    @Override
    public PublisherDto update(PublisherDto dto) {
	Publisher publisher = toPublisherEntity(dto);
	dao.updateEntity(publisher);
	return publisher.toDto();
    }

    @Override
    public PublisherDto find(Long id) {
	return dao.findById(id).toDto();
    }

    @Override
    public void remove(Long id) {
	Publisher publisher = dao.findById(id);
	dao.delete(publisher);

    }

    @Override
    public Collection<PublisherDto> getAll() {
	return dao.findAll().stream().filter(Objects::nonNull)
		.map(Publisher::toDto)
		.collect(Collectors.toList());
    }

    private Publisher toPublisherEntity(PublisherDto dto) {
	Publisher publisher = new Publisher();
	publisher.setId(dto.getId());
	publisher.setName(dto.getName());
	if (dto.getNip() != null) {
	    publisher.setNip(dto.getNip());
	}
	if (dto.getRegon() != null) {
	    publisher.setRegon(dto.getRegon());
	}

	return publisher;
    }

    @Override
    public PublisherDto findByNip(String nip) {
	return publisherRepository.findByNip(nip).toDto();
    }

    @Override
    public PublisherDto findByRegon(String regon) {
	return publisherRepository.findByRegon(regon).toDto();
    }
    
    

}
