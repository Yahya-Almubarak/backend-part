package com.kaukayarvisoft.anders.score;


import static com.kaukayarvisoft.anders.score.utilities.Constants.DATE_TIME_FORMATTER;

import java.io.StringWriter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.util.JSONPObject;

import netscape.javascript.JSObject;

@Service
public class ScoreListService {
	@Autowired
	AndersScoreRepository scoreRepository;
	
	
	public List<Score> getScores() {	
		return scoreRepository.findAll(); 
	}
	
	public List<Score> getScoresAsc() {
		List<Score> list = (List<Score>) scoreRepository.findAllByOrderByScoreAsc();
		return list; 
	}
	
	public List<Score> getScoresDsc() {
		List<Score> list = (List<Score>) scoreRepository.findAllByOrderByScoreDesc();
		return list; 
	}


	public Score save(Score newScore) {
		newScore.setDateAsString(LocalDateTime.now().format(DATE_TIME_FORMATTER));
		return scoreRepository.save(newScore);	
	}
	
	public Optional<Score> findById(Long id){
		return scoreRepository.findById(id);
	}
	
	public void deleteById(Long id) {
		scoreRepository.deleteById(id);
	}
	
	
}
