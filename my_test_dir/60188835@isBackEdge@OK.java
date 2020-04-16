public static boolean isBackEdge(int v, int a) {
    // a is a parent of v
    return firstTime[a] < firstTime[v];
}