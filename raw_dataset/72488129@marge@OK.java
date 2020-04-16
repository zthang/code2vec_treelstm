boolean marge(int i, int j) {
    if (ud(i, j)) {
        return false;
    }
    i = rootOf(i);
    j = rootOf(j);
    a[Integer.max(i, j)] = Integer.min(i, j);
    size[j] = size[i] = size[i] + size[j];
    forest -= 1;
    return true;
}