package org.cc.problem.chess

import org.scalatest.FunSuite

class SolutionTest extends FunSuite {
  
  test("Position Int encoding for 3x3 board") {
    val board = Board(3,3)
    val posCodes = board.positions.toList.sortBy { p => (p.x,p.y) }.map { p=> p->Solution.codeFor(board,p) }
    val codes = posCodes.map { _._2 }
    println(posCodes)
    assert(codes.distinct.size===9)
    assert(codes.size===9)
    assert(codes.min===0)
    assert(codes.max===8)
  }

  test("Position Int encoding for 4x4 board") {
    val board = Board(4,4)
    val posCodes = board.positions.toList.sortBy { p => (p.x,p.y) }.map { p=> p->Solution.codeFor(board,p) }
    val codes = posCodes.map { _._2 }
    println(posCodes)
    assert(codes.distinct.size===16)
    assert(codes.size===16)
    assert(codes.min===0)
    assert(codes.max===15)
  }

  
}