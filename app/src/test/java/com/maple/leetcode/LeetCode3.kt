package com.maple.leetcode

import org.junit.Test

/**
 * [★★]
 * 3. 无重复字符的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * 示例 2:
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 *
 * 示例 3:
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 * 示例 4:
 * 输入: s = ""
 * 输出: 0
 * 提示：
 * 0 <= s.length <= 5 * 104
 * s 由英文字母、数字、符号和空格组成
 *
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 *
 * @author : shaoshuai
 * @date ：2020/12/17
 */
class LeetCode3 {


    @Test
    fun runTest() {
        val test = "bpfbhmipx"
        val sum = lengthOfLongestSubstring(test)
        println("return data: $sum ")
        val sum2 = lengthOfLongestSubstring2(test)
        println("return data: $sum2 ")
    }


    fun lengthOfLongestSubstring(s: String): Int {
        if (s.length == 1) return 1
        var maxSize = 0
        var start = 0
        val map = hashMapOf<Char, Int>()
        s.forEachIndexed { index, char ->
            val find = map[char]
            if (find != null) {
                for (i in start..find) {
                    map.remove(s[i])
                }
                start = find + 1
            }
            map[char] = index
            maxSize = Math.max(maxSize, map.size)
        }
        return maxSize
    }

    // 窗口移动法
    fun lengthOfLongestSubstring2(s: String): Int {
        var maxSize = 0
        val set = hashSetOf<Char>()
        var rp = 0
        s.forEachIndexed { index, char ->
            if (index != 0) {
                set.remove(s[index - 1])
            }
            while (rp < s.length && !set.contains(s[rp])) {
                set.add(s[rp])
                rp++
            }
            maxSize = Math.max(maxSize, rp - index)
        }
        return maxSize
    }

}