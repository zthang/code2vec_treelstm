@Override
public int compareTo(pair o) {
    return x.equals(o.x) ? (Integer) y - (Integer) o.y : (Integer) x - (Integer) o.x;
}