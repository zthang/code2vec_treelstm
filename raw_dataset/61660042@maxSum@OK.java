static void maxSum(long[] a) {
    long max_so_far = Long.MIN_VALUE, max_ending_here = 0;
    int start = 0, end = 0, s = 0;
    int size = a.length;
    for (int i = 0; i < size; i++) {
        max_ending_here += a[i];
        if (max_so_far < max_ending_here) {
            max_so_far = max_ending_here;
            start = s;
            end = i;
        }
        if (max_ending_here < 0) {
            max_ending_here = 0;
            s = i + 1;
        }
    }
    if (max_so_far > 0) {
        l = start;
        r = end;
    } else {
        l = -1;
        r = -1;
    }
    sum = max_so_far;
}