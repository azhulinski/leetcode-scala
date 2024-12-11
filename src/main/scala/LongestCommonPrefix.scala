import scala.Function.tupled

/*
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

Example 1:

Input: strs = ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.

Constraints:

1 <= strs.length <= 200
0 <= strs[i].length <= 200
strs[i] consists of only lowercase English letters.
*/
object LongestCommonPrefix extends App {
  def longestCommonPrefix(strs: Array[String]): String = {
    if (strs.isEmpty) ""
    else if (strs.length == 1) strs.head
    else {
      commonPrefix(strs.head, longestCommonPrefix(strs.slice(1, strs.length)))
    }
  }

  def commonPrefix(source: String, check: String): String = {
    source.zip(check).takeWhile { case (a, b) => a == b }.map(_._1).mkString
  }
}
