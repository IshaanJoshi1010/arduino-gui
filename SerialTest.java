import com.fazecast.jSerialComm.SerialPort;

public class SerialTest {
    public static void main(String[] args) {
        SerialPort[] ports = SerialPort.getCommPorts();
        System.out.println("Available Serial Ports:");
        for (SerialPort port : ports) {
            System.out.println("Port: " + port.getSystemPortName());
            System.out.println(port.getSystemPortName());
        }
    }
}
