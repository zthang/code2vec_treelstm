static <T> ArrayDeque<T>[] genDQ(int n) {
    ArrayDeque<T>[] list = new ArrayDeque[n];
    for (int i = 0; i < n; i++) list[i] = new ArrayDeque<T>();
    return list;
}