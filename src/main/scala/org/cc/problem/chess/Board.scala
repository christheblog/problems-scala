package org.cc.problem.chess

sealed trait Piece
case object King extends Piece { override def toString = "K" }
case object Queen extends Piece { override def toString = "Q" }
case object Bishop extends Piece { override def toString = "B" }
case object Rook extends Piece { override def toString = "R" }
case object Knight extends Piece { override def toString = "N" }

case class Position(x: Int, y: Int)

object Position {
  
  lazy val cache = (for(i<-0 until 10; j <- 0 until 10) yield { (i,j)->Position(i,j) }).toMap
  
  def from(x: Int,y: Int) = cache.getOrElse((x,y),Position(x,y))
  
  implicit def tupleToPos(t:(Int,Int)): Position = Position.from(t._1,t._2)
  implicit def posToTuple(p: Position): (Int,Int) = (p.x,p.y)
}


// 0 x 0 is the upper left corner
case class Board(width: Int, height: Int) {
  lazy val positions = (for(x <- 0 until width; y <- 0 until height) yield Position.from(x,y)).toSet
}


object Board {
  
  def isOnBoard(board: Board, pos: Position) = 
    pos.x >= 0 && pos.y >= 0 && pos.x < board.width && pos.y < board.height
  
  // List of possible moves for a piece on the board
  def moves(board: Board,piece: Piece, from: Position): Set[Position] = {
    
    def square(x: Int, y: Int) = 
      (for (i <- x - 1 to x + 1; j <- y - 1 to y + 1 if (x, y) != (i, j)) yield Position.from(i, j)).toSet
    
    def diagonals(x: Int, y: Int) = 
      (for(i <- 1 to math.max(board.width,board.height)) yield Seq(Position.from(x+i,y+i),Position.from(x+i,y-i),Position.from(x-i,y+i),Position.from(x-i,y-i))).flatten.toSet
    
    def cross(x: Int, y: Int) = 
      ((for(i <-0 until board.width if i!=x) yield Position.from(i,y)) ++ (for(j <-0 until board.height if j!=y) yield Position.from(x,j))).toSet
    
    ((piece, from.x, from.y) match {
      case (King, x, y) => square(x,y)
      case (Bishop, x, y) => diagonals(x, y)
      case (Rook, x, y) => cross(x, y)
      case (Queen, x, y) => diagonals(x, y) ++ cross(x, y)
      case (Knight, x, y) => Set[Position](
    		  (x + 1, y + 2), 
    		  (x + 1, y - 2), 
    		  (x + 2, y + 1),
    		  (x + 2, y - 1), 
    		  (x - 1, y + 2), 
    		  (x - 1, y - 2), 
    		  (x - 2, y + 1), 
    		  (x - 2, y - 1))
    }).filter(isOnBoard(board,_))
  }
  
  // All available positions for the specified piece
  def freeFor(piece: Piece, 
              onBoard: Board, 
              containing: Set[(Piece,Position)], 
              withMoves: (Board,Piece,Position) => Set[Position] = Board.moves) = {
    val busy = containing.map { _._2 }
    val free = onBoard.positions -- busy -- containing.map { case (piece,pos) => withMoves(onBoard,piece,pos) }.flatten
    free.filter { atPos => (withMoves(onBoard,piece,atPos) intersect busy) isEmpty }
  }
  
  // 90 degrees clockwise - will succeed only if board is a square, else None is returned
  // Could be used to stop the search early in a sequential search generating all positions 
  def rotate(board: Board,pp: (Piece,Position)): Option[(Piece,Position)] = 
    (board.width,board.height,pp._1,pp._2) match {
      case (m,n,piece,pos) if m==n => Some((piece,Position.from(pos.y,pos.x)))
      case _ => None
    }
  
}

