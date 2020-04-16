public static boolean isCyclic(Node[][] arr, Node startNode, int n) {
    if (startNode.endX != -1 || startNode.endY != -1)
        return false;
    if (startNode.included)
        return true;
    startNode.included = true;
    // up
    if (startNode.x > 0) {
        Node upper = arr[startNode.x - 1][startNode.y];
        if (isCyclic(arr, upper, n)) {
            startNode.direction = 'U';
            ++includedCount;
            return true;
        }
    }
    // down
    if (startNode.x < n - 1) {
        Node down = arr[startNode.x + 1][startNode.y];
        if (isCyclic(arr, down, n)) {
            startNode.direction = 'D';
            ++includedCount;
            return true;
        }
    }
    // left
    if (startNode.y > 0) {
        Node left = arr[startNode.x][startNode.y - 1];
        if (isCyclic(arr, left, n)) {
            startNode.direction = 'L';
            ++includedCount;
            return true;
        }
    }
    // right
    if (startNode.y < n - 1) {
        Node right = arr[startNode.x][startNode.y + 1];
        if (isCyclic(arr, right, n)) {
            startNode.direction = 'R';
            ++includedCount;
            return true;
        }
    }
    return false;
}