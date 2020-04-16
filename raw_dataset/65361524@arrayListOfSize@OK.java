public static <T> ArrayList<T> arrayListOfSize(int size, T element) {
    ArrayList<T> result = new ArrayList<T>(size);
    for (int i = 0; i < size; i++) {
        result.add(element);
    }
    return result;
}