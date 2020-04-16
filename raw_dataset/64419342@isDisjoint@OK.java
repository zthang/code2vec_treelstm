public boolean isDisjoint(int S, int T) {
    return (S + T) == (S ^ T);
}