@Override
public int compareTo(Data o) {
    if (c == o.c) {
        if (a == o.a) {
            return Integer.compare(b, o.b);
        }
        return Integer.compare(a, o.a);
    }
    return Long.compare(c, o.c);
}