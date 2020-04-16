// returns true if disjoint
public boolean merge(int a, int b) {
    a = find(a);
    b = find(b);
    if (a == b) {
        return false;
    }
    if (size[a] > size[b]) {
        rootPtr[b] = a;
        size[a] += size[b];
    } else {
        rootPtr[a] = b;
        size[b] += size[a];
    }
    return true;
}