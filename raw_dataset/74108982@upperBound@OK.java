public static int upperBound(ArrayList<Long> list, int length, long value) {
    int low = 0;
    int high = length;
    while (low < high) {
        final int mid = (low + high) / 2;
        if (value >= list.get(mid)) {
            low = mid + 1;
        } else {
            high = mid;
        }
    }
    return low;
}