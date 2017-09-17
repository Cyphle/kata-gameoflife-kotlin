package fr.gameoflife.domain

enum class Rules(val rule: (CellWithNeighbors) -> GCell) {
  RULE_UNDER_POPULATION({ cellWithNeighbors ->
    if (cellWithNeighbors.numberOfAliveNeighbors < 2) GCell(cellWithNeighbors.cell.rowIndex, cellWithNeighbors.cell.columnIndex, State.DEAD)
    else GCell(cellWithNeighbors.cell)
  }),
  RULE_OVERCROWDING({ cellWithNeighbors ->
    if (cellWithNeighbors.numberOfAliveNeighbors > 3) GCell(cellWithNeighbors.cell.rowIndex, cellWithNeighbors.cell.columnIndex, State.DEAD)
    else GCell(cellWithNeighbors.cell)
  }),
}