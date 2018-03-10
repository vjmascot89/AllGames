package com.selflearning.battle.battleship.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ThambolaArena implements IArena<Set<ThambolaPoints>> {
	
	private Map<String, Set<ThambolaPoints>> fieldArrangment= new HashMap<String, Set<ThambolaPoints>>();
	
	public boolean initialize() {
		return false;
	}

	public boolean createBoard(IPlay playBoard) {
		return false;
	}

	public HitOrMissOrFinish makeMove(Input input) {
//		boolean contains = ((Set<ThambolaPoints>)this.getFieldArrangment().get(input.getInput())).contains(new ThambolaPoints(((ThambolaInput)input).getSourceRow(),((ThambolaInput)input).getSourceCol()));
		
		return HitOrMissOrFinish.HIT;
	}

	public Map<String, Set<ThambolaPoints>> getFieldArrangment() {
		return fieldArrangment;
	}
}
