public boolean equals(Object o) {
    if (this == o)
        return true;
    if (o == null || getClass() != o.getClass())
        return false;
    Pair<?, ?> pair = (Pair<?, ?>) o;
    if (first != null ? !first.equals(pair.first) : pair.first != null)
        return false;
    return !(second != null ? !second.equals(pair.second) : pair.second != null);
}