/*
You are given the heads of two sorted linked lists list1 and list2.

Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.

Return the head of the merged linked list.

Example 1:
Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]

Example 2:
Input: list1 = [], list2 = []
Output: []

Example 3:
Input: list1 = [], list2 = [0]
Output: [0]

Constraints:

The number of nodes in both lists is in the range [0, 50].
-100 <= Node.val <= 100
Both list1 and list2 are sorted in non-decreasing order.
*/

class ListNode(_x: Int = 0, _next: ListNode = null) {
  var next: ListNode = _next
  var x: Int = _x
}

object MergeTwoSortedList extends App {
  def mergeTwoLists(list1: ListNode, list2: ListNode): ListNode = {
    val head = new ListNode()
    if (list1 == null) list2
    else if (list2 == null) list1
    else {
      if (list1.x < list2.x) {
        head.x = list1.x
        head.next = mergeTwoLists(list1.next, list2)
      } else {
        head.next = mergeTwoLists(list1, list2.next)
        head.x = list2.x
      }
      head
    }
  }
}
