package com.selflearning.battle.battleship.model;

public interface IPlayer {
	public void setArena(IArena arena);

	public IArena getArena();

	void setStatus(HitOrMissOrFinish hitOrMiss);

	public HitOrMissOrFinish getStatus();
	public String getName() ;

	public void setName(String name) ;
}
