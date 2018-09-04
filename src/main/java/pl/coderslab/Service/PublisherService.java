package pl.coderslab.Service;

import pl.coderslab.dto.PublisherDto;

public interface PublisherService extends BaseCRUD<PublisherDto, Long>{
    
    PublisherDto findByNip(String nip);
    PublisherDto findByRegon(String regon);

}
