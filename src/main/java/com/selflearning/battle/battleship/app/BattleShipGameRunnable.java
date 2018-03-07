package com.selflearning.battle.battleship.app;

import java.util.Scanner;

import com.selflearning.battle.battleship.games.BattleshipGames;
import com.selflearning.battle.battleship.model.IPlayer;
import com.selflearning.battle.battleship.model.IPlayerWrapper;
import com.selflearning.battle.battleship.model.InputBuilder;
import com.selflearning.battle.battleship.model.BattleShipPlayerWrapper;

public class BattleShipGameRunnable implements Runnable {

	private BattleshipGames battleshipGames;
	private IPlayerWrapper player;
	public BattleShipGameRunnable(BattleshipGames battleshipGames, IPlayerWrapper player) {
		this.battleshipGames = battleshipGames;
		this.player = player;

	}

	public void run() {
		Scanner scan = new Scanner(System.in);  
		while (true) {
			System.out.println(player.getActivePlayer().getName()+" play your chance:");
			String next = scan.next();
			battleshipGames.play(player, new InputBuilder().withInput(next).build());
			if(!player.switchPlayer()){
				System.out.println("Player "+player.getActivePlayer().getName()+" has won the battle");
				break;
			}
		}
	}

}