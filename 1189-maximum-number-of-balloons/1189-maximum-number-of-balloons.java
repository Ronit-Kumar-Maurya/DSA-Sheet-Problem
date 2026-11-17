class Solution {
    public int maxNumberOfBalloons(String text) {
         HashMap<Character, Integer> map = new HashMap<>();

        // Count frequency of each character
        for(int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if(ch=='b' || ch=='a' || ch=='l' || ch=='o' || ch=='n'){
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }
        }
        int x=Math.min(map.getOrDefault('b',0), Math.min(map.getOrDefault('a',0),map.getOrDefault('n',0)));
        int xx=Math.min(map.getOrDefault('l',0),map.getOrDefault('o',0));
        return Math.min(x,xx/2);
    }
}