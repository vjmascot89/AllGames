package com.selflearning.battle.battleship.app;

import java.util.Scanner;

import com.selflearning.battle.battleship.games.BattleshipGames;
import com.selflearning.battle.battleship.model.BattleShipArena;
import com.selflearning.battle.battleship.model.IArena;
import com.selflearning.battle.battleship.model.IPlayer;
import com.selflearning.battle.battleship.model.Player;
import com.selflearning.battle.battleship.model.ShipMaker;

public class GameServer {
	
	
	public static void main(String... strings) {
		Scanner scanner = new Scanner(System.in);
		IPlayer player1 = new Player(scanner.next());
		IArena battleShipArena1 = new BattleShipArena(scanner.next().charAt(0), scanner.nextInt(), scanner.nextInt());
		ShipMaker shipMaker1 = new ShipMaker(battleShipArena1);
		player1.setArena(battleShipArena1);
		IPlayer player2 = new Player(scanner.next());
		IArena battleShipArena2 = new BattleShipArena(scanner.next().charAt(0), scanner.nextInt(), scanner.nextInt());
		ShipMaker shipMaker2 = new ShipMaker(battleShipArena2);
		player2.setArena(battleShipArena2);
		int noOfShips = scanner.nextInt();
		for (int ships = 0; ships < 2 * noOfShips; ships++) {
			ShipMaker current;
			String firstGrid = scanner.next();
			Integer length = scanner.nextInt();
			Integer width = scanner.nextInt();
			Integer shipType = scanner.nextInt();
			current = switchShips(ships,shipMaker1,shipMaker2);
				if(current.makeShips(firstGrid, length, width, shipType)){
					System.out.println("this is overlappinginput kindly reenter");
					continue;
			}

		}
		BattleshipGames battleshipGames = new BattleshipGames();
		Thread t1 = new Thread(new MyRunnable(battleshipGames, player1, player2));
		t1.start();
		try {
			t1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	private static ShipMaker switchShips(int ships, ShipMaker shipMaker1, ShipMaker shipMaker2) {
		if (ships % 2 == 0){
			return shipMaker1;
		}
		return shipMaker2;
	}

}
