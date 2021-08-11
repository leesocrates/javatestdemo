package test


fun main(args: Array<String>){
    val arr = arrayOf(1, 2, 3)
    val intArr: IntArray = intArrayOf(1,2,3)
    val longArr: LongArray = longArrayOf(1L,2L,3L)
    val floatArr: FloatArray = floatArrayOf(1.0f,2.0f,3.0f)
    val doubleArr: DoubleArray = doubleArrayOf(1.0,2.02,3.03333)
    val booleanArr: BooleanArray = booleanArrayOf(false,true,false)

    val fixedSizeArr = arrayOfNulls<Int>(6)
    val empty = emptyArray<Int>()

    for (index in intArr.indices){
        intArr[index] = 0 //与java一样，可以这样修改数据
        intArr.set(index,1) //kotlin可以通过set函数进行修改数据
    }
    array2d()
}

fun array2d(){
    //基本类型的二维数组
    val arr = Array(3){IntArray(3)}//三个长度为3的Int数组的二维数组

    for (one in arr){
        println()
        for (two in one){
            print(two)
        }
    }

    //三个长度为3的Demo类型的二维数组，自定义类型的话需要在大括号里面操作
    val arrClass = Array(3){Array<Demo>(3,{i: Int -> Demo(i) })}
    for (demos in arrClass){
        println()
        for (demo in demos){
            print("demo num : ${demo.mNum}  ")
        }
    }

    // 多维
    val arrB = Array(3){Array(3){IntArray(3)}}
    for (one in arrB) {
        println()
        for (two in one)
            for (three in two)
                print(three)
    }
}

class Demo(num: Int){
    var mNum: Int? = null
    init {
        this.mNum = num
    }
}