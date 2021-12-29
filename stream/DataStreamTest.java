package stream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataStreamTest {

	public static void main(String[] args) {

		long millisecond = 0;
		
		try(BufferedOutputStream fos = new BufferedOutputStream(new FileOutputStream("data.txt"));	//FileOutputStream�� ��� ���� ��Ʈ���� ���� Ŭ�����̴�. 
																									//��� ���� ��Ʈ���� FileOutputStream�Ǵ�FileInputStream�� ��� ����.
		//Buffered��Ʈ���� ���������� 8,192byte ũ���� �迭�� ������ �ִ�.
		//���۸�(buffering)����� �����Ͽ� �ش� ũ���� �迭�� ä���� ������� �����ϹǷ� �� ����Ʈ ������ ���� ������ �а� ���� �� ���� ������.
				
			DataOutputStream dos = new DataOutputStream(fos)) { 
			/* FileReader,FileWriter �׸��� FileInputStream�� FileOutputStream�� ���ڳ� ����Ʈ �������� ���ڸ� �а� ����.
			 * ���� �о�� ���ڸ� ���ڳ� �ڽ��� ���ϴ� �ڷ������� �ٲ���� �Ѵ�.
			 * ������ DataOutputStrem�� DataInputStream�� �а� ���� �ٷ� ����ȯ�� ���ش�.
			 */
			
			millisecond = System.currentTimeMillis();				
		
			//DataOutputStream���� �ڷ��� ���� �޼��尡 �ִ�. �ش� �ڷ����� �´� ũ�⿡ ���� �Ű������� ������n����Ʈ�� ���Ͽ� ����.
			dos.writeByte(100);	//Byte�ڷ������� ���Ͽ� ����. ũ��� 1byte. ������ ~-128���� 127�̴�.
			dos.writeByte(128);	//���� ������ �ʰ��ϴ� ���� ���� ��� �����÷ο� �߻�.
			dos.writeChar('A');	//Char�ڷ������� ���Ͽ� ����. ũ��� 2byte.
			dos.writeInt(10);	//Int�ڷ������� ���Ͽ� ����.
			dos.writeFloat(3.14f);
			dos.writeUTF("Test");	//StringŸ��. UTF-8�������� �ڵ��� ���ڿ��� ����.
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		try(BufferedInputStream fis = new BufferedInputStream(new FileInputStream("data.txt"));
				DataInputStream dis = new DataInputStream(fis)) {
		
			System.out.println(dis.readByte());
			System.out.println(dis.readByte());
			System.out.println(dis.readChar());
			System.out.println(dis.readInt());
			System.out.println(dis.readFloat());
			System.out.println(dis.readUTF());
			
			millisecond = System.currentTimeMillis() - millisecond;
			
		}catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Time: " + millisecond);
	}
}

