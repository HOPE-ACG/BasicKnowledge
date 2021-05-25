package examination.huawei;

import java.util.*;

public class ErrorRecord {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        Map<String, TreeMap<Integer, Integer>> record = new HashMap<>();
        Map<String, Map<Integer, Integer>> statistic = new HashMap<>();
        List<String> list = new ArrayList<>();
        while (s.hasNextLine()) {
            String errorRecord = s.nextLine();
            String[] er = errorRecord.split(" ");
            String fileName = er[0].substring(er[0].lastIndexOf('\\'));
            if(!list.contains(fileName)){
                list.add(fileName);
            }
            int row = Integer.parseInt(er[1]);
            TreeMap<Integer, Integer> curRecord = record.getOrDefault(fileName, new TreeMap<Integer, Integer>());
            int errorCount = curRecord.getOrDefault(row, 0) + 1;
            curRecord.put(row, errorCount);
            record.put(fileName, curRecord);
        }
        Set<String> fileNames = record.keySet();

        for(String fileName : fileNames){
            Map<Integer, Integer> errorRecord = record.get(fileName);
        }
    }

    public static String format(String fileName){

        String name = fileName;
        if(fileName.length() > 16){
            name = fileName.substring(fileName.length() - 16);
        }
        return name;
    }
}
