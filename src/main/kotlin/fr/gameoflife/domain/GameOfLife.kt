package fr.gameoflife.domain

class GameOfLife(private val initialGrid: String) {
  private var grid: Grid = toGrid()

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

