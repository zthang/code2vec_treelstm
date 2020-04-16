public boolean areConnected(int x, int y) {
    gctCon++;
    if (x == y)
        return true;
    if (lvs[0].forest[x] == null)
        return false;
    if (lvs[0].forest[y] == null)
        return false;
    Node anyx = lvs[0].forest[x];
    Node anyy = lvs[0].forest[y];
    return root(anyx) == root(anyy);
}