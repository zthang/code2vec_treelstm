boolean borFind(char[] s) {
    int v = borRoot;
    for (char c : s) {
        if (borNext[c - '0'][v] == 0)
            return false;
        v = borNext[c - '0'][v];
    }
    return borCnt[v] == testId;
}