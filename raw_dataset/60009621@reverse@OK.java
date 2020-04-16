public static void reverse(int[] array, int from, int to) {
    if (from == 0 && to == array.length) {
        new IntArray(array).inPlaceReverse();
    } else {
        new IntArray(array).subList(from, to).inPlaceReverse();
    }
}