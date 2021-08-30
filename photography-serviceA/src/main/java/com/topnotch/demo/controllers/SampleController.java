package com.topnotch.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.topnotch.demo.dtos.Curated;
import com.topnotch.demo.models.PhotoDetails;
import com.topnotch.demo.models.PhotographerDetails;
import com.topnotch.demo.repositories.PhotographerDetailsRepository;
import com.topnotch.demo.services.PhotoFetcher;
import com.topnotch.demo.services.TNPhotoDetailsService;
import com.topnotch.demo.utils.DiscoveryUtil;

import reactor.core.publisher.Mono;

@Controller
@RequestMapping("/myapp/serviceA")
public class SampleController {

	@Autowired
	private DiscoveryUtil discUtil;

	@Autowired
	private PhotographerDetailsRepository photographerRepository;

	@Autowired
	private PhotoFetcher photoFetcher;

	@Autowired
	private TNPhotoDetailsService photoService;

	private String SERVICE_NAME = "tn-auth-service";

	@GetMapping("/homePage")
	public String displayHomepage(Model model) {

		List<PhotographerDetails> photographers = photographerRepository.findAll();
		
		if( photographers.size() > 0 ) {
			
			model.addAttribute("photographers", photographers);
		}

		return "home";
	}

	@GetMapping("/uploadPage")
	public String displaySpecialpage(ServerHttpRequest request, Model model) throws InterruptedException {

		String authHeader = request.getHeaders().getFirst( "Authorization" );
		String userId = request.getHeaders().getFirst( "UserId" ) ;

		if (authHeader == null || !authHeader.substring(0, 7).equals("Bearer ")) {

			return "redirect:" + discUtil.getServiceUri(SERVICE_NAME) + "/myapp/authService/signupPage";
		}

		System.out.println("Authorization : " + authHeader + "\nUserId : " + userId);

		Mono<Curated> curated = photoFetcher.fetch() ;

		curated.subscribe( obj -> {
			
			PhotoDetails photoDetails = photoService.uploadPhoto(obj.getPhotos().get(0), userId);
			model.addAttribute("photoDetails", photoDetails);
		});
		
		Thread.sleep(2000);
		
		return "upload";
	}
}
