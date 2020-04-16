public static int lowerBound(ArrayList<Long> list, int length, long value) {
    int low = 0;
    int high = length;
    while (low < high) {
        final int mid = (low + high) / 2;
        if (value <= list.get(mid)) {
            high = mid;
        } else {
            low = mid + 1;
        }
    }
    return low;
}