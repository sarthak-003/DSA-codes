class Solution {
    public long maxKelements(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int ele : arr) pq.add(ele);
        long score = 0;
        for (int i = 0; i < k; i++) {
            score+=pq.peek();
            pq.add((int) Math.ceil((double) pq.remove() / 3));
        }
        return score;
    }
}