package com.selflearning.battle.battleship.model;

import com.selflearning.battle.battleship.games.BattleShipAttackInput;

public class InputBuilder {
	private String input;

	public InputBuilder withInput(String input) {
		this.input = input;
		return this;
	}

	public BattleShipAttackInput build() {
		BattleShipAttackInput battleShipAttackInput = new BattleShipAttackInput();
		if (input != null) {
			battleShipAttackInput.setInput(input);
		}
		return battleShipAttackInput;
	}
}
