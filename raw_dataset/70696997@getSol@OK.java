public static int getSol(int l) {
    int cu = find(lever2node[l][0]);
    int cv = find(lever2node[l][1]);
    if (turned[cu] > turned[cv])
        return pressed[cu];
    else if (turned[cv] > turned[cu])
        return pressed[cv];
    return Math.min(pressed[cu], pressed[cv]);
}