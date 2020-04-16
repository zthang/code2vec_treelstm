static int root(int[] Arr, int i) {
    while (Arr[i] != i) {
        i = Arr[i];
    }
    return i;
}