package precize.io.resultsservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;
import precize.io.resultsservice.entity.SATResult;

@Repository
@Transactional
public interface SATResultRepository extends JpaRepository<SATResult, Long> {
	void deleteByName(String name);
	Optional<SATResult> findByName(String name);
}
