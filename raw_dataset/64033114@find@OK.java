static int find(int a, int[] par) {
    if (par[a] == 0) {
        return a;
    }
    int root = find(par[a], par);
    return par[a] = root;
}