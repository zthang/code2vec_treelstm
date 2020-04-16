static long[] takeLongArrayInput(int no) {
    long[] arr = new long[no];
    for (int i = 0; i < no; ++i) {
        arr[i] = ni();
    }
    return arr;
}