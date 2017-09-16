package fr.gameoflife.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class GameOfLifeTest {
  @Test
  fun `should have the state of game when there is one living cell after one iteration`() {
    val game = GameOfLife("X");
    assertThat(game.nextState()).isEqualTo("O");
  }
}

