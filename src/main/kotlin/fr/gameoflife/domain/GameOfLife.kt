package fr.gameoflife.domain

class GameOfLife(val initialGrid: String) {
  var grid: Grid = toGrid()

  fun nextState(): String {
    grid = grid.updateState()
    return grid.toString()
  }

  private fun toGrid(): Grid {
    return Grid(initialGrid
            .split("\n")
            .mapIndexed { rowIndex, line ->
              line.split(" ").mapIndexed { columnIndex, state -> GCell(rowIndex, columnIndex, State.findByStateString(state)) }
            }
            .flatten())
  }
}

