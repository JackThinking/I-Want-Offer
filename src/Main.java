import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String str = input.readLine();
        String str_low = str.toLowerCase();
        /*char[] array = str_low.toCharArray();
        Arrays.sort(array);
        Character ans = null;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] != array[i + 1]) {
                ans = array[i];
            }
        }*/
        Main main = new Main();
        System.out.println(main.removeDuplicateLetters(str_low));
    }

    public String removeDuplicateLetters(String s) {
        int[] count = new int[26];
        char[] chars = s.toCharArray();
        for (char c : chars) {
            count[c - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        boolean[] visited = new boolean[26];
        for (char c : chars) {
            count[c - 'a']--;
            if (visited[c - 'a']) {
                continue;
            }
            while (sb.length() > 0 && c <= sb.charAt(sb.length() - 1) && count[sb.charAt(sb.length() - 1) - 'a'] > 0) {
                visited[sb.charAt(sb.length() - 1) - 'a'] = false;
                sb.deleteCharAt(sb.length() - 1);
            }
            sb.append(c);
            visited[c - 'a'] = true;
        }
        return sb.toString();
    }
}