package facade;

public class FacadeMain {
//
    public static void main(String[] args) {

        /* facade패턴을 사용하지 않았을 경우 */
        Ftp ftpClient = new Ftp("www.foo.co.kr",22,"/home/etc");
        ftpClient.connect();
        ftpClient.connect();

        Writer writer = new Writer("text.tmp");
        writer.fileConnect();
        writer.write();;

        Reader reader = new Reader("text.tmp");
        reader.fileConnect();
        reader.fileRead();

        ftpClient.disConnect();
        reader.fileDisconnect();
        writer.fileDisconnect();

        FacadeInterface stpClient = new FacadeInterface("hahaha.com",22,"home/yami","super.txt");

        stpClient.connect();
        stpClient.read();
        stpClient.write();

        stpClient.disConnect();
    }
}
