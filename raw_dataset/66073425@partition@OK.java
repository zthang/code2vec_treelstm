public static int partition(int[] arr, int s, int e) {
    int index = s;
    int pivot = arr[e];
    for (int i = s; i <= e - 1; i++) {
        if (arr[i] <= pivot) {
            arr = swap(arr, index, i);
            index++;
        }
    }
    swap(arr, index, e);
    print(arr);
    return index;
}