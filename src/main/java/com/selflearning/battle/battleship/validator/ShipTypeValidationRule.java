package com.selflearning.battle.battleship.validator;

import com.selflearning.battle.battleship.model.BattleShip;
import com.selflearning.battle.battleship.model.IPlay;

public class ShipTypeValidationRule implements IValidatorRule<Integer> {

	private Integer shipType;

	public ShipTypeValidationRule(Integer shipType) {
		this.shipType = shipType;
	}

	public boolean apply(IPlay shipType) {
		int actShipType = ((BattleShip) shipType).getShipType();
		return actShipType > 0 && actShipType <= 2;
	}

	public boolean canApply() {
		return shipType > 0 && shipType <= 2;
	}

}
