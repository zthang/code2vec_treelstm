public int[] nextIntArray(int arraySize) {
    int[] array = new int[arraySize];
    for (int i = 0; i < arraySize; i++) array[i] = nextInt();
    return array;
}