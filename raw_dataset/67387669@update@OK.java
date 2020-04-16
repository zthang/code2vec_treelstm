static void update(int index, int val) {
    for (int i = index; i <= 2 * n; i += i & -i) BIT[i] += val;
}