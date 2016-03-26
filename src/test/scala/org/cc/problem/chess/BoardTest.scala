package org.cc.problem.chess

import org.scalatest.FunSuite

class BoardTest extends FunSuite {

  // Checking positions availability in empty boards
  import Board._
  
  val Empty3x3 = Board(3,3)
  test("Available positions in an empty 3x3 board") {
    assert(Empty3x3.positions.size === 9)
    def freeFor(p: Piece) = Board.freeFor(piece=p,onBoard=Empty3x3,containing=Set())
    // Check all positions are available for all pieces
    assert(freeFor(King) == Empty3x3.positions)
    assert(freeFor(Queen) == Empty3x3.positions)
    assert(freeFor(Rook) == Empty3x3.positions)
    assert(freeFor(Bishop) == Empty3x3.positions)
    assert(freeFor(Knight) == Empty3x3.positions)
  }

  val Empty8x8 = Board(8,8)
  test("Available positions in an empty 8x8 board") {
    assert(Empty8x8.positions.size === 64)
    def freeFor(p: Piece) = Board.freeFor(piece=p,onBoard=Empty8x8,containing=Set())
    // Check all positions are available for all pieces
    assert(freeFor(King) == Empty8x8.positions)
    assert(freeFor(Queen) == Empty8x8.positions)
    assert(freeFor(Rook) == Empty8x8.positions)
    assert(freeFor(Bishop) == Empty8x8.positions)
    assert(freeFor(Knight) == Empty8x8.positions)
  }
  
  // Checking positions availability in non-empty boards
  
  test("Available positions in an non-empty 3x3 board - 1 King") {
    val board = Empty3x3
    val on: Set[(Piece,Position)] = Set((King,Position(0,0)))
    def freeFor(p: Piece) = Board.freeFor(piece=p,onBoard=Empty3x3,containing=on)
    // Check all positions are available for type of pieces
    assert(freeFor(King).map { p => (p.x,p.y) } === Set((2,0),(0,2),(1,2),(2,2),(2,1)))
    assert(freeFor(Queen).map { p => (p.x,p.y) } === Set((1,2),(2,1)))
    assert(freeFor(Rook).map { p => (p.x,p.y) } === Set((1,2),(2,1),(2,2)))
    assert(freeFor(Bishop).map { p => (p.x,p.y) } === Set((0,2),(1,2),(2,0),(2,1)))
    assert(freeFor(Knight).map { p => (p.x,p.y) } === Set((0,2),(2,0),(2,2)))
  }

  test("Available positions in an non-empty 3x3 board - 1 Queen") {
    val board = Empty3x3
    val on: Set[(Piece,Position)] = Set((Queen,Position(0,0)))
    def freeFor(p: Piece) = Board.freeFor(piece=p,onBoard=Empty3x3,containing=on)
    // Check all positions are available for type of pieces
    assert(freeFor(King).map { p => (p.x,p.y) } === Set((2,1),(1,2)))
    assert(freeFor(Queen).map { p => (p.x,p.y) } === Set((1,2),(2,1)))
    assert(freeFor(Rook).map { p => (p.x,p.y) } === Set((1,2),(2,1)))
    assert(freeFor(Bishop).map { p => (p.x,p.y) } === Set((1,2),(2,1)))
    assert(freeFor(Knight).map { p => (p.x,p.y) } === Set())
  }
  
  test("Available positions in an non-empty 3x3 board - 2 Kings") {
    val board = Empty3x3
    val on: Set[(Piece,Position)] = Set((King,Position(0,0)),(King,Position(0,2)))
    def freeFor(p: Piece) = Board.freeFor(piece=p,onBoard=Empty3x3,containing=on)
    // Check all positions are available for type of pieces
    assert(freeFor(King).map { p => (p.x,p.y) }  === Set((2,0),(2,1),(2,2)))
    assert(freeFor(Queen).map { p => (p.x,p.y) } === Set((2,1)))
    assert(freeFor(Rook).map { p => (p.x,p.y) } === Set((2,1)))
    assert(freeFor(Bishop).map { p => (p.x,p.y) }  === Set((2,1)))
    assert(freeFor(Knight).map { p => (p.x,p.y) } === Set((2,0),(2,2)))
  }
}