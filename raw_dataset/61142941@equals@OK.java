@Override
public boolean equals(Object o) {
    if (this == o)
        return true;
    if (o == null || getClass() != o.getClass())
        return false;
    Pair pair = (Pair) o;
    return a == pair.a && b == pair.b;
}