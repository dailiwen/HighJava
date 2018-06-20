package view;

import java.util.Scanner;

/**
 * @author dailiwen
 * @date 2018/05/20
 */

public class Main {
    public static void main(String[] args) throws Exception {
        UIConstructor uiConstructor = new UIConstructor();

        while(true) {
            int command = uiConstructor.menu();
            switch (command) {
                case 1:
                    uiConstructor.selectAllInfoView();
                    break;
                case 2:
                    uiConstructor.insertInfoView();
                    break;
                case 3:
                    uiConstructor.updataInfoView();
                    break;
                case 4:
                    uiConstructor.deleteInfoView();
                    break;
                default:
                    System.out.println("请输入正确的操作号");
                    break;
            }
            while (true) {
                System.out.print("敲击回车继续程序");
                Scanner scanner = new Scanner(System.in);
                String temp = scanner.nextLine();
                if ("".equals(temp)) {
                    System.out.println();
                    System.out.println();
                    System.out.println();
                    System.out.println();
                    System.out.println();
                    System.out.println();
                    break;
                }
            }
        }
    }
}
