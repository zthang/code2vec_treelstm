public boolean equals(Object o) {
    Pair ob = (Pair) o;
    int ff;
    int ss;
    if (o != null) {
        ff = ob.f;
        ss = ob.s;
        if ((ff == this.f) && (ss == this.s))
            return true;
    }
    return false;
}