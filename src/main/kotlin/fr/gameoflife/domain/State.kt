package fr.gameoflife.domain

enum class State(val stateString: String) {
  ALIVE("X"),
  DEAD("O");

  companion object {
    fun findByStateString(state: String): State {
      return State.values().find { it.stateString == state }!!
    }
  }
}