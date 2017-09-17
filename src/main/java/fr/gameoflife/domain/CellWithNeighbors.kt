package fr.gameoflife.domain

class CellWithNeighbors(var cell: GCell, val neighbors: List<GCell>) {
  val numberOfAliveNeighbors: Int = -1

  init {
    neighbors.count { it.state == "X" }
  }

  fun applyRule(rule: () -> GCell) = rule()
}