public boolean equals(Object other) {
    if (other instanceof Pair) {
        Pair<A, B> otherPair = (Pair<A, B>) other;
        return ((this.first == otherPair.first || (this.first != null && otherPair.first != null && this.first.equals(otherPair.first))) && (this.second == otherPair.second || (this.second != null && otherPair.second != null && this.second.equals(otherPair.second))));
    }
    return false;
}