package com.arya.components

import slinky.core.annotations.react
import slinky.core.StatelessComponent
import slinky.web.html.{button, div, h1, onClick}
import slinky.web.html.className
import com.arya.states.FullBoard.BoardState
import com.arya.components.Square

@react class Board extends StatelessComponent {
  case class Props(value: BoardState, onClick: Int => () => Unit)

  def render = {
    def renderSquare(i: Int) = {
      Square(props.value.squares(i), props.onClick(i))
    }
    div(
      div(className := "border-row", renderSquare(0), renderSquare(1), renderSquare(2)),
      div(className := "border-row", renderSquare(3), renderSquare(4), renderSquare(5)),
      div(className := "border-row", renderSquare(6), renderSquare(7), renderSquare(8))
    )
  }
}
