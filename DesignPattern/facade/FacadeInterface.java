package facade;

public class FacadeInterface {

    private Ftp ftp;
    private Reader reader;
    private Writer writer;

    public FacadeInterface(Ftp ftp, Reader reader, Writer wrtier) {
        this.ftp = ftp;
        this.reader = reader;
        this.writer = wrtier;
    }

    public FacadeInterface(String host, int port, String path, String fileName) {
        this.ftp = new Ftp(host, port, path);
        this.reader = new Reader(fileName);
        this.writer = new Writer(fileName);
    }

    public void connect() {
        ftp.connect();
        ftp.moveDirectory();
        writer.fileConnect();
        reader.fileConnect();
    }

    public void disConnect() {
        ftp.disConnect();
        writer.fileDisconnect();
        reader.fileDisconnect();
    }

    public void read() {
        reader.fileRead();
    }

    public void write() {
        writer.write();
    }
}
