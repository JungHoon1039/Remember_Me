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
    /**
     * 리맴버미 프로그램 초기 화면 페이지 구현 클래스 - 페이지 전용 패키지로 관리
     */
    private static final long serialVersionUID = 10089311100001L;
    private JFrame frm = RememberMe.frm; // 초기 생성 된 프레임에 페이지 게시
    private JLabel insert;
    private JPanel panel;
    private JButton next;

    // 버튼 event 등록
    private ActionListener action = new action();

    class action implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) { // 이벤트 발생 시
            if (e.getSource() == next) { // 이벤트 발생 소스가 next 버튼이면
                new memberPage(); // 페이지 이동
            }
        }
    }

    public startPage() {
        // 컴포넌트의 grid bag 속성을 배열로 저장해서 사용 - 컴포넌트 수 만큼 배열 길이 지정
        GridBagConstraints[] gbc = new GridBagConstraints[2];
        // GridBagLayout을 사용
        GridBagLayout gbl = new GridBagLayout();
        panel = new JPanel();
        panel.setLayout(gbl);

        // 프레임에 들어가는 컴포넌트 별로 속성을 설정하고 panel에 추가한다
        // 이전에 생성한 gbc 배열에서 각 엘리먼트마다 컴포넌트의 grid 정보를 담게 된다
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

        // 프레임에 페이지의 컴포넌트들을 담은 panel을 세팅하고
        frm.setContentPane(panel);
        // 프레임이 보이도록 설정
        frm.setVisible(true);
    }
}
