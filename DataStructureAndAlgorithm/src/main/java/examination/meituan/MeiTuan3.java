package examination.meituan;

import java.util.Arrays;
import java.util.Scanner;

public class MeiTuan3 {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        for(int i = 0;i < t;i++){
            int n = s.nextInt(); //������
            String count = s.next(); //ÿ����������
            int m = s.nextInt(); //�Ŷ�����
            String gender = s.next(); //�Ŷ����Ա�
            int[] people = new int[n]; //ÿ����������
            char[] sex = new char[m]; //�Ŷ����Ա�
            for(int j = 0;j < n;j++){
                people[j] = count.charAt(j) - 48;
            }
            for(int j = 0;j < m;j++){
                sex[j] =  gender.charAt(j);
            }
//            System.out.println(Arrays.toString(people));
//            System.out.println(Arrays.toString(sex));
            int[][] general = new int[3][n];
            for(int j = 0;j < n;j++){
                general[people[j]][j] = 1;
            }
            System.out.println(Arrays.toString(general[0]) + "\n"
                    + Arrays.toString(general[1]) + "\n"
                    + Arrays.toString(general[2]));
            int pos_zero;
            int pos_one;
            for(int k = 0;k < m;k++){
                pos_zero = -1;
                pos_one = -1;
                char g = sex[k];
                for(int j = 0;j < n;j++){
                    if(pos_zero == -1 && general[0][j] != 0){
                        pos_zero = j + 1;
                    }
                    if(pos_one == -1 && general[1][j] != 0){
                        pos_one = j + 1;
                    }
                    if(g == 70 && pos_zero != -1){
                        System.out.println(pos_zero);
                        general[0][j] = 0;
                        general[1][j] = 1;
                        break;
                    }
                    if(g == 77 && pos_one != -1){
                        System.out.println(pos_one);
                        general[1][j] = 0;
                        general[2][j] = 1;
                        break;
                    }
                }
                if(g == 70 && pos_zero == -1){
                    System.out.println(pos_one);
                    general[1][pos_one - 1] = 0;
                    general[2][pos_one - 1] = 1;
                }else if(g == 77 && pos_one == -1){
                    System.out.println(pos_zero);
                    general[0][pos_zero - 1] = 0;
                    general[1][pos_zero - 1] = 1;
                }
            }
            System.out.println(Arrays.toString(general[0]) + "\n"
                    + Arrays.toString(general[1]) + "\n"
                    + Arrays.toString(general[2]));
        }
    }
}
