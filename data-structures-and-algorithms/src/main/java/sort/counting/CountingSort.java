package sort.counting;

/**
 * <pre>
 * counting sort。
 * </pre>
 *
 * @author Yishen 844147804@qq.com
 * @version 1.00.00
 */
public class CountingSort {
    public static void countingSort(int[] array, int length, int max, int min) {
        if (array == null || length <= 1) {
            return;
        }
        int countArrayLength = max - min + 1;
        int[] countArray = new int[countArrayLength];
        for (int i = 0; i < length; i++) {
            countArray[array[i] - min]++;
        }
        for (int i = 1; i < countArrayLength; i++) {
            countArray[i] += countArray[i - 1];
        }
        int[] temp = new int[length];
        // 注意,这里只能由后往前遍历数组array,不然该排序就不是稳定排序了
        for (int i = length - 1; i >= 0; i--) {
            int countIdx = array[i] - min;
            int tempIdx = --countArray[countIdx];
            temp[tempIdx] = array[i];
        }
        for (int i = 0; i < length; i++) {
            array[i] = temp[i];
        }
    }
}
