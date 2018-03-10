package com.selflearning.battle.battleship.app;

import java.util.Scanner;

import com.selflearning.battle.battleship.games.BattleshipGames;
import com.selflearning.battle.battleship.model.BattleShipArena;
import com.selflearning.battle.battleship.model.IArena;
import com.selflearning.battle.battleship.model.IPlayer;
import com.selflearning.battle.battleship.model.IPlayerWrapper;
import com.selflearning.battle.battleship.model.Player;
import com.selflearning.battle.battleship.model.BattleShipPlayerWrapper;
import com.selflearning.battle.battleship.model.ShipMaker;

public class ThambolaGameServer {
	
	
	public static void main(String... strings) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Player1 name  and Player2 name:");
		IPlayerWrapper playerWrapper  = new BattleShipPlayerWrapper(new Player(scanner.next()),new Player(scanner.next()));
		System.out.println("Enter the max Row Char[A] max Col[1] max ShipType[1] as space seprated values :");
		char maxRow = scanner.next().charAt(0);
		int maxCol  = scanner.nextInt();
		int maxShipType = scanner.nextInt();
		IArena battleShipArena1 = new BattleShipArena(maxRow,maxCol ,maxShipType );
		IArena battleShipArena2 = new BattleShipArena(maxRow,maxCol ,maxShipType );
		ShipMaker shipMaker1 = new ShipMaker(battleShipArena1);
		ShipMaker shipMaker2 = new ShipMaker(battleShipArena2);
		playerWrapper.getActivePlayer().setArena(battleShipArena1);
		playerWrapper.getPassivePlayer().setArena(battleShipArena2);
		System.out.println("Enter No Of ships :");
		int noOfShips = scanner.nextInt();
		
		for (int ships = 0; ships < 2 * noOfShips; ships++) {
			ShipMaker current;
			System.out.println("Enter the FirstGrid[A2] Length[1] width[2] ShipType[1] as space seprated values for player"+(ships%2+1)+" :");
			String firstGrid = scanner.next();
			Integer length = scanner.nextInt();
			Integer width = scanner.nextInt();
			Integer shipType = scanner.nextInt();
			current = switchShips(ships,shipMaker1,shipMaker2);
				if(!current.makeShips(firstGrid, length, width, shipType)){
					System.out.println("this is overlappinginput kindly reenter");
					ships  = ships-1;
					continue;
			}

		}
		
		BattleshipGames battleshipGames = new BattleshipGames();
		Thread t1 = new Thread(new BattleShipGameRunnable(battleshipGames,playerWrapper));
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
