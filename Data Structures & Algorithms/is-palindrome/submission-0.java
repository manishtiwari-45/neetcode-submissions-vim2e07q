class Solution {
    public boolean isPalindrome(String s) {
        String str = cleanString(s);

        int n = str.length();
        int first = 0;
        int second = n - 1;
        while(first < second){
            if(str.charAt(first) != str.charAt(second)){
                return false;
            }
            first++;
            second--;
        }
        return true;

    }

    public String cleanString(String str){
        StringBuilder sb = new StringBuilder();
        for(char ch : str.toCharArray()){
            if(Character.isLetterOrDigit(ch)){
                sb.append(Character.toLowerCase(ch));
            }
        }
        return sb.toString();
    }
}
