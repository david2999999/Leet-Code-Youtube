public class CourseScheduleII {
    private class Node {
        public List<Integer> neighbors;
        public int indegree = 0;

        public Node() {
            this.neighbors = new ArrayList<>();
        }
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Node[] nodes = createNodes(numCourses, prerequisites);
        Queue<Integer> queue = new LinkedList<>();
        int[] courses = new int[numCourses];
        int i = 0;

        for (int id = 0; id < nodes.length; id++) {
            if (nodes[id].indegree == 0) queue.add(id);
        }

        while (!queue.isEmpty()) {
            int id = queue.poll();
            courses[i++] = id;

            for (int neighborId: nodes[id].neighbors) {
                nodes[neighborId].indegree--;

                if (nodes[neighborId].indegree == 0) queue.add(neighborId);
            }
        }

        return i == numCourses ? courses : new int[0];
    }

    private Node[] createNodes(int numCourses, int[][] prerequisites) {
        Node[] nodes = new Node[numCourses];

        for (int id = 0; id < nodes.length; id++) {
            nodes[id] = new Node();
        }

        for (int[] pre: prerequisites) {
            nodes[pre[1]].neighbors.add(pre[0]);
            nodes[pre[0]].indegree++;
        }

        return nodes;
    }
}