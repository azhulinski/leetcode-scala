import scala.annotation.tailrec

/*
Given the root of a binary tree, return the inorder traversal of its nodes' values.

Example 1:
Input: root = [1,null,2,3]
Output: [1,3,2]

Example 2:
Input: root = [1,2,3,4,5,null,8,null,null,6,7,9]
Output: [4,2,6,5,7,1,3,9,8]

Example 3:
Input: root = []
Output: []

Example 4:
Input: root = [1]
Output: [1]

Constraints:

The number of nodes in the tree is in the range [0, 100].
-100 <= Node.val <= 100
*/

class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
  var value: Int = _value
  var left: TreeNode = _left
  var right: TreeNode = _right
}

object BinaryTreeInorderTraversal extends App {

  def inorderTraversal(root: TreeNode): List[Int] = {
    if (root == null) return Nil

    @tailrec
    def enstack(root: TreeNode, stack: List[TreeNode]): List[TreeNode] =
      if (root == null) stack
      else enstack(root.left, root :: stack)

    @tailrec
    def inorderTraversal(stack: List[TreeNode], result: List[Int]): List[Int] = {
      stack match {
        case ::(head, tail) =>
          inorderTraversal(enstack(head.right, tail), head.value :: result)
        case _ => result.reverse
      }
    }

    inorderTraversal(enstack(root, Nil), Nil)
  }

}
