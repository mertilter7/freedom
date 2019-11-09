package com.freedom.service;

import com.freedom.entity.PublisherHome;

public interface PublisherHomeService {

    PublisherHome save(PublisherHome publisherHome);

    PublisherHome getById(Long id);

    Boolean delete (Long id);

}
