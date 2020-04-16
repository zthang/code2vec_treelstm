// Reverse an array
static <T> void reverse(T[] arr, int l, int r) {
    Collections.reverse(Arrays.asList(arr).subList(l, r));
}