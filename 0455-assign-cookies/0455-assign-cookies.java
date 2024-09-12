class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int p1 = 0,p2 = 0;
        while(p1<g.length){
            if(p2 == s.length) return p1;
            if(g[p1] <= s[p2]) {
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