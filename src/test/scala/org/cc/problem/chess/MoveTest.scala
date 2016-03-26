package org.cc.problem.chess

import org.scalatest.FunSuite

class MoveTest extends FunSuite {

  import scala.collection.immutable.Set

  // Standard 8 x 8 board
  implicit val board = Board(8, 8)
  val moves = Board.moves(board,_: Piece,_: Position)
  
  
  // Checking moves when starting from the middle
  val Start = Position(3, 3)
  
  test("King's moves") {
    val pos = moves(King, Start).map { p => (p.x,p.y)}
    val solution = Set((2,2),(2,3),(2,4),(3,2),(3,4),(4,2),(4,3),(4,4))
    assert(pos.size === 8)
    assert(solution.size === 8)
    assert(pos === solution)
  }

  test("Knight's moves") {
    val pos = moves(Knight, Start).map { p => (p.x,p.y)}
    val solution = Set((1,2),(1,4),(2,1),(2,5),(4,1),(4,5),(5,2),(5,4))
    assert(pos.size === 8)
    assert(solution.size === 8)
    assert(pos === solution)
  }

  test("Bishop's moves") {
    val pos = moves(Bishop, Start).map { p => (p.x,p.y)}
    val solution = Set((0,0),(1,1),(2,2),(4,4),(5,5),(6,6),(7,7),(6,0),(5,1),(4,2),(2,4),(1,5),(0,6))
    assert(pos.size === 13)
    assert(solution.size === 13)
    assert(pos === solution)
  }

  test("Rook's moves") {
    val pos = moves(Rook, Start).map { p => (p.x,p.y)}
    val solution = Set((0,3),(1,3),(2,3),(4,3),(5,3),(6,3),(7,3),(3,0),(3,1),(3,2),(3,4),(3,5),(3,6),(3,7))
    assert(pos.size === 14)
    assert(solution.size === 14)
    assert(pos === solution)

  }

  test("Queen's moves") {
    val pos = moves(Queen, Start).map { p => (p.x,p.y)}
    val solution = Set((0,3),(1,3),(2,3),(4,3),(5,3),(6,3),(7,3),(3,0),(3,1),(3,2),(3,4),(3,5),(3,6),(3,7)) ++
                   Set((0,0),(1,1),(2,2),(4,4),(5,5),(6,6),(7,7),(6,0),(5,1),(4,2),(2,4),(1,5),(0,6))
    assert(pos.size === 27)
    assert(solution.size === 27)
    assert(pos === solution)
  }
  
  
  // Checking moves when in a corner
  val StartFromCorner = (0,0)
  
  test("King's moves from corner") {
    val pos = moves(King, StartFromCorner).map { p => (p.x,p.y)}
    val solution = Set((0,1),(1,1),(1,0))
    assert(pos.size === 3)
    assert(solution.size === 3)
    assert(pos === solution)
  }

  test("Knight's moves from corner") {
    val pos = moves(Knight, StartFromCorner).map { p => (p.x,p.y)}
    val solution = Set((1,2),(2,1))
    assert(pos.size === 2)
    assert(solution.size === 2)
    assert(pos === solution)
  }

  test("Bishop's moves from corner") {
    val pos = moves(Bishop, StartFromCorner).map { p => (p.x,p.y)}
    val solution = Set((1,1),(2,2),(3,3),(4,4),(5,5),(6,6),(7,7))
    assert(pos.size === 7)
    assert(solution.size === 7)
    assert(pos === solution)
  }

  test("Rook's moves from corner") {
    val pos = moves(Rook, StartFromCorner).map { p => (p.x,p.y)}
    val solution = Set((0,1),(0,2),(0,3),(0,4),(0,5),(0,6),(0,7),(1,0),(2,0),(3,0),(4,0),(5,0),(6,0),(7,0))
    assert(pos.size === 14)
    assert(solution.size === 14)
    assert(pos === solution)

  }

  test("Queen's moves from corner") {
    val pos = moves(Queen, StartFromCorner).map { p => (p.x,p.y)}
    val solution = Set((1,1),(2,2),(3,3),(4,4),(5,5),(6,6),(7,7)) ++
                   Set((0,1),(0,2),(0,3),(0,4),(0,5),(0,6),(0,7),(1,0),(2,0),(3,0),(4,0),(5,0),(6,0),(7,0))
    assert(pos.size === 21)
    assert(solution.size === 21)
    assert(pos === solution)
  }
  
}