package org.cc.problem.chess

object Solution {
  
  // Naive solution implementation
  type Solution = Set[(Piece,Position)]
  type Solutions = Set[Solution]
  val Empty: Solutions = Set()

  // We need to sort a solution to have a constant list to encode
  def sort(solution: Set[(Piece,Position)]) = 
    solution.toList.sortBy { case (p,pos) => (p.toString,pos.x,pos.y) }

  // Find the Int position code of the solution on the board
  // It is basically an index for a one-dimensional array containing all the positions
  def codeFor(board: Board, atPosition: Position): Int = 
    board.width * atPosition.y + atPosition.x
  
  // Generic encoding function
  def encode[T,U](solution: Solution, 
		  		  convert: (Piece,Position) => T,
		  		  pack: Set[T] => U = identity[Set[T]]_): U = 
	  pack(solution.map(pp => convert(pp._1,pp._2)))

  // Put a solution into a String, relative to a board  		  
  def asString(board: Board, sol: Solution): String =
    encode[String,String](sol, (p1,p2) => p1.toString + codeFor(board,p2), _.toList.sorted.mkString(",","",""))
  
}