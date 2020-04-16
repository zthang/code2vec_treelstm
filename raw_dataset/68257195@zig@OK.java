public static void zig(Splay x) {
    Splay y = x.father;
    Splay z = y.father;
    Splay b = x.right;
    y.setLeft(b);
    x.setRight(y);
    z.changeChild(y, x);
    y.pushUp();
}