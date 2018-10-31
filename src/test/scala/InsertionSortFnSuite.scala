import common.{Sorting, SortingSuite}

class InsertionSortFnSuite extends SortingSuite {
  override protected def sortMethod: Sorting = new InsertionSortFn()
}
