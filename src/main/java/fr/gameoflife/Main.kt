package fr.gameoflife

import fr.gameoflife.domain.GameOfLife
import kotlin.concurrent.fixedRateTimer

fun main(args: Array<String>) {
  val game = GameOfLife("""
      O O O O O O O O O O
      O O O O O O O O O O
      O O O O O O O O O O
      O O O O O O O O O O
      O O O O O O X O O O
      O O O O O O O X O O
      O O O O O X X X O O
      O O O O O O O O O O
      O O O O O O O O O O
      O O O O O O O O O O
    """.trimIndent())

  println(" ----------- ")
  val fixedRateTimer = fixedRateTimer(name = "game-of-life-timer", initialDelay = 100, period = 1000) {
    println(game.nextState())
    println(" ----------- ")
  }

  try {
    Thread.sleep(10000)
  } finally {
    fixedRateTimer.cancel();
  }
}