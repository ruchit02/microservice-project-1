package com.topnotch.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.topnotch.demo.dtos.AvailableSizes;
import com.topnotch.demo.dtos.PhotographerDTO;
import com.topnotch.demo.dtos.TNPhoto;
import com.topnotch.demo.models.PhotoAvailableSizesDetails;
import com.topnotch.demo.models.PhotoDetails;
import com.topnotch.demo.models.PhotographerDetails;
import com.topnotch.demo.repositories.PhotoAvailableSizesDetailsRepository;
import com.topnotch.demo.repositories.PhotoDetailsRepository;
import com.topnotch.demo.repositories.PhotographerDetailsRepository;

@Service
public class TNPhotoDetailsService {

	@Autowired
	private PhotographerDetailsRepository photographerDetailsRepository;

	@Autowired
	private PhotoDetailsRepository photoDetailsRepository;

	@Autowired
	private PhotoAvailableSizesDetailsRepository photoAvailableSizesDetailsRepository;

	public void createPhotographerAcc(PhotographerDTO photographerDTO) {

		System.out.println("Mapping credentials to database object ....");

		PhotographerDetails photographer = new PhotographerDetails();
		photographer.setEmail(photographerDTO.getUsername());
		photographer.setPhotographer(photographerDTO.getFirst_name() + " " + photographerDTO.getLast_name());
		photographer.setPhotographer_url(
				"http://www.topnotchPhotography.com/@" + "" + photographerDTO.getFirst_name().toLowerCase());
		System.out.println("Database object created ....");

		photographerDetailsRepository.saveAndFlush(photographer);
		System.out.println("Object pushed to database ....");
	}

	public PhotoDetails uploadPhoto(TNPhoto photo, String email) {

		System.out.println("Mapping photo's metadata to photo database object ....");

		PhotoDetails dbPhoto = new PhotoDetails();
		dbPhoto.setPhoto_name(photo.getUrl());
		dbPhoto.setWidth(photo.getWidth());
		dbPhoto.setHeight(photo.getHeight());
		dbPhoto.setAvg_color(photo.getAvg_color());
		dbPhoto.setTimes_sold(0);

		PhotographerDetails photographer = photographerDetailsRepository.findByEmail(email);
		dbPhoto.setPhotographer_id(photographer);

		System.out.println("Database object created ....");

		AvailableSizes sizes = photo.getSrc();

		System.out.println("Mapping photo's metadata to availableSizes database object ....");

		PhotoAvailableSizesDetails avaiSizes = new PhotoAvailableSizesDetails();
		avaiSizes.setOriginal(sizes.getOriginal());
		avaiSizes.setLarge(sizes.getLarge());
		avaiSizes.setLarge2x(sizes.getLarge2x());
		avaiSizes.setMedium(sizes.getMedium());
		avaiSizes.setSmall(sizes.getSmall());
		avaiSizes.setPortrait(sizes.getPortrait());
		avaiSizes.setLandscape(sizes.getLandscape());
		avaiSizes.setTiny(sizes.getTiny());

		System.out.println("Database object created ....");

		dbPhoto.setAvailableSizes(avaiSizes);

		PhotoDetails photoDetails = photoDetailsRepository.saveAndFlush(dbPhoto);
		photoAvailableSizesDetailsRepository.saveAndFlush(avaiSizes);

		System.out.println("Photo object pushed to database ....");
		System.out.println("AvailableSizes object pushed to database ....");

		return photoDetails;
	}
}
