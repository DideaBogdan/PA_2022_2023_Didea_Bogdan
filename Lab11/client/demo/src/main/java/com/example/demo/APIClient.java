package com.example.demo;


import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.apache.http.HttpEntity;
import org.springframework.boot.jackson.JsonObjectDeserializer;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class APIClient {

    //private static final String API_URL = "http://localhost:8090/players/all"; // Replace with your API endpoint URL

    public List<Player> getPlayers() throws URISyntaxException, IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("http://localhost:8090/players/all"))
                .GET()
                .build();

        HttpResponse response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String json = (String) response.body();

        Gson gson = new Gson();
        Player[] playerList = gson.fromJson(json, Player[].class);


        return List.of(playerList);
    }

    public void addPlayer(Player player) throws URISyntaxException, IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();

        ObjectMapper mapper = new ObjectMapper();
        String requestBody = mapper
                .writeValueAsString(new HashMap<String, String>(){
                    {   put("username", player.getUsername());
                        put("password", player.getPassword());
                    }
                }
                );
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("http://localhost:8090/players/add-player"))
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .header("content-type", "application/json")
                .build();

        HttpResponse response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
    }

    public void updatePlayer(Player player) throws URISyntaxException, IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();


        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("http://localhost:8090/players/update-player/"+ player.getId() +"?username="+ player.getUsername() +"&password=" + player.getPassword()))
                .PUT(HttpRequest.BodyPublishers.noBody())
                .header("content-type", "application/json")
                .build();
        HttpResponse response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
    }

    public void deletePlayer(Player player) throws URISyntaxException, IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("http://localhost:8090/players/delete-player/" + player.getId()))
                .DELETE()
                .header("content-type", "application/json")
                .build();

        HttpResponse response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
    }
}
