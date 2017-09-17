package fr.gameoflife.domain

data class GCell(val columnIndex: Int, val state: String) {
  constructor(cell: GCell) : this(cell.columnIndex, cell.state)
}