int[][] getCycles(int[] f) {
    int n = f.length;
    int[][] ret = new int[n][];
    boolean[] ved = new boolean[n];
    int[] touched = new int[n];
    Arrays.fill(touched, -1);
    int[] path = new int[n];
    int q = 0;
    outer: for (int i = 0; i < n; i++) {
        int p = 0;
        for (int j = i; j != -1; j = f[j]) {
            if (touched[j] != -1) {
                ret[q++] = Arrays.copyOfRange(path, touched[j], p);
                break;
            }
            if (ved[j])
                break;
            touched[j] = p;
            path[p++] = j;
            ved[j] = true;
        }
        for (int k = 0; k < p; k++) {
            touched[path[k]] = -1;
        }
    }
    return Arrays.copyOf(ret, q);
}