static int[] int_arr() throws IOException {
    String[] a = read().split(" ");
    int[] b = new int[a.length];
    for (int i = 0; i < a.length; i++) {
        b[i] = int_v(a[i]);
    }
    return b;
}