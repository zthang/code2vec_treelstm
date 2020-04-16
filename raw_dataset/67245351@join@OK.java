boolean join(int i1, int i2) {
    int p1 = getParent(i1);
    int p2 = getParent(i2);
    if (p1 == p2)
        return false;
    parent[p1] = p2;
    return true;
}