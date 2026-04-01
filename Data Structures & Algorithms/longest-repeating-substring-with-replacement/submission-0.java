
class Solution {

    public int characterReplacement(String s, int k) {

        int max = 0;
        int left = 0;
        int right = 0;
        int n = s.length();

        while (right < n) {
            int winLen = right - left + 1;
            int mostFreq = find(s, left, right);

            if ((winLen - mostFreq) <= k) {
                max = Math.max(winLen, max);
            } else {
                left++;
            }

            right++;
        }
        return max;
    }

    public int find(String s, int l, int r) {

        Map<Character, Integer> map = new HashMap<>();
        for (int i = l; i <= r; i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int m = 0;
        for (int v : map.values()) {
            m = Math.max(m, v);
        }

        return m;
    }
}
