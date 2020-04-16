public Tree build(Scanner in) {
    return new Tree(in, n == -1 ? in.nextInt() : n, adjustIndex, withWeights, rootNode);
}