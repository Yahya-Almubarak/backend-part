package com.kaukayarvisoft.anders.score;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.ArrayList;
import static com.kaukayarvisoft.anders.score.utilities.Constants.DATE_TIME_FORMATTER;

public class InitialScoresPopulator {
	
	/* This class has a static method getInitialScores() to return a list of dummy enteries. */
    
    private static ArrayList<Score> initialScores = new ArrayList<>();
    private static SecureRandom random = new SecureRandom();
    
    public static ArrayList<Score> getInitialScores() {
    	initialScores.add(new Score("Otho Goold", 1200D, LocalDateTime.now().plusDays(-7).plusSeconds(random.nextInt(7*24*60*60)).format(DATE_TIME_FORMATTER)));
    	initialScores.add(new Score("Prospero Tunnelly", 1300D, LocalDateTime.now().plusDays(-7).plusSeconds(random.nextInt(7*24*60*60)).format(DATE_TIME_FORMATTER)));
    	initialScores.add(new Score("Merimac Burrowes", 1320D, LocalDateTime.now().plusDays(-7).plusSeconds(random.nextInt(7*24*60*60)).format(DATE_TIME_FORMATTER)));
    	initialScores.add(new Score("Rosa Button", 11405D, LocalDateTime.now().plusDays(-7).plusSeconds(random.nextInt(7*24*60*60)).format(DATE_TIME_FORMATTER)));
    	initialScores.add(new Score("Miranda Labingi", 900D, LocalDateTime.now().plusDays(-7).plusSeconds(random.nextInt(7*24*60*60)).format(DATE_TIME_FORMATTER)));
    	initialScores.add(new Score("Matta Hayward", 1012D, LocalDateTime.now().plusDays(-7).plusSeconds(random.nextInt(7*24*60*60)).format(DATE_TIME_FORMATTER)));
    	initialScores.add(new Score("Cerdic Brown", 1798D, LocalDateTime.now().plusDays(-7).plusSeconds(random.nextInt(7*24*60*60)).format(DATE_TIME_FORMATTER)));
    	initialScores.add(new Score("Daisy Zaragamba", 670D, LocalDateTime.now().plusDays(-7).plusSeconds(random.nextInt(7*24*60*60)).format(DATE_TIME_FORMATTER)));
    	initialScores.add(new Score("Prisca Brandybuck", 16700D, LocalDateTime.now().plusDays(-7).plusSeconds(random.nextInt(7*24*60*60)).format(DATE_TIME_FORMATTER)));
    	initialScores.add(new Score("Chilimanzar Proudfoot", 1300D, LocalDateTime.now().plusDays(-7).plusSeconds(random.nextInt(7*24*60*60)).format(DATE_TIME_FORMATTER)));
    	initialScores.add(new Score("Prima Lightfoot", 1207D, LocalDateTime.now().plusDays(-7).plusSeconds(random.nextInt(7*24*60*60)).format(DATE_TIME_FORMATTER)));
    	
        
        return initialScores;
    }
  }