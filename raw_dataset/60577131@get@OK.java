Node get(Node cur, int id, int num) {
    int dd = 1;
    int dn = num;
    while (dn > 0) {
        dd *= 10;
        dn /= 10;
    }
    // println(num);
    dd /= 10;
    while (dd > 0) {
        int h = num / dd;
        // println(h + " " + num + " " + dd);
        cur = new Node(cur, h, id);
        num -= h * dd;
        dd /= 10;
    }
    return cur;
}