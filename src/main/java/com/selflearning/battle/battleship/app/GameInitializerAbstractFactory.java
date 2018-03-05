package com.selflearning.battle.battleship.app;

import java.util.HashMap;
import java.util.Map;

import com.selflearning.battle.battleship.games.GameFactory;
import com.selflearning.battle.battleship.games.IGameFactory;

public class GameInitializerAbstractFactory {
	Map<String,IGameFactory> gameMaps;
	
	{
		System.out.println("nonstaticblock GameInitializerAbstractFactory");
		gameMaps = new HashMap<String, IGameFactory>();
		gameMaps.put("battleship", new GameFactory());
	}
	
	public GameInitializerAbstractFactory(){
		System.out.println("constructor GameInitializerAbstractFactory");
	}
	
	public  IGameFactory create(String gameName){
		System.out.println("game method GameInitializerAbstractFactory");
		return gameMaps.get(gameName);
		
	}
	public static void main(String ...strings){
		new GameInitializerAbstractFactory().create("Battleship").initialize();
	}
}
