package fr.gameoflife.domain

class Grid(private val cells: List<GCell>) {
  fun updateState(): Grid {
    val updatedGrid = cells
            .map { CellWithNeighbors(it, findNeighbors(it)) }
            .map { it.applyRules(Rules.values().toList()) }
    return Grid(updatedGrid)
  }

  fun findNeighbors(cell: GCell): List<GCell> = cells.filter { isEstOrWestNeighbor(cell, it) || isNorthOrSouthNeighbor(cell, it) || isEstDiagonalNeighbor(cell, it) || isWestDiagonalNeighbor(cell, it) }

  override fun toString(): String {
    return cells
            .groupBy { it.rowIndex }
            .toSortedMap()
            .map { it.value.sortedBy { it.columnIndex } }.joinToString("\n") { it.joinToString(" ") { it.state.stateString } }
  }

  private fun isWestDiagonalNeighbor(reference: GCell, toCompare: GCell) =
          (toCompare.columnIndex == reference.columnIndex + 1 && (toCompare.rowIndex == reference.rowIndex - 1 || toCompare.rowIndex == reference.rowIndex + 1))

  private fun isEstDiagonalNeighbor(reference: GCell, toCompare: GCell) =
          (toCompare.columnIndex == reference.columnIndex - 1 && (toCompare.rowIndex == reference.rowIndex - 1 || toCompare.rowIndex == reference.rowIndex + 1))

  private fun isNorthOrSouthNeighbor(reference: GCell, toCompare: GCell) =
          (toCompare.rowIndex == reference.rowIndex && (toCompare.columnIndex == reference.columnIndex - 1 || toCompare.columnIndex == reference.columnIndex + 1))

  private fun isEstOrWestNeighbor(reference: GCell, toCompare: GCell) =
          (toCompare.columnIndex == reference.columnIndex && (toCompare.rowIndex == reference.rowIndex - 1 || toCompare.rowIndex == reference.rowIndex + 1))
}