package client;

import entity.Teacher;
import util.JacksonUtil;

import java.io.*;
import java.net.Socket;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * @author dailiwen
 * @date 2018/06/19
 */
public class Client {
	private static BufferedReader bufferedReader;
	private static BufferedWriter bufferedWriter;


	public static void main(String[] args) throws IOException {
		Socket socket = new Socket("127.0.0.1", 8080);
		Scanner scanner = new Scanner(System.in);

		bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

		while (true) {
			System.out.println();
			System.out.println(bufferedReader.readLine());//此时str就保存了一行字符串
			System.out.println(bufferedReader.readLine());//此时str就保存了一行字符串
			System.out.println(bufferedReader.readLine());//此时str就保存了一行字符串
			System.out.println(bufferedReader.readLine());//此时str就保存了一行字符串

			String command = scanner.next();

			bufferedWriter.write(command + "\n");
			bufferedWriter.flush();

			String json = bufferedReader.readLine();
			Map<String, Object> result = JacksonUtil.jsonToMap(json);
			switch ((Integer) result.get("type")) {
				case 1: {
					List<Map<String, Object>> teachers = (List<Map<String, Object>>) result.get("result");
					System.out.println("下面是全教职工信息");
					//输出15列，左对齐(-号表示左对齐)
					System.out.printf("%-15s","id");
					System.out.printf("%-10s","name");
					System.out.printf("%-10s","sex");
					System.out.printf("%-20s","birthday");
					System.out.printf("%-10s","salary");
					System.out.printf("%-10s","college");
					System.out.printf("%-10s","majoy");
					System.out.println();

					for (int i = 0; i < teachers.size(); i++) {
						Teacher teacher = (Teacher) JacksonUtil.map2Object(teachers.get(i), Teacher.class);
						System.out.printf("%-15s",teacher.getId());
						System.out.printf("%-10s",teacher.getName());
						System.out.printf("%-10s",teacher.getSex());
						System.out.printf("%-20s",teacher.getBirthday());
						System.out.printf("%-10s",teacher.getSalary());
						System.out.printf("%-10s",teacher.getCollege());
						System.out.printf("%-10s",teacher.getMajoy());
						System.out.println();
					}
					System.out.println(bufferedReader.readLine());
					System.out.println();
					break;
				}
				case 2: {
					for (int i = 0; i < 7; i++) {
						System.out.print(bufferedReader.readLine());
						String insert = scanner.next();
						bufferedWriter.write(insert + "\n");
						bufferedWriter.flush();
					}
					System.out.println(bufferedReader.readLine());
					break;
				}
				case 3: {
					for (int i = 0; i < 7; i++) {
						System.out.print(bufferedReader.readLine());
						String update = scanner.next();
						bufferedWriter.write(update + "\n");
						bufferedWriter.flush();
					}
					System.out.println(bufferedReader.readLine());
					break;
				}
				case 4: {
					System.out.print(result.get("result"));
					String id = scanner.next();
					bufferedWriter.write(id + "\n");
					bufferedWriter.flush();
					System.out.println(bufferedReader.readLine());
					break;
				}
				default: {
					System.out.println(result.get("result"));
					break;
				}
			}

		}
	}
}
