static long go(int nodeMatched, int haveChildToMatch, int node, int childIndex) {
    if (childIndex == child[node].length) {
        if (nodeMatched == 1 && haveChildToMatch == 0)
            return 0;
        return INF;
    }
    if (dp[nodeMatched][haveChildToMatch][node][childIndex] != -1)
        return dp[nodeMatched][haveChildToMatch][node][childIndex];
    long res = INF;
    Edge e = child[node][childIndex];
    // match self with child
    if (nodeMatched == 0)
        res = min(res, e.c + go(1, haveChildToMatch, node, childIndex + 1) + go(1, 0, e.to, 0));
    // dont match with child
    res = min(res, go(nodeMatched, haveChildToMatch, node, childIndex + 1) + go(0, 0, e.to, 0));
    // match child with stored guy
    if (haveChildToMatch == 1)
        res = min(res, e.c + go(nodeMatched, 0, node, childIndex + 1) + go(1, 0, e.to, 0));
    // store this guy
    if (haveChildToMatch == 0)
        res = min(res, e.c + go(nodeMatched, 1, node, childIndex + 1) + go(1, 0, e.to, 0));
    return dp[nodeMatched][haveChildToMatch][node][childIndex] = res;
}