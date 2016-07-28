package week2

object fact {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(198); 
  def factorial(n: Int): Int = {
    def factHelp(cur: Int, total: Int): Int =
      if (cur == n) total
      else factHelp(cur + 1, total * cur)
    factHelp(1, 1)
  };System.out.println("""factorial: (n: Int)Int""");$skip(16); val res$0 = 
  factorial(10);System.out.println("""res0: Int = """ + $show(res$0));$skip(322); 

  def balance(chars: List[Char]): Boolean = {
    def auxBalance(acc: Int, chars: List[Char]): Int =
      if (chars.head == '(') auxBalance(acc + 1, chars.tail)
      else {
        if (chars.head == ')') auxBalance(acc - 1, chars.tail)
        else auxBalance(acc, chars.tail)
      }
    auxBalance(0, chars) == 0
  };System.out.println("""balance: (chars: List[Char])Boolean""");$skip(172); 

  def sum(f: Int => Int, a: Int, b: Int): Int = {
    def loop(a: Int, acc: Int): Int = {
      if (a > b) acc
      else loop(a + a, f(a) + acc)
    }
    loop(a, 0)
  };System.out.println("""sum: (f: Int => Int, a: Int, b: Int)Int""");$skip(105); 
  def product(f: Int => Int)(a: Int, b:Int): Int = {
  	if(a > b) 1 else f(a) * product(f)(a + 1, b)
  };System.out.println("""product: (f: Int => Int)(a: Int, b: Int)Int""");$skip(52); 
  def fact(a: Int) = {
  	product(x => x)(1, a)
  };System.out.println("""fact: (a: Int)Int""");$skip(10); val res$1 = 
  fact(5);System.out.println("""res1: Int = """ + $show(res$1));$skip(151); 
	def genRange(f: Int => Int, c: (Int, Int) => Int, base: Int)(a: Int, b:Int): Int = {
		if(a > b) base else c(f(a), genRange(f, c, base)(a + 1, b))
	};System.out.println("""genRange: (f: Int => Int, c: (Int, Int) => Int, base: Int)(a: Int, b: Int)Int""");$skip(48); val res$2 = 
	genRange(x => x * x, (x, y) => x * y, 1)(3, 4);System.out.println("""res2: Int = """ + $show(res$2))}
	
	
}
