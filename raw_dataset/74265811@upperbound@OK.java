static int upperbound(ArrayList<Integer> array, int length, int value) {
    int low = 0;
    int high = length;
    while (low < high) {
        final int mid = (low + high) / 2;
        if (value >= array.get(mid)) {
            low = mid + 1;
        } else {
            high = mid;
        }
    }
    return low;
}