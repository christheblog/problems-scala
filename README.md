# Problems-Scala


## Description

This project will contain some small problems that I enjoyed solving in Scala. It will be most likely short snippets of code. 

## Generalized N-Queens problem

The first problem here is a generalized version of the N-Queens problem : 
Given a board N x N and a set of chess pieces (among King, Queen, Knight, Rook, Tower), find all possible configurations where no piece can attack another one.

For example, you have given 2 Rooks and a King to place on a 3 x 3 board. A solution could be :

```
	| K |   |   |
	-------------
	|   |   | R |
	-------------
	|   | R |   |
	-------------
```

Rotating the board, you could find 3 more symmetrical solutions.

The program computes all possible solutions for a problem provided a list of pieces to place and a board of dimension N x N.

The well known N-Queens is a particular case of this problems where we need to place N Queens on a N x N board. You can read more here : https://en.wikipedia.org/wiki/Eight_queens_puzzle 

The N-queens problem can be solved in many different ways, lot of the solutions and optimizations relying on the fact pieces are queens. 
The N-queens problem has given rise to a number of interesting variations like the 9-queens problem : "Put 9 queens and one pawn on an 8 × 8 board in such a way that queens cannot attack each other"
You can check the following link : http://www.chessvariants.com/problems.dir/9queens.html
     