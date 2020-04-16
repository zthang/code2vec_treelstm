public void pushUp() {
    largest = larger(this, left.largest);
    largest = larger(largest, right.largest);
}