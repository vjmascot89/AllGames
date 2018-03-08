package com.selflearning.battle.battleship.model;

public interface IArena<T> {
	public boolean initialize();

	public boolean createBoard(IPlay playBoard);

	public HitOrMissOrFinish makeMove(Input input);

	public T getFieldArrangment();
}
