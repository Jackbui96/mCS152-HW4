object ListLab {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(60); 
  println("Welcome to the Scala worksheet");$skip(46); 
       
  // Define
  def inc(n: Int) = n + 1;System.out.println("""inc: (n: Int)Int""");$skip(177); 
                                               
  // Problem 2a
  def sumOfSums(list: List[List[Int]]) = {
  	var sum = 0
  	for(i <- list.flatten)
  		sum = sum + i
  	sum
  };System.out.println("""sumOfSums: (list: List[List[Int]])Int""");$skip(48); val res$0 = 
  
  sumOfSums(List(List(1, 2, 3, 4), List(3)));System.out.println("""res0: Int = """ + $show(res$0));$skip(48); val res$1 = 
  sumOfSums(List(List(1, 2, 3), List(4, 5, 6)));System.out.println("""res1: Int = """ + $show(res$1));$skip(54); val res$2 = 
  sumOfSums(List(List(1, 2), List(2, 3), List(3, 4)));System.out.println("""res2: Int = """ + $show(res$2));$skip(105); 
  // Problem 2b
  def sumOfSumsRecur(list: List[List[Int]]): Int =
  	sumOfSumsRecurHelper(list.flatten);System.out.println("""sumOfSumsRecur: (list: List[List[Int]])Int""");$skip(124); 
  
 	def sumOfSumsRecurHelper(list: List[Int]): Int =
 		if(list == Nil) 0 else list.head + sumOfSumsRecurHelper(list.tail);System.out.println("""sumOfSumsRecurHelper: (list: List[Int])Int""");$skip(53); val res$3 = 
  
  sumOfSumsRecur(List(List(1, 2, 3, 4), List(3)));System.out.println("""res3: Int = """ + $show(res$3));$skip(53); val res$4 = 
  sumOfSumsRecur(List(List(1, 2, 3), List(4, 5, 6)));System.out.println("""res4: Int = """ + $show(res$4));$skip(59); val res$5 = 
  sumOfSumsRecur(List(List(1, 2), List(2, 3), List(3, 4)));System.out.println("""res5: Int = """ + $show(res$5));$skip(111); 
 
  // Problem 2c
 	def sumOfSumsTail(list: List[List[Int]]): Int = {
 		sumOfSumsTailHelper(list.flatten)
 	};System.out.println("""sumOfSumsTail: (list: List[List[Int]])Int""");$skip(220); 
 	
 	def sumOfSumsTailHelper(list: List[Int]): Int = {
 		def helper(result: Int, unseen: List[Int]): Int = {
       if (unseen == Nil) result else helper(result + unseen.head, unseen.tail)
    }
    helper(0, list)
 	};System.out.println("""sumOfSumsTailHelper: (list: List[Int])Int""");$skip(52); val res$6 = 
 	
 	sumOfSumsTail(List(List(1, 2, 3, 4), List(3)));System.out.println("""res6: Int = """ + $show(res$6));$skip(52); val res$7 = 
  sumOfSumsTail(List(List(1, 2, 3), List(4, 5, 6)));System.out.println("""res7: Int = """ + $show(res$7));$skip(58); val res$8 = 
  sumOfSumsTail(List(List(1, 2), List(2, 3), List(3, 4)));System.out.println("""res8: Int = """ + $show(res$8));$skip(177); 
  
	// Problem 2d
	def innerSum(list: List[Int]): Int = {
		if (list.length == 0) throw new Exception("length = 0")
    var total = 0
    for(i <- list) total += i
    total
	};System.out.println("""innerSum: (list: List[Int])Int""");$skip(74); val res$9 = 
	
	
	sumOfSumsTailHelper(List(List(1, 2, 3, 4), List(3)).map(innerSum _));System.out.println("""res9: Int = """ + $show(res$9));$skip(73); val res$10 = 
	sumOfSumsTailHelper(List(List(1, 2, 3), List(4, 5, 6)).map(innerSum _));System.out.println("""res10: Int = """ + $show(res$10));$skip(79); val res$11 = 
	sumOfSumsTailHelper(List(List(1, 2), List(2, 3), List(3, 4)).map(innerSum _));System.out.println("""res11: Int = """ + $show(res$11));$skip(94); val res$12 = 
	sumOfSumsTailHelper(List(List(1, 4), List(1, 4), List(2, 4, 6), List(4, 6)).map(innerSum _));System.out.println("""res12: Int = """ + $show(res$12));$skip(136); 
	// Problem 6a
	def countPass[T](list: List[T], f: T => Boolean): Int  = {
  	var r = 0
  	for (x <- list)
  		if(f(x)) r += 1
  	r
  };System.out.println("""countPass: [T](list: List[T], f: T => Boolean)Int""");$skip(117); val res$13 = 
  
  countPass(List(false, true, false, "test", 4, 532, false, "hydra", true), (x : Any) => x.isInstanceOf[Boolean]);System.out.println("""res13: Int = """ + $show(res$13));$skip(56); val res$14 = 
  countPass(List(42, 3, 5, 23), (x: Int) => x / 5 == 1);System.out.println("""res14: Int = """ + $show(res$14));$skip(203); 
  // Problem 6b
  def countPassRecur[T](list: List[T], f: T => Boolean): Int  = {
  	if(list == Nil) 0
  	else if(f(list.head)) inc(countPassRecur(list.tail, f))
  	else countPassRecur(list.tail, f)
  };System.out.println("""countPassRecur: [T](list: List[T], f: T => Boolean)Int""");$skip(122); val res$15 = 
  
  countPassRecur(List(false, true, false, "test", 4, 532, false, "hydra", true), (x : Any) => x.isInstanceOf[Boolean]);System.out.println("""res15: Int = """ + $show(res$15));$skip(61); val res$16 = 
  countPassRecur(List(42, 3, 5, 23), (x: Int) => x / 5 == 1);System.out.println("""res16: Int = """ + $show(res$16));$skip(304); 
  
  // Problem 6c
  def countPassTail[T](list: List[T], f: T => Boolean): Int  = {
  	def helper(result: Int, unseen: List[T]): Int = {
       if (unseen == Nil) result
       else if(f(unseen.head)) helper(inc(result), unseen.tail)
       else helper(result, unseen.tail)
    }
    helper(0, list)
  };System.out.println("""countPassTail: [T](list: List[T], f: T => Boolean)Int""");$skip(121); val res$17 = 
  
  countPassTail(List(false, true, false, "test", 4, 532, false, "hydra", true), (x : Any) => x.isInstanceOf[Boolean]);System.out.println("""res17: Int = """ + $show(res$17));$skip(60); val res$18 = 
  countPassTail(List(42, 3, 5, 23), (x: Int) => x / 5 == 1);System.out.println("""res18: Int = """ + $show(res$18));$skip(118); 
  
  // Problem 6d
	def countPassFilter[Any](list: List[Any], f: Any => Boolean): Int  = {
  	list.filter(f).size
  };System.out.println("""countPassFilter: [Any](list: List[Any], f: Any => Boolean)Int""");$skip(123); val res$19 = 
  
  countPassFilter(List(false, true, false, "test", 4, 532, false, "hydra", true), (x : Any) => x.isInstanceOf[Boolean]);System.out.println("""res19: Int = """ + $show(res$19));$skip(62); val res$20 = 
  countPassFilter(List(42, 3, 5, 23), (x: Int) => x / 5 == 1);System.out.println("""res20: Int = """ + $show(res$20));$skip(180); 
  
  // Problem 7a
  def countPassAll[T](list: List[T], f: T => Boolean): Boolean  = {
  	var flag = true
  	for (x <- list)
  		if(!f(x) && flag == true) flag = false
  	flag
  };System.out.println("""countPassAll: [T](list: List[T], f: T => Boolean)Boolean""");$skip(120); val res$21 = 
  
  countPassAll(List(false, true, false, "test", 4, 532, false, "hydra", true), (x : Any) => x.isInstanceOf[Boolean]);System.out.println("""res21: Boolean = """ + $show(res$21));$skip(86); val res$22 = 
  countPassAll(List(false, true, false, false), (x : Any) => x.isInstanceOf[Boolean]);System.out.println("""res22: Boolean = """ + $show(res$22));$skip(59); val res$23 = 
  countPassAll(List(42, 3, 5, 23), (x: Int) => x / 5 == 1);System.out.println("""res23: Boolean = """ + $show(res$23));$skip(275); 
  
  // Problem 7b
  def countPassAllRecur[T](list: List[T], f: T => Boolean): Boolean = {
  	if(list.tail == Nil && f(list.head)) true
  	else if(list.tail == Nil && !f(list.head)) false
  	else{
  		if(!f(list.head)) false
  		else countPassAllRecur(list.tail, f)
  	}
  };System.out.println("""countPassAllRecur: [T](list: List[T], f: T => Boolean)Boolean""");$skip(128); val res$24 = 
  
  
  countPassAllRecur(List(false, true, false, "test", 4, 532, false, "hydra", true), (x : Any) => x.isInstanceOf[Boolean]);System.out.println("""res24: Boolean = """ + $show(res$24));$skip(91); val res$25 = 
  countPassAllRecur(List(false, true, false, false), (x : Any) => x.isInstanceOf[Boolean]);System.out.println("""res25: Boolean = """ + $show(res$25));$skip(64); val res$26 = 
  countPassAllRecur(List(42, 3, 5, 23), (x: Int) => x / 5 == 1);System.out.println("""res26: Boolean = """ + $show(res$26));$skip(68); val res$27 = 
  
  countPassAllRecur(List(5, 20, 15, 55), (x: Int) => x % 5 == 0);System.out.println("""res27: Boolean = """ + $show(res$27));$skip(340); 
                                                  
  // Problem 7c
  def countPassAllTail[T](list: List[T], f: T => Boolean): Boolean = {
  	def helper(result: Boolean, unseen: List[T]): Boolean = {
       if (unseen == Nil) true
       else if(f(unseen.head)) helper(result, unseen.tail)
       else false
    }
    helper(true, list)
  };System.out.println("""countPassAllTail: [T](list: List[T], f: T => Boolean)Boolean""");$skip(124); val res$28 = 
  
  countPassAllTail(List(false, true, false, "test", 4, 532, false, "hydra", true), (x : Any) => x.isInstanceOf[Boolean]);System.out.println("""res28: Boolean = """ + $show(res$28));$skip(90); val res$29 = 
  countPassAllTail(List(false, true, false, false), (x : Any) => x.isInstanceOf[Boolean]);System.out.println("""res29: Boolean = """ + $show(res$29));$skip(63); val res$30 = 
  countPassAllTail(List(42, 3, 5, 23), (x: Int) => x / 5 == 1);System.out.println("""res30: Boolean = """ + $show(res$30));$skip(67); val res$31 = 
  
  countPassAllTail(List(5, 20, 15, 55), (x: Int) => x % 5 == 0);System.out.println("""res31: Boolean = """ + $show(res$31));$skip(157); 
  
  // Problem 7d
  
  def countPassAllFilter[T](list: List[T], f: T => Boolean): Boolean = {
  	if(list.filter(f).size == list.size) true
		else false
  };System.out.println("""countPassAllFilter: [T](list: List[T], f: T => Boolean)Boolean""");$skip(124); val res$32 = 

  countPassAllFilter(List(false, true, false, "test", 4, 532, false, "hydra", true), (x : Any) => x.isInstanceOf[Boolean]);System.out.println("""res32: Boolean = """ + $show(res$32));$skip(92); val res$33 = 
  countPassAllFilter(List(false, true, false, false), (x : Any) => x.isInstanceOf[Boolean]);System.out.println("""res33: Boolean = """ + $show(res$33));$skip(65); val res$34 = 
  countPassAllFilter(List(42, 3, 5, 23), (x: Int) => x / 5 == 1);System.out.println("""res34: Boolean = """ + $show(res$34));$skip(69); val res$35 = 
  
  countPassAllFilter(List(5, 20, 15, 55), (x: Int) => x % 5 == 0);System.out.println("""res35: Boolean = """ + $show(res$35));$skip(166); 
  
  
  // Problem 8a
  def countPassAny[T](list: List[T], f: T => Boolean): Boolean  = {
  	var flag = false
  	for (x <- list)
  		if(f(x)) flag = true
  	flag
  };System.out.println("""countPassAny: [T](list: List[T], f: T => Boolean)Boolean""");$skip(120); val res$36 = 
  
  countPassAny(List(false, true, false, "test", 4, 532, false, "hydra", true), (x : Any) => x.isInstanceOf[Boolean]);System.out.println("""res36: Boolean = """ + $show(res$36));$skip(86); val res$37 = 
  countPassAny(List(false, true, false, false), (x : Any) => x.isInstanceOf[Boolean]);System.out.println("""res37: Boolean = """ + $show(res$37));$skip(93); val res$38 = 
  
  countPassAny(List(42, "test", 5 + 3, "Baneling"), (x : Any) => x.isInstanceOf[Boolean]);System.out.println("""res38: Boolean = """ + $show(res$38));$skip(59); val res$39 = 
  countPassAny(List(42, 3, 5, 23), (x: Int) => x / 5 == 1);System.out.println("""res39: Boolean = """ + $show(res$39));$skip(63); val res$40 = 
  
  countPassAny(List(5, 20, 15, 55), (x: Int) => x % 5 == 0);System.out.println("""res40: Boolean = """ + $show(res$40));$skip(186); 
  // Problem 8b
 	def countPassAnyRecur[T](list: List[T], f: T => Boolean): Boolean = {
  	if(list == Nil) false
  	else if(f(list.head)) true
  	else countPassAnyRecur(list.tail, f)
	};System.out.println("""countPassAnyRecur: [T](list: List[T], f: T => Boolean)Boolean""");$skip(125); val res$41 = 
  
  countPassAnyRecur(List(false, true, false, "test", 4, 532, false, "hydra", true), (x : Any) => x.isInstanceOf[Boolean]);System.out.println("""res41: Boolean = """ + $show(res$41));$skip(91); val res$42 = 
  countPassAnyRecur(List(false, true, false, false), (x : Any) => x.isInstanceOf[Boolean]);System.out.println("""res42: Boolean = """ + $show(res$42));$skip(64); val res$43 = 
  countPassAnyRecur(List(42, 3, 5, 23), (x: Int) => x / 5 == 1);System.out.println("""res43: Boolean = """ + $show(res$43));$skip(98); val res$44 = 
  
  countPassAnyRecur(List(42, "test", 5 + 3, "Baneling"), (x : Any) => x.isInstanceOf[Boolean]);System.out.println("""res44: Boolean = """ + $show(res$44));$skip(68); val res$45 = 
  
  countPassAnyRecur(List(5, 20, 15, 55), (x: Int) => x % 5 == 0);System.out.println("""res45: Boolean = """ + $show(res$45));$skip(294); 
  
  // Problem 8c
  def countPassSomeTail[T](list: List[T], f: T => Boolean): Boolean = {
  	def helper(result: Boolean, unseen: List[T]): Boolean = {
       if (unseen == Nil) false
       else if(f(unseen.head)) true
       else helper(result, unseen.tail)
    }
    helper(false, list)
  };System.out.println("""countPassSomeTail: [T](list: List[T], f: T => Boolean)Boolean""");$skip(125); val res$46 = 
  
  countPassSomeTail(List(false, true, false, "test", 4, 532, false, "hydra", true), (x : Any) => x.isInstanceOf[Boolean]);System.out.println("""res46: Boolean = """ + $show(res$46));$skip(91); val res$47 = 
  countPassSomeTail(List(false, true, false, false), (x : Any) => x.isInstanceOf[Boolean]);System.out.println("""res47: Boolean = """ + $show(res$47));$skip(64); val res$48 = 
  countPassSomeTail(List(42, 3, 5, 23), (x: Int) => x / 5 == 1);System.out.println("""res48: Boolean = """ + $show(res$48));$skip(98); val res$49 = 
  
  countPassSomeTail(List(42, "test", 5 + 3, "Baneling"), (x : Any) => x.isInstanceOf[Boolean]);System.out.println("""res49: Boolean = """ + $show(res$49));$skip(68); val res$50 = 
  
  countPassSomeTail(List(5, 20, 15, 55), (x: Int) => x % 5 == 0);System.out.println("""res50: Boolean = """ + $show(res$50));$skip(154); 
  
  // Problem 8d
  def countPassSomeFilter[T](list: List[T], f: T => Boolean): Boolean = {
  	if(list == Nil) false
  	else list.filter(f).size > 0
  };System.out.println("""countPassSomeFilter: [T](list: List[T], f: T => Boolean)Boolean""");$skip(127); val res$51 = 
  
  countPassSomeFilter(List(false, true, false, "test", 4, 532, false, "hydra", true), (x : Any) => x.isInstanceOf[Boolean]);System.out.println("""res51: Boolean = """ + $show(res$51));$skip(66); val res$52 = 
  countPassSomeFilter(List(42, 3, 5, 23), (x: Int) => x / 5 == 1);System.out.println("""res52: Boolean = """ + $show(res$52));$skip(98); 
  
  // Problem 13
  def stream1(number: Int): Stream[Int] = Stream.cons(number, stream1(number));System.out.println("""stream1: (number: Int)Stream[Int]""");$skip(27); 
  stream1(1).take(5).print;$skip(84); 
  def stream2(number: Int): Stream[Int] = Stream.cons(number, stream2(inc(number)));System.out.println("""stream2: (number: Int)Stream[Int]""");$skip(27); 
  stream2(1).take(4).print;$skip(83); 
  def stream3(number: Int): Stream[Int] = Stream.cons(number, stream3(number + 2));System.out.println("""stream3: (number: Int)Stream[Int]""");$skip(27); 
  stream3(2).take(4).print;$skip(102); 
  def stream4(number: Double): Stream[Double] = Stream.cons(math.pow(number, 2), stream4(number + 1));System.out.println("""stream4: (number: Double)Stream[Double]""");$skip(27); 
  stream4(1).take(4).print;$skip(146); 
  
  
 	// Problem 3
 	def spellCheck(doc: List[String], dictionary: List[String]): List[String] =
 		doc filterNot (x => dictionary.contains(x));System.out.println("""spellCheck: (doc: List[String], dictionary: List[String])List[String]""");$skip(63); val res$53 = 
 	spellCheck(List("test", "red", "blue"), List("test", "red"));System.out.println("""res53: List[String] = """ + $show(res$53));$skip(88); val res$54 = 
 	spellCheck(List("bulbasaur", "charmander", "pikachu", "ratata"), List("test", "red"));System.out.println("""res54: List[String] = """ + $show(res$54));$skip(74); val res$55 = 
 	
 	spellCheck(List("I", "am", "a", "pirate"), List("am", "bin", "ich"));System.out.println("""res55: List[String] = """ + $show(res$55));$skip(114); 
 	
 	// Problem 4
  
  def evalMono(mono: (Double, Double), x: Double): Double = mono._1 * (math.pow(x, mono._2));System.out.println("""evalMono: (mono: (Double, Double), x: Double)Double""");$skip(24); val res$56 = 
  
  evalMono((2,3), 4);System.out.println("""res56: Double = """ + $show(res$56));$skip(109); 

	def evalPoly(poly: List[(Double, Double)], x: Double): Double
		= poly.head._1 * math.pow(poly.head._2, x);System.out.println("""evalPoly: (poly: List[(Double, Double)], x: Double)Double""");$skip(44); val res$57 = 
  evalPoly(List((3.0,2.0), (-5.0, 0.0)), 4);System.out.println("""res57: Double = """ + $show(res$57))}
  
}
