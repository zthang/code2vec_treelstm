@Override
public int compareTo(Pair o) {
    if (a == o.a && b == o.b || a == o.b && b == o.a) {
        return 0;
    }
    return 1;
}