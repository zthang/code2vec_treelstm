public boolean sameParent(int x, int y, int[] parent) {
    return getParent(x, parent) == getParent(y, parent);
}