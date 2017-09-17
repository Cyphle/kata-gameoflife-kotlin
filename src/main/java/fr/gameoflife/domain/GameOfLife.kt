package fr.gameoflife.domain

class GameOfLife(val initialGrid: String) {
  var grid: Grid = toGrid()

  fun nextState(): String {
    grid = grid.updateState()
    return grid.toString()
  }

  private fun toGrid(): Grid {
    return Grid(this.initialGrid.split(" ").mapIndexed { columnIndex, state -> GCell(columnIndex, state) })
  }
}

