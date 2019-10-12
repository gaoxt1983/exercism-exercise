class CustomSet[T](l: List[T]) extends Set[T] {

  self =>

  private val innerMap: Map[T, Boolean] = l.map(e => (e, true)).toMap

  override def contains(elem: T): Boolean = innerMap.contains(elem)

  override def +(elem: T): Set[T] = {
    CustomSet.fromList(elem +: innerMap.keys.toList)
  }

  override def -(elem: T): Set[T] = {
    CustomSet.fromList(innerMap.filterKeys(e => !e.equals(elem)).keys.toList)
  }

  override def iterator: Iterator[T] = {
    self.innerMap.keys.iterator
  }
}

object CustomSet {

  def fromList[T](l: List[T]): CustomSet[T] = {
    new CustomSet(l)
  }

  def empty[T](s: CustomSet[T]): Boolean = {
    s.isEmpty
  }

  def member[T](s: CustomSet[T], m: T): Boolean = {
    s.contains(m)
  }

  def isSubsetOf[T](s1: CustomSet[T], s2: CustomSet[T]): Boolean = {
    s1.subsetOf(s2)
  }

  def isDisjointFrom[T](s1: CustomSet[T], s2: CustomSet[T]): Boolean = {
    s1.forall(e => !s2.contains(e))
  }

  def isEqual[T](s1: CustomSet[T], s2: CustomSet[T]): Boolean = {
    s1.forall(e => s2.contains(e))
  }

  def insert[T](s: CustomSet[T], m: T): CustomSet[T] = {
    CustomSet.fromList(m +: s.toList)
  }

  def intersection[T](s1: CustomSet[T], s2: CustomSet[T]): CustomSet[T] = {
    CustomSet.fromList(s1.filter(e => s2.contains(e)).toList)
  }

  def difference[T](s1: CustomSet[T], s2: CustomSet[T]): CustomSet[T] = {
    CustomSet.fromList(s1.filter(e => !s2.contains(e)).toList)
  }

  def union[T](s1: CustomSet[T], s2: CustomSet[T]): CustomSet[T] = {
    CustomSet.fromList((s2 ++ difference(s1, s2)).toList)
  }
}
