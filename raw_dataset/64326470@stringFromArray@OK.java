public static StringBuilder stringFromArray(int[] a) {
    StringBuilder b = new StringBuilder(9 * a.length);
    for (int i = 0; i < a.length; ++i) {
        if (i != 0)
            b = b.append(' ');
        b = b.append(a[i]);
    }
    return b;
}