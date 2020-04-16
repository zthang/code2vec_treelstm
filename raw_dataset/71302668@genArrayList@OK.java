public static <E> List<E>[] genArrayList(int size) {
    return Stream.generate(ArrayList::new).limit(size).toArray(List[]::new);
}