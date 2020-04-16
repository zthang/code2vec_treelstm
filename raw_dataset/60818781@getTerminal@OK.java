static long getTerminal(int p, int at) {
    long best = 0;
    for (int i : metaGraph[at]) {
        if (i == p || comeBack[i])
            continue;
        best = Math.max(best, getTerminal(at, i));
    }
    return comeBack[at] ? best : best + metaWeight[at];
}