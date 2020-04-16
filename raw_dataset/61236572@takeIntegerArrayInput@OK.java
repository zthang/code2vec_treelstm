static int[] takeIntegerArrayInput(int no) {
    int[] arr = new int[no];
    for (int i = 0; i < no; ++i) {
        arr[i] = ni();
    }
    return arr;
}