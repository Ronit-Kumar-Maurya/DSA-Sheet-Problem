class Solution {
    public int compress(char[] chars) {
        int idx = 0;
        for (int i = 0; i < chars.length;) {
            char ch = chars[i];
            int count = 0;
            while (i < chars.length && ch == chars[i]) {
                count++;
                i++;
            }
            // if(count==1){
            //     chars[idx++] = ch;
            // } ya fir direct likh do
            chars[idx++]=ch;
            if (count > 1) {
                String str = String.valueOf(count);
                for (int j = 0; j < str.length(); j++) {
                    chars[idx++] = str.charAt(j);
                }
            }
        }

        return idx;
    }
}
