package fr.gameoflife.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class GridTest {
  @Test
  fun `should find neighbors with grid 1x3`() {
    val grid = Grid(listOf(
            GCell(1, 1, "X"),
            GCell(1, 2, "X"),
            GCell(1, 3, "X")
    ))

    val neighborOfOne = grid.findNeighbors(GCell(1, 1, "X"));
    val neighborOfTwo = grid.findNeighbors(GCell(1, 2, "X"));

    assertThat(neighborOfOne).isEqualTo(listOf(GCell(1, 2, "X")));
    assertThat(neighborOfTwo).isEqualTo(listOf(GCell(1, 1, "X"), GCell(1, 3, "X")));
  }

  @Test
  fun `should find neighbors with grid 2x3`() {
    val grid = Grid(listOf(
            GCell(1, 1, "X"),
            GCell(1, 2, "X"),
            GCell(1, 3, "X"),
            GCell(2, 1, "X"),
            GCell(2, 2, "X"),
            GCell(2, 3, "X")
    ))

    val neighborOfOne = grid.findNeighbors(GCell(1, 1, "X"));
    assertThat(neighborOfOne).isEqualTo(listOf(
            GCell(1, 2, "X"),
            GCell(2, 1, "X")
    ));
    val neighborOfTwo = grid.findNeighbors(GCell(1, 2, "X"));
    assertThat(neighborOfTwo).isEqualTo(listOf(
            GCell(1, 1, "X"),
            GCell(1, 3, "X"),
            GCell(2, 2, "X")
    ));
  }

  @Test
  fun `should find neighbors with grid 3x3`() {
    val grid = Grid(listOf(
            GCell(1, 1, "X"),
            GCell(1, 2, "X"),
            GCell(1, 3, "X"),
            GCell(2, 1, "X"),
            GCell(2, 2, "X"),
            GCell(2, 3, "X"),
            GCell(3, 1, "X"),
            GCell(3, 2, "X"),
            GCell(3, 3, "X")
    ))

    val neighborOfOne = grid.findNeighbors(GCell(2, 2, "X"));
    assertThat(neighborOfOne).isEqualTo(listOf(
            GCell(1, 2, "X"),
            GCell(3, 2, "X"),
            GCell(2, 1, "X"),
            GCell(2, 3, "X")
    ));
  }
}