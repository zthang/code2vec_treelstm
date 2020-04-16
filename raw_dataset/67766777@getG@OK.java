private List<Integer>[] getG(int N) {
    List<Integer>[] ret = new List[N];
    for (int i = 0; i < N; i++) ret[i] = new ArrayList<Integer>();
    return ret;
}