package com.selflearning.battle.battleship.model;

public interface IPlayerWrapper {
IPlayer getActivePlayer();
IPlayer getPassivePlayer();
boolean switchPlayer();
}
