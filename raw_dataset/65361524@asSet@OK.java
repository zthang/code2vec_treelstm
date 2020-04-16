public static <T> Set<T> asSet(Collection<T> uniqueElements) {
    return asModifiableSet(Collections.unmodifiableCollection(uniqueElements));
}