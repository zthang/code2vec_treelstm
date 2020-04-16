public boolean equals(Object o) {
    if (this == o)
        return true;
    if (!(o instanceof CAnadiAndDomino.domino))
        return false;
    CAnadiAndDomino.domino domino = (CAnadiAndDomino.domino) o;
    return left == domino.left && right == domino.right;
}