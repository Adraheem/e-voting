package africa.semicolon.evoting.controllers;

import africa.semicolon.evoting.data.dtos.requests.CreateVoteRequestDto;
import africa.semicolon.evoting.data.dtos.responses.VoteDto;
import africa.semicolon.evoting.services.VoteService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/vote")
public class VoteController {

    private final VoteService voteService;

    @Autowired
    public VoteController(VoteService voteService) {
        this.voteService = voteService;
    }

    @PostMapping("")
    @Operation(summary = "Cast vote")
    public ResponseEntity<VoteDto> castVote(@RequestBody @Valid CreateVoteRequestDto request){
        return new ResponseEntity<>(voteService.vote(request), HttpStatus.CREATED);
    }

}
