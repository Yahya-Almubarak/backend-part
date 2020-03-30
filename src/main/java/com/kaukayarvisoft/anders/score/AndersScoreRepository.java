package com.kaukayarvisoft.anders.score;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

// Repository
@RepositoryRestResource(collectionResourceRel = "scores", path = "scores")
public interface AndersScoreRepository extends JpaRepository<Score, Long> {
	Score save(Score score);
	List<Score> findAll();
	List<Score> findAllByOrderByScoreAsc();
	List<Score> findAllByOrderByScoreDesc();

}

