public static int findRep(int i) {
    if (parent[i] == i) {
        return i;
    }
    int n = findRep(parent[i]);
    parent[i] = n;
    return n;
}