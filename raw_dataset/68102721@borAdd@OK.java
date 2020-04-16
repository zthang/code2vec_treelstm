void borAdd(char[] s) {
    int v = borRoot;
    for (char c : s) {
        if (borNext[c - '0'][v] == 0)
            borNext[c - '0'][v] = cnt++;
        v = borNext[c - '0'][v];
    }
    borCnt[v] = testId;
}