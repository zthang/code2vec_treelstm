int root(int a) {
    while (a != F[a]) {
        F[a] = F[F[a]];
        a = F[a];
    }
    return a;
}