package com.topnotch.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.topnotch.demo.models.PhotoAvailableSizesDetails;

public interface PhotoAvailableSizesDetailsRepository 
		extends JpaRepository<PhotoAvailableSizesDetails, Long>{

}
