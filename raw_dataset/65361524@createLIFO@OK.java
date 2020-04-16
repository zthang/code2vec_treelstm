public static <T> Queue<T> createLIFO() {
    return Collections.asLifoQueue(new ArrayDeque<>());
}