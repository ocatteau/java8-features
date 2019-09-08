package fr.stateofmind.lambda;

import org.junit.Test;

import java.util.*;

import static org.fest.assertions.Assertions.assertThat;

public class TripletTest {

    @Test
    public void compareTriplets() throws Exception {
        List<Integer> a = Arrays.asList(1, 6, 9);
        List<Integer> b = Arrays.asList(1, 7, 5);

        List<Integer> result = Arrays.asList(0, 0);

        for (int i = 0; i < a.size(); i++) {
            if (a.get(i) > b.get(i)) {
                result.set(0, result.get(0) + 1);
            }
            if (a.get(i) < b.get(i)) {
                result.set(1, result.get(1) + 1);
            }
        }

        System.out.println("result = " + result);
    }

    @Test
    public void sumLongs() throws Exception {
        long[] ar = new long[]{1L, 4L, 7L};

        long sum = Arrays.stream(ar).sum();
        assertThat(sum).isEqualTo(12);
    }

    @Test
    public void diagonalDifference() {
        int[][] arr = new int[][]{
                new int[]{1, 2, 3},
                new int[]{4, 5, 6},
                new int[]{10, 2, 3}};

        int d1 = 0;
        int d2 = 0;
        for (int i = 0; i < arr.length; i++) {
            d1 += arr[i][i];
            d2 += arr[arr.length - i - 1][i];
        }
        assertThat(Math.abs(d1 - d2)).isEqualTo(9);
    }


    @Test
    public void plusMinus() throws Exception {
        int[] arr = new int[]{1, 1, 1, 0, -1, -1};

        double positive = 0;
        double negative = 0;
        for (int value : arr) {
            if (value > 0) {
                positive++;
            } else if (value < 0) {
                negative++;
            }
        }
        System.out.printf("%.6f\n", positive / arr.length);
        System.out.printf("%.6f\n", negative / arr.length);
        System.out.printf("%.6f\n", (arr.length - negative - positive) / arr.length);
    }


    @Test
    public void staircase() throws Exception {
        for (int i = 0; i < 5; i++) {
            char[] line = new char[5];
            Arrays.fill(line, '#');
            for (int j = 0; j < 5 - i - 1; j++) {
                line[j] = ' ';
            }
            System.out.println(line);
        }
    }


    @Test
    public void miniMaxSum() throws Exception {
        int[] arr = new int[]{5, 1, 6, 9, 3};
        int min = arr[0];
        int max = arr[0];
        long sum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
            sum += arr[i];
        }
        long minSum = sum - max;
        long maxSum = sum - min;
        System.out.println(minSum + " " + maxSum);
    }



    @Test
    public void pouet() throws Exception {
        final String str = "aaabbbccca";
        final int maxOccur = countOccurMax(str);
        System.out.println("maxOccur = " + maxOccur);
    }

    private int countOccurMax(String str) {
        int maxOccur = 0;
        Map<String, Integer> occurMap = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            String letter = String.valueOf(str.charAt(i));
            if (!occurMap.containsKey(letter)) {
                occurMap.put(letter, 1);
                if (maxOccur <= 1) {
                    maxOccur = 1;
                }
            } else {
                int nbOccur = occurMap.get(letter) + 1;
                occurMap.put(letter, nbOccur);
                if (maxOccur <= nbOccur) {
                    maxOccur = nbOccur;
                }
            }
        }
        return maxOccur;
    }


    @Test
    public void pouet2() throws Exception {
        long s = 12L; // changez cette valeur pour tester d'autres cas
        Monnaie m = monnaieOptimale(s);

        System.out.println("Pièce(s)   2€ : " + m.piece2);
        System.out.println("Billet(s)  5€ : " + m.billet5);
        System.out.println("Billet(s) 10€ : " + m.billet10);

        long resultat = m.piece2 * 2 + m.billet5 * 5 + m.billet10 * 10;
        System.out.println("\nMonnaie rendue = " + resultat);
    }

    private Monnaie monnaieOptimale(long s) {
        long nb10 = s / 10;
        long reste10 = s % 10;


        long nb5 = reste10 /  5;
        long reste5 = reste10 % 5;

        if (nb5 > 0 && (reste5 == 1 || reste5 == 3)) {
            nb5--;
            reste5 += 5;
        }

        long nb2 = reste5 / 2;
        long modulo2 = reste5 % 2;

        if (modulo2 != 0) {
            return null;
        }

        Monnaie monnaie = new Monnaie();
        monnaie.piece2 = nb2;
        monnaie.billet5 = nb5;
        monnaie.billet10 = nb10;
        return monnaie;
    }

    private Monnaie monnaieOptimale00(long s) {
        long div10 = s / 10;
        System.out.println("div10 = " + div10);
        long modulo10 = s % 10;
        System.out.println("modulo10 = " + modulo10);

        long reste1 = s - div10 * 10;
        System.out.println("reste = " + reste1);

        long div5 = reste1 /  5;
        System.out.println("div5 = " + div5);

        long modulo5 = reste1 % 5;
        System.out.println("modulo5 = " + modulo5);

        long reste2 = reste1 - div5 * 5;
        System.out.println("reste2 = " + reste2);

        long div2 = reste2 / 2;
        System.out.println("div2 = " + div2);
        long modulo2 = reste2 % 2;
        System.out.println("modulo2 = " + modulo2);


        Monnaie monnaie = new Monnaie();
        monnaie.piece2 = 0;
        monnaie.billet5 = 0;
        monnaie.billet10 = 0;
        return monnaie;
    }

    private class Monnaie {
        public long piece2;
        public long billet5;
        public long billet10;
    }


    @Test
    public void findMaxHeight() throws Exception {
        final ITabChecker testTab = new TabChecker(6, 4,
                new boolean[][]{
                        new boolean[]{false, true, false, false, false, false},
                        new boolean[]{false, true, false, false, false, true},
                        new boolean[]{false, true, false, false, false, true},
                        new boolean[]{true, true, false, true, true, true}
                }
        );

        System.out.println("testTab.isCheckedCell(0,3) = " + testTab.isCheckedCell(2, 1));
        final int maxHeight = findMaxHeight(testTab);
        System.out.println("Hauteur max : " + maxHeight);
    }

    private int findMaxHeight(ITabChecker testTab) {
        int maxHeigh = 0;
        for (int x = 0; x < testTab.getWidth(); x++) {
            int currentHeigth = 0;
            int y = testTab.getHeight() - 1;
            while (y >= 0 && testTab.isCheckedCell(x, y)) {
                currentHeigth++;
                y--;
            }
            maxHeigh = Math.max(maxHeigh, currentHeigth);
        }
        return maxHeigh;
    }

    interface ITabChecker {
        public int getWidth();

        public int getHeight();

        public boolean isCheckedCell(final int x, final int y);
    }

    private class TabChecker implements ITabChecker {
        private final int width;
        private final int height;
        private final boolean[][] booleans;

        public TabChecker(int width, int height, boolean[][] booleans) {
            this.width = width;
            this.height = height;
            this.booleans = booleans;
        }

        @Override
        public int getWidth() {
            return width;
        }

        @Override
        public int getHeight() {
            return height;
        }

        @Override
        public boolean isCheckedCell(int x, int y) {
            return booleans[y][x];
        }
    }
}