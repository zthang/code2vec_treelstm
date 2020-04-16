@Override
public int compareTo(Edge o) {
    // TODO Auto-generated method stub
    if (w == o.w)
        return ind - o.ind;
    return w - o.w;
}