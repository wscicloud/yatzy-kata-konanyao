package com.yatzy.kata;

import java.util.function.Function;

/**
 * Cette enumeration permet de definir des catégories.
 */
public enum CategoryEnum {
	CHANGE(YatzyScore::chance),
	YATZY(YatzyScore::yatzy),
	ONES(YatzyScore::ones),
	TWOS(YatzyScore::twos),
	THREES(YatzyScore::threes),
	FOURS(YatzyScore::fours),
	FIVES(YatzyScore::fives),
	SIXES(YatzyScore::sixes),
	PAIR(YatzyScore::pair),
	TOW_PAIRS(YatzyScore::twoPairs),
	THREE_OF_A_KIND(YatzyScore::threeOfAKind),
	FOUR_OF_A_KIND(YatzyScore::fourOfAKind),
	SMALL_STRAIGHT(YatzyScore::smallStraight),
	LARGE_STRAIGHT(YatzyScore::largeStraight),
	FULL_HOUSE(YatzyScore::fullHouse);
	
	CategoryEnum(Function<Roll, Integer> computScore){
		this.computeScore = computScore;
	}
	
	public int scoreCalculator(Roll roll) {
		return this.computeScore.apply(roll);
	}

	private final Function<Roll, Integer> computeScore;
	
}
