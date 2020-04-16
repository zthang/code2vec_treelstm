public boolean equals(Object o) {
    if (o == null)
        return false;
    Triplet p = (Triplet) o;
    if (first == p.first && second == p.second && third == p.third)
        return true;
    return false;
}