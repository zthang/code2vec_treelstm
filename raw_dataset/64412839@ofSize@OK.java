public static DoubleArrayList ofSize(int size, double element) {
    DoubleArrayList result = new DoubleArrayList(size);
    result.length = size;
    for (int i = 0; i < element; i++) {
        result.arr[i] = element;
    }
    return result;
}