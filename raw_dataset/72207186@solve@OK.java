public void solve(InputProvider in, PrintWriter out) throws IOException {
    List<RoadPoint> points = IntStream.rangeClosed(1, in.nextInt()).mapToObj(RoadPoint::new).collect(Collectors.toList());
    int roads = in.nextInt();
    for (int i = 0; i < roads; i++) {
        RoadPoint from = points.get(in.nextInt() - 1);
        RoadPoint to = points.get(in.nextInt() - 1);
        to.previousPoints.add(from);
    }
    int[] wayPoints = new int[in.nextInt()];
    for (int i = 0; i < wayPoints.length; i++) {
        wayPoints[i] = in.nextInt() - 1;
    }
    int target = wayPoints[wayPoints.length - 1];
    RoadPoint targetPoint = points.get(target);
    targetPoint.mark = 0;
    Queue<RoadPoint> processingPoints = new ArrayDeque<>();
    processingPoints.add(targetPoint);
    while (!processingPoints.isEmpty()) {
        RoadPoint currentPoint = processingPoints.poll();
        Collection<RoadPoint> previousPoints = currentPoint.previousPoints;
        for (RoadPoint previousPoint : previousPoints) {
            if (previousPoint.mark > currentPoint.mark + 1) {
                processingPoints.add(previousPoint);
                previousPoint.mark = currentPoint.mark + 1;
                previousPoint.nextPoints.clear();
                previousPoint.nextPoints.add(currentPoint);
            } else if (previousPoint.mark == currentPoint.mark + 1) {
                previousPoint.nextPoints.add(currentPoint);
            }
        }
    }
    long minChanges = 0;
    long maxChanges = 0;
    RoadPoint previousPoint = points.get(wayPoints[0]);
    for (int i = 1; i < wayPoints.length; i++) {
        RoadPoint wayPoint = points.get(wayPoints[i]);
        if (previousPoint.nextPoints.contains(wayPoint)) {
            if (previousPoint.nextPoints.size() > 1) {
                maxChanges++;
            }
        } else {
            minChanges++;
            maxChanges++;
        }
        previousPoint = wayPoint;
    }
    out.print(minChanges + " " + maxChanges);
}