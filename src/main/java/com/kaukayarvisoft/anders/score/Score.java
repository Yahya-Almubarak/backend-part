package com.kaukayarvisoft.anders.score;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
public class Score {
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;	
	private String playerName;	
	private Double score;
	@JsonIgnore
	private String	dateAsString;	
	

	public Score() {}

	public Score(String name, Double mScore, String mDateAsString) {
		super();
		playerName = name;
		score = mScore;
		dateAsString = mDateAsString;
	} 

}
