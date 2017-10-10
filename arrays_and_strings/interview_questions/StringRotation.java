class StringRotation {
    public static boolean isSubstring(String s1, String s2){
        return s1.contains(s2);
    }

    public static boolean stringRotationCheck(String s1, String s2){
        String combined = s1+s1;
        return isSubstring(combined,s2);
    }

    public static void main(String[] args){
        System.out.println(stringRotationCheck("waterbottle","erbottlewat"));
    }
}
