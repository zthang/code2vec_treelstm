public static <T> List<T>[] listArray(int size) {
    List<T>[] result = new List[size];
    for (int i = 0; i < size; i++) {
        result[i] = new ArrayList<>();
    }
    return result;
}