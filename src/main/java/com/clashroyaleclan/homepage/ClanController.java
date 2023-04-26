package com.clashroyaleclan.homepage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

@Controller
public class ClanController {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${api.key}")
    private String apiKey;

    @GetMapping("/clans")
    public String getClan(@RequestParam("clanTag") String clanTag, Model model) {
        Clan clan = fetchClan(clanTag);
        model.addAttribute("clan", clan);

        ClanMember[] clanMembers = fetchClanMembers(clanTag);
        model.addAttribute("clanMembers", clanMembers);

        return "clan";
    }

    private Clan fetchClan(String clanTag) {
        try {
            String decodedClanTag = URLDecoder.decode(clanTag, StandardCharsets.UTF_8.toString());
            HttpHeaders headers = new HttpHeaders();
            headers.set("Authorization", "Bearer " + apiKey);
            HttpEntity<String> httpEntity = new HttpEntity<>(headers);

            ResponseEntity<Clan> responseEntity = restTemplate.exchange(
                    "https://api.clashroyale.com/v1/clans/" + decodedClanTag,
                    HttpMethod.GET,
                    httpEntity,
                    Clan.class);
            return responseEntity.getBody();
        } catch (Exception e) {
            // Handle the exception (e.g., log the error, return an error message, etc.)
            return null;
        }
    }

    private ClanMember[] fetchClanMembers(String clanTag) {
        try {
            String decodedClanTag = URLDecoder.decode(clanTag, StandardCharsets.UTF_8.toString());
            HttpHeaders headers = new HttpHeaders();
            headers.set("Authorization", "Bearer " + apiKey);
            HttpEntity<String> httpEntity = new HttpEntity<>(headers);

            ResponseEntity<ClanMember[]> responseEntity = restTemplate.exchange(
                    "https://api.clashroyale.com/v1/clans/" + decodedClanTag + "/members",
                    HttpMethod.GET,
                    httpEntity,
                    ClanMember[].class);
            return responseEntity.getBody();
        } catch (Exception e) {
            // Handle the exception (e.g., log the error, return an error message, etc.)
            return new ClanMember[0];
        }
    }
}
