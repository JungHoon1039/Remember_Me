package ssafy10.seoul8.page;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ssafy10.seoul8.function.scoreBoard;
import ssafy10.seoul8.startframe.RememberMe;

public class resultPage extends JFrame {
    /**
     * 리맴버미 프로그램 결과 페이지 구현 클래스 - 페이지 전용 패키지로 관리
     */
    private static final long serialVersionUID = 10089311100006L;
    private JFrame frm = RememberMe.frm; // 초기 생성 된 프레임에 페이지 게시
    private JLabel result;
    private JPanel panel;

    public resultPage() {
        // 컴포넌트의 grid bag 속성을 배열로 저장해서 사용 - 컴포넌트 수 만큼 배열 길이 지정
        GridBagConstraints[] gbc = new GridBagConstraints[1];
        // GridBagLayout을 사용
        GridBagLayout gbl = new GridBagLayout();
        panel = new JPanel();
        panel.setLayout(gbl);

        // 프레임에 들어가는 컴포넌트 별로 속성을 설정하고 panel에 추가한다
        // 이전에 생성한 gbc 배열에서 각 엘리먼트마다 컴포넌트의 grid 정보를 담게 된다
        result = new JLabel("");
        gbc[0] = new GridBagConstraints();
        gbc[0].gridx = 0;
        gbc[0].gridy = 0;
        panel.add(result, gbc[0]);

        result.setText(scoreBoard.result(namePage.memberMap));

        // 프레임에 페이지의 컴포넌트들을 담은 panel을 세팅하고
        frm.setContentPane(panel);
        // 프레임이 보이도록 설정
        frm.setVisible(true);
    }
}