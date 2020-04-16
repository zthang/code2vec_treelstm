private static void merge(long[] arr, int start, int mid, int end) {
    int i, j = mid + 1, c = 0;
    long[] temp = new long[end - start + 1];
    for (i = start; i <= mid && j <= end; c++) {
        if (arr[i] <= arr[j]) {
            temp[c] = arr[i];
            i++;
        } else {
            temp[c] = arr[j];
            j++;
        }
    }
    while (i <= mid) {
        temp[c] = arr[i];
        i++;
        c++;
    }
    while (j <= end) {
        temp[c] = arr[j];
        j++;
        c++;
    }
    c = 0;
    for (i = start; i <= end; i++, c++) arr[i] = temp[c];
}