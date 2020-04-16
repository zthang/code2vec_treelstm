int cmp(int n1, int n2) {
    if (curH[n1] != curH[n2]) {
        return Integer.compare(curH[n1], curH[n2]);
    }
    return lca(n1, n2);
}