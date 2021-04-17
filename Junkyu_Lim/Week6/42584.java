import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Node> st = new Stack<>();
        
        for(int i = 0; i < prices.length; i ++) {
            int cPrice = prices[i];
            
            if(st.isEmpty()) st.push(new Node(cPrice, i));
            else {
                while(!st.isEmpty()){
                    Node tar = st.pop();
                    if(cPrice < tar.price) {
                        answer[tar.idx] = i-tar.idx;
                    } else {
                        st.push(tar);
                        break;
                    }
                }
                st.push(new Node(cPrice, i));
            }
        }
        
        if(!st.isEmpty()) {
            while(!st.isEmpty()) {
                Node tar = st.pop();
                answer[tar.idx] = prices.length - (tar.idx+1);
            }
        }
        
        return answer;
    }
}

class Node{
    int price;
    int idx;
    
    public Node(int a, int b) {
        this.price = a;
        this.idx = b;
    }
}