public boolean equals(Object o) {
    if (this == o)
        return true;
    if (!(o instanceof pair))
        return false;
    pair key = (pair) o;
    return x == key.x && y == key.y;
}