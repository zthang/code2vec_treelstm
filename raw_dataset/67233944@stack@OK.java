private static <T> Queue<T> stack() {
    return Collections.asLifoQueue(new LinkedList<T>());
}