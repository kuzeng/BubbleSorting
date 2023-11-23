package com.example.bubblesorting

import com.google.common.truth.Truth.assertThat
import org.junit.Test


class BubbleSortUtilTest {
    @Test
    fun `small array returns sorted array`() {
        val testNumbers = intArrayOf(2, 3, 2, 8)

        val result = BubbleSortUtil.bubbleSort(testNumbers)
        val expectedResult = intArrayOf(2, 2, 3, 8)

        assertThat(result).isEqualTo(expectedResult)
    }

    @Test
    fun `large array returns sorted array`() {
        val testNumbers = intArrayOf(64, 34, 25, 12, 22, 11, 90)

        val result = BubbleSortUtil.bubbleSort(testNumbers)
        val expectedResult = intArrayOf(11, 12, 22, 25, 34, 64, 90)

        assertThat(result).isEqualTo(expectedResult)
    }

    @Test
    fun `example array returns sorted array`() {
        val testNumbers = intArrayOf(9, 8, 3, 2, 4, 6, 1)

        val result = BubbleSortUtil.bubbleSort(testNumbers)
        val expectedResult = intArrayOf(1, 2, 3, 4, 6, 8, 9)

        assertThat(result).isEqualTo(expectedResult)
    }

    @Test
    fun `empty array returns empty array`() {
        val testNumbers = intArrayOf()

        val result = BubbleSortUtil.bubbleSort(testNumbers)

        assertThat(result).isEmpty()
    }
}