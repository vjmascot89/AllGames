package com.selflearning.battle.battleship.app;

import com.selflearning.battle.battleship.model.IPlayer;

public interface IPlayerWrapper {
IPlayer getActive();
IPlayer getPassivePlayer();
boolean switchPlayer();
}
