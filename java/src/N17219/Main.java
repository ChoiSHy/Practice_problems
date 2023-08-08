package N17219;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        int n, m;     // n: 저장된 사이트 주소 수 , m: 찾으려는 사이트 수
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Map<String, String> pwDic = new HashMap<>();

        try {
            String[] inputs = br.readLine().split(" ");
            n = Integer.parseInt(inputs[0]);
            m = Integer.parseInt(inputs[1]);

            for(int i=0;i<n;i++){
                inputs = br.readLine().split(" ");
                pwDic.put(inputs[0], inputs[1]);
            }
            for(int i=0;i<m;i++){
                String input = br.readLine();
                sb.append(pwDic.get(input)).append("\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(sb.toString());
    }
}
