package com.selflearning.battle.battleship.app;

import java.util.Scanner;

import com.selflearning.battle.battleship.games.BattleshipGames;
import com.selflearning.battle.battleship.model.IPlayer;
import com.selflearning.battle.battleship.model.InputBuilder;
import com.selflearning.battle.battleship.model.PlayerWrapper;

public class MyRunnable implements Runnable {

	private BattleshipGames battleshipGames;
	private IPlayer player1;
	private IPlayer player2;

	public MyRunnable(BattleshipGames battleshipGames, IPlayer player1, IPlayer player2) {
		this.battleshipGames = battleshipGames;
		this.player1 = player1;
		this.player2 = player2;
	}

	public void run() {
		IPlayerWrapper player = new PlayerWrapper(player1, player2);
		Scanner scan = new Scanner(System.in);  
		while (true) {
			System.out.println(player.getActive().getName()+" play your chance:");
			String next = scan.next();
			battleshipGames.play(player, new InputBuilder().withInput(next).build());
			if(!player.switchPlayer()){
				System.out.println("Player "+player.getActive().getName()+" has won the battle");
				break;
			}
		}
	}

}