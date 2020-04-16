static void update(int x, int val, int[] ft) {
    for (int i = x; i < ft.length; i += i & -i) ft[i] += val;
}