public void pop() {
    if (top != null) {
        top = top.next;
    }
    Size--;
}