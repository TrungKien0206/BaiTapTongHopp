package baitaptonghop;

import java.util.Scanner;

public class BaiTapTongHop {

    public static float[] importData(float[] arrays) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < arrays.length; i++) {
            System.out.print("Nhap vao phan tu cua mang " + (i + 1) + ": ");
            arrays[i] = scanner.nextFloat();
        }
        return arrays;
    }

    public static void printData(float[] arrays) {
        System.out.print("Cac phan tu cua mang: ");
        for (float element : arrays) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    public static float findMax2(float[] arrays) {
        float max1 = Float.MIN_VALUE;//
        float max2 = Float.MIN_VALUE;//

        for (float element : arrays) {
            if (element > max1) {
                max2 = max1;
                max1 = element;
            } else if (element > max2 && element < max1) {
                max2 = element;
            }
        }
        if (max2 == Float.MIN_VALUE) {
            System.out.println("k co so lon thu 2.");
        } else {
            System.out.println("So lon thu 2: " + max2);
        }
        return max2;
    }

    public static float[] deleteOddNumber(float[] arrays) {
        int count = 0;
        for (float element : arrays) {
            if (element % 2 != 0) {
                count++;
            }
        }

        float[] newArr = new float[arrays.length - count];
        int index = 0;
        for (float element : arrays) {
            if (element % 2 == 0) {
                newArr[index++] = element;
            }
        }
        return newArr;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhap so luong phan tu: ");
        int n = scanner.nextInt();

        float[] arrays = new float[n];
        arrays = importData(arrays);
        printData(arrays);

        findMax2(arrays);

        float[] newArr = deleteOddNumber(arrays);
        System.out.print("Mang sau khi xoa cac so le: ");
        printData(newArr);
    }
}
