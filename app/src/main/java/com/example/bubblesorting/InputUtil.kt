package com.example.bubblesorting

object InputUtil {

    /**
     *  the input is not valid if ...
     *  ..the input is empty
     *  .. The maximum input is larger than size = 8
     *  .. The minimum input is smaller than  size = 3
     *  .. The input item is not integer
     *  .. The input is not separated by comma
     *  .. The max input number is not between 0 and 9
     */
    fun validateNumberInput(input: String): Boolean {
        if (input.isEmpty()) return false

        val numbers = input.split(",")

        if (numbers.count() < 3 || numbers.count() > 8) return false

        for (number in numbers) {
            val parsedInt = number.toIntOrNull()
            if (parsedInt != null) {
                if (parsedInt < 0 || parsedInt > 9) return false
            } else {
                return false
            }
        }

        return true
    }
}