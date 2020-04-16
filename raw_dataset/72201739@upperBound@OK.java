public static int upperBound(List<Integer> list, int value) {
    int low = 0;
    int high = list.size();
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