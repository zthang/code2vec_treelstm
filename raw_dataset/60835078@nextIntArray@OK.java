public Integer[] nextIntArray(int size) {
    Integer[] array = new Integer[size];
    for (int i = 0; i < size; i++) {
        array[i] = nextInt();
    }
    return array;
}