package ssafy10.seoul8.page;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ssafy10.seoul8.function.scoreBoard;
import ssafy10.seoul8.startframe.RememberMe;

public class resultPage extends JFrame {
    private JFrame frm = RememberMe.frm;
    private JLabel result;
    private JPanel panel;

    public resultPage() {
        GridBagConstraints[] gbc = new GridBagConstraints[1]; // 컴포넌트
        GridBagLayout gbl = new GridBagLayout();
        panel = new JPanel();
        panel.setLayout(gbl);

        // 자식 컴포넌트
        result = new JLabel("");
        gbc[0] = new GridBagConstraints();
        gbc[0].gridx = 0;
        gbc[0].gridy = 0;
        panel.add(result, gbc[0]);

        result.setText(scoreBoard.result(namePage.memberMap));

        frm.setContentPane(panel);
        frm.setVisible(true);
    }
}