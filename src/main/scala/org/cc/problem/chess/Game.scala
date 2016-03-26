package org.cc.problem.chess

// The game is to find all configuration of the board with no pieces left
// These are corresponding to the Configuration.out sequence to be empty
// The solution is then the Configuration.on representing pieces on the board
// All configuration objects generated must be valid
object Game {
  
  import scala.collection.immutable.Set
  import Solution._
  import Solver.solve
  
  // Solve - no encoding
  def solveNoEncoder(board: Board, 
                     pieces: List[Piece],
                     moves: (Board,Piece,Position) => Set[Position] = Board.moves): Set[Solution] =
    solve[Solution,Solutions](board,pieces)(Encoder.DefaultEncoder,moves)
  
  // Solve using a String encoder - better perfs for big number of solutions
  def solveStringEncoder(board: Board, 
                         pieces: List[Piece],
                         moves: (Board,Piece,Position) => Set[Position] = Board.moves): Set[String] =
    solve[String,Set[String]](board,pieces)(Encoder.StringEncoder ,moves)

  // Solve the n-queen problem
  def nQueens(n: Int) = 
    solveStringEncoder(Board(n,n),(0 until n).map { _ => Queen}.toList)
    
}
