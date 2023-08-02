package ssafy10.seoul8.page;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ssafy10.seoul8.startframe.RememberMe;

public class memberPage extends JFrame {
    /**
     * 리맴버미 프로그램 플레이어 수 설정 페이지 구현 클래스 - 페이지 전용 패키지로 관리
     */
    private static final long serialVersionUID = 10089311100002L;
    public static int member = 0; // 등록 할 플레이어 수 - 다른 클래스에서 접근 가능하도록 설정
    private JFrame frm = RememberMe.frm; // 초기 생성 된 프레임에 페이지 게시
    private JTextField field;
    private JLabel insert, result;
    private JPanel panel;
    private JButton button, next;

    // 버튼 event 등록
    private ActionListener action = new action();

    class action implements ActionListener {
        private String text; // 입력 되는 값을 받기 위한 변수 선언

        @Override
        public void actionPerformed(ActionEvent e) { // 이벤트 발생 시
            if (e.getSource() == button) { // 이벤트 발생 소스가 button 버튼이면
                text = String.valueOf(field.getText()); // text에 입력 된 값을 할당 하고
                if (text.equals("1") || text.equals("2") || text.equals("3") || text.equals("4") || text.equals("5")) { // 1,2,3,4,5 만 입력 가능
                    result.setText("현재 참여 인원 : " + text + "명"); // 입력 된 값에 대한 안내 메세지 출력
                    member = Integer.parseInt(text); // 등록 할 플레이어 수에 입력 된 값 할당
                } else { // 입력 된 값이 1,2,3,4,5가 아닌 경우
                    result.setText("1~5 만 입력 가능합니다"); // 입력 불가 안내 메세지 출력
                }
            } else if (e.getSource() == next) { // 이벤트 발생 소스가 next 버튼이면
                if (member != 0) { // 등록 할 플레이어가 0명이 아닌 경우
                    new namePage(); // 페이지 이동
                } else { // 등록 할 플레이어가 0명인 경우
                    result.setText("한명 이상 등록 해 주세요"); // 등록 할 플레이어 수를 설정 해달라는 안내메세지 출력
                }
            }
        }
    }

    public memberPage() {
        // 컴포넌트의 grid bag 속성을 배열로 저장해서 사용 - 컴포넌트 수 만큼 배열 길이 지정
        GridBagConstraints[] gbc = new GridBagConstraints[5];
        // GridBagLayout을 사용
        GridBagLayout gbl = new GridBagLayout();
        panel = new JPanel();
        panel.setLayout(gbl);

        // 프레임에 들어가는 컴포넌트 별로 속성을 설정하고 panel에 추가한다
        // 이전에 생성한 gbc 배열에서 각 엘리먼트마다 컴포넌트의 grid 정보를 담게 된다
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

        // 프레임에 페이지의 컴포넌트들을 담은 panel을 세팅하고
        frm.setContentPane(panel);
        // 프레임이 보이도록 설정
        frm.setVisible(true);
    }
}
