private static int find(int a, int[] par) {
    if (par[a] == 0) {
        return a;
    }
    return par[a] = find(par[a], par);
}