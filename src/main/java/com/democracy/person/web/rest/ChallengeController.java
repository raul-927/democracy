package com.democracy.person.web.rest;

import com.democracy.person.domain.ChallengeAttempt;
import com.democracy.person.dto.ChallengeAttemptDTO;
import com.democracy.person.service.ChallengeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.ClientHttpResponseStatusCodeException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/democracyPersonMS")
public class ChallengeController {

    @Autowired
    private ChallengeService challengeService;

    @PostMapping
    public ResponseEntity<ChallengeAttempt> select(@RequestBody ChallengeAttemptDTO challenge) {
        HttpHeaders headers = new HttpHeaders();

        ChallengeAttempt result = this.challengeService.verifyAttempt(challenge);

        return new ResponseEntity<ChallengeAttempt>(result, headers, HttpStatus.OK);
    }
}
