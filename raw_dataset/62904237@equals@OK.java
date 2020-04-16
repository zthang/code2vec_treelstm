@Override
public boolean equals(Object o) {
    if (this == o)
        return true;
    if (!(o instanceof Pair))
        return false;
    Pair p = (Pair) o;
    return first == p.first && second == p.second;
}