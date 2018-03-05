package com.selflearning.battle.battleship.model;

public enum HitOrMissOrFinish {

	MISS(0, "Miss"), HIT(1, "Hit"), FINISH(2, "Finish");
	private Integer intVal;
	private String stringVal;

	private HitOrMissOrFinish(Integer intVal, String stringVal) {
		this.intVal = intVal;
		this.stringVal = stringVal;
	}

	public Integer getIntVal() {
		return intVal;
	}

	public String getStringVal() {
		return stringVal;
	}

}
