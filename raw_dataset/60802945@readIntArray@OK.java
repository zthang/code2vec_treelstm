public int[] readIntArray(int size) {
    int[] array = new int[size];
    for (int i = 0; i < size; i++) {
        array[i] = readInt();
    }
    return array;
}