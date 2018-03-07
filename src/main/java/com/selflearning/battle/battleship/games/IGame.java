package com.selflearning.battle.battleship.games;

import com.selflearning.battle.battleship.model.IPlayerWrapper;
import com.selflearning.battle.battleship.model.Input;

public interface IGame {
public void play(IPlayerWrapper player,Input input);
}
