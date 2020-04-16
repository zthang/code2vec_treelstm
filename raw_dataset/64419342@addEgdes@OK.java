void addEgdes(int[] a, int[] b) {
    for (int i = 0; i < a.length; i++) {
        list[a[i]].add(new Edge(b[i], 1));
    }
}