public boolean equals(Object o) {
    Pair pair = (Pair) o;
    if (this.value == pair.value) {
        return true;
    }
    return false;
}