public boolean equals(Object o) {
    if (this == o) {
        return true;
    }
    if (o == null || getClass() != o.getClass()) {
        return false;
    }
    DCowAndSnacks.Pair pair = (DCowAndSnacks.Pair) o;
    return x == pair.x && y == pair.y && z == pair.z;
}