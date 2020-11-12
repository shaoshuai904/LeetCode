package com.maple.leetcode

import org.junit.Test

/**
 * [★]
 * 给定字符串J 代表石头中宝石的类型，和字符串 S代表你拥有的石头。 
 * S 中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。
 * J 中的字母不重复，J 和 S中的所有字符都是字母。
 * 字母区分大小写，因此"a"和"A"是不同类型的石头。
 *
 * 示例:
 * 输入: J = "aA", S = "aAAbbbb"
 * 输出: 3
 *
 * 输入: J = "z", S = "ZZ"
 * 输出: 0
 *
 * https://leetcode-cn.com/problems/jewels-and-stones/
 *
 * @author maple
 * @time 2019-08-18
 */
class UnitTest771 {

    @Test
    fun runTest() {
        val ret = numJewelsInStones("asdf", "asbbbsssb")
        println("return data: $ret ")

    }

    /**
     * J字符串字符在S中出现的次数
     */
    fun numJewelsInStones(J: String, S: String): Int {
        var sum = 0
        for (j in J) {
            for (s in S) {
                if (s == j) sum++
            }
        }
        return sum
    }
}