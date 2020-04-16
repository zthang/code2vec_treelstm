public void pushUp() {
    eldest = elder(this, left.eldest);
    eldest = elder(eldest, right.eldest);
}