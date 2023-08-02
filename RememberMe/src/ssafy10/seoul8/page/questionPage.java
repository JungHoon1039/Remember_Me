package ssafy10.seoul8.page;

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

import ssafy10.seoul8.function.answerCrawling;
import ssafy10.seoul8.startframe.RememberMe;

public class questionPage extends JFrame {
    public static Map<String, String> questionMap = new HashMap<>();
    private JFrame frm = RememberMe.frm;
    private JTextField field;
    private JLabel insert, result;
    private JPanel panel;
    private JButton button, next;

    // event 등록하는 함수
    private ActionListener action = new action();

    class action implements ActionListener {
        private String text;
        private int cnt = 0;

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == button) {
                text = String.valueOf(field.getText());
                if (questionMap.containsKey(text)) {
                    result.setText("동일한 문제는 입력 불가");
                } else {
                    questionMap.put(text, answerCrawling.searchGoogle(text));
                    result.setText("문제 개수 : " + ++cnt + "개");
                }
            } else if (e.getSource() == next) {
                if (cnt != 0) {
                    new quizPage();
                } else {
                    result.setText("문제가 0개 입니다");
                }
            }
        }
    }

    public questionPage() {
        GridBagConstraints[] gbc = new GridBagConstraints[5]; // 컴포넌트
        GridBagLayout gbl = new GridBagLayout();
        panel = new JPanel();
        panel.setLayout(gbl);

        // 자식 컴포넌트
        insert = new JLabel("단어를 입력하세요");
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

        result = new JLabel("문제 개수 : 0개");
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