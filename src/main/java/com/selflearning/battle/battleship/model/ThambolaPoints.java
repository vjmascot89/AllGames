package com.selflearning.battle.battleship.model;

import java.util.HashSet;
import java.util.Set;

public class ThambolaPoints implements IPlay {

	private Integer col;
	private Integer row;
	private Set<ThambolaPoints> set;
	private Integer validDirection;

	public ThambolaPoints(Integer col,Integer row){
		this.col = col;
		this.row = row;
		
	}
	public ThambolaPoints(){
		
	}
	public Integer getValidDirection() {
		return validDirection;
	}

	public void setValidDirection(Integer validDirection) {
		this.validDirection = validDirection;

	}

	public Integer getCol() {
		return col;
	}

	public void setCol(Integer col) {
		this.col = col;
	}

	public Integer getRow() {
		return row;
	}

	public void setRow(Integer row) {
		this.row = row;
	}

	public String getkey() {
		return getRow() + "" + getCol();
	}

	public Integer getValue() {
		return getRow() + getCol();
	}

	public Set<ThambolaPoints> getValidThambolaPoint() {
		return (Set<ThambolaPoints>) ((HashSet<ThambolaPoints>) set).clone();
	}

	public void setValidThambolaPoint(ThambolaPoints thambolaPoints) {
		set.add(thambolaPoints);
	}
	@Override
	public boolean equals(Object obj) {
		ThambolaPoints thambolaPoints =(ThambolaPoints)obj;
		return this.row.equals(thambolaPoints.getRow())&&this.col.equals(thambolaPoints.getCol());
	}
	@Override
	public int hashCode() {
		return this.row+this.col;
	}
}
