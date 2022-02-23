package Exer;

public class SameString {

    public static void main(String[] args) {
        SameString s = new SameString();
        String str1 = "abcwerthelloyuiodeflobnm";
        String str2 = "cvhellobnm";

        System.out.println(s.maxSameSubString(str1,str2));

    }
    //當只有一個時
    public String maxSameSubString(String str1,String str2){
        String maxStr = (str1.length() >= str2.length())? str1 : str2;
        String minStr = (str1.length() < str2.length())? str1 : str2;

        int len = minStr.length();

        for (int i = 0; i < len; i++) {  //控制要減去多少個char
            for (int x = 0,y = len - i; y <= len; x++,y++) {
                if(maxStr.contains(minStr.substring(x,y))){
                    return minStr.substring(x,y);
                }
            }

        }

        return null;
    }
    //有多個時

}
