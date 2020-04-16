public void prop() {
    if (left == null)
        return;
    left.min += propD;
    left.propD += propD;
    right.min += propD;
    right.propD += propD;
    propD = 0;
}