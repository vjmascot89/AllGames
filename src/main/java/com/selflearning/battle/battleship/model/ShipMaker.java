package com.selflearning.battle.battleship.model;

public class ShipMaker {

	private IArena battleShipArena;

	public ShipMaker(IArena battleShipArena) {
		this.battleShipArena = battleShipArena;
		
	}

	public Boolean makeShips(String startCol, Integer length, Integer width, Integer shipType) {
		Boolean shipCreated = true; 
		for (int row = startCol.charAt(0); row < startCol.charAt(0) + length; row++) {
			for (int col = startCol.charAt(1); col < (startCol.charAt(1) + width); col++) {
				BattleShip build = new BattleShipBuilder().withRow((char)row).withCol(col).withShipType(shipType).build();
				if(battleShipArena.getFieldArrangment().containsKey(build.getkey())||battleShipArena.createBoard(build)){
					shipCreated = false;
				}
			}
		}
		return shipCreated;
	}

}
