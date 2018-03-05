package com.selflearning.battle.battleship.app;

import java.util.HashMap;

import com.selflearning.battle.battleship.games.BattleshipGames;
import com.selflearning.battle.battleship.model.BattleShipArena;
import com.selflearning.battle.battleship.model.BattleShipBuilder;
import com.selflearning.battle.battleship.model.IArena;
import com.selflearning.battle.battleship.model.IPlayer;
import com.selflearning.battle.battleship.model.Player;

public class GameServer {
	
	
	public static void main(String ...strings){
		IPlayer player1 = new Player("Vijay");
		
		IArena battleShipArena1 = new BattleShipArena('G', 9, 2);
		battleShipArena1.createBoard( new BattleShipBuilder().withRow('A').withCol(1).withShipType(2).build());
		battleShipArena1.createBoard( new BattleShipBuilder().withRow('A').withCol(2).withShipType(1).build());
		battleShipArena1.createBoard( new BattleShipBuilder().withRow('B').withCol(5).withShipType(2).build());
		player1.setArena(battleShipArena1);
		
		IPlayer player2 = new Player("Pallavi");
		IArena battleShipArena2 = new BattleShipArena('G', 9, 2);
		battleShipArena2.createBoard( new BattleShipBuilder().withRow('B').withCol(1).withShipType(2).build());
		battleShipArena2.createBoard( new BattleShipBuilder().withRow('B').withCol(2).withShipType(1).build());
		battleShipArena2.createBoard( new BattleShipBuilder().withRow('A').withCol(5).withShipType(2).build());
		player2.setArena(battleShipArena2);
		
		HashMap<IPlayer, IArena> hashMap = new HashMap<IPlayer, IArena>();
		hashMap.put(player1, battleShipArena2);
		hashMap.put(player2, battleShipArena1);
		BattleshipGames battleshipGames = new BattleshipGames(hashMap);
		Thread t1 = new Thread (new MyRunnable(battleshipGames,player1,player2) );
		t1.start();
		try {
			t1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
//	private void initializeGame(String whichGame){
//		
//	}

}
