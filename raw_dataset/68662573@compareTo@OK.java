@Override
public int compareTo(Point o) {
    if (x != o.x)
        return Integer.compare(x, o.x);
    else
        return -Boolean.compare(open, o.open);
}