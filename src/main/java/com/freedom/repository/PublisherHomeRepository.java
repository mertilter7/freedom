package com.freedom.repository;

import com.freedom.entity.PublisherHome;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublisherHomeRepository extends JpaRepository<PublisherHome, Long> {
}
