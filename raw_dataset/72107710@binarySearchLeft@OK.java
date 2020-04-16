static int binarySearchLeft(List<Range> list, int value) {
    int left = 0;
    int right = list.size();
    while (left < right) {
        int mid = left + (right - left) / 2;
        int now = list.get(mid).left;
        if (now > value) {
            right = mid;
        } else {
            left = mid + 1;
        }
    }
    return left;
}