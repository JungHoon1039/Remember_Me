package ssafy10.seoul8.pjh;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class quizPage extends JFrame {
    private JLabel player, quiz, answer;
    private JPanel panel;
    private JButton check, collect, wrong, next;
    JFrame frm = startPage.frm;
    String text;

    // event 등록하는 함수
    private ActionListener action = new action();

    class action implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == next) {

            }
        }
    }

    public quizPage() {
        GridBagConstraints[] gbc = new GridBagConstraints[7]; // 컴포넌트
        GridBagLayout gbl = new GridBagLayout();
        panel = new JPanel();
        panel.setLayout(gbl);

        // 자식 컴포넌트
        player = new JLabel("플레이어");
        gbc[0] = new GridBagConstraints();
        gbc[0].gridx = 0;
        gbc[0].gridy = 0;
        gbc[0].gridwidth = 2;
        panel.add(player, gbc[0]);

        quiz = new JLabel("문제");
        gbc[1] = new GridBagConstraints();
        gbc[1].gridx = 0;
        gbc[1].gridy = 1;
        gbc[1].gridwidth = 2;
        panel.add(quiz, gbc[1]);

        answer = new JLabel("내용");
        gbc[2] = new GridBagConstraints();
        gbc[2].gridx = 0;
        gbc[2].gridy = 2;
        gbc[2].gridwidth = 2;
        panel.add(answer, gbc[2]);

        check = new JButton("확인");
        check.addActionListener(action);
        gbc[3] = new GridBagConstraints();
        gbc[3].gridx = 0;
        gbc[3].gridy = 3;
        gbc[3].gridwidth = 2;
        panel.add(check, gbc[3]);

        collect = new JButton("정답");
        collect.addActionListener(action);
        gbc[4] = new GridBagConstraints();
        gbc[4].gridx = 0;
        gbc[4].gridy = 4;
        panel.add(collect, gbc[4]);

        wrong = new JButton("오답");
        wrong.addActionListener(action);
        gbc[5] = new GridBagConstraints();
        gbc[5].gridx = 1;
        gbc[5].gridy = 4;
        panel.add(wrong, gbc[5]);

        next = new JButton("다음");
        next.addActionListener(action);
        gbc[6] = new GridBagConstraints();
        gbc[6].gridx = 0;
        gbc[6].gridy = 5;
        gbc[6].gridwidth = 2;
        panel.add(next, gbc[6]);

        frm.setContentPane(panel);
        frm.setVisible(true);
    }

}