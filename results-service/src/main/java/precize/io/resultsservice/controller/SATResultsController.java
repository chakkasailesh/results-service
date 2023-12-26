package precize.io.resultsservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import precize.io.resultsservice.dto.SATResultDTO;
import precize.io.resultsservice.service.SATResultsService;

@RestController
@RequestMapping("/results")
@CrossOrigin
public class SATResultsController {
	@Autowired
	private SATResultsService satResultsService;

	@GetMapping
	public ResponseEntity<List<SATResultDTO>> getResults() {
		return ResponseEntity.ok(satResultsService.getResults());
	}

	@PutMapping
	public ResponseEntity<String> updateResult(
			@RequestBody SATResultDTO resultDTO) {
		satResultsService.updateResult(resultDTO);
		return ResponseEntity.ok("Record updated successfully");
	}

	@DeleteMapping("/{name}")
	public ResponseEntity<String> deleteResult(@PathVariable String name) {
		satResultsService.deleteResult(name);
		return ResponseEntity.ok("Record deleted successfully");
	}

	@GetMapping("/rank/{name}")
	public ResponseEntity<Integer> getRank(@PathVariable String name) {
		int rank = satResultsService.getRank(name);
		return ResponseEntity.ok(rank);
	}

	@PostMapping
	public ResponseEntity<String> addResult(
			@RequestBody SATResultDTO resultDTO) {
		satResultsService.addResult(resultDTO);
		return ResponseEntity.status(201).body("Record created successfully");
	}
}
