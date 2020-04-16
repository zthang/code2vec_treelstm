public void del(int[] seg, int left, int right, int index, int k) {
    if (left == right) {
        seg[index]--;
        return;
    }
    seg[index]--;
    int mid = left + (right - left) / 2;
    if (k <= mid) {
        del(seg, left, mid, 2 * index + 1, k);
    } else
        del(seg, mid + 1, right, 2 * index + 2, k);
}