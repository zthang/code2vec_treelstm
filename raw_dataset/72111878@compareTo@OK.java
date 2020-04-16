@Override
public int compareTo(Pair o) {
    if (l != o.l)
        return (int) (l - o.l);
    return (int) (r - o.r);
}