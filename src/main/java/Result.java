import java.util.*;

class Result {
    public static Set<String> noSolution = new HashSet<>();

    public String passwordCracker(List<String> passwords, String loginAttempt) {
        if (passwords.contains(loginAttempt)) return loginAttempt;

        String result = concatenate(passwords, loginAttempt, "");
        return result;
    }

    public String concatenate(List<String> passwords, String loginAttempt, String solver) {
        if (loginAttempt.length() == 0) {
            return solver.trim();
        } else if (noSolution.contains(loginAttempt)) {
            return "WRONG PASSWORD";
        }

        for (String pwd : passwords) {
            if (loginAttempt.indexOf(pwd) == 0) {
                solver = solver + " " + pwd;
                String res = concatenate(passwords, loginAttempt.substring(pwd.length()), solver);
                if (! res.equals("WRONG PASSWORD")) {
                    return res;
                }
            }
        }
        noSolution.add(loginAttempt);
        return "WRONG PASSWORD";
    }

    public static void main(String[] args) {
        Result result = new Result();
        String str = "okweif rpgnteja ufemijimuw vpon eoncaf udgf hhtez aiknzgy bpndljur eeycbwv";
        String[] array = str.split(" ");
        List<String> list = new ArrayList<>();
        for (String s : array) {
            list.add(s);
        }
        String attempt = "ufemijimuweeycbwvokweifvponbpndljurudgfaiknzgyhhtezufemijimuwufemijimuwaiknzgyudgfufemijimuwrpgntejaeoncafvponudgfbpndljurokweifhhtezbpndljurvponufemijimuwudgfbpndljurufemijimuweoncafrpgntejaudgf";
        String answer = result.passwordCracker(list, attempt);
        System.out.println(answer);
    }
}