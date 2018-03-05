package com.selflearning.battle.battleship.model;

public class Player implements IPlayer {

	private String name;

	private IArena arena;

	private HitOrMissOrFinish hitOrMiss;

	public Player(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setArena(IArena arena) {
		this.arena = arena;
	}

	public IArena getArena() {
		return this.arena;
	}

	public void setStatus(HitOrMissOrFinish hitOrMiss) {
		this.hitOrMiss = hitOrMiss;
	}

	public HitOrMissOrFinish getStatus() {
		return this.hitOrMiss;
	}

	public boolean equals(IPlayer player) {
		return this.getName().equals(player.getName());
	}
}
