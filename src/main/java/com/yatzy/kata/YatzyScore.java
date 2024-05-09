package com.yatzy.kata;

import java.util.List;

/**
 * Cette classe permet de calculer le score.
 */
public class YatzyScore {

	public static int chance(Roll roll) {

		return roll.sum();
	}

	public static int yatzy(Roll roll) {

		return roll.counts().values().stream().filter(value -> value == 5).findFirst().map(e -> 50).orElse(0);
	}

	private static int number(Roll roll, int number) {
		return roll.counts().getOrDefault(number, 0) * number;

	}

	public static int ones(Roll roll) {
		return number(roll, 1);
	}

	public static int twos(Roll roll) {
		return number(roll, 2);
	}

	public static int threes(Roll roll) {
		return number(roll, 3);
	}

	public static int fours(Roll roll) {
		return number(roll, 4);
	}

	public static int fives(Roll roll) {
		return number(roll, 5);
	}

	public static int sixes(Roll roll) {
		return number(roll, 6);
	}

	public static int pair(Roll roll) {
		List<Integer> pairList = roll.findPairs();

		if (pairList.isEmpty()) {
			return 0;
		}

		return pairList.get(0) * 2;
	}

	public static int twoPairs(Roll roll) {
		List<Integer> pairList = roll.findPairs();

		if (pairList.size() < 2) {
			return 0;
		}

		return pairList.stream().mapToInt(pair -> pair * 2).sum();
	}

	public static int threeOfAKind(Roll roll) {
		return roll.countDiceGreaterThan(3) * 3;

	}

	public static int fourOfAKind(Roll roll) {
		return roll.countDiceGreaterThan(4) * 4;

	}

	public static int smallStraight(Roll roll) {

		return roll.isSmallStraight() ? 15 : 0;

	}

	public static int largeStraight(Roll roll) {
		return roll.isLargeStraight() ? 20 : 0;
	}

	public static int fullHouse(Roll roll) {

		if (roll.isFullHouse()) {
			return roll.sum();
		}

		return 0;

	}
}
