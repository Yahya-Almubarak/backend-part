package com.kaukayarvisoft.anders.score;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import lombok.AllArgsConstructor;

@RestController
public class Controller {
	
	@Autowired
	ScoreListService service;
	
	@GetMapping("/scores")
	public ResponseEntity<ScoresListObject> getScores(){
		 try {
			 List<Score> list = service.getScores(); 
				ScoresListObject scoresListObject  = new ScoresListObject();
				scoresListObject.setScoreList(list);
				if(list == null  || list.isEmpty())
					return new ResponseEntity<ScoresListObject>(scoresListObject, HttpStatus.NOT_FOUND);
				return new ResponseEntity<ScoresListObject>(scoresListObject, HttpStatus.OK);
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
		    }
		
	}
	
	/* to get the list of scores in ascending order */
	@GetMapping("/scores/1")
	public ResponseEntity<ScoresListObject> getScoresAsc(){
		try {
			List<Score> list = service.getScoresAsc(); 
			ScoresListObject scoresListObject  = new ScoresListObject();
			scoresListObject.setScoreList(list);
			if(list == null  || list.isEmpty())
				return new ResponseEntity<ScoresListObject>(scoresListObject, HttpStatus.NOT_FOUND);
			return new ResponseEntity<ScoresListObject>(scoresListObject, HttpStatus.OK);
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
		    }
		
	}
	
	/* to get the list of scores in descending order */
	@GetMapping("/scores/2")
	public ResponseEntity<ScoresListObject> getScoresDsc(){
		try {
			List<Score> list = service.getScoresDsc(); 
			ScoresListObject scoresListObject  = new ScoresListObject();
			scoresListObject.setScoreList(list);
			if(list == null  || list.isEmpty())
				return new ResponseEntity<ScoresListObject>(scoresListObject, HttpStatus.NOT_FOUND);
			return new ResponseEntity<ScoresListObject>(scoresListObject, HttpStatus.OK);
		      
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
		    }
		
	}
	
	/* to add an item to the scores, the item is in the body,
	 * the item is a json object contains to values, playerName and score
	 * {
	 * 		"playerName: "gghjj",
	 * 		score: 12345
	 * }
	 * 
	 *  content-type should be application/json
	 *
	 */
	
	@PostMapping("/scores")
	  public ResponseEntity<Score> postScore(@RequestBody Score score) {
	    try {
	      Score _score = service.save(score);
	      return new ResponseEntity<>(_score, HttpStatus.CREATED);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
	    }
	  }
	@CrossOrigin
	@PutMapping("/scores")
	  public ResponseEntity<Score>  updateScore(@RequestBody Score score) {
	    Optional<Score> scoreData = service.findById(score.getId());

	    if (scoreData.isPresent()) {
	      Score _score = scoreData.get();
	      _score.setPlayerName(score.getPlayerName());
	      _score.setScore(score.getScore());
	      return new ResponseEntity<>(service.save(_score), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	@CrossOrigin
	@DeleteMapping("/scores/{id}")
	  public ResponseEntity<HttpStatus> deleteScore(@PathVariable("id") long id) {
	    try {
	      service.deleteById(id);
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
	    }
	  }

	
	
	
	
	
	
}
