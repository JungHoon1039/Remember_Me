package ssafy10.seoul8.pjh;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class memberPage extends JFrame {
    static int member = 0;
    private JTextField field;
    private JLabel insert, result;
    private JPanel panel;
    private JButton button, next;
    JFrame frm = RememberMe.frm;
    String text;

    // event 등록하는 함수
    private ActionListener action = new action();

    class action implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == button) {
                text = String.valueOf(field.getText());
                if (text.equals("1") || text.equals("2") || text.equals("3") || text.equals("4") || text.equals("5")) {
                    result.setText("현재 참여 인원 : " + text + "명");
                    member = Integer.parseInt(text);
                } else {
                    result.setText("1~5 만 입력 가능합니다");
                }
            } else if (e.getSource() == next) {
                if (member != 0) {
                    new namePage();
                } else {
                    result.setText("한명 이상 등록 해 주세요");
                }
            }
        }
    }

    public memberPage() {
        GridBagConstraints[] gbc = new GridBagConstraints[5]; // 컴포넌트
        GridBagLayout gbl = new GridBagLayout();
        panel = new JPanel();
        panel.setLayout(gbl);

        // 자식 컴포넌트
        insert = new JLabel("인원 수를 입력하세요");
        gbc[0] = new GridBagConstraints();
        gbc[0].gridx = 0;
        gbc[0].gridy = 0;
        gbc[0].gridwidth = 2;
        panel.add(insert, gbc[0]);

        field = new JTextField(5);
        field.setText("");
        gbc[1] = new GridBagConstraints();
        gbc[1].gridx = 0;
        gbc[1].gridy = 1;
        panel.add(field, gbc[1]);

        button = new JButton("입력");
        button.addActionListener(action);
        gbc[2] = new GridBagConstraints();
        gbc[2].gridx = 1;
        gbc[2].gridy = 1;
        panel.add(button, gbc[2]);

        result = new JLabel("현재 참여 인원 : 0명");
        gbc[3] = new GridBagConstraints();
        gbc[3].gridx = 0;
        gbc[3].gridy = 2;
        gbc[3].gridwidth = 2;
        panel.add(result, gbc[3]);

        next = new JButton("다음");
        next.addActionListener(action);
        gbc[4] = new GridBagConstraints();
        gbc[4].gridx = 0;
        gbc[4].gridy = 3;
        gbc[4].gridwidth = 2;
        panel.add(next, gbc[4]);

        frm.setContentPane(panel);
        frm.setVisible(true);
    }

}
