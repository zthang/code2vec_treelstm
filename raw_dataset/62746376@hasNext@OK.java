public boolean hasNext() {
    if (c > 32)
        return true;
    while (true) {
        c = nextChar();
        if (c == NC)
            return false;
        else if (c > 32)
            return true;
    }
}