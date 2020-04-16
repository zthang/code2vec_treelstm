public static <T> ArrayList<T> arrayListOfSize(int size, T element) {
    return new ArrayList<>(Collections.nCopies(size, element));
}