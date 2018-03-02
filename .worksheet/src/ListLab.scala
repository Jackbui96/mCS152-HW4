object ListLab {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(60); 
  println("Welcome to the Scala worksheet");$skip(151); 
  
  // Problem 1a
  def sumCubes(list: List[Double]) = {
  	var sum = 0.0;
  	for(i <- list)
  		if(i % 2 != 0) sum = sum + math.pow(i, 3)
  	sum
  };System.out.println("""sumCubes: (list: List[Double])Double""");$skip(35); val res$0 = 
  
  sumCubes(List(1, 2, 3, 4, 5));System.out.println("""res0: Double = """ + $show(res$0));$skip(32); val res$1 = 
  sumCubes(List(1, 2, 3, 4, 5));System.out.println("""res1: Double = """ + $show(res$1));$skip(32); val res$2 = 
  sumCubes(List(1, 2, 3, 4, 5));System.out.println("""res2: Double = """ + $show(res$2));$skip(32); val res$3 = 
  sumCubes(List(1, 2, 3, 4, 5));System.out.println("""res3: Double = """ + $show(res$3))}
  
  // Problem 1b
  //def sumCubesRecur() =
  
  
}
