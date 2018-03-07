package com.selflearning.battle.battleship.model;

import com.selflearning.battle.battleship.app.IPlayerWrapper;

public class PlayerWrapper implements IPlayerWrapper {

	private IPlayer player1;
	private IPlayer player2;

	public PlayerWrapper(IPlayer player1, IPlayer player2) {
		this.player1 = player1;
		this.player2 = player2;
	}

	public IPlayer getActivePlayer() {
		return player1;
	}

	public IPlayer getPassivePlayer() {
		return player2;
	}

	public boolean switchPlayer() {
		if (getActivePlayer().getStatus().equals(HitOrMissOrFinish.MISS)) {
			IPlayer tmp = player1;
			player1 = player2;
			player2 = tmp;
		} else if (getActivePlayer().getStatus().equals(HitOrMissOrFinish.FINISH)) {
			return false;
		}
		return true;
	}

}
