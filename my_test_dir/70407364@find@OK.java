public boolean find(int i1, int i2) {
    if (i1 == -1 || i2 == -1)
        return false;
    return root(i1) == root(i2);
}