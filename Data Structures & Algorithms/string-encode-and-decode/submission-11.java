class Solution {

    public String encode(List<String> strs) {

        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            int l = s.length();
            sb.append(l);
            sb.append('*');
            sb.append(s);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {

        List<String> ls = new ArrayList<>();
        int i = 0;

        while (i < str.length()) {

            int j = i;

            // find '*'
            while (str.charAt(j) != '*') {
                j++;
            }

            // extract length
            int length = Integer.parseInt(str.substring(i, j));

            // move to start of actual string
            i = j + 1;
            j = i + length;

            // extract string using length
            ls.add(str.substring(i, j));

            // move to next encoded part
            i = j;
        }
        return ls;
    }
}
