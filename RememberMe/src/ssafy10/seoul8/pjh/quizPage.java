package ssafy10.seoul8.pjh;

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

public class quizPage extends JFrame {
    private JFrame frm = RememberMe.frm;
    private JLabel player, quiz, answer;
    private JPanel panel;
    private JButton check, collect, wrong, next;
    private String member, question, search;
    private Map<String, Integer> memberMap = namePage.memberMap;
    private Map<String, String> questionMap = questionPage.questionMap;
    private LinkedList<String> memberList = randomQuiz.randomMember(memberMap, questionMap);
    private LinkedList<String> questionList = randomQuiz.randomQuestion(questionMap);

    // event 등록하는 함수
    private ActionListener action = new action();

    class action implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == check) {
                if (questionList.size() >= 0 && member != null) {
                    answer.setText(search);
                }
            } else if (e.getSource() == collect) {
                if (questionList.size() > 0) {
                    memberMap.put(member, memberMap.get(member) + 1);
                    nextQuiz();
                    player.setText(member + " 차례입니다");
                    quiz.setText(question);
                    answer.setText("");
                } else if (questionList.size() == 0 && member != null) {
                    memberMap.put(member, memberMap.get(member) + 1);
                    member = null;
                    player.setText("모든 문제가 종료 되었습니다");
                    quiz.setText("");
                    answer.setText("");
                }
            } else if (e.getSource() == wrong) {
                if (questionList.size() > 0) {
                    nextQuiz();
                    player.setText(member + " 차례입니다");
                    quiz.setText(question);
                    answer.setText("");
                } else if (questionList.size() == 0 && member != null) {
                    member = null;
                    player.setText("모든 문제가 종료 되었습니다");
                    quiz.setText("");
                    answer.setText("");
                }
            } else if (e.getSource() == next) {
                new resultPage();
            }
        }
    }

    public void nextQuiz() {
        member = memberList.poll();
        question = questionList.poll();
        search = questionMap.get(question);
    }

    public quizPage() {
        GridBagConstraints[] gbc = new GridBagConstraints[7]; // 컴포넌트
        GridBagLayout gbl = new GridBagLayout();
        panel = new JPanel();
        panel.setLayout(gbl);

        // 자식 컴포넌트
        nextQuiz();
        player = new JLabel(member + " 차례입니다");
        gbc[0] = new GridBagConstraints();
        gbc[0].gridx = 0;
        gbc[0].gridy = 0;
        gbc[0].gridwidth = 2;
        panel.add(player, gbc[0]);

        quiz = new JLabel(question);
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

        frm.setContentPane(panel);
        frm.setVisible(true);
    }
}