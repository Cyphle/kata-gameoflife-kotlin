package fr.gameoflife.domain

data class GCell(val rowIndex: Int, val columnIndex: Int, val state: State) {
  constructor(cell: GCell) : this(cell.rowIndex, cell.columnIndex, cell.state)
}

enum class State(val stateString: String) {
  ALIVE("X"),
  DEAD("O");

  companion object {
    fun findByStateString(state: String): State {
      return State.values().find { it.stateString == state }!!
    }
  }
}