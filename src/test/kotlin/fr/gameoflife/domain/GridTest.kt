package fr.gameoflife.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class GridTest {
  @Test
  fun `should find neighbors with grid 1x3`() {
    val grid = Grid(listOf(
            GCell(1, 1, State.ALIVE),
            GCell(1, 2, State.ALIVE),
            GCell(1, 3, State.ALIVE)
    ))

    val neighborOfOne = grid.findNeighbors(GCell(1, 1, State.ALIVE));
    val neighborOfTwo = grid.findNeighbors(GCell(1, 2, State.ALIVE));

    assertThat(neighborOfOne).isEqualTo(listOf(GCell(1, 2, State.ALIVE)));
    assertThat(neighborOfTwo).isEqualTo(listOf(GCell(1, 1, State.ALIVE), GCell(1, 3, State.ALIVE)));
  }

  @Test
  fun `should find neighbors with grid 2x3`() {
    val grid = Grid(listOf(
            GCell(1, 1, State.ALIVE),
            GCell(1, 2, State.ALIVE),
            GCell(1, 3, State.ALIVE),
            GCell(2, 1, State.ALIVE),
            GCell(2, 2, State.ALIVE),
            GCell(2, 3, State.ALIVE)
    ))

    val neighborOfOne = grid.findNeighbors(GCell(1, 1, State.ALIVE));
    assertThat(neighborOfOne).isEqualTo(listOf(
            GCell(1, 2, State.ALIVE),
            GCell(2, 1, State.ALIVE)
    ));
    val neighborOfTwo = grid.findNeighbors(GCell(1, 2, State.ALIVE));
    assertThat(neighborOfTwo).isEqualTo(listOf(
            GCell(1, 1, State.ALIVE),
            GCell(1, 3, State.ALIVE),
            GCell(2, 2, State.ALIVE)
    ));
  }

  @Test
  fun `should find neighbors with grid 3x3`() {
    val grid = Grid(listOf(
            GCell(1, 1, State.ALIVE),
            GCell(1, 2, State.ALIVE),
            GCell(1, 3, State.ALIVE),
            GCell(2, 1, State.ALIVE),
            GCell(2, 2, State.ALIVE),
            GCell(2, 3, State.ALIVE),
            GCell(3, 1, State.ALIVE),
            GCell(3, 2, State.ALIVE),
            GCell(3, 3, State.ALIVE)
    ))

    val neighborOfOne = grid.findNeighbors(GCell(2, 2, State.ALIVE));
    assertThat(neighborOfOne).isEqualTo(listOf(
            GCell(1, 2, State.ALIVE),
            GCell(3, 2, State.ALIVE),
            GCell(2, 1, State.ALIVE),
            GCell(2, 3, State.ALIVE)
    ));
  }
}