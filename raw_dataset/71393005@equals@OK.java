public boolean equals(Object obj) {
    if (obj == null || obj.getClass() != this.getClass())
        return false;
    pair p = (pair) obj;
    return (this.x == p.x && this.y == p.y);
}