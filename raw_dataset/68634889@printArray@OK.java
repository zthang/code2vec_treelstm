void printArray(long[] a, int from) {
    int l = a.length;
    for (int i = from; i < l; ++i) {
        print(a[i]);
        if (i != l - 1) {
            print(" ");
        }
    }
    println();
}