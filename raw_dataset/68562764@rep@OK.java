private static int[] rep(int S, int T) {
    if (S >= T)
        return new int[0];
    int[] res = new int[T - S];
    for (int i = S; i < T; ++i) res[i - S] = i;
    return res;
}