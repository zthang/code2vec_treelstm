public static void sort(int[] a) {
    Data[] d = new Data[a.length];
    for (int i = 0; i < a.length; i++) {
        d[i] = new Data(a[i], 0, 0);
    }
    Arrays.sort(d);
    for (int i = 0; i < a.length; i++) {
        a[i] = d[i].a;
    }
}