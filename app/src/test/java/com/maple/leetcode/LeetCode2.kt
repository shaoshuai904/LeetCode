package com.maple.leetcode

import org.junit.Test

/**
 * [★★]
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * https://leetcode-cn.com/problems/add-two-numbers/
 *
 * @author maple
 * @time 2020-11-10
 */
class LeetCode2 {

    class ListNode(var `val`: Int, var next: ListNode? = null) {
        override fun toString(): String {
            val sb = StringBuilder()
            var node: ListNode? = this
            while (node != null) {
                sb.append("${node.`val`}   ")
                node = node.next
            }
            return sb.toString()
        }
    }

    @Test
    fun runTest() {
        val list1 = ListNode(2, ListNode(4, ListNode(3)))
        val list2 = ListNode(5, ListNode(6, ListNode(8)))
        val sum = addTwoNumbers(list1, list2)
        println("return data: $sum ")
    }

    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        return dfs(l1, l2, 0)
    }

    fun dfs(l1: ListNode?, l2: ListNode?, i: Int): ListNode? {
        return if (l1 != null || l2 != null || i != 0) {
            val he: Int = (l1?.`val` ?: 0) + (l2?.`val` ?: 0) + i
            ListNode(he % 10).apply {
                next = dfs(l1?.next, l2?.next, he / 10)
            }
        } else null
    }

    fun addTwoNumbers1(l1: ListNode?, l2: ListNode?): ListNode? {
        val root: ListNode? = ListNode(0)
        var curNode = root

        var list1: ListNode? = l1
        var list2: ListNode? = l2
        var carry: Int = 0

        while (list1 != null || list2 != null || carry != 0) {
            val he: Int = (list1?.`val` ?: 0) + (list2?.`val` ?: 0) + carry
            carry = he / 10

            curNode?.next = ListNode(he % 10)
            curNode = curNode?.next

            list1 = list1?.next
            list2 = list2?.next
        }
        return root?.next
    }

}