class Solution {
    public static boolean canTransform(String s1, String s2) {
        // code here
        int[] parentstore =new int[26];
        Integer[] store = new Integer[26];
        for(int i =0;i < s1.length();i++) {
            int index = s1.charAt(i) - 'a';
            int index2 = s2.charAt(i) - 'a';
            if(store[index] == null) {
                store[index] = index2;
            }
            else if(store[index] != index2) {
                int symmetry = Math.abs(index - store[index]);
                int distance = 0;
                if(store[index] > index) {
                     distance = (index  -  symmetry + 26)%26;
                }
                else if (store[index] < index){
                    distance = (index + symmetry)%26;
                }
                if(index2 != distance) {
                    return false;
                }
                
            }
        }
        return true;
    }
}
