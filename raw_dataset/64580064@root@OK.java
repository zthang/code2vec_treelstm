int root(int a) {
    while (F[a] != a) {
        F[a] = F[F[a]];
        a = F[a];
    }
    return a;
}