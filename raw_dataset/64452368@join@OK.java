static void join(Pair[] pr, int i, int j) {
    i = find(pr, i);
    j = find(pr, j);
    if (i == j)
        return;
    if (pr[i].rank >= pr[j].rank) {
        pr[j].parent = i;
        pr[i].rank += pr[j].rank;
    } else {
        pr[i].parent = j;
        pr[j].rank += pr[i].rank;
    }
}