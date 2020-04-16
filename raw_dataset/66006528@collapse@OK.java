private static void collapse(int[] a) {
    for (int i = 0; i < a.length; i++) {
        if (a[i] > -1)
            a[i] = parentOf(a, i);
    }
}