package com.arya.states

sealed trait SquareState

  object SquareState {

    case object None extends SquareState {
      override def toString: String = ""
    }

    case object X extends SquareState {
      override def toString: String = "X"
    }

    case object O extends SquareState {
      override def toString: String = "O"
    }

  }