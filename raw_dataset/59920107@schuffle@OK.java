public static int[] schuffle(int[] a) {
    for (int i = 0; i < a.length; i++) {
        int x = (int) (Math.random() * a.length);
        int temp = a[x];
        a[x] = a[i];
        a[i] = temp;
    }
    return a;
}