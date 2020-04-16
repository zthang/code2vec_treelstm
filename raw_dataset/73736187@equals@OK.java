@Override
public boolean equals(Object o) {
    if (this == o) {
        return true;
    }
    if (!(o instanceof Pair)) {
        return false;
    }
    Pair key = (Pair) o;
    return x == key.x && y == key.y;
}