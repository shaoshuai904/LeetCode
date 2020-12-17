package com.maple.leetcode

import org.junit.Test

/**
 * [★★]
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target。该矩阵具有以下特性：
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 *
 * 示例：
 * 现有矩阵 matrix 如下：
 *  [
 *      [1,   4,  7, 11, 15],
 *      [2,   5,  8, 12, 19],
 *      [3,   6,  9, 16, 22],
 *      [10, 13, 14, 17, 24],
 *      [18, 21, 23, 26, 30]
 *  ]
 * 给定 target = 5，返回 true。
 * 给定 target = 20，返回 false。
 *
 * https://leetcode-cn.com/problems/search-a-2d-matrix-ii/
 *
 * @author maple
 * @time 2020-11-12
 */
class LeetCode240 {

    @Test
    fun runTest() {
//        val aaa = arrayOf(
//                intArrayOf(1, 4, 6, 11, 15),
//                intArrayOf(2, 5, 7, 17, 21),
//                intArrayOf(3, 7, 9, 31, 61),
//                intArrayOf(7, 9, 40, 43, 76)
//        )
        val aaa = arrayOf(
                intArrayOf(5, 6, 9),
                intArrayOf(9, 10, 11),
                intArrayOf(11, 14, 18)
        )
        val bbb = searchMatrix(aaa, 9)

        println("return data:  $bbb ")
    }

    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        if (matrix.isEmpty() || matrix[0].isEmpty() ||
                target < matrix[0][0] || target > matrix[matrix.size - 1][matrix[0].size - 1]) {
            return false
        }
        if (target == matrix[0][0] || target == matrix[matrix.size - 1][matrix[0].size - 1]) {
            return true
        }
        return dfs(matrix, target, 0, matrix.size - 1, 0, matrix[0].lastIndex)
    }


    fun dfs(matrix: Array<IntArray>, target: Int, minLine: Int, maxLine: Int, minIndex: Int, maxIndex: Int): Boolean {
        var newMinIndex = minIndex
        var newMaxIndex = maxIndex
        var newMinLine = minLine
        var newMaxLine = maxLine
        // 竖直方向 缩减范围
        if (minIndex < newMaxIndex) {
            while (matrix[newMaxLine][newMinIndex] <= target) {
                if (matrix[newMaxLine][newMinIndex] == target)
                    return true
                newMinIndex++
            }
            while (matrix[newMinLine][newMaxIndex] >= target) {
                if (matrix[newMinLine][newMaxIndex] == target)
                    return true
                newMaxIndex--
                if (newMaxIndex < newMinIndex)
                    return false
            }
        }
        // 水平方向 缩减范围
        if (newMinLine < newMaxLine) {
            while (matrix[newMinLine][newMaxIndex] <= target) {
                if (matrix[newMinLine][newMaxIndex] == target)
                    return true
                newMinLine++
            }
            while (matrix[newMaxLine][newMinIndex] >= target) {
                if (matrix[newMaxLine][newMinIndex] == target)
                    return true
                newMaxLine--
                if (newMaxLine < newMinLine)
                    return false
            }
        }
        if (newMinIndex == newMaxIndex && newMinLine == newMaxLine) {
            return matrix[newMinLine][newMinIndex] == target
        }
        return dfs(matrix, target, newMinLine, newMaxLine, newMinIndex, newMaxIndex)
    }


}