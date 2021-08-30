package com.topnotch.demo.utils;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;

@Service
public class DiscoveryUtil {

	@Autowired
	private DiscoveryClient discClient;

	public String getServiceUri(String serviceName) {

		List<ServiceInstance> info = discClient.getInstances(serviceName);

		String serviceURI = info.get(0).getUri().toString();

		return serviceURI;
	}
}
