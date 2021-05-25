package examination.zijie;

import java.util.ArrayList;
import java.util.Arrays;

public class BackPack {
    int[][] dp;
    int backpackCapacity; // 背包容量
    int[] weights; // 各物品重量
    int[] values; // 各物品价值
    /** * 初始化背包 * * @param backpackCapacity 背包容量
     * @param weights 各个物品的重量
     * @param values 各个物品的价值
     */ public BackPack(int backpackCapacity, int[] weights, int[] values) {
        int objectNum = weights.length;
        int[][] dp = new int[objectNum + 1][backpackCapacity + 1];
        this.dp = dp;
        this.backpackCapacity = backpackCapacity;
        this.weights = weights;
        this.values = values;
        // 初始化所有dp所有元素为0
        for (int[] row : dp) {
            Arrays.fill(row, 0);
        } this.getMaxValue(objectNum);
    }
    /**
     * 获取前n个物品组合，在完整背包容量下组合的最大价值 * * @param objectNum 物品总数
     * @return 返回最大价值
     */ public int getMaxValue(int objectNum) {
        for (int row = 1; row < objectNum + 1; row++) {
            for (int col = 1; col < this.backpackCapacity + 1; col++) {
                // dp[row][col] 的实际意义 - 前row个物品在背包容量为col下组合的价值
                int objectIndex = row - 1;
                if (this.weights[objectIndex] > col) {
                    // 容量为col的情况下，只装row号物品 装不下
                    dp[row][col] = dp[row - 1][col];
                } else {
                    // 容量为col的情况下，只装row号物品 装得下
                    // 比较以下两种组合对应的最大价值 // 组合一：row号物品价值 + 在背包容量col装进row号后的剩余空间中，前row-1个物品的最大价值 int total_addRowObj = values[objectIndex] + dp[row - 1][col - weights[objectIndex]];
                    // 组合二：不装row号物品，考虑前row-1个物品在背包容量col情况下组合的最大价值
                    int total_notAddRowObj = dp[row - 1][col];
                    int total_addRowObj=0;
                    dp[row][col] = Math.max(total_addRowObj, total_notAddRowObj);
                } } } return dp[objectNum][this.backpackCapacity];
    }
    /**
     * 回溯，返回背包容量为 backpackCapacity 情况下，前objectNum个物品的最大价值对应的物品组合 * * @param objectNum 物品总数
     * @return 最佳组合对应的物品编号（物品编号从1开始）
     */ public ArrayList<Integer> getBestCombination(int objectNum) {
        int row = objectNum, col = backpackCapacity;
        ArrayList<Integer> objectIndexes = new ArrayList<>();
        while (row > 0 && col > 0) {
            int objectIndex = row - 1; // row号物品在weights中下标为row-1，使用objectIndex表示
            if (dp[row][col] > dp[row - 1][col]) {
                // 最佳组合中包含row号物品
                objectIndexes.add(row);
                row--;
                col = col - weights[objectIndex];
            } else {
                // 上移一行
                row--;
            } } return objectIndexes;
    }
    public static void main(String[] args) {
        // 题干部分
        int backpackCapacity = 8;
        int[] weights = {2, 3, 4, 5};
        int[] values = {3, 4, 5, 6};
        int objectNum = weights.length;
        BackPack b = new BackPack(backpackCapacity, weights, values);
        // 测试数据
        int targetBackpackCapacity = backpackCapacity -1;
        int targetObjectNum = objectNum -1;
        int maxValue = b.getMaxValue(targetObjectNum);
        ArrayList<Integer> objectIndexes = b.getBestCombination(targetObjectNum);
        System.out.println(
                String.format(
                        "背包容量为: %dn物品数量为: %dn最大价值为: %dn最大价值对应的最佳组合为: %s"
                        , targetBackpackCapacity
                        , targetObjectNum
                        , maxValue
                        , objectIndexes
                )
        ); }
}
