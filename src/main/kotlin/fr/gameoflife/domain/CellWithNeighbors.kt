package fr.gameoflife.domain

data class CellWithNeighbors(var cell: GCell, private val neighbors: List<GCell>) {
  var numberOfAliveNeighbors: Int = -1

  init {
    numberOfAliveNeighbors = neighbors.count { it.state == State.ALIVE }
  }

  fun applyRules(rules: List<Rules>): GCell {
    rules.forEach { rule -> cell = applyRule { rule.rule(this) } }
    return cell
  }

  private fun applyRule(rule: () -> GCell) = rule()
}