class Solution {
    static class Node{
        int value;
        int row;
        int col;
        Node(int value, int row, int col){
            this.value = value;
            this.row = row;
            this.col = col;
        }
    }
    static class Compare implements Comparator<Node>{
        public int compare(Node a, Node b){
            return a.value - b.value;
        }
    }

    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int m = matrix[0].length;

        PriorityQueue<Node> pq = new PriorityQueue<>(new Compare());

        for(int i = 0; i < n; i++){
            pq.add(new Node(matrix[i][0], i, 0));
        }

        int count = 0;
        int result = -1;

        while(!pq.isEmpty()){
            Node node = pq.poll();
            count++;

            if(count == k){
                result = node.value;
                break;
            }

            int col = node.col;

            if(col == m - 1){
                continue;
            }

            pq.offer(new Node(matrix[node.row][col + 1], node.row, col + 1));
        }

        return result;
    }
}