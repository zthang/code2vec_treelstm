boolean sameSet(int a, int b) {
    a = findSet(a);
    b = findSet(b);
    if (a == b)
        return true;
    return false;
}