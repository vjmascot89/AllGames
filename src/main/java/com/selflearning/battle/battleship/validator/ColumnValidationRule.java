package com.selflearning.battle.battleship.validator;

import com.selflearning.battle.battleship.model.BattleShip;
import com.selflearning.battle.battleship.model.IPlay;

public class ColumnValidationRule implements IValidatorRule<Integer> {

	private Integer col;

	public ColumnValidationRule(Integer col) {
		this.col = col;
	}

	public boolean apply(IPlay actualCol) {
		int actCol = ((BattleShip) actualCol).getCol();
		return actCol > 0 && actCol <= col;
	}

	public boolean canApply() {
		return col > 0 && col <= Integer.MAX_VALUE;
	}

}
