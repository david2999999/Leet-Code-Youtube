public class CourseSchedule {
    private class Node {
        public int id;
        public List<Node> neighbors;
        public int indegree = 0;

        public Node(int id) {
            this.id = id;
            this.neighbors = new ArrayList<>();
        }
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Node[] nodes = createNodes(numCourses, prerequisites);
        Queue<Integer> queue = new LinkedList<>();
        int courses = 0;

        for (int id = 0; id < nodes.length; id++) {
            if (nodes[id].indegree == 0) queue.add(id);
        }

        while (!queue.isEmpty()) {
            int id = queue.poll();
            courses++;

            for (Node neighbor: nodes[id].neighbors) {
                nodes[neighbor.id].indegree--;

                if (nodes[neighbor.id].indegree == 0) queue.add(neighbor.id);
            }
        }

        return courses == numCourses;
    }

    private Node[] createNodes(int numCourses, int[][] prerequisites) {
        Node[] nodes = new Node[numCourses];

        for (int id = 0; id < numCourses; id++) {
            nodes[id] = new Node(id);
        }

        for (int[] pre: prerequisites) {
            nodes[pre[1]].neighbors.add(nodes[pre[0]]);
            nodes[pre[0]].indegree++;
        }

        return nodes;
    }
}