public void union(int a, int b) {
    int ra = getSet(a);
    int rb = getSet(b);
    if (ra == rb)
        return;
    if (r[ra] == r[rb]) {
        p[ra] = rb;
        r[rb]++;
        max[rb] = Math.max(max[ra], max[rb]);
        return;
    }
    if (r[ra] > r[rb]) {
        p[rb] = ra;
        max[ra] = Math.max(max[ra], max[rb]);
    } else {
        p[ra] = rb;
        max[rb] = Math.max(max[ra], max[rb]);
    }
}