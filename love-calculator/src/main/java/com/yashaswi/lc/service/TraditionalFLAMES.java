package com.yashaswi.lc.service;

import org.springframework.stereotype.Service;

//@Service
public class TraditionalFLAMES implements LoveCalculationService {
	private final String BASE_CODE = "FLAMES";
	
	private static final String F_MEANING = "FRIENDS";
	private static final String L_MEANING = "LOVE";
	private static final String A_MEANING = "AFFECTION";
	private static final String M_MEANING = "MARRIED COUPLES";
	private static final String E_MEANING = "ENIMIES";
	private static final String S_MEANING = "SIBLINGS";
	
	public String calculateLove(String userName, String crushName) {
		
		int lettersCountInNames = (userName.length()+crushName.length());
		int lettersCountInBaseCode = BASE_CODE.length();
		
		int keyCharacterPosition = lettersCountInNames % lettersCountInBaseCode;
		
		char key = BASE_CODE.charAt(keyCharacterPosition);
		
		String result = whatsBetweenUs(key);
		
		return result;
	}

	public String whatsBetweenUs(char key) {
		String result = null;
		
		if(key == 'F') {
			result = TraditionalFLAMES.F_MEANING;
		} else if(key == 'L') {
			result = TraditionalFLAMES.L_MEANING;
		} else if(key == 'A') {
			result = TraditionalFLAMES.A_MEANING;
		} else if(key == 'M') {
			result = TraditionalFLAMES.M_MEANING;
		} else if(key == 'E') {
			result = TraditionalFLAMES.E_MEANING;
		} else if(key == 'S') {
			result = TraditionalFLAMES.S_MEANING;
		}
		
		return result;
	}

}
