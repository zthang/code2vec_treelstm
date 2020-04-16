static int BSL(long[] a, long target, int left, int right, boolean syojun) {
    int lt = left;
    int rt = right - 1;
    while (lt <= rt) {
        long gaze = a[lt + (rt - lt) / 2];
        if ((syojun && gaze <= target) || (!syojun && gaze >= target)) {
            lt = lt + (rt - lt) / 2 + 1;
        } else if ((syojun && gaze > target) || (!syojun && gaze < target)) {
            rt = lt + (rt - lt) / 2 - 1;
        }
    }
    return lt;
}