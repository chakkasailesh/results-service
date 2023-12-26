package precize.io.resultsservice.service;

import java.util.List;

import precize.io.resultsservice.dto.SATResultDTO;

public interface SATResultsService {
	public List<SATResultDTO> getResults();
	public void addResult(SATResultDTO resultDTO);
	public void updateResult(SATResultDTO resultDTO);
	public void deleteResult(String name);
}
