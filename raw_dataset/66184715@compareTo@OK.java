public int compareTo(Object o) {
    Pair<?, ?> p = (Pair<?, ?>) o;
    if (fi.equals(p.fi))
        return ((Comparable) se).compareTo(p.se);
    return ((Comparable) fi).compareTo(p.fi);
}