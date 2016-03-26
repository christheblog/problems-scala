package org.cc.problem.chess

import org.scalatest.FunSuite
import org.cc.problem.chess._

class Main extends FunSuite {

  test("3x3 - K,R,R") {
    val res = Game.solveNoEncoder(Board(3,3), King::Rook::Rook::Nil)
    res.foreach(println)
    assert(res.size === 4)
  }

  test("3x3 - K,K,R") {
    val res = Game.solveNoEncoder(Board(3,3), King::King::Rook::Nil)
    assert(res.size === 4)
  }
  
  test("4x4 - R,R,N,N,N,N") {
    val res = Game.solveNoEncoder(Board(4,4), Rook::Rook::Knight::Knight::Knight::Knight::Nil)
    assert(res.size === 8)
  }
  
  ignore("7x7 - K,K,Q,Q,B,B,N") {
    val res = Game.solveNoEncoder(Board(7,7), King::King::Queen::Queen::Bishop::Bishop::Knight::Nil)
    assert(res.size === 3063828)
  }
  
  test("3x3 - K,R,R - with string encoder") {
    val res = Game.solveStringEncoder(Board(3,3), King::Rook::Rook::Nil)
    assert(res.size === 4)
  }
  
  test("4x4 - R,R,N,N,N,N - with string encoder") {
    val res = Game.solveStringEncoder(Board(4,4), Rook::Rook::Knight::Knight::Knight::Knight::Nil)
    assert(res.size === 8)
  }
  
  ignore("7x7 - K,K,Q,Q,B,B,N - with string encoder") {
    val res = Game.solveStringEncoder(Board(7,7), King::King::Queen::Queen::Bishop::Bishop::Knight::Nil)
    assert(res.size === 3063828)
  }
  
  // From TJ
  
  test("5x5 - K,Q,Q") {
    val res = Game.solveNoEncoder(Board(5,5), Queen::Queen::King::Nil)
    assert(res.size === 612)
  }
  
  test("5x5 - K,Q,Q - with string encoder") {
    val res = Game.solveStringEncoder(Board(5,5), Queen::Queen::King::Nil)
    assert(res.size === 612)
  }


}