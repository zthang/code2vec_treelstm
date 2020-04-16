int[] readInt(int size) throws IOException {
    int[] array = new int[size];
    for (int i = 0; i < size; i++) {
        array[i] = nextInt();
    }
    return array;
}