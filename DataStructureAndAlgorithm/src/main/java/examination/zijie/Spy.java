package examination.zijie;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Spy {

    public static void main(String[] args) throws IOException {

        int mod = 99997867;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String nd = br.readLine();
        String[] nds= nd.split(" ");
        int n = Integer.parseInt(nds[0]);
        int d = Integer.parseInt(nds[1]);
        String pos_str = br.readLine();
        String[] poses = pos_str.split(" ");
        int[] pos = new int[n];
        for(int i = 0; i < n; i++){
            pos[i] = Integer.parseInt(poses[i]);
        }
        long count = 0;
        long range = 0;
        for(int i = 0; i < n - 2; i++){
            for(int j = n - 1; j > i; j--){
                if(pos[j] - pos[i] <= d){
                    range = j;
                    break;
                }
            }
            if(range >= i + 2){
                range = range - i - 1;
                count = count + ((range * (range + 1)) / 2);
            }
        }
        System.out.println(count % mod);
    }
}
