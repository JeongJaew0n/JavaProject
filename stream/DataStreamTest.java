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
		
		try(BufferedOutputStream fos = new BufferedOutputStream(new FileOutputStream("data.txt"));	//FileOutputStream은 모든 보조 스트림의 상위 클래스이다. 
																									//모든 보조 스트림은 FileOutputStream또는FileInputStream을 상속 받음.
		//Buffered스트림은 내부적으로 8,192byte 크기의 배열을 가지고 있다.
		//버퍼링(buffering)기능을 제공하여 해당 크기의 배열에 채워서 입출력을 실행하므로 한 바이트 단위나 문자 단위로 읽고 쓰는 것 보다 빠르다.
				
			DataOutputStream dos = new DataOutputStream(fos)) { 
			/* FileReader,FileWriter 그리고 FileInputStream과 FileOutputStream은 문자나 바이트 형식으로 문자를 읽고 쓴다.
			 * 따라서 읽어온 문자를 숫자나 자신이 원하는 자료형으로 바꿔줘야 한다.
			 * 하지만 DataOutputStrem과 DataInputStream은 읽고 쓸때 바로 형변환을 해준다.
			 */
			
			millisecond = System.currentTimeMillis();				
		
			//DataOutputStream에는 자료형 별로 메서드가 있다. 해당 자료형에 맞는 크기에 따라 매개변수의 마지막n바이트를 파일에 쓴다.
			dos.writeByte(100);	//Byte자료형으로 파일에 쓴다. 크기는 1byte. 범위는 ~-128부터 127이다.
			dos.writeByte(128);	//따라서 범위를 초과하는 값을 넣을 경우 오버플로우 발생.
			dos.writeChar('A');	//Char자료형으로 파일에 쓴다. 크기는 2byte.
			dos.writeInt(10);	//Int자료형으로 파일에 쓴다.
			dos.writeFloat(3.14f);
			dos.writeUTF("Test");	//String타입. UTF-8형식으로 코딩된 문자열을 쓴다.
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

