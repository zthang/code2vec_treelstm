public long[] nextLongArray(int arraySize) {
    long[] array = new long[arraySize];
    for (int i = 0; i < arraySize; i++) array[i] = nextLong();
    return array;
}