package com.arya.components

import slinky.core.annotations.react
import slinky.core.StatelessComponent
import slinky.web.html.{button, onClick, className}
import slinky.web.html.{button, className}

import com.arya.states.SquareState
@react class Square extends StatelessComponent {
  case class Props(value: SquareState, onClick: () => Unit)
  
  def render = {
    button(
      className := "square",
      s"${props.value.toString}",
      onClick := (e => props.onClick())
    )
  }
}
