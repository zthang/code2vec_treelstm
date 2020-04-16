boolean union(int a, int b, boolean same) {
    // out.println("I " + a + " " +b);
    int aa = find(a);
    int bb = find(b);
    // out.println("I " + aa + " " + bb);
    if (!same)
        aa = -aa;
    if (aa < 0) {
        aa = -aa;
        bb = -bb;
    }
    // out.println("I " + aa + " " + bb);
    if (aa == bb)
        return false;
    same = (bb > 0);
    // out.println("Same " + same);
    a = conv(aa);
    b = conv(bb);
    if (r[a] > r[b]) {
        if (same)
            p[b] = aa;
        else
            p[b] = -aa;
        if (!same) {
            s1[a] += s2[b];
            s2[a] += s1[b];
        } else {
            s2[a] += s2[b];
            s1[a] += s1[b];
        }
    } else {
        p[a] = bb;
        if (!same) {
            s1[b] += s2[a];
            s2[b] += s1[a];
        } else {
            s2[b] += s2[a];
            s1[b] += s1[a];
        }
        if (r[b] == r[a])
            r[b]++;
    }
    return true;
}