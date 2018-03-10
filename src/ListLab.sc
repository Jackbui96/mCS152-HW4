object ListLab {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
       
  // Define
  def inc(n: Int) = n + 1                         //> inc: (n: Int)Int
                                               
  // Problem 2a
  def sumOfSums(list: List[List[Int]]) = {
  	var sum = 0
  	for(i <- list.flatten)
  		sum = sum + i
  	sum
  }                                               //> sumOfSums: (list: List[List[Int]])Int
  
  sumOfSums(List(List(1, 2, 3, 4), List(3)))      //> res0: Int = 13
  sumOfSums(List(List(1, 2, 3), List(4, 5, 6)))   //> res1: Int = 21
  sumOfSums(List(List(1, 2), List(2, 3), List(3, 4)))
                                                  //> res2: Int = 15
  // Problem 2b
  def sumOfSumsRecur(list: List[List[Int]]): Int =
  	sumOfSumsRecurHelper(list.flatten)        //> sumOfSumsRecur: (list: List[List[Int]])Int
  
 	def sumOfSumsRecurHelper(list: List[Int]): Int =
 		if(list == Nil) 0 else list.head + sumOfSumsRecurHelper(list.tail)
                                                  //> sumOfSumsRecurHelper: (list: List[Int])Int
  
  sumOfSumsRecur(List(List(1, 2, 3, 4), List(3))) //> res3: Int = 13
  sumOfSumsRecur(List(List(1, 2, 3), List(4, 5, 6)))
                                                  //> res4: Int = 21
  sumOfSumsRecur(List(List(1, 2), List(2, 3), List(3, 4)))
                                                  //> res5: Int = 15
 
  // Problem 2c
 	def sumOfSumsTail(list: List[List[Int]]): Int = {
 		sumOfSumsTailHelper(list.flatten)
 	}                                         //> sumOfSumsTail: (list: List[List[Int]])Int
 	
 	def sumOfSumsTailHelper(list: List[Int]): Int = {
 		def helper(result: Int, unseen: List[Int]): Int = {
       if (unseen == Nil) result else helper(result + unseen.head, unseen.tail)
    }
    helper(0, list)
 	}                                         //> sumOfSumsTailHelper: (list: List[Int])Int
 	
 	sumOfSumsTail(List(List(1, 2, 3, 4), List(3)))
                                                  //> res6: Int = 13
  sumOfSumsTail(List(List(1, 2, 3), List(4, 5, 6)))
                                                  //> res7: Int = 21
  sumOfSumsTail(List(List(1, 2), List(2, 3), List(3, 4)))
                                                  //> res8: Int = 15
  
	// Problem 2d
	def innerSum(list: List[Int]): Int = {
		if (list.length == 0) throw new Exception("length = 0")
    var total = 0
    for(i <- list) total += i
    total
	}                                         //> innerSum: (list: List[Int])Int
	
	
	sumOfSumsTailHelper(List(List(1, 2, 3, 4), List(3)).map(innerSum _))
                                                  //> res9: Int = 13
	sumOfSumsTailHelper(List(List(1, 2, 3), List(4, 5, 6)).map(innerSum _))
                                                  //> res10: Int = 21
	sumOfSumsTailHelper(List(List(1, 2), List(2, 3), List(3, 4)).map(innerSum _))
                                                  //> res11: Int = 15
	sumOfSumsTailHelper(List(List(1, 4), List(1, 4), List(2, 4, 6), List(4, 6)).map(innerSum _))
                                                  //> res12: Int = 32
	// Problem 6a
	def countPass[T](list: List[T], f: T => Boolean): Int  = {
  	var r = 0
  	for (x <- list)
  		if(f(x)) r += 1
  	r
  }                                               //> countPass: [T](list: List[T], f: T => Boolean)Int
  
  countPass(List(false, true, false, "test", 4, 532, false, "hydra", true), (x : Any) => x.isInstanceOf[Boolean])
                                                  //> res13: Int = 5
  countPass(List(42, 3, 5, 23), (x: Int) => x / 5 == 1)
                                                  //> res14: Int = 1
  // Problem 6b
  def countPassRecur[T](list: List[T], f: T => Boolean): Int  = {
  	if(list == Nil) 0
  	else if(f(list.head)) inc(countPassRecur(list.tail, f))
  	else countPassRecur(list.tail, f)
  }                                               //> countPassRecur: [T](list: List[T], f: T => Boolean)Int
  
  countPassRecur(List(false, true, false, "test", 4, 532, false, "hydra", true), (x : Any) => x.isInstanceOf[Boolean])
                                                  //> res15: Int = 5
  countPassRecur(List(42, 3, 5, 23), (x: Int) => x / 5 == 1)
                                                  //> res16: Int = 1
  
  // Problem 6c
  def countPassTail[T](list: List[T], f: T => Boolean): Int  = {
  	def helper(result: Int, unseen: List[T]): Int = {
       if (unseen == Nil) result
       else if(f(unseen.head)) helper(inc(result), unseen.tail)
       else helper(result, unseen.tail)
    }
    helper(0, list)
  }                                               //> countPassTail: [T](list: List[T], f: T => Boolean)Int
  
  countPassTail(List(false, true, false, "test", 4, 532, false, "hydra", true), (x : Any) => x.isInstanceOf[Boolean])
                                                  //> res17: Int = 5
  countPassTail(List(42, 3, 5, 23), (x: Int) => x / 5 == 1)
                                                  //> res18: Int = 1
  
  // Problem 6d
	def countPassFilter[Any](list: List[Any], f: Any => Boolean): Int  = {
  	list.filter(f).size
  }                                               //> countPassFilter: [Any](list: List[Any], f: Any => Boolean)Int
  
  countPassFilter(List(false, true, false, "test", 4, 532, false, "hydra", true), (x : Any) => x.isInstanceOf[Boolean])
                                                  //> res19: Int = 5
  countPassFilter(List(42, 3, 5, 23), (x: Int) => x / 5 == 1)
                                                  //> res20: Int = 1
  
  // Problem 7a
  def countPassAll[T](list: List[T], f: T => Boolean): Boolean  = {
  	var flag = true
  	for (x <- list)
  		if(!f(x) && flag == true) flag = false
  	flag
  }                                               //> countPassAll: [T](list: List[T], f: T => Boolean)Boolean
  
  countPassAll(List(false, true, false, "test", 4, 532, false, "hydra", true), (x : Any) => x.isInstanceOf[Boolean])
                                                  //> res21: Boolean = false
  countPassAll(List(false, true, false, false), (x : Any) => x.isInstanceOf[Boolean])
                                                  //> res22: Boolean = true
  countPassAll(List(42, 3, 5, 23), (x: Int) => x / 5 == 1)
                                                  //> res23: Boolean = false
  
  // Problem 7b
  def countPassAllRecur[T](list: List[T], f: T => Boolean): Boolean = {
  	if(list.tail == Nil && f(list.head)) true
  	else if(list.tail == Nil && !f(list.head)) false
  	else{
  		if(!f(list.head)) false
  		else countPassAllRecur(list.tail, f)
  	}
  }                                               //> countPassAllRecur: [T](list: List[T], f: T => Boolean)Boolean
  
  
  countPassAllRecur(List(false, true, false, "test", 4, 532, false, "hydra", true), (x : Any) => x.isInstanceOf[Boolean])
                                                  //> res24: Boolean = false
  countPassAllRecur(List(false, true, false, false), (x : Any) => x.isInstanceOf[Boolean])
                                                  //> res25: Boolean = true
  countPassAllRecur(List(42, 3, 5, 23), (x: Int) => x / 5 == 1)
                                                  //> res26: Boolean = false
  
  countPassAllRecur(List(5, 20, 15, 55), (x: Int) => x % 5 == 0)
                                                  //> res27: Boolean = true
                                                  
  // Problem 7c
  def countPassAllTail[T](list: List[T], f: T => Boolean): Boolean = {
  	def helper(result: Boolean, unseen: List[T]): Boolean = {
       if (unseen == Nil) true
       else if(f(unseen.head)) helper(result, unseen.tail)
       else false
    }
    helper(true, list)
  }                                               //> countPassAllTail: [T](list: List[T], f: T => Boolean)Boolean
  
  countPassAllTail(List(false, true, false, "test", 4, 532, false, "hydra", true), (x : Any) => x.isInstanceOf[Boolean])
                                                  //> res28: Boolean = false
  countPassAllTail(List(false, true, false, false), (x : Any) => x.isInstanceOf[Boolean])
                                                  //> res29: Boolean = true
  countPassAllTail(List(42, 3, 5, 23), (x: Int) => x / 5 == 1)
                                                  //> res30: Boolean = false
  
  countPassAllTail(List(5, 20, 15, 55), (x: Int) => x % 5 == 0)
                                                  //> res31: Boolean = true
  
  // Problem 7d
  
  def countPassAllFilter[T](list: List[T], f: T => Boolean): Boolean = {
  	if(list.filter(f).size == list.size) true
		else false
  }                                               //> countPassAllFilter: [T](list: List[T], f: T => Boolean)Boolean

  countPassAllFilter(List(false, true, false, "test", 4, 532, false, "hydra", true), (x : Any) => x.isInstanceOf[Boolean])
                                                  //> res32: Boolean = false
  countPassAllFilter(List(false, true, false, false), (x : Any) => x.isInstanceOf[Boolean])
                                                  //> res33: Boolean = true
  countPassAllFilter(List(42, 3, 5, 23), (x: Int) => x / 5 == 1)
                                                  //> res34: Boolean = false
  
  countPassAllFilter(List(5, 20, 15, 55), (x: Int) => x % 5 == 0)
                                                  //> res35: Boolean = true
  
  
  // Problem 8a
  def countPassAny[T](list: List[T], f: T => Boolean): Boolean  = {
  	var flag = false
  	for (x <- list)
  		if(f(x)) flag = true
  	flag
  }                                               //> countPassAny: [T](list: List[T], f: T => Boolean)Boolean
  
  countPassAny(List(false, true, false, "test", 4, 532, false, "hydra", true), (x : Any) => x.isInstanceOf[Boolean])
                                                  //> res36: Boolean = true
  countPassAny(List(false, true, false, false), (x : Any) => x.isInstanceOf[Boolean])
                                                  //> res37: Boolean = true
  
  countPassAny(List(42, "test", 5 + 3, "Baneling"), (x : Any) => x.isInstanceOf[Boolean])
                                                  //> res38: Boolean = false
  countPassAny(List(42, 3, 5, 23), (x: Int) => x / 5 == 1)
                                                  //> res39: Boolean = true
  
  countPassAny(List(5, 20, 15, 55), (x: Int) => x % 5 == 0)
                                                  //> res40: Boolean = true
  // Problem 8b
  def countPassAnyRecur[T](list: List[T], f: T => Boolean): Boolean = {
  	if(list == Nil) false
  	else if(f(list.head)) true
  	else countPassAllRecur(list.tail, f)
  }                                               //> countPassAnyRecur: [T](list: List[T], f: T => Boolean)Boolean
  
  
  countPassAnyRecur(List(false, true, false, "test", 4, 532, false, "hydra", true), (x : Any) => x.isInstanceOf[Boolean])
                                                  //> res41: Boolean = true
  countPassAnyRecur(List(false, true, false, false), (x : Any) => x.isInstanceOf[Boolean])
                                                  //> res42: Boolean = true
  countPassAnyRecur(List(42, 3, 5, 23), (x: Int) => x / 5 == 1)
                                                  //> res43: Boolean = false
  
  countPassAnyRecur(List(42, "test", 5 + 3, "Baneling"), (x : Any) => x.isInstanceOf[Boolean])
                                                  //> res44: Boolean = false
  
  countPassAnyRecur(List(5, 20, 15, 55), (x: Int) => x % 5 == 0)
                                                  //> res45: Boolean = true
  
  // Problem 8c
  def countPassSomeTail[T](list: List[T], f: T => Boolean): Boolean = {
  	def helper(result: Boolean, unseen: List[T]): Boolean = {
       if (unseen == Nil) false
       else if(f(unseen.head)) true
       else helper(result, unseen.tail)
    }
    helper(false, list)
  }                                               //> countPassSomeTail: [T](list: List[T], f: T => Boolean)Boolean
  
  countPassSomeTail(List(false, true, false, "test", 4, 532, false, "hydra", true), (x : Any) => x.isInstanceOf[Boolean])
                                                  //> res46: Boolean = true
  countPassSomeTail(List(false, true, false, false), (x : Any) => x.isInstanceOf[Boolean])
                                                  //> res47: Boolean = true
  countPassSomeTail(List(42, 3, 5, 23), (x: Int) => x / 5 == 1)
                                                  //> res48: Boolean = true
  
  countPassSomeTail(List(42, "test", 5 + 3, "Baneling"), (x : Any) => x.isInstanceOf[Boolean])
                                                  //> res49: Boolean = false
  
  countPassSomeTail(List(5, 20, 15, 55), (x: Int) => x % 5 == 0)
                                                  //> res50: Boolean = true
  
  // Problem 8d
  def countPassSomeFilter[T](list: List[T], f: T => Boolean): Boolean = {
  	if(list == Nil) false
  	else list.filter(f).size > 0
  }                                               //> countPassSomeFilter: [T](list: List[T], f: T => Boolean)Boolean
  
  countPassSomeFilter(List(false, true, false, "test", 4, 532, false, "hydra", true), (x : Any) => x.isInstanceOf[Boolean])
                                                  //> res51: Boolean = true
  countPassSomeFilter(List(42, 3, 5, 23), (x: Int) => x / 5 == 1)
                                                  //> res52: Boolean = true
  
  // Problem 13
  def stream1(number: Int): Stream[Int] = Stream.cons(number, stream1(number))
                                                  //> stream1: (number: Int)Stream[Int]
  stream1(1).take(5).print                        //> 1, 1, 1, 1, 1, empty
  def stream2(number: Int): Stream[Int] = Stream.cons(number, stream2(inc(number)))
                                                  //> stream2: (number: Int)Stream[Int]
  stream2(1).take(4).print                        //> 1, 2, 3, 4, empty
  def stream3(number: Int): Stream[Int] = Stream.cons(number, stream3(number + 2))
                                                  //> stream3: (number: Int)Stream[Int]
  stream3(2).take(4).print                        //> 2, 4, 6, 8, empty
  def stream4(number: Double): Stream[Double] = Stream.cons(math.pow(number, 2), stream4(number + 1))
                                                  //> stream4: (number: Double)Stream[Double]
  stream4(1).take(4).print                        //> 1.0, 4.0, 9.0, 16.0, empty
  
  
 	// Problem 3
 	def spellCheck(doc: List[String], dictionary: List[String]): List[String] =
 		doc filterNot (x => dictionary.contains(x))
                                                  //> spellCheck: (doc: List[String], dictionary: List[String])List[String]
 	spellCheck(List("test", "red", "blue"), List("test", "red"))
                                                  //> res53: List[String] = List(blue)
 	spellCheck(List("bulbasaur", "charmander", "pikachu", "ratata"), List("test", "red"))
                                                  //> res54: List[String] = List(bulbasaur, charmander, pikachu, ratata)
 	
 	spellCheck(List("I", "am", "a", "pirate"), List("am", "bin", "ich"))
                                                  //> res55: List[String] = List(I, a, pirate)
 	
 	// Problem 4
  
  def evalMono(mono: (Double, Double), x: Double): Double = mono._1 * (math.pow(x, mono._2))
                                                  //> evalMono: (mono: (Double, Double), x: Double)Double
  
  evalMono((2,3), 4)                              //> res56: Double = 128.0

	def evalPoly(poly: List[(Double, Double)], x: Double): Double
		= poly.head._1 * math.pow(poly.head._2, x)
                                                  //> evalPoly: (poly: List[(Double, Double)], x: Double)Double
  evalPoly(List((3.0,2.0), (-5.0, 0.0)), 4)       //> res57: Double = 48.0
  
  
  
  
  
  
  
  
  
  
}