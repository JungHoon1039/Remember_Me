package ssafy10.seoul8.page;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ssafy10.seoul8.function.randomQuiz;
import ssafy10.seoul8.startframe.RememberMe;

public class quizPage extends JFrame {
    /**
     * 리맴버미 프로그램 퀴즈 풀이 페이지 구현 클래스 - 페이지 전용 패키지로 관리
     */
    private static final long serialVersionUID = 10089311100005L;
    private JFrame frm = RememberMe.frm; // 초기 생성 된 프레임에 페이지 게시
    private JLabel player, quiz, answer;
    private JPanel panel;
    private JButton check, collect, wrong, next;
    private String member, question, search; // 문제를 풀 플레이어, 현재 문제, 현재 문제의 정답
    private Map<String, Integer> memberMap = namePage.memberMap; // 플레이어 Map 정보
    private Map<String, String> questionMap = questionPage.questionMap; // 문제 Map 정보
    private LinkedList<String> memberList = randomQuiz.randomMember(memberMap, questionMap); // 플레이어 Map을 List로 변환 하여 사용
    private LinkedList<String> questionList = randomQuiz.randomQuestion(questionMap); // 문제 Map을 List로 변환 하여 사용

    // 버튼 event 등록
    private ActionListener action = new action();

    class action implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) { // 이벤트 발생 시
            if (e.getSource() == check) { // 이벤트 발생 소스가 check 버튼이면
                if (questionList.size() >= 0 && member != null) { // 아직 문제가 남아 있는 경우
                    answer.setText(search); // 정답 정보를 세팅
                }
            } else if (e.getSource() == collect) { // 이벤트 발생 소스가 collect 버튼이면
                if (questionList.size() > 0) { // 문제가 더 남아 있는 경우
                    memberMap.put(member, memberMap.get(member) + 1); // 플레이어의 점수를 증가시키고
                    nextQuiz(); // 새로운 문제로 변수 재할당
                } else if (questionList.size() == 0 && member != null) { // 문제가 마지막인 경우
                    memberMap.put(member, memberMap.get(member) + 1); // 플레이어의 점수를 증가시키고
                    endQuiz(); // 문제 종료 설정
                }
            } else if (e.getSource() == wrong) { // 이벤트 발생 소스가 wrong 버튼이면
                if (questionList.size() > 0) { // 문제가 더 남아 있는 경우
                    nextQuiz(); // 새로운 문제로 변수 재할당
                } else if (questionList.size() == 0 && member != null) { // 문제가 마지막인 경우
                    endQuiz(); // 문제 종료 설정
                }
            } else if (e.getSource() == next) { // 이벤트 발생 소스가 next 버튼이면
                if (questionList.size() == 0 && member == null) { // 문제가 모두 종료 된 경우
                    new resultPage(); // 페이지 이동
                } else { // 문제가 종료되지 않은 경우
                    player.setText("<html>문제가 남아 있습니다<br>" + member + " 차례</html>"); // 문제가 종료되지 않았다는 안내메세지 출력
                }
            }
        }
    }

    // 다음 문제로 넘어가는 메소드
    public void nextQuiz() {
        member = memberList.poll(); // 다음 플레이어 설정
        question = questionList.poll(); // 다음 문제 설정
        search = questionMap.get(question); // 다음 문제 정답 설정
        player.setText(member + " 차례입니다"); // 플레이어 안내
        quiz.setText(question); // 문제 안내
        answer.setText(""); // 정답 가림
    }

    // 문제를 종료하는 메소드
    public void endQuiz() {
        member = null; // 플레이어 초기화
        player.setText("모든 문제가 종료 되었습니다"); // 종료 안내메세지 출력
        quiz.setText(""); // 문제 가림
        answer.setText(""); // 정답 가림
    }

    public quizPage() {
        // 컴포넌트의 grid bag 속성을 배열로 저장해서 사용 - 컴포넌트 수 만큼 배열 길이 지정
        GridBagConstraints[] gbc = new GridBagConstraints[7];
        // GridBagLayout을 사용
        GridBagLayout gbl = new GridBagLayout();
        panel = new JPanel();
        panel.setLayout(gbl);

        // 프레임에 들어가는 컴포넌트 별로 속성을 설정하고 panel에 추가한다
        // 이전에 생성한 gbc 배열에서 각 엘리먼트마다 컴포넌트의 grid 정보를 담게 된다

        player = new JLabel("");
        gbc[0] = new GridBagConstraints();
        gbc[0].gridx = 0;
        gbc[0].gridy = 0;
        gbc[0].gridwidth = 2;
        panel.add(player, gbc[0]);

        quiz = new JLabel("");
        gbc[1] = new GridBagConstraints();
        gbc[1].gridx = 0;
        gbc[1].gridy = 1;
        gbc[1].gridwidth = 2;
        panel.add(quiz, gbc[1]);

        check = new JButton("확인");
        check.addActionListener(action);
        gbc[2] = new GridBagConstraints();
        gbc[2].gridx = 0;
        gbc[2].gridy = 2;
        gbc[2].gridwidth = 2;
        panel.add(check, gbc[2]);

        collect = new JButton("정답");
        collect.addActionListener(action);
        gbc[3] = new GridBagConstraints();
        gbc[3].gridx = 0;
        gbc[3].gridy = 3;
        panel.add(collect, gbc[3]);

        wrong = new JButton("오답");
        wrong.addActionListener(action);
        gbc[4] = new GridBagConstraints();
        gbc[4].gridx = 1;
        gbc[4].gridy = 3;
        panel.add(wrong, gbc[4]);

        next = new JButton("다음");
        next.addActionListener(action);
        gbc[5] = new GridBagConstraints();
        gbc[5].gridx = 0;
        gbc[5].gridy = 4;
        gbc[5].gridwidth = 2;
        panel.add(next, gbc[5]);

        answer = new JLabel("");
        gbc[6] = new GridBagConstraints();
        gbc[6].gridx = 0;
        gbc[6].gridy = 5;
        gbc[6].gridwidth = 2;
        panel.add(answer, gbc[6]);

        nextQuiz(); // 첫 문제 할당
        // 프레임에 페이지의 컴포넌트들을 담은 panel을 세팅하고
        frm.setContentPane(panel);
        // 프레임이 보이도록 설정
        frm.setVisible(true);
    }
}