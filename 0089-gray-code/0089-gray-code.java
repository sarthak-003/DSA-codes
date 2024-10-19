class Solution {
    static  List<Integer> grayCode(int n) {
        int c = 0;
        List<Integer>list = new ArrayList<>();
        list.add(0);
        for(int i = 1 ; i <= n ; i++){
            int l = list.size();
            c = 1 << (i-1);
            for(int j = 1 ; j <=c ; j++){
                int x = list.get(l - j) + c;
                list.add(x);
            }
        }
        return list;
    }
}