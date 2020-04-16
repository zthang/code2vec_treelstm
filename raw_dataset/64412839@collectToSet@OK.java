public static <T> Collector<T, ?, Set<T>> collectToSet() {
    return Collectors.collectingAndThen(Collectors.toList(), Utils::asSet);
}