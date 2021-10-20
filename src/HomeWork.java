import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class HomeWork {
    private static final int MIN = 1;
    private static final int MAX = 99;

    private static int right = 0;
    private static int wrong = 0;

    private static class Work {
        public int firstValue;
        public int secondValue;
    }

    public static void main(String[] args) {

        int total = 50;
        List<Work> wrongWorkList = new ArrayList<>();
        System.out.println("随机生成" + total + "道题， 答题开始...");

        for (int i = 0; i < total; i++) {
            try {
                doPlus(i, wrongWorkList);
            } catch (Exception e) {
                i--;
                System.out.println("错误，需要输入数字");
            }
        }

        System.out.println("Miki 总得分✌️: " + 100 / total * right);

        correct(wrongWorkList);

    }

    private static void doMinus(int i, List<Work> wrongWorkList) {
        Work work = new Work();
        work.firstValue = getRandom(MIN, MAX);
        work.secondValue = getRandom(work.firstValue + 1, MAX);
        int result = work.secondValue - work.firstValue;
        System.out.println();
        System.out.println("第" + (i + 1) + "道题：" + work.secondValue + " - " + work.firstValue + " = ?");
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        if (n == result) {
            right += 1;
            System.out.println("✅: " + right + "道题");
        } else {
            wrongWorkList.add(work);
            wrong += 1;
            System.out.println("❌: " + wrong + "道题");
        }
    }

    private static void doPlus(int i, List<Work> wrongWorkList) {
        Work work = new Work();
        work.firstValue = getRandom(MIN, MAX);
        work.secondValue = getRandom(MIN, 100 - work.firstValue);
        int result = work.secondValue + work.firstValue;
        System.out.println();
        System.out.println("第" + (i + 1) + "道题：" + work.secondValue + " + " + work.firstValue + " = ?");
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        if (n == result) {
            right += 1;
            System.out.println("✅: " + right + "道题");
        } else {
            wrongWorkList.add(work);
            wrong += 1;
            System.out.println("❌: " + wrong + "道题");
        }
    }

    private static void correct(List<Work> wrongWorkList) {
        int right;
        int wrong;
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
