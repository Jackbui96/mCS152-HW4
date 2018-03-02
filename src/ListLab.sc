object ListLab {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  // Problem 1a
  def sumCubes(list: List[Double]) = {
  	var sum = 0.0;
  	for(i <- list)
  		if(i % 2 != 0) sum = sum + math.pow(i, 3)
  	sum
  }                                               //> sumCubes: (list: List[Double])Double
  
  sumCubes(List(1, 2, 3, 4, 5))                   //> res0: Double = 153.0
  sumCubes(List(1, 2, 3, 4, 5))                   //> res1: Double = 153.0
  sumCubes(List(1, 2, 3, 4, 5))                   //> res2: Double = 153.0
  sumCubes(List(1, 2, 3, 4, 5))                   //> res3: Double = 153.0
  
  // Problem 1b
  //def sumCubesRecur() =
  
  
}