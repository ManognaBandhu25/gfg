class Solution {
    public static boolean areAnagrams(String s1, String s2) {
        // code here
        HashMap<Character,Integer> hm=new HashMap();
        boolean bool=false;
        
        if(s1.length()!=s2.length())
        {
            return false;
        }
        
        for(int i=0;i<s1.length();i++)
        {
            char ch=s1.charAt(i);
            hm.put(ch,hm.getOrDefault(ch,0)+1);
        }
        for(int i=0;i<s2.length();i++)
        {
            char ch=s2.charAt(i);
            if(hm.containsKey(ch))
            {
                hm.put(ch,hm.get(ch)-1);
                if(hm.get(ch)<0){return false;}
                bool=true;
            }
            else
            {
                bool=false;
                break;
            }
        }
        return bool;
    }
}