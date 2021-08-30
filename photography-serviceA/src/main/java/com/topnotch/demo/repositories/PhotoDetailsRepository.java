package com.topnotch.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.topnotch.demo.models.PhotoDetails;

public interface PhotoDetailsRepository extends JpaRepository<PhotoDetails, Long>{

}
