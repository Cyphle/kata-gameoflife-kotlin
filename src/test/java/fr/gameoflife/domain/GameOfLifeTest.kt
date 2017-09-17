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

  @Test
  fun `should have a game of cells when it is a grid of one line`() {
    val game = GameOfLife("X X X")
    assertThat(game.nextState()).isEqualTo("O X O")
  }

  @Test
  fun `should have a game of cells when there is a grid of 2x3 (2 lines, 3 columns)`() {
    val game = GameOfLife("""
      X X O
      O X X
    """.trimIndent())
    assertThat(game.nextState()).isEqualTo("""
      X X O
      O X X
    """.trimIndent())
  }

  @Test
  fun `should have a game of cells when there is a grid of 3x3`() {
    val game = GameOfLife("""
      X O O
      O X X
      X X O
    """.trimIndent())
    assertThat(game.nextState()).isEqualTo("""
      O X O
      O O X
      X X X
    """.trimIndent())

    """O O O
    O X O
    O X O"""
  }
}