package africa.semicolon.evoting.controllers;

import africa.semicolon.evoting.data.dtos.requests.CreateOfficeRequestDto;
import africa.semicolon.evoting.data.models.OfficeEntity;
import africa.semicolon.evoting.services.OfficeService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/office")
@AllArgsConstructor
public class OfficeController {

    private final OfficeService officeService;

    @PostMapping("")
    @Operation(summary = "Create new office")
    public ResponseEntity<OfficeEntity> createOffice(@RequestBody CreateOfficeRequestDto requestDto) {
        return new ResponseEntity<>(officeService.createOffice(requestDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get office by ID")
    public ResponseEntity<OfficeEntity> getOffice(@PathVariable Long id) {
        return new ResponseEntity<>(officeService.getById(id), HttpStatus.CREATED);
    }

    @GetMapping("/{electionId}/all")
    @Operation(summary = "Get all offices in an election")
    public ResponseEntity<List<OfficeEntity>> getAllOfficesInElection(@PathVariable Long electionId) {
        return new ResponseEntity<>(officeService.findAllByElectionId(electionId), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete office by Id")
    public ResponseEntity<String> deleteOffice(@PathVariable Long id) {
        officeService.deleteById(id);
        return new ResponseEntity<>("Deleted successfully!", HttpStatus.OK);
    }
}
