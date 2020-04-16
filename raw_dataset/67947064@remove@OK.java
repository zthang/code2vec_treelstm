public void remove(int l, int r) {
    if (l > r) {
        return;
    }
    checkRange(l);
    checkRange(r);
    if (r == size - 1) {
        size = l;
        return;
    } else {
        System.arraycopy(data, r + 1, data, l, size - (r + 1));
        size -= (r - l + 1);
    }
}