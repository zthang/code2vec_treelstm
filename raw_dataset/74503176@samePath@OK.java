private static boolean samePath(int a, int b) {
    return in[a] <= in[b] && outTime[b] <= outTime[a];
}