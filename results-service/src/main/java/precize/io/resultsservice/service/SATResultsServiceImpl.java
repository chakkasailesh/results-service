package precize.io.resultsservice.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import precize.io.resultsservice.dto.SATResultDTO;
import precize.io.resultsservice.entity.SATResult;
import precize.io.resultsservice.repository.SATResultRepository;

@Service
public class SATResultsServiceImpl implements SATResultsService {
	@Autowired
	private SATResultRepository resultRepository;
	@Autowired
	private ModelMapper mapper;

	public List<SATResultDTO> getResults() {
		List<SATResult> results = resultRepository.findAll();
		List<SATResultDTO> resultDTOs = new ArrayList<>();
		results.forEach(result -> resultDTOs
				.add(mapper.map(result, SATResultDTO.class)));
		return resultDTOs;
	}

	public void addResult(SATResultDTO resultDTO) {
		resultDTO.setPassed(resultDTO.getSatScore() > 30 ? "PASS" : "FAIL");
		SATResult result = mapper.map(resultDTO, SATResult.class);
		resultRepository.save(result);
	}

	public void updateResult(SATResultDTO resultDTO) {
		SATResult result = resultRepository.findByName(resultDTO.getName())
				.get();
		result.setSatScore(resultDTO.getSatScore());
		result.setPassed(resultDTO.getSatScore() > 30 ? "PASS" : "FAIL");
		resultRepository.save(result);
	}

	public void deleteResult(String name) {
		resultRepository.deleteByName(name);
	}

	public int getRank(String name) {
		List<SATResult> results = resultRepository.getRanks().get();
		int rank = 0, i = 0;
		double currScore = -1;
		while (i < results.size()) {
			if (results.get(i).getName().equals(name)) {
				if (results.get(i).getSatScore() != currScore) {
					return i + 1;
				} else
					return rank;
			} else if (results.get(i).getSatScore() != currScore)
				rank = i + 1;
			currScore = results.get(i).getSatScore();
			i++;
			System.out.println(rank + " " + i + " " + currScore);
		}
		return -1;
	}

}
