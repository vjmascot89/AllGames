package com.selflearning.battle.battleship.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.selflearning.battle.battleship.validator.ColumnValidationRule;
import com.selflearning.battle.battleship.validator.IValidatorRule;
import com.selflearning.battle.battleship.validator.RowValidationRule;
import com.selflearning.battle.battleship.validator.ShipTypeValidationRule;

public class BattleShipArena implements IArena{
	List<IValidatorRule> validation;
	BattleShipBuilder withBuilder;
	private Map<String, Integer> fieldArrangment= new HashMap<String, Integer>();

	public BattleShipArena(char row, int col, int shipType) {
		validation = new ArrayList<IValidatorRule>();
		validation.add(new RowValidationRule(row));
		validation.add(new ColumnValidationRule(col));
		validation.add(new ShipTypeValidationRule(shipType));
		
	}

	public boolean initialize() {
		boolean bool = false;
		for (IValidatorRule val : validation) {
			bool = val.canApply();
		}
		return bool;
	}

	public boolean createBoard(IPlay playBoard) {
		boolean applicable = false;
		for (IValidatorRule val : validation) {
			applicable = val.apply(playBoard);
		}
		if (applicable) {
			((Map<String, Integer>)getFieldArrangment()).put(playBoard.getkey(), playBoard.getValue());
		}
		return applicable;
	}

	public Map<String,Integer> getFieldArrangment() {
		return fieldArrangment;
	}

	public HitOrMissOrFinish makeMove(Input input) {
		Integer value = ((Map<String, Integer>) getFieldArrangment()).get(input.getInput());
		HitOrMissOrFinish ret = HitOrMissOrFinish.MISS;
		
		if (value != null) {
			value--;
			ret = HitOrMissOrFinish.HIT;
			if (value == 0) {
				((Map<String, Integer>) getFieldArrangment()).remove(input.getInput());
			} else {
				((Map<String, Integer>) getFieldArrangment()).put(input.getInput(), value);
			}
			if (((Map<String, Integer>)getFieldArrangment()).keySet().isEmpty()) {
				ret = HitOrMissOrFinish.FINISH;
			}
		}
		return ret;
	}
}
