public boolean equals(Object o) {
    if (this == o)
        return true;
    if (!(o instanceof ETreeQueries.pair))
        return false;
    ETreeQueries.pair key = (ETreeQueries.pair) o;
    return x == key.x && y == key.y;
}