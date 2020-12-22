package com.maple.leetcode

import org.junit.Test

/**
 * [★★]
 * 5. 最长回文子串
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 *
 * 示例 2：
 * 输入: "cbbd"
 * 输出: "bb"
 *
 * https://leetcode-cn.com/problems/longest-palindromic-substring/
 *
 * @author : shaoshuai
 * @date ：2020/12/22
 */
class LeetCode5 {

    @Test
    fun runTest() {
        val test = "abcddeeddfg"
        val sum = longestPalindrome(test)
        println("return data: $sum ")
    }

    fun longestPalindrome(s: String): String {
        if (s.length <= 1)
            return s
        var result = ""
        s.forEachIndexed { index, c ->
            // 奇数：字母对折 aa [b] acdd
            result = fad(s, index - 1, index + 1, result)
            // 偶数：字母中间对折 aa[b] acdd
            result = fad(s, index, index + 1, result)
        }
        return result
    }

    // 指定字符串str，从左右指针开始，向两边拓展对比，查找出最大的回文字符串，并和原始做对比更新
    private fun fad(str: String, left: Int, right: Int, result: String): String {
        var start = left
        var end = right
        while (start >= 0 && end < str.length && str[start] == str[end]) {
            start--
            end++
        }
        if (start + 1 >= 0 && end <= str.length) {
            val ret = str.substring(start + 1, end)
            if (ret.length > result.length) {
                return ret
            }
        }
        return result
    }

}