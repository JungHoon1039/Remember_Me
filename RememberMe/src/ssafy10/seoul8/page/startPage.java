package ssafy10.seoul8.page;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ssafy10.seoul8.startframe.RememberMe;

public class startPage extends JFrame {
    private JFrame frm = RememberMe.frm;
    private JLabel insert;
    private JPanel panel;
    private JButton next;

    // event 등록하는 함수
    private ActionListener action = new action();

    class action implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == next) {
                new memberPage();
            }
        }
    }

    public startPage() {
        GridBagConstraints[] gbc = new GridBagConstraints[2]; // 컴포넌트
        GridBagLayout gbl = new GridBagLayout();
        panel = new JPanel();
        panel.setLayout(gbl);

        // 자식 컴포넌트
        insert = new JLabel("Remember Me");
        gbc[0] = new GridBagConstraints();
        gbc[0].gridx = 0;
        gbc[0].gridy = 0;
        panel.add(insert, gbc[0]);

        next = new JButton("시작");
        next.addActionListener(action);
        gbc[1] = new GridBagConstraints();
        gbc[1].gridx = 0;
        gbc[1].gridy = 1;
        panel.add(next, gbc[1]);

        frm.setContentPane(panel);
        frm.setVisible(true);
    }
}
