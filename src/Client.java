import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Quan Ly Nhan Vien Codegym");
            System.out.println("1. Them nhan vien");
            System.out.println("2. Duoi nhan vien");
            System.out.println("3. Hien thi doanh thu theo ten");
            System.out.println("4. Tim kiem nhan vien theo ten");
            System.out.println("5. Sap xep nhan vien theo ten");
            System.out.println("6. Sap xep nhan vien theo doanh thu");
            System.out.println("7. Hien thi tat ca nhan vien");
            System.out.println("8. Thoat ra");
            System.out.print("Moi ban lua chon: ");
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    System.out.println("1. Nhan vien dao tao");
                    System.out.println("2. Nhan vien tuyen sinh");
                    System.out.print("Chon di: ");
                    int choiceAdd = Integer.parseInt(sc.nextLine());
                    if (choiceAdd == 1) {
                        System.out.println("1. Nhan vien part time");
                        System.out.println("2. Nhan vien full time");
                        int choiceSubAdd = Integer.parseInt(sc.nextLine());
                        if (choiceSubAdd == 1)
                            QuanLyNhanVien.addNhanVien(1);
                        else QuanLyNhanVien.addNhanVien(2);
                    } else
                        QuanLyNhanVien.addNhanVien(3);
                    break;
                case 2:
                    System.out.println("1. Nhan vien dao tao");
                    System.out.println("2. Nhan vien tuyen sinh");
                    int choiceRemove = Integer.parseInt(sc.nextLine());
                    if (choiceRemove == 1)
                        QuanLyNhanVien.removeNhanVien(1);
                    else QuanLyNhanVien.removeNhanVien(2);
                    break;
                case 3:
                    QuanLyNhanVien.displaySalarybyName();
                    break;
                case 4:
                    QuanLyNhanVien.displayNhanVienByName();
                    break;
                case 5:
                    QuanLyNhanVien.sortNhanVienByName();
                    break;
                case 6:
                    QuanLyNhanVien.sortNhanVienByDoanhThu();
                    break;
                case 7:
                    QuanLyNhanVien.showNhanVien();
                    break;
                case 8:
                    System.exit(0);
            }
        }
    }
}
