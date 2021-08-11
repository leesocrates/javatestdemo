package algorightm.sort

/**
 * merge sort （divide and conquer）
 */
class MergeSort {

    fun sort(array: IntArray) {
        for (i in array) {
            print(i)
            print(" ")
        }
        sort(array, 0, array.size - 1)
        println("")
        for (i in array) {
            print(i)
            print(" ")
        }
    }

    private fun sort(array: IntArray, left: Int, right: Int) {
        if (left >= right) return
        val mid = (left + right) / 2
        sort(array, left, mid)
        sort(array, mid + 1, right)
        merge(array, left, mid, right)
    }

    private fun merge(array: IntArray, left: Int, center: Int, right: Int) {
        var low = left
        var high = center+1
        var i = 0
        var temp = IntArray(array.size)
        while (low <= center && high <= right) {
            if (array[low] > array[high]) {
                temp[i++] = array[high++]
            } else {
                temp[i++] = array[low++]
            }
        }
        while (low <= center) {
            temp[i++] = array[low++]
        }
        while (high <= right) {
            temp[i++] = array[high++]
        }
        var j = left
        i = 0
        while (j <= right) {
            array[j++] = temp[i++]
        }
        println("")
        println("temp -- $left  $center $right")
        for (i in temp) {
            print(i)
            print(" ")
        }
        println("\ntemp array")
        for (i in array) {
            print(i)
            print(" ")
        }
    }
}


fun main(args: Array<String>) {

    MergeSort().sort(intArrayOf(3, 9, 2, 29, 4, 8, 10))
}