public int find(int[] seg, int left, int right, int index, int k) {
    if (left == right) {
        if (seg[index] == 1)
            return left;
        else
            return -1;
    }
    int mid = left + (right - left) / 2;
    if (seg[2 * index + 1] < k)
        return find(seg, mid + 1, right, 2 * index + 2, k - seg[2 * index + 1]);
    else
        return find(seg, left, mid, 2 * index + 1, k);
}