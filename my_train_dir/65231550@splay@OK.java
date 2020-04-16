public static void splay(DynamicMST.LCTNode x) {
    if (x == NIL) {
        return;
    }
    DynamicMST.LCTNode y, z;
    while ((y = x.father) != NIL) {
        if ((z = y.father) == NIL) {
            y.pushDown();
            x.pushDown();
            if (x == y.left) {
                zig(x);
            } else {
                zag(x);
            }
        } else {
            z.pushDown();
            y.pushDown();
            x.pushDown();
            if (x == y.left) {
                if (y == z.left) {
                    zig(y);
                    zig(x);
                } else {
                    zig(x);
                    zag(x);
                }
            } else {
                if (y == z.left) {
                    zag(x);
                    zig(x);
                } else {
                    zag(y);
                    zag(x);
                }
            }
        }
    }
    x.pushDown();
    x.pushUp();
}