package ssafy10.seoul8.pjh;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class namePage extends JFrame {
    private JFrame frm = RememberMe.frm;
    public static Map<String, Integer> memberMap = new HashMap<>();
    private JTextField field;
    private JLabel insert, result;
    private JPanel panel;
    private JButton button, next;
    private String text;
    private int cnt = 1;

    // event 등록하는 함수
    private ActionListener action = new action();

    class action implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == button) {
                if (cnt <= memberPage.member) {
                    text = String.valueOf(field.getText());
                    if (memberMap.containsKey(text)) {
                        result.setText("동일한 이름은 입력 불가");
                    } else {
                        memberMap.put(text, 0);
                        result.setText("플레이어 " + cnt++ + " 등록 완료");
                        if (cnt <= memberPage.member) {
                            insert.setText("플레이어 " + cnt + " 이름을 입력하세요");
                        } else {
                            insert.setText("모든 플레이어 등록 완료");
                        }
                    }
                } else {
                    result.setText("모든 플레이어가 등록 되었습니다");
                }
            } else if (e.getSource() == next) {
                if (memberMap.size() == memberPage.member) {
                    new questionPage();
                } else {
                    result.setText("등록 되지 않은 플레이어가 있습니다");
                }
            }
        }
    }

    public namePage() {
        GridBagConstraints[] gbc = new GridBagConstraints[5]; // 컴포넌트
        GridBagLayout gbl = new GridBagLayout();
        panel = new JPanel();
        panel.setLayout(gbl);

        // 자식 컴포넌트
        insert = new JLabel("플레이어 " + cnt + " 이름을 입력하세요");
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

        result = new JLabel("");
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