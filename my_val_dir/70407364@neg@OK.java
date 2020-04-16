private JN neg() {
    int x = pr1;
    pr1 = pr2;
    pr2 = x;
    state = -state;
    return this;
}