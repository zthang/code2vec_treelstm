static void reverse(char[] arr, int i, int j) {
    if (i == j)
        return;
    while (i < j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        ++i;
        --j;
    }
}