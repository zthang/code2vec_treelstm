private Integer[][] na2(int n, int m) {
    Integer[][] a = new Integer[n][];
    for (int i = 0; i < n; i++) a[i] = na2(m);
    return a;
}