package com.topnotch.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.topnotch.demo.models.PhotographerDetails;

public interface PhotographerDetailsRepository extends JpaRepository<PhotographerDetails, Long>{

	PhotographerDetails findByEmail(String email);
}
