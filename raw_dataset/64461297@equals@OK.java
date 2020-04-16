@Override
public boolean equals(Object o) {
    if (this == o)
        return true;
    if (o == null || getClass() != o.getClass())
        return false;
    Edge pair = (Edge) o;
    return v == pair.v && u == pair.u;
}