public boolean equals(Object o) {
    triplet ob = (triplet) o;
    int ff;
    int ss;
    long tt;
    if (o != null) {
        ff = ob.f;
        ss = ob.s;
        tt = ob.t;
        if ((ff == this.f) && (ss == this.s) && (tt == this.t))
            return true;
    }
    return false;
}