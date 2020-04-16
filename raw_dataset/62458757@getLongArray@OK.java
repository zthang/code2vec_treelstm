public long[] getLongArray(int size) throws Exception {
    long[] ar = new long[size];
    for (int i = 0; i < size; ++i) ar[i] = nextLong();
    return ar;
}