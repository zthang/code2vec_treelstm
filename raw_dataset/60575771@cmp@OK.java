public static int cmp(Node a, Node b) {
    if (a == inf && b == inf) {
        return 0;
    }
    if (a == inf) {
        return 1;
    }
    if (b == inf) {
        return -1;
    }
    if (a == b) {
        return 0;
    }
    if (a.depth != b.depth) {
        return a.depth - b.depth;
    }
    int step = 19;
    while (step >= 0) {
        if (a.bl[step] == null || a.bl[step] == b.bl[step]) {
        } else {
            a = a.bl[step];
            b = b.bl[step];
        }
        step--;
    }
    return a.c - b.c;
}