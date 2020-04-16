boolean combine(int a, int b) {
    a = findSet(a);
    b = findSet(b);
    if (a == b)
        return true;
    // System.out.println(num+" ppp");
    num--;
    if (size[a] > size[b]) {
        p[b] = a;
        max[a] = Math.max(max[a], max[b]);
        size[a] += size[b];
    } else {
        p[a] = b;
        max[b] = Math.max(max[a], max[b]);
        size[b] += size[a];
    }
    return false;
}