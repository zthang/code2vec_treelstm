public static <T> Pair<Integer, T>[] getSortedIndices(List<T> list, Comparator<? super T> comp) {
    Pair<Integer, T>[] result = new Pair[list.size()];
    for (int i = 0; i < result.length; i++) {
        result[i] = new Pair<>(i, list.get(i));
    }
    if (comp != null) {
        ArrayUtils.sort(result, (a, b) -> comp.compare(a.getValue(), b.getValue()));
    } else {
        ArrayUtils.sort(result, (a, b) -> ((Comparable<T>) a.getValue()).compareTo(b.getValue()));
    }
    return result;
}