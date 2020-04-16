public boolean uniond(int x, int y) {
    int xParent = findd(x);
    int yParent = findd(y);
    if (xParent == yParent) {
        return true;
    }
    if (dSets.get(xParent).size > dSets.get(yParent).size) {
        dSets.get(yParent).parent = xParent;
        dSets.get(xParent).size += dSets.get(yParent).size;
    } else {
        dSets.get(xParent).parent = yParent;
        dSets.get(yParent).size += dSets.get(xParent).size;
    }
    totalDisjointSets--;
    return false;
}