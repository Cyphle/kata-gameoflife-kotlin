package fr.gameoflife.domain

class GameOfLife(val initialGrid: String) {
  var grid: List<GCell> = toGrid()

  fun nextState(): String {
    updateState()

    return grid.map { it.state }.joinToString(" ")
  }

  private fun updateState() {
    val updatedGrid: MutableList<GCell> = mutableListOf()

    grid.forEach { cell ->
      val neighbors: List<GCell> = findNeighbors(cell)
      val updatedCell: GCell = applyRules(cell, neighbors)
      updatedGrid.add(updatedCell)
    }

    grid = updatedGrid
  }

  private fun applyRules(cell: GCell, neighbors: List<GCell>): GCell {
    val numberOfAlive: Int = neighbors.count { it.state == "X" }
    if (numberOfAlive < 2)
      return GCell(cell.columnIndex, "O")
    else
      return GCell(cell.columnIndex, cell.state)
  }

  private fun findNeighbors(cell: GCell): List<GCell> {
    return grid.filter { it.columnIndex == cell.columnIndex - 1 || it.columnIndex == cell.columnIndex + 1 }
  }

  private fun toGrid(): List<GCell> {
    return this.initialGrid.split(" ").mapIndexed { columnIndex, state -> GCell(columnIndex, state) };
  }
}

data class GCell(val columnIndex: Int, val state: String)