public boolean equals(Object o) {
    if (this == o) {
        return true;
    }
    if (o == null || getClass() != o.getClass()) {
        return false;
    }
    PairII pair = (PairII) o;
    return first == pair.first && second == pair.second;
}