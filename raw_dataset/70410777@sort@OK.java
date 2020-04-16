void sort(int[] a) {
    Random rd = new Random();
    for (int i = 1; i < a.length; ++i) {
        int id = rd.nextInt(i);
        int t = a[id];
        a[id] = a[i];
        a[i] = t;
    }
}