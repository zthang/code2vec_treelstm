@Override
public boolean equals(Object o) {
    if (this == o)
        return true;
    if (o == null || getClass() != o.getClass())
        return false;
    Pair<?, ?> p = (Pair<?, ?>) o;
    if (!fi.equals(p.fi))
        return false;
    return se.equals(p.se);
}