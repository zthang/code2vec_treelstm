// Find the start and end index of a given t in a sorted(ascending) array; return [-1, -1] is t is not found
private static int[] searchRange(Integer[] a, int t) {
    int first = firstPos(a, t);
    int last = firstPos(a, t + 1) - 1;
    if (first <= last) {
        return new int[] { first, last };
    }
    return new int[] { -1, -1 };
}