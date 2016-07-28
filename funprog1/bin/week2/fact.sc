package week2

object fact {
  def factorial(n: Int): Int = {
    def factHelp(cur: Int, total: Int): Int =
      if (cur == n) total
      else factHelp(cur + 1, total * cur)
    factHelp(1, 1)
  }                                               //> factorial: (n: Int)Int
  factorial(10)                                   //> res0: Int = 362880

  def balance(chars: List[Char]): Boolean = {
    def auxBalance(acc: Int, chars: List[Char]): Int =
      if (chars.head == '(') auxBalance(acc + 1, chars.tail)
      else {
        if (chars.head == ')') auxBalance(acc - 1, chars.tail)
        else auxBalance(acc, chars.tail)
      }
    auxBalance(0, chars) == 0
  }                                               //> balance: (chars: List[Char])Boolean

  def sum(f: Int => Int, a: Int, b: Int): Int = {
    def loop(a: Int, acc: Int): Int = {
      if (a > b) acc
      else loop(a + a, f(a) + acc)
    }
    loop(a, 0)
  }                                               //> sum: (f: Int => Int, a: Int, b: Int)Int
  def product(f: Int => Int)(a: Int, b:Int): Int = {
  	if(a > b) 1 else f(a) * product(f)(a + 1, b)
  }                                               //> product: (f: Int => Int)(a: Int, b: Int)Int
  def fact(a: Int) = {
  	product(x => x)(1, a)
  }                                               //> fact: (a: Int)Int
  fact(5)                                         //> res1: Int = 120
	def genRange(f: Int => Int, c: (Int, Int) => Int, base: Int)(a: Int, b:Int): Int = {
		if(a > b) base else c(f(a), genRange(f, c, base)(a + 1, b))
	}                                         //> genRange: (f: Int => Int, c: (Int, Int) => Int, base: Int)(a: Int, b: Int)I
                                                  //| nt
	genRange(x => x * x, (x, y) => x * y, 1)(3, 4)
                                                  //> res2: Int = 144
	
	
}