package com.selflearning.battle.battleship.validator;

import com.selflearning.battle.battleship.model.IPlay;

public interface IValidatorRule<T> {

	public boolean canApply();

	public boolean apply(IPlay obj);

}
