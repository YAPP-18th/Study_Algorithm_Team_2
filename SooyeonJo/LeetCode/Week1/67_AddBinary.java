class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        
        while(i >= 0 || j >= 0){
            int result = carry;
            if(i >= 0){
                result += a.charAt(i--) - '0';
            }
            if(j >= 0){
                result += b.charAt(j--) - '0';
            }
            carry = result >= 2 ? 1 : 0;
            sb.append(result % 2);
        }
        
        if(carry == 1){
            sb.append(carry);
        }
        
        return sb.reverse().toString();
    }
}
