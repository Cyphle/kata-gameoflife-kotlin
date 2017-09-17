package fr.gameoflife.domain

enum class Rules(val rule: (CellWithNeighbors) -> GCell) {
  RULE_ONE({ cellWithNeighbors ->
    if (cellWithNeighbors.numberOfAliveNeighbors < 2) GCell(cellWithNeighbors.cell.rowIndex, cellWithNeighbors.cell.columnIndex, "O")
    else GCell(cellWithNeighbors.cell)
  })
}