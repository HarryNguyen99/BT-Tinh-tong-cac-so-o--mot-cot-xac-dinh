import java.util.Scanner;

public class Mail {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        boolean isValidChoice = false;
        boolean isValidNum = false;
        boolean isValidIndex = false;
        int row;
        int col;

        do {
            System.out.print("Nhập số lượng hàng: ");
            row = scanner.nextInt();
            System.out.print("Nhập số lượng cột: ");
            col = scanner.nextInt();
            if (row >= 0 && row <= 10 && col >= 0 && col <= 10) {
                isValidNum = true;
            } else {
                System.out.println("Đâu vao không hợp lệ. Tối thiểu là 0 và tối đa là 10");
            }
        } while (!isValidNum);

        double[][] demoArray = new double[row][col];
        do {
            System.out.println("1. Nhập phần tử");
            System.out.println("2. Ngẫu nhiên");
            System.out.print("Nhập sự lựa chọn: ");
            choice = scanner.nextInt();
            if (choice == 1 || choice == 2) {
                isValidChoice = true;
            } else {
                System.out.println("Lựa chọn không hợp lệ! Vui lòng chọn lại!");
            }
        } while (!isValidChoice);

        switch (choice) {
            case 1:
                SumColumn.addElement(demoArray);
                break;
            case 2:
                SumColumn.randomElement(demoArray);
                break;
        }
        System.out.println();
        System.out.println("Đây là mảng của bạn: ");
        SumColumn.displayArray(demoArray);

        int colIndex;
        do {
            System.out.print("Nhập chỉ mục của cột bạn muốn tóm tắt: ");
            colIndex = scanner.nextInt();
            if (colIndex >= 0 && colIndex <= demoArray[0].length) {
                isValidIndex = true;
            } else {
                System.out.println("Đâu vao không hợp lệ! Vui lòng nhập lại");
            }
        } while (!isValidIndex);
        double totalCol = SumColumn.sumColumn(demoArray,colIndex);
        System.out.printf("Tóm tắt cột %d Là %f", colIndex, totalCol);
        System.out.println();


        int rowIndex;
        isValidIndex = false;
        do {
            System.out.print("Nhập chỉ mục của hàng bạn muốn tóm tắt: ");
            rowIndex = scanner.nextInt();
            if (rowIndex >= 0 && rowIndex <= demoArray.length) {
                isValidIndex = true;
            } else {
                System.out.println("Đâu vao không hợp lệ! Vui lòng nhập lại");
            }
        } while (!isValidIndex);
        double totalRow = SumColumn.sumRow(demoArray,rowIndex);
        System.out.printf("Tóm tắt hàng %d là %f", rowIndex, totalRow);
        System.out.println();

    }
}
