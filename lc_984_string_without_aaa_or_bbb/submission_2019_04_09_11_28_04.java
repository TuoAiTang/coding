

class Solution {
    public String strWithout3a3b(int A, int B) {
        StringBuilder sb = new StringBuilder();
        String a = "a", b = "b";
        if(B > A){
            int tmp = B;
            B = A;
            A = tmp;
            a = "b";
            b = "a";
        }
        //when A > B, use aabaab
        //when A = B, use abab
        while(A > 0 || B > 0){
            if(A > 0)  {sb.append(a); A--;}
            if(A > B)  {sb.append(a); A--;}
            if(B > 0)  {sb.append(b); B--;}
        }
        
        return sb.toString();
    }
}