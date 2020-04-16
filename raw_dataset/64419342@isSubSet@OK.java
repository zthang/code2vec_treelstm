public boolean isSubSet(int S, int T) {
    return (S - T) == (S ^ T);
}