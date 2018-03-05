package com.selflearning.battle.battleship.model;

public class BattleShip implements IPlay {

	private Integer col;
	private Character row;
	private Integer shipType;


	public Integer getCol() {
		return col;
	}

	public void setCol(Integer col) {
		this.col = col;
	}
	
	public Character getRow() {
		return row;
	}

	public void setRow(Character row) {
		this.row = row;
	}
	
	public Integer getShipType(){
		return shipType;
	}
	
	public void setShipType(Integer shipType) {
		this.shipType = shipType;
	}
	
	public String getkey() {
		return getRow()+""+getCol();
	}

	public Integer getValue() {
		return getShipType();
	}



}
