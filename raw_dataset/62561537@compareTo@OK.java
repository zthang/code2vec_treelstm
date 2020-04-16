@Override
public int compareTo(Pair o) {
    if (x == o.x)
        return (int) (y - o.y);
    return (int) (x - o.x);
}