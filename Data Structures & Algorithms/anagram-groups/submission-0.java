class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> result = new ArrayList<>();
        int[] isChecked = new int[strs.length];
        for (int i = 0; i < strs.length; i++) {
            if (isChecked[i] == 1) continue;

            String current = strs[i];
            List<String> arr = new ArrayList<>();
            arr.add(current);           
            isChecked[i] = 1;
            for (int j = i + 1; j < strs.length; j++) {
                if (isChecked[j] == 0 && isAnagram(current, strs[j])) {
                    arr.add(strs[j]);
                    isChecked[j] = 1;
                }
            }
            result.add(arr);        
        }

        return result;
    }

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] arr = new int[26];

        for (char ch : s.toCharArray()) {
            arr[ch - 'a']++;
        }
        for (char ch : t.toCharArray()) {
            arr[ch - 'a']--;
        }

        for (int num : arr) {
            if (num != 0) {
                return false;
            }
        }

        return true;
    }
}
