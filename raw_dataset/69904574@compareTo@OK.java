@Override
public int compareTo(Segment o) {
    return l == o.l ? r - o.r : l - o.l;
}