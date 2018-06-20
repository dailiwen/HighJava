package server;

import dao.TeacherDao;
import util.JacksonUtil;
import view.UIConstructor;

import java.io.*;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

/**
 * @author dailiwen
 * @date 2018/06/19
 */
public class SocketHandler implements Runnable{

	private Socket socket;
	private BufferedWriter bufferedWriter;
	private BufferedReader bufferedReader;
	private UIConstructor uiConstructor = new UIConstructor();

	public SocketHandler(Socket socket) throws IOException {
		this.socket = socket;

		this.bufferedReader = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
		this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(this.socket.getOutputStream()));
	}

	@Override
	public void run() {
		while (true) {
			try {
				System.out.println("-------向客户端展示操作目录列表-------");
				bufferedWriter.write(uiConstructor.menu());
				bufferedWriter.flush();

				int command = Integer.parseInt(this.bufferedReader.readLine());
				System.out.println("接收客户端选择类型：" + command);

				switch (command) {
					case 1: {
						bufferedWriter.write(uiConstructor.selectAllInfoView() + "\n");
						bufferedWriter.flush();
						bufferedWriter.write("查询成功" + "\n");
						bufferedWriter.flush();
						break;
					}
					case 2:
						uiConstructor.insertInfoView(bufferedReader, bufferedWriter);
						break;
					case 3:
						uiConstructor.updataInfoView(bufferedReader, bufferedWriter);
						break;
					case 4: {
						uiConstructor.deleteInfoView(bufferedReader, bufferedWriter);
						break;
					}
					default:
						Map<String, Object> msg = new HashMap<>();
						msg.put("type", 5);
						msg.put("result", "请输入正确的操作序号");
						bufferedWriter.write(JacksonUtil.objectToJson(msg) + "\n");
						bufferedWriter.flush();
						break;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
