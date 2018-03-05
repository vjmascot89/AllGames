package com.selflearning.battle.battleship.model;

import java.util.Map;

import com.selflearning.battle.battleship.games.Input;

public interface IArena {
	public boolean initialize();

	public boolean createBoard(IPlay playBoard);

	public HitOrMissOrFinish makeMove(Input input);

	public Map<String,Integer> getFieldArrangment();
}
