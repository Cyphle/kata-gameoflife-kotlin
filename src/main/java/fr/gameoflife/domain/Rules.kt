package fr.gameoflife.domain

enum class Rules(val rule: (CellWithNeighbors) -> GCell) {
  RULE_ONE({ cellWithNeighbors ->
    if (cellWithNeighbors.numberOfAliveNeighbors < 2) GCell(1, cellWithNeighbors.cell.columnIndex, "O")
    else GCell(cellWithNeighbors.cell)
  })
}