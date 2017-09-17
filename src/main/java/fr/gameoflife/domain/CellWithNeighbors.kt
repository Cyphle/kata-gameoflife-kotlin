package fr.gameoflife.domain

class CellWithNeighbors(var cell: GCell, val neighbors: List<GCell>) {
  var numberOfAliveNeighbors: Int = -1

  init {
    numberOfAliveNeighbors = neighbors.count { it.state == "X" }
  }

  fun applyRule(rule: () -> GCell) = rule()
}