class Solution {

    boolean isAlphaNum(char ch){
            if((ch>='0'&&ch<='9')||(ch>='a'&&ch<='z')||(ch>='A'&&ch<='Z')){
                return true;
            }
            return false;
        };


    public boolean isPalindrome(String s) {
        int n = s.length();
        int start =0;
        int end = n-1;

        while(start<end){
            if(!isAlphaNum(s.charAt(start))){
                start++; continue;
            }
            if(!isAlphaNum(s.charAt(end))){
                end--; continue;
            }

            if (Character.toLowerCase(s.charAt(start)) !=
                Character.toLowerCase(s.charAt(end))) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}