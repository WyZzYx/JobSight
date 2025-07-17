package org.example.jobsight.Controllers;

import org.example.jobsight.Services.JobMarketExplorerService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/jobs")
public class JobMarketExplorerController {

    private JobMarketExplorerService jobMarketExplorerService;

    public JobMarketExplorerController(JobMarketExplorerService jobMarketExplorerService) {
        this.jobMarketExplorerService = jobMarketExplorerService;
    }

    @GetMapping("/search")
    public ResponseEntity<String> advancedSearch(
            @RequestParam(required = false) String what,
            @RequestParam(required = false) String whatExclude,
            @RequestParam(required = false) String where,
            @RequestParam(required = false) Integer salaryMin,
            @RequestParam(required = false) boolean fullTime,
            @RequestParam(required = false) boolean permanent,
            @RequestParam(required = false) String sortBy
    ) {
        String response = jobMarketExplorerService.searchJobs(what, whatExclude, where, salaryMin, fullTime, permanent, sortBy);
        return ResponseEntity.ok(response);
    }
}
