public boolean equlas(Object o) {
    if (o instanceof tripletL) {
        tripletL p = (tripletL) o;
        return (x - p.x == 0) && (y - p.y == 0) && (z - p.z == 0);
    }
    return false;
}