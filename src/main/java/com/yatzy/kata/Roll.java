package com.yatzy.kata;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Cette classe représente les roulés de dé et ses opérations associées.
 */
public class Roll {

	private final List<Integer> dices;

	private static final Collector<Integer, ?, Integer> countingInt = Collectors.reducing(0,
			(previous, current) -> previous + 1);

	public Roll(int d1, int d2, int d3, int d4, int d5) {
		this.dices = Arrays.asList(d1, d2, d3, d4, d5);
	}

	public Map<Integer, Integer> counts() {
		return dices.stream().collect(Collectors.groupingBy(Function.identity(), countingInt));
	}

	public int sum() {
		return dices.stream().mapToInt(value -> value).sum();
	}

	public int countDice(int dice) {
		return counts().getOrDefault(dice, 0);
	}

	public boolean isYatzy() {
		return counts().values().stream().anyMatch(count -> count == 5);
	}

	private Stream<Integer> filterNumberOfGreaterThan(int x) {
		return counts().entrySet().stream().filter(entry -> entry.getValue() >= x).map(Entry::getKey);

	}

	public List<Integer> findPairs() {
		return filterNumberOfGreaterThan(2).sorted(Comparator.reverseOrder()).collect(Collectors.toList());

	}

	public int countDiceGreaterThan(int x) {
		return filterNumberOfGreaterThan(x).findFirst().orElse(0);

	}

	private List<Integer> sort() {
		return dices.stream().sorted().collect(Collectors.toList());
	}

	public boolean isSmallStraight() {
		return sort().equals(Arrays.asList(1, 2, 3, 4, 5));
	}

	public boolean isLargeStraight() {
		return sort().equals(Arrays.asList(2, 3, 4, 5, 6));
	}

	public boolean isFullHouse() {

		boolean hasThreeOfAKind = countDiceGreaterThan(3) != 0;
		boolean hasPair = !findPairs().isEmpty();
		boolean isYatzy = isYatzy();

		return hasThreeOfAKind && hasPair && !isYatzy;
	}

}
