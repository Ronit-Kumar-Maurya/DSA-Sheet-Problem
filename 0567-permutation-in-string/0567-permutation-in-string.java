class Solution {

    boolean issameFreq(int freq1[], int freq2[]){
        for(int i=0; i<freq1.length; i++){
            if(freq1[i]!=freq2[i]){
                return false;
            }
        }
        return true;
    }
    public boolean checkInclusion(String s1, String s2) {
        int freq[] = new int[26];
        for(int i=0; i<s1.length(); i++){
            freq[s1.charAt(i)-'a']++;
        }

        int windSize=s1.length();
        int windfreq[] = new int[26];

        for(int i=0; i<s2.length(); i++){
            int windIdx=0; int idx=i;
            while(windIdx<windSize && idx<s2.length()){
                windfreq[s2.charAt(idx)-'a']++;

                windIdx++;
                idx++;
            }

            if(issameFreq(freq, windfreq)){
                return true;
            }
            windfreq = new int[26];
        }
        return false;
    }
}