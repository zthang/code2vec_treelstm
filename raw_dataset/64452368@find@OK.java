static int find(Pair[] pr, int i) {
    if (i == pr[i].parent)
        return i;
    else {
        pr[i].parent = find(pr, pr[i].parent);
        return pr[i].parent;
    }
}