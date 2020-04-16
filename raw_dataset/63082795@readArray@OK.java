long[] readArray(int size_) {
    long[] ar = new long[size_];
    for (int i = 0; i < size_; i++) {
        ar[i] = in.nextLong();
    }
    return ar;
}