int rootOf(int i) {
    if (isRoot(i)) {
        return i;
    }
    return a[i] = rootOf(a[i]);
}