package com.freedom.service.impl;
import com.freedom.entity.PublisherHome;
import com.freedom.repository.PublisherHomeRepository;
import com.freedom.service.PublisherHomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublisherHomeImpl implements PublisherHomeService {

    private final PublisherHomeRepository  publisherHomeRepository;

    @Autowired
    public PublisherHomeImpl(PublisherHomeRepository publisherHomeRepository)  {
        this.publisherHomeRepository = publisherHomeRepository;
    }

    @Override
    public PublisherHome save(PublisherHome publisherHome) {
        publisherHome = publisherHomeRepository.save(publisherHome);
        return publisherHome;
    }

    @Override
    public PublisherHome getById(Long id) {
       return publisherHomeRepository.getOne(id);

    }

    @Override
    public Boolean delete(Long id) {
        publisherHomeRepository.deleteById(id);
        return true;
    }

    @Override
    public List<PublisherHome> findAllPublisherHome() {
        List<PublisherHome> publisherHomes = publisherHomeRepository.findAll();
        return publisherHomeRepository.findAll();
    }
}
