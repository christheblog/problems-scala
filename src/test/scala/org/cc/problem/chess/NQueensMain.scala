package org.cc.problem.chess

import org.scalatest.FunSuite


class NQueensMain extends FunSuite {

  test("4 Queens") {
    val res = Game.nQueens(4)
    assert(res.size === 2)
  }

  test("5 Queens") {
    val res = Game.nQueens(5)
    assert(res.size === 10)
  }

  test("6 Queens") {
    val res = Game.nQueens(6)
    assert(res.size === 4)
  }

  test("7 Queens") {
    val res = Game.nQueens(7)
    assert(res.size === 40)
  }

  ignore("8 Queens") {
    val res = Game.nQueens(8)
    assert(res.size === 92)
  }

}