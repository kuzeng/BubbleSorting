package com.example.bubblesorting

object BubbleSortUtil {
    fun bubbleSort(arr: IntArray): IntArray {
        val n = arr.size

        // Traverse through all array elements
        for (i in 0 until n) {
            // Last i elements are already in place
            for (j in n - 1 downTo i + 1) {
                // Traverse the array from n-1 to i+1
                // Swap if the element found is greater
                // than the previous element
                if (arr[j] < arr[j - 1]) {
                    // Print the current step of swapping
                    println("Swapping ${arr[j]} and ${arr[j - 1]}")

                    // Swap the elements
                    val temp = arr[j]
                    arr[j] = arr[j - 1]
                    arr[j - 1] = temp

                    // Print the current array
                    println("Current array: ${arr.joinToString()}")
                }
            }
        }

        return arr
    }

    fun buildBubbleSortStringArray(arr: IntArray): List<String> {
        val n = arr.size
        val steps: MutableList<String> = mutableListOf()
        var currentArrayString = ""

        // Traverse through all array elements
        for (i in 0 until n) {
            // Last i elements are already in place
            for (j in n - 1 downTo i + 1) {
                // Traverse the array from n-1 to i+1
                // Swap if the element found is greater
                // than the previous element
                currentArrayString = ""

                if (arr[j] < arr[j - 1]) {
                    currentArrayString = arr.joinToString() + " [if ${arr[j]} < ${arr[j - 1]} then swap]"
                    // Swap the elements
                    val temp = arr[j]
                    arr[j] = arr[j - 1]
                    arr[j - 1] = temp
                } else {
                    currentArrayString = arr.joinToString() + " [if ${arr[j]} > ${arr[j - 1]} then don't swap]"
                }
                // Capture the current array as a string
                steps.add(currentArrayString)
            }

            if (i == n - 1) {
                currentArrayString = arr.joinToString() + " [Sorted Array]"
                steps.add(currentArrayString)
            } else {
                currentArrayString = arr.joinToString()
                steps.add(currentArrayString)
                if (i == 0) {
                    currentArrayString = "1st sorting iteration is ended"
                } else if (i == 1) {
                    currentArrayString = "2nd sorting iteration is ended"
                } else if (i == 2) {
                    currentArrayString = "3rd sorting iteration is ended"
                } else {
                    currentArrayString = "${i + 1}th sorting iteration is ended"
                }

                steps.add(currentArrayString)
                steps.add("")
            }
        }

        return steps
    }
}