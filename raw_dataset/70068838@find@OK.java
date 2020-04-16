int find(int x) {
    if (p[x] == x + 1)
        return x + 1;
    boolean neg = p[x] < 0;
    int next = conv(p[x]);
    int answer = find(next);
    if (neg)
        p[x] = -answer;
    else
        p[x] = answer;
    return p[x];
}