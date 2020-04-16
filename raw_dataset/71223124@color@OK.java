public long color(long[] c1, long[] c2, long[] c3, int p1, int p2, int index, int[] ans) {
    int a = 3 - (p1 + p2) % 3;
    ans[index] = a;
    if (a == 1)
        return c1[index];
    if (a == 2)
        return c2[index];
    return c3[index];
}