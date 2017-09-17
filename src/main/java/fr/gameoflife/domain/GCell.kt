package fr.gameoflife.domain

data class GCell(val rowIndex: Int = 1, val columnIndex: Int, val state: String) {
  constructor(cell: GCell) : this(cell.rowIndex, cell.columnIndex, cell.state)
}