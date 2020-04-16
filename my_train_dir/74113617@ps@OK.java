int[] ps(int[] a) {
    int[] ps = new int[a.length];
    ps[0] = a[0];
    for (int i = 1; i < a.length; i++) ps[i] = ps[i - 1] + a[i];
    return ps;
}