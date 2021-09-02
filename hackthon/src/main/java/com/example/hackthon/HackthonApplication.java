package com.example.hackthon;

import com.example.hackthon.dto.Commit;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;


@SpringBootApplication
public class HackthonApplication implements CommandLineRunner {

    private final RestTemplate restTemplate = new RestTemplate();

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = new
            SpringApplicationBuilder(HackthonApplication.class).web(WebApplicationType.NONE).run();
        ctx.close();
	}

    @Override
    public void run(String... args) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);


        String githubApi = "https://api.github.com/repos/SevenSenders/Hackathon/pulls/5/commits";
        String jiraAPI = "https://jira.atlassian.com/rest/api/latest/issue/";



        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "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");
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        ResponseEntity<String> response = restTemplate.exchange(githubApi, HttpMethod.GET, entity, String.class);
        Commit[] commits = objectMapper.readValue(response.getBody(), Commit[].class);
        Arrays.stream(commits).forEach(commit -> {
            String message = commit.getDetails().getMessage();
            //String ticketNumber = message.substring(message.indexOf(":"));
            System.out.println(message);
        });

    }

}
