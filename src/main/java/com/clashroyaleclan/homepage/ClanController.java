package com.clashroyaleclan.homepage;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class ClanController {

    private static final String API_URL = "https://api.clashroyale.com/v1/clans/%s";

    @Value("${api.key}")
    private String API_KEY;

    private static final Logger log = LoggerFactory.getLogger(ClanController.class);

    @GetMapping("/clans")
    public String getClan(@RequestParam String clanTag, Model model) throws IOException, InterruptedException {
        String encodedClanTag = URLEncoder.encode(clanTag, StandardCharsets.UTF_8);
        String apiUrl = String.format(API_URL, encodedClanTag);
        log.info("apiUrl: {}", apiUrl);

        // Set up the API request
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(apiUrl))
                .header("Authorization", "Bearer " + API_KEY)
                .header("Accept", "application/json")
                .build();

        // Send the API request and deserialize the response
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(response.body());

        // Create a Clan object and set its properties
        Clan clan = new Clan();
        clan.setName(rootNode.get("name").asText());
        clan.setTag(rootNode.get("tag").asText());
        clan.setClanWarTrophies(rootNode.get("clanWarTrophies").asInt());

        // Create a list to hold the clan members
        List<ClanMember> memberList = new ArrayList<>();

        // Loop through the memberList JSON array and create a ClanMember object for each member
        for (JsonNode memberNode : rootNode.get("memberList")) {
            ClanMember member = new ClanMember();
            member.setName(memberNode.get("name").asText());
            member.setTrophies(memberNode.get("trophies").asInt());
            memberList.add(member);
        }

        // Set the memberList property of the clan object
        clan.setMemberList(memberList);

        // Add the Clan object to the model
        model.addAttribute("clan", clan);

        // Return the name of the view to be rendered
        return "clan";
    }
}
