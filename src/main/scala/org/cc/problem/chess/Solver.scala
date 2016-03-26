package org.cc.problem.chess

object Solver {
  
  import scala.collection.immutable.Set
  import Solution._
  
  def solve[T,U](board: Board, pieces: List[Piece])
       (implicit encoder: Encoder[T,U] = Encoder.DefaultEncoder,
                 moves: (Board,Piece,Position) => Set[Position] = Board.moves): U = {
    import encoder._
    def loop(on: Set[(Piece,Position)], remaining: List[Piece], res: U): U = (on,remaining) match {
      case (on,Nil) => 
        add(res,encode(on))
      case (on,p::ps) =>
        val available = Board.freeFor(piece=p,onBoard=board,containing=on,withMoves=moves)
        if(available.isEmpty) res
        else available.par.map { pos => loop(on + ((p,pos)),ps,res) }.seq.foldLeft(empty())(combine)
    }
    loop(Set(),pieces,empty())
  }

}