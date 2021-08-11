package algorightm.heap;

import java.util.Arrays;

public class BinaryHeap {
    /**
     * 上浮
     * @param array 数据数组
     */
    public static void upAdjust(int index, int[] array) {
        // 先求出父子节点的下标
        int childrenIndex = index;
        int parentIndex = (childrenIndex - 1) / 2;
        // 记录子节点数据，用于最后赋值
        int temp = array[childrenIndex];
        // 开始上浮
        while (childrenIndex > 0 && temp > array[parentIndex]) {
            System.out.println("childrenIndex is "+childrenIndex+" value is : "+array[childrenIndex]+" ; parentIndex is "+parentIndex+ " value is "+array[parentIndex]);
            // 直接单向赋值，无需做交换操作
            array[childrenIndex] = array[parentIndex];
            // 更新父子节点下标的值，下面两句代码顺序不可相反
            childrenIndex = parentIndex;
            parentIndex = (parentIndex - 1) / 2;
            System.out.println("array = " + Arrays.toString(array));
        }
        // 最后赋值
        array[childrenIndex] = temp;
        System.out.println("array = " + Arrays.toString(array));
    }

    /**
     * 下沉节点
     * @param index 要下浮的节点的下标
     * @param array 数据数组
     */
    public static void downAdjust(int index, int[] array) {
        // 先记录父节点及左子节点的下标
        int parentIndex = index;
        int childrenIndex = 2 * parentIndex + 1;
        // 记录父节点的值，用于最后赋值
        int temp = array[parentIndex];
        // 若有左子节点则继续
        while (childrenIndex <= array.length - 1) {
            // 若有右子节点，且右子节点比左子节点大，则将 childrenIndex 记录为右子节点的下标
            if (childrenIndex + 1 <= array.length - 1 && array[childrenIndex + 1] > array[childrenIndex]) {
                childrenIndex++;
            }
            // 如果子节点大于父节点，则无需下沉，直接返回
            if (temp >= array[childrenIndex]) {
                break;
            }
            // 直接单向赋值，无需做交替操作
            array[parentIndex] = array[childrenIndex];
            // 更新父子节点下标的值，下面两句代码顺序不可相反
            parentIndex = childrenIndex;
            childrenIndex = 2 * childrenIndex + 1;
        }
        // 最后赋值
        array[parentIndex] = temp;
    }

    /**
     * 构建二叉堆
     * @param array 数据数组
     */
    public static void  buildBinaryHeap(int[] array) {
        for (int i = (array.length/2)-1; i >= 0; i--) {
            downAdjust(i, array);
        }
    }

    public static void main(String[] args) {
        // 构建二叉堆
        int[] arr01 = {5, 9, 8, 6, 7, 3};
        buildBinaryHeap(arr01);
        System.out.println("buildBinaryHeap: "+Arrays.toString(arr01));
        // 添加一个数据，测试上浮操作
        int[] arr02 = {9, 6, 6, 6, 2, 3, 5,4,7, 3, 8,20};
        for(int i2 = arr02.length-1; i2>(arr02.length-1)/2; i2--){
            upAdjust(i2, arr02);
        }

        System.out.println("upAdjust: "+Arrays.toString(arr02));
        // 删除一个数据，册数下沉操作
        int[] arr03 = {3, 8, 7, 4, 6, 6, 6, 2, 3, 5};
        downAdjust(0, arr03);
        System.out.println("downAdjust: "+Arrays.toString(arr03));
    }
}