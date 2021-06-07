package com.orangetalents.ConsumirAPI;


import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;



public class ConsumirAPI{

	String url = "https://parallelum.com.br/fipe/api/v1/carros/marcas";
	
	
	HttpClient client = HttpClient.newHttpClient();
	HttpRequest request = HttpRequest.newBuilder()
			.GET()
			.header("accept", "application/json")
			.uri(URI.create(url))
			.build();

//	HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
		
	
}
