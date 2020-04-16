public static int[][] logstepParents(int[] par) {
    int n = par.length;
    int m = Integer.numberOfTrailingZeros(Integer.highestOneBit(n - 1)) + 1;
    int[][] pars = new int[m][n];
    pars[0] = par;
    for (int j = 1; j < m; j++) {
        for (int i = 0; i < n; i++) {
            pars[j][i] = pars[j - 1][i] == -1 ? -1 : pars[j - 1][pars[j - 1][i]];
        }
    }
    return pars;
}