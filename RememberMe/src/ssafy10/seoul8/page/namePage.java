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

import ssafy10.seoul8.startframe.RememberMe;

public class namePage extends JFrame {
    public static Map<String, Integer> memberMap = new HashMap<>(); // key : 플레이어 - value : 점수 형식으로 Map 생성, 다른 클래스에서 접근 가능하도록 설정
    private JFrame frm = RememberMe.frm; // 초기 생성 된 프레임에 페이지 게시
    private JTextField field;
    private JLabel insert, result;
    private JPanel panel;
    private JButton button, next;

    // 버튼 event 등록
    private ActionListener action = new action();

    class action implements ActionListener {
        private String text; // 입력 되는 값을 받기 위한 변수 선언
        private int cnt = 1; // 등록 된 플레이어 수 카운트 하는 변수 선언

        @Override
        public void actionPerformed(ActionEvent e) { // 이벤트 발생 시
            if (e.getSource() == button) { // 이벤트 발생 소스가 button 버튼이면
                if (cnt <= memberPage.member) { // 등록 된 플레이어 수가 설정 된 플레이어 수 이하 인 경우
                    text = String.valueOf(field.getText()); // 입력 된 값을 받아서
                    if (memberMap.containsKey(text)) { // memberMap에 동일한 값이 존재 하는 경우
                        result.setText("동일한 이름은 입력 불가"); // 등록 불가
                    } else { // memberMap에 동일한 값이 존재하지 않는 경우
                        memberMap.put(text, 0); // key:이름 - value:점수 로 추가
                        result.setText("플레이어 " + cnt++ + " 등록 완료"); // 등록 완료 된 플레이어 안내
                        if (cnt <= memberPage.member) { // 추가로 등록 할 플레이어가 남아 있는 경우
                            insert.setText("플레이어 " + cnt + " 이름을 입력하세요"); // 플레이어 이름을 입력 하라고 안내
                        } else { // 추가로 등록 할 플레이어가 없는 경우
                            insert.setText("모든 플레이어 등록 완료"); // 모든 플레이어 등록 안내
                        }
                    }
                } else { // 등록 된 플레이어를 모두 등록 한 경우
                    result.setText("모든 플레이어가 등록 되었습니다"); // 모든 플레이어 등록 메세지 출력
                }
            } else if (e.getSource() == next) { // 이벤트 발생 소스가 next 버튼이면
                if (memberMap.size() == memberPage.member) { // 설정 된 플레이어 수 만큼 플레이어가 등록 된 경우
                    new questionPage(); // 페이지 이동
                } else { // 설정 된 플레이어 수 만큼 플레이어가 등록 되지 않은 경우
                    result.setText("등록 되지 않은 플레이어가 있습니다"); // 등록 되지 않은 플레이어가 있다는 안내 메세지 출력
                }
            }
        }
    }

    public namePage() {
        // 컴포넌트의 grid bag 속성을 배열로 저장해서 사용 - 컴포넌트 수 만큼 배열 길이 지정
        GridBagConstraints[] gbc = new GridBagConstraints[5];
        // GridBagLayout을 사용
        GridBagLayout gbl = new GridBagLayout();
        panel = new JPanel();
        panel.setLayout(gbl);

        // 프레임에 들어가는 컴포넌트 별로 속성을 설정하고 panel에 추가한다
        // 이전에 생성한 gbc 배열에서 각 엘리먼트마다 컴포넌트의 grid 정보를 담게 된다
        insert = new JLabel("플레이어 1 이름을 입력하세요");
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

        // 프레임에 페이지의 컴포넌트들을 담은 panel을 세팅하고
        frm.setContentPane(panel);
        // 프레임이 보이도록 설정
        frm.setVisible(true);
    }
}