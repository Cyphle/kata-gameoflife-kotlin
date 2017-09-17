package fr.gameoflife.domain

class Grid(val cells: List<GCell>) {
  fun updateState(): Grid {
    val updatedGrid = cells
            .map { CellWithNeighbors(it, findNeighbors(it)) }
            .map { it.applyRule { Rules.RULE_ONE.rule(it) } }
    return Grid(updatedGrid)
  }

  fun findNeighbors(cell: GCell): List<GCell> {
    return cells.filter {
      (it.columnIndex == cell.columnIndex && (it.rowIndex == cell.rowIndex - 1 || it.rowIndex == cell.rowIndex + 1))
              || (it.rowIndex == cell.rowIndex && (it.columnIndex == cell.columnIndex - 1 || it.columnIndex == cell.columnIndex + 1))
    }
  }

  override fun toString(): String {
    return cells.joinToString(" ") { it.state }
  }
}