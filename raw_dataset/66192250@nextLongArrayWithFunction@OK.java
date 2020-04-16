public <T> T[] nextLongArrayWithFunction(int n, Function<Long, T> function, Class<T> c) {
    T[] arr = (T[]) Array.newInstance(c, n);
    for (int i = 0; i < n; i++) {
        arr[i] = function.apply(nextLong());
    }
    return arr;
}