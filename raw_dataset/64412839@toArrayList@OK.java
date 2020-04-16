public static <T> ArrayList<T> toArrayList(Spliterator<T> spliterator) {
    long estimatedSize = spliterator.estimateSize();
    if (estimatedSize >= Long.MAX_VALUE || estimatedSize <= 10)
        estimatedSize = 10;
    ArrayList<T> result = new ArrayList<>((int) Math.min(estimatedSize, Integer.MAX_VALUE));
    spliterator.forEachRemaining(result::add);
    return result;
}