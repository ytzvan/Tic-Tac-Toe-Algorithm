import scala.collection.mutable.ListBuffer

class evalresult {
	def victory(result: ListBuffer[String]) : Boolean = {
		val victory1 = List("a1","a2","a3") //The victoryn defines the different combination to win
		val victory2 = List("a1","b1","c1")
		val victory3 = List("a1","b2","c3")
		val victory4 = List("b1","b2","b3")
		val victory5 = List("a2","b2","c2")
		val victory6 = List("a3","b3","c3")
		val victory7 = List("c1","c2","c3")
		val victory8 = List("a3","b2","c1")
		val player = result.sorted
		val lstplayer = player.toList
		if (lstplayer == victory1) {
			return true
		} else if (lstplayer == victory2) {
			return true
		} else if (lstplayer == victory3) {
			return true
		} else if (lstplayer == victory4) {
			return true
		} else if (lstplayer == victory5) {
			return true
		} else if (lstplayer == victory6) {
			return true
		} else if (lstplayer == victory7) {
			return true
		}  else if (lstplayer == victory8) {
			return true
		} else {
			return false
		}
	}
}

class game{
	def validate(move: String) : Boolean = {
		val board = List("a1","a2","a3","b1","b2","b3","c1","c2","c3") //this is the board, letter are the rows, numbers are the files
		val playermove = move
		if (board.contains(playermove)) {
			return true
		} else {
			return false
		}
	}
	def moves{
		var i = 0; 
		var x = 0;
		val p1 = ListBuffer[String]()
		val p2 = ListBuffer[String]()
		var pos = ""
		
		for (i <- 1 to 3){
			var a = 0;
			while (a != 1) {
				println("Player 1: Mark your position")
				pos = readLine()	
				val valid = validate(pos)
				if (valid) {
					if (p1.contains(pos)) {
						println("Player 1: Alredy Marked") 
					} else if (p2.contains(pos)){
						println("Player 1: Alredy Marked") 
					} else{
						p1 += pos
						println("Player 1: Marked correctly")
						a = 1
					}
					} else {
						println("Player 1: Select a space betweeen A1 and C3")
					}
			}	
			for (x <- 1 to 1){
				a = 0
				while (a != 1) {
					println("Player 2: Mark your position")
					pos = readLine()
					val valid = validate(pos)
					if (valid) {
						if (p2.contains(pos)) {
							println("Player 2: Alredy Marked") 
						} else if (p1.contains(pos)){
							println("Player 2: Alredy Marked") 
						} else{
							p2 += pos
							println("Player 2: Marked correctly")
							a = 1
						}
					}
				}
			}
		}
		val myevalresult = new evalresult
	 	val scorep1 = myevalresult.victory(p1)
	 	val scorep2 = myevalresult.victory(p2)
	 	if (scorep1) {
	 		println("Player 1 Wins")
	 	} else if (scorep2) {
	 		println("Player 2 Wins")
	 	} else {
	 		println("Tie")
	 	}
	}
}

var mygame = new game
mygame.moves