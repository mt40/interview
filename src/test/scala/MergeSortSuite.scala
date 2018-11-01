import common.{Sorting, SortingSuite}

class MergeSortSuite extends SortingSuite {
  override protected def sortMethod: Sorting = new MergeSort()
}
