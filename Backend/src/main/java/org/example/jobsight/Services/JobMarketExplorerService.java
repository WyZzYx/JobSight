package org.example.jobsight.Services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class JobMarketExplorerService {

    @Value("${ADZUNA_APP_ID}")
    private String appId;

    @Value("${ADZUNA_APP_KEY}")
    private String appKey;

    private final RestTemplate restTemplate;

    public JobMarketExplorerService() {
        this.restTemplate = new RestTemplate();
    }



    public String searchJobs(String what, String whatExclude, String where, int salaryMin,
                             boolean fullTime, boolean permanent, String sortBy) {

        UriComponentsBuilder uriBuilder = UriComponentsBuilder
                .fromUriString("https://api.adzuna.com/v1/api/jobs/pl/search/1")
                .queryParam("app_id", appId)
                .queryParam("app_key", appKey)
                .queryParam("results_per_page", 20)
                .queryParam("what", what)
                .queryParam("what_exclude", whatExclude)
                .queryParam("where", where)
                .queryParam("sort_by", sortBy)
                .queryParam("salary_min", salaryMin)
                .queryParam("full_time", fullTime ? 1 : 0)
                .queryParam("permanent", permanent ? 1 : 0)
                .queryParam("content-type", "application/json");
        System.out.println("Calling Adzuna: " + uriBuilder.toUriString());


        try {
            return restTemplate.getForObject(uriBuilder.toUriString(), String.class);
        } catch (HttpClientErrorException | HttpServerErrorException e) {
            System.err.println("API Error: " + e.getStatusCode());
            System.err.println("Response body: " + e.getResponseBodyAsString());
            throw new RuntimeException("Adzuna API call failed: " + e.getMessage());
        }

    }
}
