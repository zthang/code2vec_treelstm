void add(int x, int i) {
    if (i == 0)
        return;
    while (i < val.length) {
        val[i] += x;
        i += i & (-i);
    }
}