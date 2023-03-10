package africa.semicolon.evoting.controllers;

import africa.semicolon.evoting.data.dtos.requests.CreateElectionRequestDto;
import africa.semicolon.evoting.data.dtos.responses.ElectionDto;
import africa.semicolon.evoting.services.ElectionService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/election")
public class ElectionController {

    private final ElectionService electionService;

    @Autowired
    public ElectionController(ElectionService electionService) {
        this.electionService = electionService;
    }

    @PostMapping("")
    @Operation(summary = "Create new election")
    public ResponseEntity<ElectionDto> createNewElection(@RequestBody @Valid CreateElectionRequestDto request) {
        return new ResponseEntity<>(electionService.createElection(request), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get election")
    public ResponseEntity<ElectionDto> getElection(@PathVariable Long id){
        return new ResponseEntity<>(electionService.getElection(id), HttpStatus.OK);
    }

    @PutMapping("")
    @Operation(summary = "Update election")
    public ResponseEntity<ElectionDto> updateElection(@RequestBody ElectionDto request){
        return new ResponseEntity<>(electionService.updateElection(request), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete election")
    public ResponseEntity<String> deleteElection(@PathVariable Long id){
        electionService.deleteElection(id);
        return new ResponseEntity<>("Deleted Successfully!", HttpStatus.OK);
    }
}
