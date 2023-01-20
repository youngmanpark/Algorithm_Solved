package CD8;

import java.util.Stack;

public class Proc8_3 {
    public String  solution(String s){
        String answer = "";
        Stack<String> stack = new Stack<>();
        for (Character x : s.toCharArray()) {
            if (x == ')') {
                String tmp = "";
                while (!stack.isEmpty()) {
                    String c = stack.pop() ;
                    if (c.equals("(")) {

                        String num = "";
                        while (!stack.isEmpty() && Character.isDigit(stack.peek().charAt(0))) {
                            num = stack.pop()+ num;
                        }
                        int cnt=0;
                        if (num.equals("")) cnt = 1;
                        else cnt = Integer.parseInt(num);
                        String res = "";
                        for (int i = 0; i < cnt; i++) res += tmp;
                        stack.push(res);

                        break;
                    } else {
                        tmp = c + tmp;
                    }
                }

            }else
            stack.push(String.valueOf(x));
        }for(String x:stack)
        answer += x;
        return answer;
    }

    public static void main(String[] args) {
        Proc8_3 T = new Proc8_3();
        System.out.println(T.solution("3(a2(b))ef"));
    }
}
