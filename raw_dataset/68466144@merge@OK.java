public static D merge(D t1, D t2) {
    if (t1 == null) {
        return t2;
    }
    if (t2 == null) {
        return t1;
    }
    if (t1.y > t2.y) {
        t1.c += t2.c;
        t1.right = merge(t1.right, t2);
        return t1;
    } else {
        t2.c += t1.c;
        t2.left = merge(t1, t2.left);
        return t2;
    }
}