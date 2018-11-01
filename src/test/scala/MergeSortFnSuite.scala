import common.{Sorting, SortingSuite}

class MergeSortFnSuite extends SortingSuite{
  override protected def sortMethod: Sorting = new MergeSortFn()
}
