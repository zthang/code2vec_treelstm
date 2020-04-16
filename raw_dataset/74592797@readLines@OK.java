String[] readLines(int size) throws IOException {
    String[] array = new String[size];
    for (int i = 0; i < size; i++) {
        array[i] = nextLine();
    }
    return array;
}