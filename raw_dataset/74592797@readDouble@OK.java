double[] readDouble(int size) throws IOException {
    double[] array = new double[size];
    for (int i = 0; i < size; i++) {
        array[i] = nextDouble();
    }
    return array;
}