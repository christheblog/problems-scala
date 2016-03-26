package org.cc.problem.chess

// Define a generic solution encoder
case class Encoder[T,U](empty: () => U,
                        encode: Set[(Piece,Position)] => T,
                        add: (U,T) => U,
                        combine: (U,U) => U)

object Encoder {
  
  lazy val DefaultEncoder = Encoder[Set[(Piece,Position)],Set[Set[(Piece,Position)]]](
    empty = () => Set(),
	  encode = (s: Set[(Piece,Position)]) => s,
	  add = (gs:Set[Set[(Piece,Position)]],s: Set[(Piece,Position)]) => gs + s,
	  combine = (s1: Set[Set[(Piece,Position)]],s2: Set[Set[(Piece,Position)]]) => s1 ++ s2
  )

  lazy val StringEncoder = Encoder[String,Set[String]](
    empty = () => Set(),
	  encode = (s: Set[(Piece,Position)]) => Solution.sort(s).mkString(",","",""),
	  add = (gs:Set[String],s: String) => gs + s,
	  combine = (s1: Set[String],s2: Set[String]) => s1 ++ s2
  )
  
  // TODO 
  // BloomFilter encoder : to estimate the number of solutions, 
  // Trie encoder : to compress big number of solutions, 
  // Long/Bitset encoder : for particular cases like the n-queens problems, etc.
	
}