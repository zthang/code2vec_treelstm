static void reverse(int[] arr) {
    int last = arr.length / 2;
    for (int i = 0; i < last; i++) {
        int tmp = arr[i];
        arr[i] = arr[arr.length - 1 - i];
        arr[arr.length - 1 - i] = tmp;
    }
}