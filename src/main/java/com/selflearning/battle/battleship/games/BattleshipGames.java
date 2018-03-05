package com.selflearning.battle.battleship.games;

import java.util.Map;

import com.selflearning.battle.battleship.model.HitOrMissOrFinish;
import com.selflearning.battle.battleship.model.IArena;
import com.selflearning.battle.battleship.model.IPlayer;

public class BattleshipGames implements IGame {

	Map<IPlayer, IArena> game;

	public BattleshipGames(Map<IPlayer, IArena> game) {
		this.game = game;
	}

	public void play(IPlayer player, Input input) {

		HitOrMissOrFinish hitOrMiss = game.get(player).makeMove(input);

		player.setStatus(hitOrMiss);

	}

}
