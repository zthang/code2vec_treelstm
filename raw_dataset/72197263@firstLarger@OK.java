public static int firstLarger(int val, ArrayList<Integer> ok, int left, int right) {
    if (ok.get(right) <= val) {
        return -1;
    }
    if (left == right) {
        return left;
    } else if (left + 1 == right) {
        if (val < ok.get(left)) {
            return left;
        } else {
            return right;
        }
    } else {
        int mid = (left + right) / 2;
        if (ok.get(mid) > val) {
            return firstLarger(val, ok, left, mid);
        } else {
            return firstLarger(val, ok, mid + 1, right);
        }
    }
}