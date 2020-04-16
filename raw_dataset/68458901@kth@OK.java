int kth(int k) {
    if (k > sum[1]) {
        throw new IndexOutOfBoundsException();
    }
    return kth(1, 0, n - 1, k);
}