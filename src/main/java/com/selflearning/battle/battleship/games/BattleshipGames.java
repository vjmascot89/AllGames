package com.selflearning.battle.battleship.games;

import com.selflearning.battle.battleship.app.IPlayerWrapper;
import com.selflearning.battle.battleship.model.HitOrMissOrFinish;

public class BattleshipGames implements IGame {


	public void play(IPlayerWrapper player, Input input) {

		HitOrMissOrFinish hitOrMiss = player.getPassivePlayer().getArena().makeMove(input);

		player.getActive().setStatus(hitOrMiss);

	}

}
