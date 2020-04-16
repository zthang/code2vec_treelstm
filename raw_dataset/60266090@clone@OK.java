public Splay clone() {
    try {
        return (Splay) super.clone();
    } catch (CloneNotSupportedException e) {
        throw new RuntimeException(e);
    }
}