private static void merge(long[] A, long start, long mid, long end) {
    long p = start, q = mid + 1;
    long[] Arr = new long[(int) (end - start + 1)];
    long k = 0;
    for (int i = (int) start; i <= end; i++) {
        if (p > mid)
            Arr[(int) k++] = A[(int) q++];
        else if (q > end)
            Arr[(int) k++] = A[(int) p++];
        else if (A[(int) p] < A[(int) q])
            Arr[(int) k++] = A[(int) p++];
        else
            Arr[(int) k++] = A[(int) q++];
    }
    for (int i = 0; i < k; i++) {
        A[(int) start++] = Arr[i];
    }
}