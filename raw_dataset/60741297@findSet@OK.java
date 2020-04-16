public int findSet(int i) {
    if (p.get(i) == i)
        return i;
    else {
        int ret = findSet(p.get(i));
        p.set(i, ret);
        return ret;
    }
}