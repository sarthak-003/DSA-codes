class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);
        int p1 = 0,p2 = 0;
        int l1 = players.length;
        int l2 = trainers.length;
        while(p1<l1){
            if(p2 == l2) return p1;
            if(players[p1] <= trainers[p2]) {
                p1++;
                p2++;
            }
            else {
                p2++;
            }
        }
        return p1;
    }
}