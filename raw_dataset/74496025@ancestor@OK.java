protected static int ancestor(int a, int m, int[][] spar) {
    for (int i = 0; m > 0 && a != -1; m >>>= 1, i++) {
        if ((m & 1) == 1)
            a = spar[i][a];
    }
    return a;
}