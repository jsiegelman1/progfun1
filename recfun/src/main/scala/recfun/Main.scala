package recfun

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = {
    if (c == 0 || c == r || r == 0) 1
    else pascal(c - 1, r - 1) + pascal(c, r - 1)
  }

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
    def auxBalance(acc: Int, chars: List[Char]): Int = {
      if (acc < 0) -1
      else if (!chars.isEmpty) {
        def head = chars.head
        if (head == '(') {
          auxBalance(acc + 1, chars.tail)
        } else {
          if (head == ')') {
            auxBalance(acc - 1, chars.tail)
          } else {
            auxBalance(acc, chars.tail)
          }
        }
      } else {
        acc
      }
    }
    auxBalance(0, chars) == 0
  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    if (money == 0 || coins.isEmpty) 0
    else {
      def first = {
        if (money == coins.head) 1
        else if (money >= coins.head) countChange(money - coins.head, coins)
        else 0
      }
      first + countChange(money, coins.tail)
    }
  }
}
