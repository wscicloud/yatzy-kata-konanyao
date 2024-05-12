package com.yatzy.kata;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.AggregateWith;
import org.junit.jupiter.params.provider.CsvSource;

import com.yatzy.kata.aggregator.RollAggregator;

public class YatzyScoreTest {
	
	@DisplayName("change")
	@ParameterizedTest(name = "[{index}]: expected:{0} => d1:{1}, d2:{2}, d3:{3}, d4:{4}, d5:{5}")
	@CsvSource({
		"15, 2, 3, 4, 5, 1", 
		"16, 3, 3, 4, 5, 1", 
		"14, 1, 1, 3, 3, 6",
		"21, 4, 5, 5, 6, 1"
	})
	public void chance(String expected, @AggregateWith(RollAggregator.class) Roll roll) {
		assertEquals(Integer.valueOf(expected), CategoryEnum.CHANGE.scoreCalculator(roll));
	}

	@DisplayName("yatzy")
	@ParameterizedTest(name = "[{index}]: expected:{0} => d1:{1}, d2:{2}, d3:{3}, d4:{4}, d5:{5}")
	@CsvSource({
		"50, 4, 4, 4, 4, 4", 
		"50, 6, 6, 6, 6, 6", 
		"0, 6, 6, 6, 6, 3",
		"50, 1, 1, 1, 1, 1",
		"0, 1, 1, 1, 2, 1"
	})
	public void yatzy(String expected, @AggregateWith(RollAggregator.class) Roll roll) {
		assertEquals(Integer.valueOf(expected), CategoryEnum.YATZY.scoreCalculator(roll));

	}

	@DisplayName("ones")
	@ParameterizedTest(name = "[{index}]: expected:{0} => d1:{1}, d2:{2}, d3:{3}, d4:{4}, d5:{5}")
	@CsvSource({
		"1, 1, 2, 3, 4, 5", 
		"2, 1, 2, 1, 4, 5", 
		"0, 6, 6, 6, 6, 3",
		"4, 1, 2, 1, 1, 1",
		"0, 3, 3, 3, 4, 5"
	})
	public void ones(String expected, @AggregateWith(RollAggregator.class) Roll roll) {
		assertEquals(Integer.valueOf(expected), CategoryEnum.ONES.scoreCalculator(roll));

	}

	@DisplayName("twos")
	@ParameterizedTest(name = "[{index}]: expected:{0} => d1:{1}, d2:{2}, d3:{3}, d4:{4}, d5:{5}")
	@CsvSource({
		"4, 1, 2, 3, 2, 6", 
		"10, 2, 2, 2, 2, 2", 
		"4, 2, 3, 2, 5, 1"
	})
	public void twos(String expected, @AggregateWith(RollAggregator.class) Roll roll) {
		assertEquals(Integer.valueOf(expected), CategoryEnum.TWOS.scoreCalculator(roll));

	}

	@DisplayName("threes")
	@ParameterizedTest(name = "[{index}]: expected:{0} => d1:{1}, d2:{2}, d3:{3}, d4:{4}, d5:{5}")
	@CsvSource({
		"6, 1, 2, 3, 2, 3", 
		"12, 2, 3, 3, 3, 3"
	})
	public void threes(String expected, @AggregateWith(RollAggregator.class) Roll roll) {
		assertEquals(Integer.valueOf(expected), CategoryEnum.THREES.scoreCalculator(roll));

	}

	@DisplayName("fours")
	@ParameterizedTest(name = "[{index}]: expected:{0} => d1:{1}, d2:{2}, d3:{3}, d4:{4}, d5:{5}")
	@CsvSource({
		"12, 4, 4, 4, 5, 5", 
		"8, 4, 4, 5, 5, 5",
		"4, 4, 5, 5, 5, 5",
		"8, 1, 1, 2, 4, 4"
	})
	public void fours(String expected, @AggregateWith(RollAggregator.class) Roll roll) {
		assertEquals(Integer.valueOf(expected), CategoryEnum.FOURS.scoreCalculator(roll));

	}

	@DisplayName("fives")
	@ParameterizedTest(name = "[{index}]: expected:{0} => d1:{1}, d2:{2}, d3:{3}, d4:{4}, d5:{5}")
	@CsvSource({
		"10, 4, 4, 4, 5, 5", 
		"15, 4, 4, 5, 5, 5",
		"20, 4, 5, 5, 5, 5"
	})
	public void fives(String expected, @AggregateWith(RollAggregator.class) Roll roll) {
		assertEquals(Integer.valueOf(expected), CategoryEnum.FIVES.scoreCalculator(roll));

	}

	@DisplayName("sixes")
	@ParameterizedTest(name = "[{index}]: expected:{0} => d1:{1}, d2:{2}, d3:{3}, d4:{4}, d5:{5}")
	@CsvSource({
		"0, 4, 4, 4, 5, 5", 
		"6, 4, 4, 6, 5, 5",
		"18, 6, 5, 6, 6, 5"
	})
	public void sixes(String expected, @AggregateWith(RollAggregator.class) Roll roll) {
		assertEquals(Integer.valueOf(expected), CategoryEnum.SIXES.scoreCalculator(roll));

	}

	@DisplayName("pair")
	@ParameterizedTest(name = "[{index}]: expected:{0} => d1:{1}, d2:{2}, d3:{3}, d4:{4}, d5:{5}")
	@CsvSource({
		"6, 3, 4, 3, 5, 6", 
		"10, 5, 3, 3, 3, 5",
		"12, 5, 3, 6, 6, 5",
		"0, 1, 2, 3, 4, 5",
		"8, 3, 3, 3, 4, 4",
		"12, 1, 1, 6, 2, 6",
		"6, 3, 3, 3, 4, 1",
		"6, 3, 3, 3, 3, 1",
		"0, 1, 2, 3, 4, 5"
	})
	public void pair(String expected, @AggregateWith(RollAggregator.class) Roll roll) {
		assertEquals(Integer.valueOf(expected), CategoryEnum.PAIR.scoreCalculator(roll));

	}

	@DisplayName("twoPairs")
	@ParameterizedTest(name = "[{index}]: expected:{0} => d1:{1}, d2:{2}, d3:{3}, d4:{4}, d5:{5}")
	@CsvSource({
		"16, 3, 3, 5, 4, 5", 
		"16, 3, 3, 5, 5, 5",
		"8, 1, 1, 2, 3, 3",
		"0, 1, 1, 2, 3, 4",
		"6, 1, 1, 2, 2, 2",
		"0, 3, 3, 3, 3, 1"
	})
	public void twoPairs(String expected, @AggregateWith(RollAggregator.class) Roll roll) {
		assertEquals(Integer.valueOf(expected), CategoryEnum.TOW_PAIRS.scoreCalculator(roll));

	}

	@DisplayName("threeOfAKind")
	@ParameterizedTest(name = "[{index}]: expected:{0} => d1:{1}, d2:{2}, d3:{3}, d4:{4}, d5:{5}")
	@CsvSource({
		"9, 3, 3, 3, 4, 5", 
		"15, 5, 3, 5, 4, 5",
		"9, 3, 3, 3, 3, 5",
		"9, 3, 3, 3, 3, 3",
		"9, 3, 3, 3, 4, 5",
		"0, 3, 3, 4, 5, 6",
		"9, 3, 3, 3, 3, 1"
	})
	public void threeOfAKind(String expected, @AggregateWith(RollAggregator.class) Roll roll) {
		assertEquals(Integer.valueOf(expected), CategoryEnum.THREE_OF_A_KIND.scoreCalculator(roll));

	}

	@DisplayName("fourOfAKind")
	@ParameterizedTest(name = "[{index}]: expected:{0} => d1:{1}, d2:{2}, d3:{3}, d4:{4}, d5:{5}")
	@CsvSource({
		"12, 3, 3, 3, 3, 5", 
		"20, 5, 5, 5, 4, 5",
		"8, 2, 2, 2, 2, 5",
		"0, 2, 2, 2, 5, 5",
		"8, 2, 2, 2, 2, 2"
	})
	public void fourOfAKind(String expected, @AggregateWith(RollAggregator.class) Roll roll) {
		assertEquals(Integer.valueOf(expected), CategoryEnum.FOUR_OF_A_KIND.scoreCalculator(roll));

	}

	@DisplayName("smallStraight")
	@ParameterizedTest(name = "[{index}]: expected:{0} => d1:{1}, d2:{2}, d3:{3}, d4:{4}, d5:{5}")
	@CsvSource({
		"15, 1, 2, 3, 4, 5", 
		"15, 2, 3, 4, 5, 1",
		"0, 1, 2, 2, 4, 5",
		"15, 1, 2, 3, 4, 5"
	})
	public void smallStraight(String expected, @AggregateWith(RollAggregator.class) Roll roll) {
		assertEquals(Integer.valueOf(expected), CategoryEnum.SMALL_STRAIGHT.scoreCalculator(roll));

	}

	@DisplayName("largeStraight")
	@ParameterizedTest(name = "[{index}]: expected:{0} => d1:{1}, d2:{2}, d3:{3}, d4:{4}, d5:{5}")
	@CsvSource({
		"20, 6, 2, 3, 4, 5", 
		"20, 2, 3, 4, 5, 6",
		"0, 1, 2, 2, 4, 5",
		"20, 2, 3, 4, 5, 6"
	})
	public void largeStraight(String expected, @AggregateWith(RollAggregator.class) Roll roll) {
		assertEquals(Integer.valueOf(expected), CategoryEnum.LARGE_STRAIGHT.scoreCalculator(roll));

	}

	@DisplayName("fullHouse")
	@ParameterizedTest(name = "[{index}]: expected:{0} => d1:{1}, d2:{2}, d3:{3}, d4:{4}, d5:{5}")
	@CsvSource({
		"18, 6, 2, 2, 2, 6", 
		"0, 2, 3, 4, 5, 6",
		"8, 1, 1, 2, 2, 2",
		"0, 2, 2, 3, 3, 4",
		"0, 4, 4, 4, 4, 4"
	})
	public void fullHouse(String expected, @AggregateWith(RollAggregator.class) Roll roll) {
		assertEquals(Integer.valueOf(expected), CategoryEnum.FULL_HOUSE.scoreCalculator(roll));

	}
}
