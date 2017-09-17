package fr.gameoflife.domain

class Grid(val cells: List<GCell>) {
  fun updateState(): Grid {
    val updatedGrid = cells
            .map { CellWithNeighbors(it, findNeighbors(it)) }
            .map {
              it.applyRule({
                if (it.numberOfAliveNeighbors < 2) GCell(it.cell.columnIndex, "O")
                else GCell(it.cell.columnIndex, it.cell.state)
              })
            }

    return Grid(updatedGrid)
  }

  override fun toString(): String {
    return cells.joinToString(" ") { it.state }
  }

  private fun findNeighbors(cell: GCell): List<GCell> {
    return cells.filter { it.columnIndex == cell.columnIndex - 1 || it.columnIndex == cell.columnIndex + 1 }
  }
}