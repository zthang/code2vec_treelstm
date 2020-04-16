private List<Integer>[] getG(int N, int M) {
    List<Integer>[] ret = new List[N];
    for (int i = 0; i < N; i++) ret[i] = new ArrayList<Integer>();
    for (int i = 0; i < M; i++) {
        int u = ni() - 1;
        int v = ni() - 1;
        ret[u].add(v);
    }
    return ret;
}