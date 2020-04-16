static int findNext(int val, boolean[] taken) {
    if (val == taken.length)
        return taken.length;
    if (!taken[val])
        return val;
    if (val == taken.length - 1)
        return taken.length;
    return next[val] = findNext(next[val], taken);
}