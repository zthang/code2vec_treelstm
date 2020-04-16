private static int findParent(int x) {
    if (x == ss[x].parent) {
        return ss[x].parent;
    } else {
        ss[x].parent = findParent(ss[x].parent);
    }
    return ss[x].parent;
}