void setCons(int[] ar) {
    con = ar;
    whichCon = new int[n];
    minCon = new int[n];
    maxCon = new int[n];
    for (int i = 0; i < ar.length; i++) whichCon[ar[i]] = i;
    setminmax(0);
    L = new int[n][ar.length];
    G = new int[n][ar.length];
    makeLR(0);
    numEdges = new int[n];
    indexInP = new int[n];
    sort(0);
    cumsum = new int[n][];
    getsums(0);
}