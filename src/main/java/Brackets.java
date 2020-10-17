public class Brackets {
    public int solution(String S) {
        if (S == null) return 1;
        int len = S.length();
        if (len == 0) return 1;
        if (len % 2 != 0) return 0;
        while (S.indexOf("()") >= 0 || S.indexOf("[]") >= 0 || S.indexOf("{}") >= 0) {
            S = S.replace("()","");
            S = S.replace("[]","");
            S = S.replace("{}","");
        }
        if (S.length() == 0) {
            return 1;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        Brackets brackets = new Brackets();
        String S = "{[()()]}";
        //S = "([)()]";
        int ans = brackets.solution(S);
        System.out.println(ans);
    }
}
