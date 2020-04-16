void addWeighterEdges(int[] a, int[] b, int[] c) {
    for (int i = 0; i < a.length; i++) {
        list[a[i]].add(new Edge(b[i], c[i]));
    }
}