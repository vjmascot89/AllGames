package com.selflearning.battle.battleship.model;

public class ShipMaker {

	private IArena battleShipArena;

	public ShipMaker(IArena battleShipArena) {
		this.battleShipArena = battleShipArena;
		
	}

	public Boolean makeShips(String startCol, Integer length, Integer width, Integer shipType) {
		Boolean shipCreated = true; 
		for (int row = startCol.charAt(0); row < startCol.charAt(0) + length; row++) {
			for (int col = (int)startCol.charAt(1)-48; col < (startCol.charAt(1)-48 + width) ; col++) {
				BattleShip build = new BattleShipBuilder().withRow((char)row).withCol(col).withShipType(shipType).build();
				if(battleShipArena.getFieldArrangment().get(build.getkey())!=null||!battleShipArena.createBoard(build)){
					System.out.println("ship creation abandoned");
					shipCreated = false;
				}
			}
		}
		return shipCreated;
	}

}
