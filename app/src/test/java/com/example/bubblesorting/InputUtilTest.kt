package com.example.bubblesorting

import com.google.common.truth.Truth.assertThat

import org.junit.Test

class InputUtilTest {


    @Test
    fun `empty input returns false`() {
        val result = InputUtil.validateNumberInput("")

        assertThat(result).isFalse()
    }

    @Test
    fun `input number is not digit returns false`() {
        val result = InputUtil.validateNumberInput("1,2,3,4,5,asd")

        assertThat(result).isFalse()
    }

    @Test
    fun `input number is not between 0 and 9`() {
        val result = InputUtil.validateNumberInput("1,2,3,4,10")

        assertThat(result).isFalse()
    }

    @Test
    fun `input number count is not between 3 and 8`() {
        val result = InputUtil.validateNumberInput("1,2")
        val result2 = InputUtil.validateNumberInput("1,2,1,2,1,2,1,2,3,4")

        assertThat(result).isFalse()
        assertThat(result2).isFalse()
    }

    @Test
    fun `input is not separated by comma`() {
        val result = InputUtil.validateNumberInput("1 2 2 4 65")

        assertThat(result).isFalse()
    }
}