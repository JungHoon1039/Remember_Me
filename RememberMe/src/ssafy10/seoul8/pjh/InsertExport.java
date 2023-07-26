package ssafy10.seoul8.pjh;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class InsertExport {
    public static void main(String[] args) {
        Custom c = new Custom();
    }
}

class Custom extends JFrame {
    private JTextField field;
    private JLabel label, label2;
    private JPanel panel;
    private JButton button, button2;
    private ArrayList<String> list = new ArrayList<>();
    String text;
    private ActionListener ml = new ml();
    class ml implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == button) {
                text = String.valueOf(field.getText());
                list.add(text);
            } else if (e.getSource() == button2) {
                for (String c : list)
                    label2.setText(list.toString());
            }
        }

    }
    
    public Custom() {
        this.setTitle("RememberMe2");
        this.setSize(300, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        field = new JTextField(5);
        label = new JLabel("입력확인");
        label2 = new JLabel("출력확인");
        panel = new JPanel();
        button = new JButton("입력");
        button2 = new JButton("출력");
        field.setText("");
        button.addActionListener(ml);
        button2.addActionListener(ml);
        panel.add(label);
        panel.add(field);
        panel.add(button);
        panel.add(button2);
        panel.add(label2);
        
        this.add(panel);
        this.setVisible(true);
    }
}
