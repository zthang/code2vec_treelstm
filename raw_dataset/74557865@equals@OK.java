public boolean equals(Object o) {
    triplet ob = (triplet) o;
    if (o != null) {
        if ((ob.f == this.f) && (ob.s == this.s) && (ob.t == this.t))
            return true;
    }
    return false;
}