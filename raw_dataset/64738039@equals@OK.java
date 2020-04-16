@Override
public boolean equals(Object o) {
    if (this == o)
        return true;
    if (o == null || getClass() != o.getClass())
        return false;
    Pair pair = (Pair) o;
    if (a != pair.a)
        return false;
    return b == pair.b;
}