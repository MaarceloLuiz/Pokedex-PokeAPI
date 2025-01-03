package com.marceloluiz.Pokedex.services.api;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class APIConsumption {
	
	public String gettingData(String url) {
		try {
			URI address = URI.create(url);
			
			try(var client = HttpClient.newHttpClient()){
				var request = HttpRequest.newBuilder(address).GET().build(); //HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();
				HttpResponse<String> response = client.send(request, BodyHandlers.ofString());

				return response.body();
			}
		}
		catch(IOException | InterruptedException e) {
			throw new RuntimeException(e);
		}
	}
}
