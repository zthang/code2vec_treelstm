public double getDistanceToParent() {
    if (!hasParent())
        throw new NoSuchElementException("Node has no parent!");
    return this.distanceToParent;
}