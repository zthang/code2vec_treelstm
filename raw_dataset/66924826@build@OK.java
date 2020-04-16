public Tree build(Input in) {
    return new Tree(in, nodeCount == -1 ? in.nextInt() : nodeCount, adjustIndex, withWeights, rootNode);
}