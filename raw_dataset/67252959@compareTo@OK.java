@Override
public int compareTo(seg o) {
    if (l != o.l)
        return l - o.l;
    return r - o.r;
}