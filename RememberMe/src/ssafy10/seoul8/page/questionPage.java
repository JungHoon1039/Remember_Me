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
    public static Map<String, String> questionMap = new HashMap<>(); // key : 문제 - value : 정답 형식으로 Map 생성, 다른 클래스에서 접근 가능하도록 설정
    private JFrame frm = RememberMe.frm; // 초기 생성 된 프레임에 페이지 게시
    private JTextField field;
    private JLabel insert, result;
    private JPanel panel;
    private JButton button, next;

    // 버튼 event 등록
    private ActionListener action = new action();

    class action implements ActionListener {
        private String text; // 입력 되는 값을 받기 위한 변수 선언
        private int cnt = 0; // 문제 개수 카운트 하는 변수 선언

        @Override
        public void actionPerformed(ActionEvent e) { // 이벤트 발생 시
            if (e.getSource() == button) { // 이벤트 발생 소스가 button 버튼이면
                text = String.valueOf(field.getText()); // text에 입력 된 값을 할당 하고
                if (questionMap.containsKey(text)) { // 해당 값이 이미 Map에 존재 하는 경우
                    result.setText("동일한 문제는 입력 불가"); // 입력 불가
                } else { // 해당 값이 Map에 없는 경우
                    questionMap.put(text, answerCrawling.searchGoogle(text)); // key:문제 - value:정답 으로 추가
                    result.setText("문제 개수 : " + ++cnt + "개"); // 현재까지 카운트 된 문제 개수 표시
                }
            } else if (e.getSource() == next) { // 이벤트 발생 소스가 next 버튼이면
                if (cnt != 0) { // 문제 개수가 0개가 아닌 경우
                    new quizPage(); // 페이지 이동
                } else { // 문제 개수가 0개 인 경우
                    result.setText("문제가 0개 입니다"); // 안내메세지 출력
                }
            }
        }
    }

    public questionPage() {
        // 컴포넌트의 grid bag 속성을 배열로 저장해서 사용 - 컴포넌트 수 만큼 배열 길이 지정
        GridBagConstraints[] gbc = new GridBagConstraints[5];
        // GridBagLayout을 사용
        GridBagLayout gbl = new GridBagLayout();
        panel = new JPanel();
        panel.setLayout(gbl);

        // 프레임에 들어가는 컴포넌트 별로 속성을 설정하고 panel에 추가한다
        // 이전에 생성한 gbc 배열에서 각 엘리먼트마다 컴포넌트의 grid 정보를 담게 된다
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

        // 프레임에 페이지의 컴포넌트들을 담은 panel을 세팅하고
        frm.setContentPane(panel);
        // 프레임이 보이도록 설정
        frm.setVisible(true);
    }
}