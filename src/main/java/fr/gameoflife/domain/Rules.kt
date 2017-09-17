package fr.gameoflife.domain

enum class Rules(val rule: (CellWithNeighbors) -> GCell) {
  RULE_ONE({ cellWithNeighbors ->
    if (cellWithNeighbors.numberOfAliveNeighbors < 1) GCell(cellWithNeighbors.cell.columnIndex, "O")
    else GCell(cellWithNeighbors.cell)
  })
}