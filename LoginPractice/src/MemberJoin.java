import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MemberJoin {
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		//���ϻ����� ��ġ ����
		File file = new File("C:\\song\\MemberDB.txt");
		try {
			//���� �ۼ�
			FileWriter filewriter = new FileWriter(file, true);
			if(file.isFile() && file.canWrite()) {
				System.out.println("ȸ�������� ���� ID�� �Է��ϼ���.");
				System.out.println("ID �Է� : ");
				//��ĳ�ʷ� �Է¹ޱ�
				filewriter.append(scan.nextLine());
				filewriter.append("\t");
				System.out.println("��й�ȣ �Է� : ");
				filewriter.append(scan.nextLine());
				filewriter.append("\r"); //���๮��
				System.out.println("ȸ�������� �Ϸ�Ǿ����ϴ�.");
			}
			filewriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}