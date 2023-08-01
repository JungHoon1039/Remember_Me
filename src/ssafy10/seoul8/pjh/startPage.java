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

public class startPage extends JFrame {
    static int member = 0;
    private JTextField field;
    private JLabel insert, result;
    private JPanel panel;
    private JButton button, next;
    static JFrame frm;
    String text;

    // event 등록하는 함수
    private ActionListener action = new action();

    class action implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == next) {
                memberPage rememberme = new memberPage();
            }
        }
    }

    public startPage() {
        // 부모 프레임 생성
        frm = new JFrame("layout");
        // 부모 프레임 타이틀 설정
        frm.setTitle("RememberMe");
        // 부모 프레임 사이즈 설정
        frm.setSize(300, 300);
        // 부모 프레임을 화면 가운데 배치
        frm.setLocationRelativeTo(null);
        // 부모 프레임을 닫으면 메모리에서 제거 되도록 (프로그램 종료 하도록) 설정
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 레이아웃
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
