package ejerciciospracticas4;

public class StrSymmetryPoint {

    public static void main(String[] args) {
        String s = "coche de carreras";
        System.out.println(solution4(s));
    }

    public static int solution3(String S) {

        // write your code in Java SE 8
        if (S.length() == 1) {
            return 0;
        } else if (S.length() == 0 || S.length() % 2 == 0) {
            return -1;
        } else {

            int len = S.length();

            int half = (len / 2);

            for (int i = 0; i < half; i++) {

                if (S.charAt(i) != S.charAt((len - 1) - i)) {
                    return -1;
                }

            }

            return (len / 2);

        }

    }
    public static int solution4(String S) {
    int l = 0;
    int r = S.length() - 1;
    int ans = -1;
    while (l <= r) {
      if (l == r) {
        ans = l;
        break;
      }
      if (S.charAt(l) == S.charAt(r)) {
        l++;
        r--;
      } else {
        ans = -1;
        break;
      }
    }
    return ans;
  }

    public static int solution1(String s) {
        if ((s.length() & 1) == 0) {
            return -1;
        }
        final int result = s.length() / 2;
        for (int i = result, j = result; j >= 0; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return -1;
            }
        }
        return result;
    }

    /* public static int solution(String S) {
    int length = S.length();
    if (length % 2 != 0 && isPalindrome(S)) {
    return length / 2;
    } else {
    return -1;
    }
    }
    
    static boolean isPalindrome(String S) {
    for (int i = 0, j = S.length() - 1; i < j; i++, j--) {
    if (S.charAt(i) != S.charAt(j)) {
    return false;
    }
    }
    return true;
    }*/
}
