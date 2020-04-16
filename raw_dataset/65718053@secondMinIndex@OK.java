public static int secondMinIndex(int[] arr) {
    int min = 100000000;
    int minIndex = 100000000;
    int secondMin = 100000000;
    int secondMinIndex = 100000000;
    for (int i = 0; i < arr.length; i++) {
        if (arr[i] < min) {
            secondMin = min;
            secondMinIndex = minIndex;
            min = arr[i];
            minIndex = i;
        } else if (arr[i] < secondMin) {
            secondMin = arr[i];
            secondMinIndex = i;
        }
    }
    return secondMinIndex;
}