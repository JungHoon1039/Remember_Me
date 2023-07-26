package ssafy10.seoul8.pjh;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ssafy10.seoul8.pjh.Custom.ml;

public class RememberMe {
    public static void main(String[] args) {
        StartRememberMe rememberme = new StartRememberMe();
    }
}

class StartRememberMe extends JFrame {
    private JTextField field;
    private JLabel insert, result;
    private JPanel panel;
    private JButton button, button2;
    private ArrayList<String> list = new ArrayList<>();
    String text;
    private ActionListener action = new action();
    class action implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == button) {
                text = String.valueOf(field.getText());
                result.setText(text);
            }
        }

    }
    
    public StartRememberMe() {
        this.setTitle("RememberMe");
        this.setSize(300, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        field = new JTextField(5);
        insert = new JLabel("인원 수를 입력하세요!");
        result = new JLabel("0명");
        panel = new JPanel();
        button = new JButton("입력");
        field.setText("");
        button.addActionListener(action);
        panel.add(insert);
        panel.add(field);
        panel.add(button);
        panel.add(result);
        
        JLabel test = new JLabel("확인용");
        JPanel chk = new JPanel();
        chk.add(test);
        this.add(panel);
        this.add(chk);
        this.setVisible(true);
    }
}