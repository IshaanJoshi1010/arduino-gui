import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.fazecast.jSerialComm.SerialPort;

public class ArduinoGUI extends JFrame {
    private SerialPort serialPort;
    private JFrame frame;
    private JButton onButton;
    private JButton offButton;
    private JButton servoOnButton;
    private JButton servoOffButton;

    public ArduinoGUI(String port) {
        
        serialPort = SerialPort.getCommPort(port);
        serialPort.setBaudRate(9600);
        if (serialPort.openPort() == false) {
            JOptionPane.showMessageDialog(null, "Failed to open port");
            return;
        }

        // Create GUI
        frame = new JFrame("Arduino GUI");
        frame.setSize(300, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());//this shit is so good oml

        onButton = new JButton("Signal On");
        offButton = new JButton("Signal Off");
         servoOnButton = new JButton("Servo Counter");
         servoOffButton = new JButton("Servo Clockwise");

        onButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendCommand("A");
            }
        });

        offButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendCommand("a");
            }
        });
        servoOnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendCommand("S");
            }
        });
        servoOffButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendCommand("s");
            }
        });
        // Add buttons to the frame
        frame.add(servoOnButton);
        frame.add(servoOffButton);

        frame.add(onButton);
        frame.add(offButton);
        frame.setVisible(true);
    }

    private void sendCommand(String command) {
        if (serialPort.isOpen()) {
            serialPort.writeBytes(command.getBytes(), command.length());
        }
    }

   
}