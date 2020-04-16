public <T> T[] nextIntArrayWithFunction(int n, Function<Integer, T> function, Class<T> c) {
    T[] arr = (T[]) Array.newInstance(c, n);
    for (int i = 0; i < n; i++) {
        arr[i] = function.apply(nextInt());
    }
    return arr;
}