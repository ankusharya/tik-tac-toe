package com.arya.components

import slinky.core.Component
import slinky.core.annotations.react
import slinky.web.html.{button, div, h1, onClick, li, ol, className}

import com.arya.states.FullBoard.BoardState
@react class Game extends Component {
  type Props = Unit
  case class State(board: List[BoardState])

  override def initialState = State(board = List(BoardState()))

  def handleClick(i: Int) = { () =>
    setState(state => {
      val s = state.board
      val current = s.head
      val move = current.move(i)
      if (move == current) State(s) else State(move :: s)
    })
  }

  def jumpTo(i: Int) = { () =>
    setState(state => {
      val x = state.board
      State(x.drop(x.length - 1 - i))
    })
  }

  def render = {
    def status = state.board.head.winner match {
      case Some(winner) => s"The winner is $winner"
      case None =>
        val player = if (state.board.head.xIsNext) "X" else "O"
        s"Next Turn: $player"
    }
    def moves =
      ol(state.board.zipWithIndex.map {
        case (move, i) =>
          val desc = if (i == 0) " Go to game start" else s"Go to move #$i"

          li(
            button(onClick := { _ => jumpTo(i)() }, desc)
          )
      })
    div(
      div(
        className := "game",
        div(
          className := "game-board",
          Board(onClick = { i => handleClick(i) }, value = state.board.head)
        ),
        div(
          className := "game-info",
          div(status),
          div(
            moves
          )
        )
      )
    )
  }
}
