@Override
public boolean equals(Object o) {
    if (this == o)
        return true;
    if (o == null || getClass() != o.getClass())
        return false;
    pair pair = (pair) o;
    return x == pair.x && y == pair.y;
}