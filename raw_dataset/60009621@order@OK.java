public static int[] order(final int[] array) {
    return sort(createOrder(array.length), (first, second) -> Integer.compare(array[first], array[second]));
}