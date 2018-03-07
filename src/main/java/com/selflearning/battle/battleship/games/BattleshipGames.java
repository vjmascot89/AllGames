package com.selflearning.battle.battleship.games;

import com.selflearning.battle.battleship.model.HitOrMissOrFinish;
import com.selflearning.battle.battleship.model.IPlayerWrapper;
import com.selflearning.battle.battleship.model.Input;

public class BattleshipGames implements IGame {


	public void play(IPlayerWrapper player, Input input) {

		HitOrMissOrFinish hitOrMiss = player.getPassivePlayer().getArena().makeMove(input);

		player.getActivePlayer().setStatus(hitOrMiss);

	}

}
