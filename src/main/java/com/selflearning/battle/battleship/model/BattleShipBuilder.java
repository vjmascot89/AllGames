package com.selflearning.battle.battleship.model;

public class BattleShipBuilder {

	private Character row;
	private Integer col;
	private Integer shipType;

	public BattleShipBuilder withRow(Character row) {
		this.row = row;
		return this;
	}

	public BattleShipBuilder withCol(Integer col) {
		this.col = col;
		return this;
	}

	public BattleShipBuilder withShipType(Integer shipType) {
		this.shipType = shipType;
		return this;
	}

	public BattleShip build() {
		BattleShip battleShip = new BattleShip();
		if (row != null)
			battleShip.setRow(row);
		if (col != null)
			battleShip.setCol(col);
		if (shipType != null)
			battleShip.setShipType(shipType);
		return battleShip;
	}
}
