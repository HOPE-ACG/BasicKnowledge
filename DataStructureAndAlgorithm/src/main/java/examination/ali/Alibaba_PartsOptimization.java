package examination.ali;

public class Alibaba_PartsOptimization {

    //Optimize system in space and time with many of parts
    public static void main(String[] args) {
        //Scanner s = new Scanner(System.in);
        //int n = s.nextInt(); // parts' number
        int n = 50000;
        //int m = s.nextInt(); // conflict relations' number
        int m = 10000;
        int[] instability_time = new int[n];
        int[] instability_space = new int[n];
        for(int i = 0;i < n;i++){ // the value of instability in time and space
            instability_time[i] = (int) (Math.random() * 10);
            instability_space[i] = (int) (Math.random() * 10);
        }
        /*for(int t : instability_time){
            System.out.print(t + " ");
        }
        System.out.println();
        for(int s : instability_space){
            System.out.print(s + " ");
        }
        System.out.println();*/
       /* for(int i = 0;i < n;i++){ // the value of instability in time and space
            instability_time[i] = s.nextInt();
            instability_space[i] = s.nextInt();
        }*/
        int[] conflict_male = new int[m];
        int[] conflict_female = new int[m];
        conflict_male[0] = 1;
        conflict_female[0] = 5;
        for(int j = 1;j < m;j++){ // conflict's index of two parts
            conflict_male[j] = (int) (Math.random() * n + 1);
            conflict_female[j] = (int) (Math.random() * n + 1);
        }
        /*for(int j = 0;j < m;j++){ // conflict's index of two parts
            conflict_male[j] = s.nextInt();
            conflict_female[j] = s.nextInt();
        }*/
        int[][] conflict = new int[n][m];
        boolean male, female;
        for(int k = 0;k < m;k++){ // classify conflict's part of every part
            male = false;
            female = false;
            for(int kk = 0;kk < m;kk++){
                if(!male && conflict[conflict_male[k] - 1][kk] == 0){
                    conflict[conflict_male[k] - 1][kk] = conflict_female[k];
                    male = true;
                }
                if(!female && conflict[conflict_female[k] - 1][kk] == 0){
                    conflict[conflict_female[k] - 1][kk] = conflict_male[k];
                    female = true;
                }
                if(male && female){
                    break;
                }
            }
        }
/*        for(int p = 0;p < n;p++){
            for(int pp = 0;pp < m;pp++){
                System.out.print(conflict[p][pp] + " ");
            }
            System.out.println();
        }*/
        for(int index = 0;index < n;index++){
            int optimalValue = algorithm(index, n, conflict, instability_time, instability_space);
            System.out.print(optimalValue + " ");
        }
    }

    //get optimal answer
    private static int algorithm(int index,int n, int[][] conflict, int[] instability_time, int[] instability_space){

        int sum = 0;
        boolean flag;
        for(int i = 0;i < n;i++){
            if(i == index){
                continue;
            }
            flag = false;
            for(int j = 0;j < conflict[index].length;j++){
                if(conflict[index][j] == 0){
                    break;
                }
                if(i == conflict[index][j] - 1){
                    flag = true;
                    break;
                }
            }
            if(flag){
                continue;
            }
            sum += Math.min(
                    instability_time[index] + instability_space[i],
                    instability_space[index] + instability_time[i]
            );
        }
        return sum;
    }
}
