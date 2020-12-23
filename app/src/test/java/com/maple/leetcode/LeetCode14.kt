package com.maple.leetcode

import org.junit.Test

/**
 * [★]
 * 14. 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 *
 * 示例 2:
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 *
 * 说明:
 * 所有输入只包含小写字母 a-z 。
 *
 * https://leetcode-cn.com/problems/longest-common-prefix/
 *
 * @author : shaoshuai
 * @date ：2020/12/22
 */
class LeetCode14 {

    @Test
    fun runTest() {
        val ret = longestCommonPrefix(arrayOf("flower", "flow", "flight"))
        println("return data: $ret ")
    }

    fun longestCommonPrefix(strs: Array<String>): String {
        if (strs.isEmpty())
            return ""
        if (strs.size == 1)
            return strs[0]
        var result = strs[0]
        for (i in 1 until strs.size) {
            result = subSomeStr(result, strs[i])
        }
        return result
    }

    // 取两个字符串的公共前缀
    fun subSomeStr(str1: String, str2: String): String {
        if (str1.isEmpty() && str2.isEmpty()){
            return ""
        }
        var length = 0
        while (length < str1.length && length < str2.length && str1[length] == str2[length]) {
            length++
        }
        return str1.substring(0, length)
    }

}