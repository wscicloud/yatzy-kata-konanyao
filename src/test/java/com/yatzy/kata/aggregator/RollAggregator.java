package com.yatzy.kata.aggregator;

import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.aggregator.ArgumentsAggregationException;
import org.junit.jupiter.params.aggregator.ArgumentsAggregator;

import com.yatzy.kata.Roll;

/**
 * Cette classe permet créer un Roll pour les tests.
 */
public class RollAggregator implements ArgumentsAggregator {

	@Override
	public Object aggregateArguments(ArgumentsAccessor accessor, ParameterContext context)
			throws ArgumentsAggregationException {

		return new Roll(accessor.getInteger(1), accessor.getInteger(2), accessor.getInteger(3), accessor.getInteger(4),
				accessor.getInteger(5));
	}

}
