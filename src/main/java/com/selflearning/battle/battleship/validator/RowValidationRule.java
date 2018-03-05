package com.selflearning.battle.battleship.validator;

import com.selflearning.battle.battleship.model.BattleShip;
import com.selflearning.battle.battleship.model.IPlay;

public class RowValidationRule implements IValidatorRule<Character> {

	private int numericValue;

	public RowValidationRule(char row) {
		numericValue = Character.getNumericValue(row);
	}

	public boolean canApply() {
		return numericValue > 64 && numericValue < 91;
	}

	public boolean apply(IPlay obj) {
		int valueOf = Character.getNumericValue(((BattleShip) obj).getRow());
		return valueOf > 64 && valueOf <= numericValue;
	}

}
