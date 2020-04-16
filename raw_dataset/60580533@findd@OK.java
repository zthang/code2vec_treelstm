public int findd(int x) {
    if (dSets.get(x).parent == x) {
        return x;
    }
    return dSets.get(x).parent = findd(dSets.get(x).parent);
}