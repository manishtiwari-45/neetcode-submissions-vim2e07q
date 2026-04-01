class Solution {
    public boolean checkInclusion(String s1, String s2) {

        int len1 = s1.length();
        int len2 = s2.length();

        if (len1 > len2) return false;

        int[] s1Arr = new int[26];
        int[] s2Arr = new int[26];

        for (int i = 0; i < len1; i++) {
            s1Arr[s1.charAt(i) - 'a']++;
            s2Arr[s2.charAt(i) - 'a']++;
        }
        int left = 0;
        for (int right = len1; right < len2; right++) {
            boolean match = true;
            for (int i = 0; i < 26; i++) {
                if (s1Arr[i] != s2Arr[i]) {
                    match = false;
                    break;
                }
            }
            if (match){
                return true;
            }
            s2Arr[s2.charAt(right) - 'a']++;
            s2Arr[s2.charAt(left) - 'a']--;
            left++;
        }

        for (int i = 0; i < 26; i++) {
            if (s1Arr[i] != s2Arr[i]) return false;
        }

        return true;
    }
}
