private boolean join(int a, int b) {
    int x = root(a), y = root(b);
    if (x != y) {
        if (size[x] < size[y])
            y = x ^ y ^ (x = y);
        root[y] = x;
        size[x] += size[y];
        return true;
    }
    return false;
}