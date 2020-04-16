public boolean equals(Object obj) {
    if (this.getClass() != obj.getClass())
        return false;
    pair<U, V> other = (pair<U, V>) obj;
    return x.equals(other.x) && y.equals(other.y);
}