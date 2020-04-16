@Override
public int compareTo(Point o) {
    if (x != o.x) {
        return x - o.x;
    }
    return type - o.type;
}