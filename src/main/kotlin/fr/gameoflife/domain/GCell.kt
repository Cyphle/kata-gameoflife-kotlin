package fr.gameoflife.domain

data class GCell(val rowIndex: Int, val columnIndex: Int, val state: State) {
  constructor(cell: GCell) : this(cell.rowIndex, cell.columnIndex, cell.state)
}