void update(int i, int val) {
    i++;
    while (i <= n) {
        tree[i] += val;
        i += i & -i;
    }
}