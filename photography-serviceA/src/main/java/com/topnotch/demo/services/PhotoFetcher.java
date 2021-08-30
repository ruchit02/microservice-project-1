package com.topnotch.demo.services;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.topnotch.demo.dtos.Curated;

import reactor.core.publisher.Mono;

@Service
public class PhotoFetcher {

	private static final String LOCATION = "https://api.pexels.com/v1/curated?page=1&per_page=1" ;
	private static final String KEY = "563492ad6f91700001000001f9ce61179abe4c639bb3c05835384668" ;
	
	public Mono<Curated> fetch(){
		
		Mono<Curated> photo = WebClient.builder().build()
						   						 .get()
						   						 .uri( LOCATION )
						   						 .header( "Authorization" , KEY )
						   						 .accept( MediaType.APPLICATION_JSON )
						   						 .retrieve()
						   						 .bodyToMono( Curated.class ) ;
		
		return photo ;
	}
}
