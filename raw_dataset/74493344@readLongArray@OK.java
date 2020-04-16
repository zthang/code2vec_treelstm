static long[] readLongArray(int size, InputReader in) {
    long[] a = new long[size];
    for (int i = 0; i < size; i++) {
        a[i] = in.nextLong();
    }
    return a;
}