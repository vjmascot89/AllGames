package com.selflearning.battle.battleship.model;

import java.util.HashSet;
import java.util.Set;

public class ThambolaMaker {
	private ThambolaArena thambolaArena;
	private IPlayerWrapper playerWrapper;
	private Integer row;
	private Integer col;

	public ThambolaMaker(ThambolaArena thambolaArena, IPlayerWrapper playerWrapper, Integer row, Integer col) {
		this.thambolaArena = thambolaArena;
		this.playerWrapper = playerWrapper;
		this.row = row;
		this.col = col;
	}

	public boolean makeThambola() {
		Set<ThambolaPoints> blackThambola = new HashSet<ThambolaPoints>();
		for (int i = 1; i < 3; i++) {
			for (int j = 1; j <= col; j++) {
				ThambolaPoints thambolaPoints = new ThambolaPoints();
				thambolaPoints.setRow(row);
				thambolaPoints.setCol(col);
				thambolaPoints.setValidDirection(1);
				blackThambola.add(thambolaPoints);
			}
		}
		thambolaArena.getFieldArrangment().put(playerWrapper.getActivePlayer().getName(), blackThambola);

		Set<ThambolaPoints> whiteThambola = new HashSet<ThambolaPoints>();
		for (int i = row; i > row - 3; i++) {
			for (int j = 1; j <= col; j++) {
				ThambolaPoints thambolaPoints = new ThambolaPoints();
				thambolaPoints.setRow(row);
				thambolaPoints.setCol(col);
				thambolaPoints.setValidDirection(1);
				whiteThambola.add(thambolaPoints);
			}
		}
		thambolaArena.getFieldArrangment().put(playerWrapper.getPassivePlayer().getName(), whiteThambola);
		validMoves(playerWrapper, thambolaArena);
		return true;
	}

	public void validMoves(IPlayerWrapper playerWrapper, IArena arena) {
		Set<ThambolaPoints> thambolaPointsPlayer1 = ((ThambolaArena) arena).getFieldArrangment()
				.get(playerWrapper.getActivePlayer().getName());
		Set<ThambolaPoints> thambolaPointsPlayer2 = ((ThambolaArena) arena).getFieldArrangment()
				.get(playerWrapper.getPassivePlayer().getName());

		thambolaPointsPlayer1.stream().forEach(
				t -> setValidThambolaPointForCurrentThambolaPoint(t, thambolaPointsPlayer1, thambolaPointsPlayer2));
		thambolaPointsPlayer2.stream().forEach(
				t -> setValidThambolaPointForCurrentThambolaPoint(t, thambolaPointsPlayer2, thambolaPointsPlayer1));
	}

	private void setValidThambolaPointForCurrentThambolaPoint(ThambolaPoints t,
			Set<ThambolaPoints> thambolaPointsPlayer1, Set<ThambolaPoints> thambolaPointsPlayer2) {
		Integer newRow = t.getRow();
		Integer newCol = t.getCol();
		int offSet = 1;
		for (int i = 0; i < 3; i++) {
			ThambolaPoints thambolaPoints = new ThambolaPoints();
			int col = i - offSet;
			if (col == 0) {
				newRow = newRow + +t.getValidDirection();
			}
			thambolaPoints.setRow(newRow);
			thambolaPoints.setCol(newCol + col);
			if (!thambolaPointsPlayer1.contains(thambolaPoints) && !thambolaPointsPlayer2.contains(thambolaPoints)) {
				if (0 < newRow && newRow < row && 0 < newCol && newCol < col) {
					t.setValidThambolaPoint(thambolaPoints);
				}
			} else if (thambolaPointsPlayer2.contains(thambolaPoints)) {
				if (col == -1) {
					thambolaPoints.setCol(thambolaPoints.getCol() - 1);
				} else if (col == 0) {
					thambolaPoints.setRow(thambolaPoints.getRow() + 1);
				} else {
					thambolaPoints.setCol(thambolaPoints.getCol() + 1);
				}
				if (!thambolaPointsPlayer1.contains(thambolaPoints)
						&& !thambolaPointsPlayer2.contains(thambolaPoints)) {
					if (0 < newRow && newRow < row && 0 < newCol && newCol < col) {
						t.setValidThambolaPoint(thambolaPoints);
					}
				}
			}
		}
	}
}
