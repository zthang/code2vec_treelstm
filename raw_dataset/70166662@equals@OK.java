@Override
public boolean equals(Object obj) {
    Point ob = (Point) obj;
    if (this.x == ob.x && this.y == ob.y) {
        return true;
    }
    return false;
}