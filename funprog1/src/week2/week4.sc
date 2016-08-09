package week2

object week4 {
  def nth[T](list: List[T], n: Int): T =
    if (list.isEmpty) throw new IndexOutOfBoundsException()
    else if (n == 0) list.head
    else nth(list.tail, n - 1)                    //> nth: [T](list: week2.List[T], n: Int)T
  val list = new Cons(1, new Cons(2, new Cons(3, new Nil)))
                                                  //> list  : week2.Cons[Int] = week2.Cons@2f7a2457
  nth(list, 2)

  //> res0: Int = 3
  def n1 = Zero.successor.successor
  def n2 = Zero.successor.successor.successor
  n1 + n2

}

trait List[T] {
  def isEmpty: Boolean
  def head: T
  def tail: List[T]
}
class Cons[T](val head: T, val tail: List[T]) extends List[T] {
  def isEmpty = false
}
class Nil[T] extends List[T] {
  def isEmpty = true
  def head = throw new NoSuchElementException("nil.head")
  def tail = throw new NoSuchElementException("nil.tail")
}

abstract class Nat {
  def isZero: Boolean
  def predecessor: Nat
  def successor: Nat = new Succ(this)
  def + (that: Nat): Nat
  def - (that: Nat): Nat
}

object Zero extends Nat {
  def isZero: Boolean = true
  def predecessor: Nat = throw new IllegalArgumentException()
  def + (that: Nat): Nat = that
  def - (that: Nat): Nat = if(that.isZero) this else throw new IllegalArgumentException()
}

class Succ(n: Nat) extends Nat {
  def isZero: Boolean = false
  def predecessor: Nat = n
  def + (that: Nat): Nat = new Succ(n + that)
  def - (that: Nat): Nat = if (that.isZero) this else n - that.predecessor
}

object List {
  def apply[T](x: T, y: T): List[T] = new Cons(x, new Cons(y, new Nil))
  def apply[T](x: T): List[T] = new Cons(x, new Nil)
  def apply[T](): List[T] = new Nil
}