package com.yashaswi.lc.service;

import org.springframework.stereotype.Service;

@Service
public class AdvancedFLAMES implements LoveCalculationService {
	private final String BASE_CODE = "FLAMES";

	private static final String F_MEANING = "FRIENDS";
	private static final String L_MEANING = "LOVE";
	private static final String A_MEANING = "AFFECTION";
	private static final String M_MEANING = "MARRIED COUPLES";
	private static final String E_MEANING = "ENIMIES";
	private static final String S_MEANING = "SIBLINGS";

	public String calculateLove(String userName, String crushName) {
		String[] newNames = removeSimilarCharacters(userName, crushName);
		userName = newNames[0];
		crushName = newNames[1];

		int lettersCountInNames = (userName.length() + crushName.length());
		int lettersCountInBaseCode = BASE_CODE.length();

		int keyCharacterPosition = lettersCountInNames % lettersCountInBaseCode;

		char key = BASE_CODE.charAt(keyCharacterPosition);

		String result = whatsBetweenUs(key);

		return result;
	}

	public String whatsBetweenUs(char key) {
		String result = null;

		if (key == 'F') {
			result = AdvancedFLAMES.F_MEANING;
		} else if (key == 'L') {
			result = AdvancedFLAMES.L_MEANING;
		} else if (key == 'A') {
			result = AdvancedFLAMES.A_MEANING;
		} else if (key == 'M') {
			result = AdvancedFLAMES.M_MEANING;
		} else if (key == 'E') {
			result = AdvancedFLAMES.E_MEANING;
		} else if (key == 'S') {
			result = AdvancedFLAMES.S_MEANING;
		}

		return result;
	}

	public String[] removeSimilarCharacters(String str1, String str2) {
		String[] modifiedStrings = new String[2];
		String modifiedStr1 = "", modifiedStr2 = "";

		for (int i = 0; i < str1.length(); i++) {
			char currentCharacter = str1.charAt(i);
			if (str2.indexOf(currentCharacter) == -1) {
				modifiedStr1 += currentCharacter;
			}
		}

		for (int i = 0; i < str2.length(); i++) {
			char currentCharacter = str2.charAt(i);
			if (str1.indexOf(currentCharacter) == -1) {
				modifiedStr2 += currentCharacter;
			}
		}

		modifiedStrings[0] = modifiedStr1;
		modifiedStrings[1] = modifiedStr2;

		return modifiedStrings;
	}
}
