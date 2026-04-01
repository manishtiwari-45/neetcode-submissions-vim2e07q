class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        if(n > m){
            return false;
        }

        int[] s1Arr = new int[26];
        int[] s2Arr = new int[26];

        for (int i = 0; i < n; i++) {
            s1Arr[s1.charAt(i) - 'a']++;
        }
        int left = 0;
        for(int right = 0; right < m; right++){
            s2Arr[s2.charAt(right) - 'a']++;

            if(right - left + 1 > n){
                s2Arr[s2.charAt(left) - 'a']--;
                left++;
            }if(matches(s1Arr, s2Arr)){
                return true;
            }
        }
        
        return false;
    }

    private boolean matches(int[] a, int[] b){
        for(int i=0; i<26;i++){
            if(a[i] != b[i]){
                return false;
            }
        }
        return true;
    }
}
