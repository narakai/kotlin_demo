import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class HomeWork {
    private static class Work {
        public int firstValue;
        public int secondValue;
    }

    public static void main(String[] args) {
        int right = 0;
        int wrong = 0;
        int total = 1000;
        //加法
//        int min = 15;
//        int max = 49;
        //减法
        int min = 49;
        int max = 100;

        int min1 = 15;
        int max1 = 49;
        List<Work> wrongWorkList = new ArrayList<>();
        System.out.println("总共" + total + "道题， 答题开始...");
        for (int i = 0; i < total; i++) {
            Work work = new Work();
            work.firstValue = getRandom(min, max);
            work.secondValue = getRandom(min1, max1);
            int result = work.firstValue - work.secondValue;
            System.out.println();
            System.out.println("第" + (i + 1) + "道题：" + work.firstValue + " - " + work.secondValue + " = ?");
            Scanner input = new Scanner(System.in);
            try {
                int n = input.nextInt();
                if (n == result) {
                    right += 1;
                    System.out.println("✅: " + right + "道题");
                } else {
                    wrongWorkList.add(work);
                    wrong += 1;
                    System.out.println("❌: " + wrong + "道题");
                }
            } catch (Exception e) {
                i--;
                System.out.println("错误，需要输入数字");
            }
        }
        System.out.println("Miki 总得分✌️: " + 100 / total * right);


        if (wrongWorkList.size() > 0) {
            right = 0;
            wrong = 0;
            System.out.println();
            System.out.println("错误改正");
            for (int i = 0; i < wrongWorkList.size(); i++) {
                Work work = wrongWorkList.get(i);
                int result = work.firstValue - work.secondValue;
                System.out.println("第" + (i + 1) + "道错题🐰：" + work.firstValue + " + " + work.secondValue + " = ?");
                Scanner input = new Scanner(System.in);
                try {
                    int n = input.nextInt();
                    if (n == result) {
                        right += 1;
                        System.out.println("已做对✅: " + right + "道错题");
                    } else {
                        wrong += 1;
                        System.out.println("已做错❌: " + wrong + "道错题");
                    }
                } catch (Exception e) {
                    i--;
                    System.out.println("错误，需要输入数字");
                }
            }
        }

    }

    private static int getRandom(int min, int max) {
        Random random = new Random();
        return random.nextInt(max) % (max - min + 1) + min;
    }
}
