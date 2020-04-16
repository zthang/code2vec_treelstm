long[] readLong(int size) throws IOException {
    long[] array = new long[size];
    for (int i = 0; i < size; i++) {
        array[i] = nextLong();
    }
    return array;
}