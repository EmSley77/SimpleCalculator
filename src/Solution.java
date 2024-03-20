import java.util.Stack;
//Emanuel sleyman
// 2024-03-20
public class Solution {

        public int calculate(String str) {
            Stack<Character> stack = new Stack<>();
            if (str == null) return 0;

            int total = 0;

            for (char c : str.toCharArray()) {
                if (c == ' ') continue;

                if (c != ')') {
                    stack.push(c);
                } else {
                    StringBuilder cur = new StringBuilder();
                    while (!stack.isEmpty() && stack.peek() != '(') {
                        cur.insert(0, stack.pop());
                    }
                    stack.pop();
                    int curInt = cal(cur.toString());
                    if (!stack.isEmpty() && stack.peek() == '-' && curInt < 0) {
                        stack.pop();
                        stack.push('+');
                        curInt = -curInt;
                    }
                    String curString = Integer.toString(curInt);
                    for (int i = 0; i < curString.length(); i++) {
                        stack.push(curString.charAt(i));
                    }
                }
            }

            StringBuilder last = new StringBuilder();
            while (!stack.isEmpty()) last.insert(0, stack.pop());
            total += cal(last.toString());
            return total;
        }

        public int cal(String s) {
            int total = 0;
            if (s == null || s.length() == 0) return 0;

            int last = 0;
            int power = 0;

            for (int i = s.length() - 1; i >= 0; i--) {
                char cur = s.charAt(i);
                if (cur == ' ') continue;

                if (cur == '+') {
                    total += last;
                    power = 0;
                    last = 0;
                } else if (cur == '-') {
                    total -= last;
                    power = 0;
                    last = 0;
                } else {
                    last += (int) ((cur - '0') * Math.pow(10, power));
                    power++;
                }
            }
            total += last;
            return total;
        }
    }



