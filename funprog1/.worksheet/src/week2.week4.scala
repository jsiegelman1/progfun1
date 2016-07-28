package week2

object week4 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(192); 
  def nth[T](list: List[T], n: Int): T =
    if (list.isEmpty) throw new IndexOutOfBoundsException()
    else if (n == 0) list.head
    else nth(list.tail, n - 1);System.out.println("""nth: [T](list: week2.List[T], n: Int)T""");$skip(60); 
  val list = new Cons(1, new Cons(2, new Cons(3, new Nil)));System.out.println("""list  : week2.Cons[Int] = """ + $show(list ));$skip(15); val res$0 = 
  nth(list, 2);System.out.println("""res0: Int = """ + $show(res$0))}
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
