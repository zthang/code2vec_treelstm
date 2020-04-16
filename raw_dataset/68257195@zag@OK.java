public static void zag(Splay x) {
    Splay y = x.father;
    Splay z = y.father;
    Splay b = x.left;
    y.setRight(b);
    x.setLeft(y);
    z.changeChild(y, x);
    y.pushUp();
}