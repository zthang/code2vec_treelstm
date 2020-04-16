public static void reverse(int[] array, int from, int end) {
    while (from < end) {
        swap(array, from, end);
        ++from;
        --end;
    }
}