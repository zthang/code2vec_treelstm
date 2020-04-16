Token append(int v, int id) {
    int l = 0, p = 1;
    for (; p <= v; p *= 10) {
        ++l;
    }
    int nHead, nTail;
    if (len / 9 == (len + l) / 9) {
        nHead = head;
        nTail = tail * p + v;
    } else {
        int ll = (len + l) / 9 * 9;
        nHead = extend(head, tail * p10[ll - len] + v / p10[len + l - ll]);
        nTail = v % p10[len + l - ll];
    }
    return new Token(id, len + l, nHead, nTail, (int) (((long) val * p + v) % MOD));
}