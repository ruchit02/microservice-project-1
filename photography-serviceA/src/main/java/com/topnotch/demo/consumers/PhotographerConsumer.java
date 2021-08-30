package com.topnotch.demo.consumers;

import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.topnotch.demo.dtos.PhotographerDTO;
import com.topnotch.demo.services.TNPhotoDetailsService;

import reactor.core.publisher.Flux;

@Configuration
public class PhotographerConsumer {

	@Autowired
	private TNPhotoDetailsService photoService ;
	
	@Bean
	public Consumer<PhotographerDTO> extractPhotographerDetails(){
		
		/*return flux -> {
			
			flux.subscribe( photographer -> {
				
				System.out.println( "Photographer object received from message broker ...." );
				System.out.println( "Photographer FirstName ...." + photographer.getFirst_name() );
				System.out.println( "Photographer LastName ...." + photographer.getLast_name() );
				System.out.println( "Photographer UserName ...." + photographer.getUsername() );
				photoService.createPhotographerAcc( photographer );
			});
		};*/
		
		return photographer -> {
			
			System.out.println( "Photographer object received from message broker ...." );
			System.out.println( "Photographer FirstName ...." + photographer.getFirst_name() );
			System.out.println( "Photographer LastName ...." + photographer.getLast_name() );
			System.out.println( "Photographer UserName ...." + photographer.getUsername() );
			photoService.createPhotographerAcc( photographer );
		};
	}
}
