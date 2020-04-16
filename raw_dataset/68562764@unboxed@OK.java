private static int[] unboxed(Integer[] A) {
    return stream(A).mapToInt(x -> x).toArray();
}