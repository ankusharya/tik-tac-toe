package com.arya.states

import com.arya.logic.Logic


object FullBoard {
    case class BoardState(xIsNext: Boolean = true, squares: Vector[SquareState] = Vector.fill(9)(SquareState.None)) {
    def move(i: Int): BoardState = if (!hasWinner && squares(i) == SquareState.None) {
      val square = if (xIsNext) SquareState.X else SquareState.O
      BoardState(!xIsNext, squares.patch(i, Seq(square), 1))
    } else {
      this
    }

    def hasWinner: Boolean = Logic.winningLines.exists {
      case List(a, b, c) =>
        squares(a) != SquareState.None && squares(a) == squares(b) && squares(a) == squares(c)
    }

    def winner: Option[String] = if (hasWinner) Some(if (xIsNext) "O" else "X") else None
  }

}