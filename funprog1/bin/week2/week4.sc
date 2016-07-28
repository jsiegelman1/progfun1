package week2

object week4 {
  def nth[T](list: List[T], n: Int): T =
    if (list.isEmpty) throw new IndexOutOfBoundsException()
    else if (n == 0) list.head
    else nth(list.tail, n - 1)                    //> nth: [T](list: week2.List[T], n: Int)T
  val list = new Cons(1, new Cons(2, new Cons(3, new Nil)))
                                                  //> list  : week2.Cons[Int] = week2.Cons@2f7a2457
  nth(list, 2)                                    //> res0: Int = 3
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