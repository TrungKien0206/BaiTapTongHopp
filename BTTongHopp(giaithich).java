package bttonghopp;

import java.util.Scanner; //lấy dữ liệu đầu vào từ người dùng

public class BTTongHopp {

    public static float[] importData(float[] arrays) {
        Scanner scanner = new Scanner(System.in);//đọc dữ liệu đầu vào từ bàn phím
        for (int i = 0; i < arrays.length; i++) { //Vòng lặp for từ 0 đến "n-1" giúp nhập dữ liệu cho từng phần tử trong mảng 
            System.out.print("Nhap vao phan tu cua mang " + (i + 1) + ": "); //Hiển thị lời nhắc
            arrays[i] = scanner.nextFloat();//đọc giá trị số thực và gán vào phần tử thứ "i:
        }
        return arrays;//Trả về arrays sau khi các phần tử đã được nhập 
    }

    public static void printData(float[] arrays) {
        System.out.print("Cac phan tu cua mang: ");
        for (float element : arrays) { //duyệt qua từng phần tử trong mảng 
            System.out.print(element + " ");//in ra phần tử cách nhau bởi phím space:))
        }
        System.out.println();//Xuống dòng 
    }

    public static float findMax2(float[] arrays) { //Khai báo phương thức findMax2 để tìm giá trị lớn thứ 2 trong mảng
        float max1 = Float.MIN_VALUE;//lưu giá trị lớn nhất
        float max2 = Float.MIN_VALUE;//lưu giá trị lớn thứ hai
        //Ban đầu cả hai biến này được gán giá trị nhỏ nhất có thể của kiểu float
        for (float element : arrays) {
            if (element > max1) { //Nếu element lớn hơn max1 
                max2 = max1;      //cho max2= max1
                max1 = element;   // và max1=element
            } else if (element > max2 && element < max1) { //Nếu element hiện tại >max2 but <max1
                max2 = element; // thì max2=element
            }
        }
        if (max2 == Float.MIN_VALUE) {//kiểm tra max2 có giữ giá trị ban đầu hay ko 
            //nếu max2 bằng "Float.MIN_VALUE" thì có ngĩa là ko có số lớn thứ 2trong mảng
            System.out.println("k co so lon thu 2.");//Nếu điều kiện trong if là đúng chương trình sẽ in ra thông báo "k co so lon thu 2."
            //Nếu max2 không bằng Float.MIN_VALUE, điều này có nghĩa là một giá trị lớn thứ hai đã được tìm thấy trong mảng.
        } else {
            System.out.println("So lon thu 2: " + max2);
        }
        return max2;
    }

    public static float[] deleteOddNumber(float[] arrays) {
        int count = 0;//để đếm số lượng phần tử lẻ trong mảng.
        for (float element : arrays) {//để duyệt qua từng phần tử trong mảng.
            if (element % 2 != 0) {//Nếu phần tử hiện tại là số lẻ (chia cho 2 dư 1), tăng biến dem lên 1.
                count++;
            }
        }

        float[] newArr = new float[arrays.length - count];//với kích thước bằng số phần tử chẵn (bằng kích thước ban đầu trừ đi số phần tử lẻ)
        int index = 0;//để theo dõi vị trí cần chèn phần tử vào mảng mới.
        for (float element : arrays) {//Lặp lại qua các phần tử trong mảng gốc.
            if (element % 2 == 0) {//Nếu phần tử hiện tại là số chẵn, thêm nó vào mangMoi và tăng index lên 1.
                newArr[index++] = element;
            }
        }
        return newArr;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhap so luong phan tu: ");
        int n = scanner.nextInt();//Đọc số nguyên n từ người dùng

        float[] arrays = new float[n];
        arrays = importData(arrays);
        // Câu lệnh này cho phép cập nhật dữ liệu cho mảng arrays bằng cách gọi phương thức importData. Kết quả là, mảng arrays sau khi thực thi câu lệnh sẽ chứa các giá trị mới mà người dùng đã nhập vào.
        printData(arrays);

        findMax2(arrays);

        float[] newArr = deleteOddNumber(arrays);
        System.out.print("Mang sau khi xoa cac so le: ");
        printData(newArr);
    }
}
