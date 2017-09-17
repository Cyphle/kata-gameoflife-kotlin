package fr.gameoflife.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class GameOfLifeTest {
  @Test
  fun `should have the state of game when there is one living cell after one iteration`() {
    val game = GameOfLife("X")
    assertThat(game.nextState()).isEqualTo("O")
  }

  @Test
  fun `should have a game of 3 dead cells when there is less than 2 living neighbor`() {
    val game = GameOfLife("O X O")
    assertThat(game.nextState()).isEqualTo("O O O")
  }
}