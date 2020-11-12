package com.maple.leetcode

import org.junit.Test
import java.util.*
import kotlin.Comparator

/**
 * [★★]
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 *
 * 示例:
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 *
 * 输入: nums = [1], k = 1
 * 输出: [1]
 *
 * https://leetcode-cn.com/problems/top-k-frequent-elements/
 *
 * @author maple
 * @time 2019-08-18
 */
class UnitTest347 {

    @Test
    fun runTest() {
        val ret = topKFrequent(intArrayOf(1, 2, 3, 1, 41, 2, 2, 31), 2)
        println("return data: $ret ")
    }

    /**
     * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
     */
    private fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val map = hashMapOf<Int, Int>()
        for (num in nums) {
            val size = map.getOrDefault(num, 0)
            map[num] = size + 1
        }

        // 遍历map，用最小堆保存频率最大的k个元素
        val pq = PriorityQueue<Int>(Comparator { o1, o2 -> map[o1]!!.compareTo(map[o2]!!) })
        for (key in map.keys) {
            if (pq.size < k) {
                pq.add(key)
            } else if (map[key]!! > map[pq.peek()]!!) {
                pq.remove()
                pq.add(key)
            }
        }
        // 取出最小堆中的元素
        val ret = arrayListOf<Int>()
        while (pq.isNotEmpty()) {
            ret.add(pq.remove())
        }
        return ret.toIntArray()
    }

}