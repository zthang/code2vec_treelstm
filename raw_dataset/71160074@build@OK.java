public int build(int[] seg, int left, int right, int index) {
    if (left == right) {
        seg[index]++;
        return 1;
    }
    int mid = left + (right - left) / 2;
    seg[index] = build(seg, left, mid, 2 * index + 1) + build(seg, mid + 1, right, 2 * index + 2);
    return seg[index];
}