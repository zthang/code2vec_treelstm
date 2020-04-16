public static int mergeIntoInteger(int[] arr, int[] max) {
    int result = 0;
    for (int i = 0; i < max.length; i++) {
        result *= max[i];
        result += arr[i];
    }
    return result;
}