public int find(int x) {
    // use for calculating height
    tmph = 0;
    while (prr[x] != x) {
        x = prr[x];
        tmph++;
    }
    return x;
}