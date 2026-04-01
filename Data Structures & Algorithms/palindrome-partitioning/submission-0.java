class Solution {
    int n;
    List<List<String>> result = new ArrayList<>();

    public List<List<String>> partition(String s) {
        n = s.length();
        backtrack(0, new ArrayList<>(), s);
        return result;
    }

    private void backtrack(int idx, List<String> current, String s) {
        if (idx == n) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = idx; i < n; i++) {
            if (isPalindrome(s, idx, i)) {
                current.add(s.substring(idx, i + 1));
                backtrack(i + 1, current, s);
                current.remove(current.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}