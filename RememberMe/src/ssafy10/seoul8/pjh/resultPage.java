package ssafy10.seoul8.pjh;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class resultPage extends JFrame {
    private JLabel result;
    private JPanel panel;
    private JButton next;
    JFrame frm = startPage.frm;
    String text;
    Map<String, Integer> memberMap = namePage.memberMap;

    // event 등록하는 함수
    private ActionListener action = new action();

    class action implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == next) {
                new startPage();
            }
        }
    }

    public resultPage() {
        GridBagConstraints[] gbc = new GridBagConstraints[2]; // 컴포넌트
        GridBagLayout gbl = new GridBagLayout();
        panel = new JPanel();
        panel.setLayout(gbl);
 
        // 자식 컴포넌트

        result = new JLabel("");
        gbc[0] = new GridBagConstraints();
        gbc[0].gridx = 0;
        gbc[0].gridy = 0;
        panel.add(result, gbc[0]);

        next = new JButton("다시하기");
        next.addActionListener(action);
        gbc[1] = new GridBagConstraints();
        gbc[1].gridx = 0;
        gbc[1].gridy = 3;
        panel.add(next, gbc[1]);
        
        List<String> memberList = new ArrayList<>(memberMap.keySet());
        memberList.sort((o1, o2) -> memberMap.get(o2).compareTo(memberMap.get(o1)));
        Iterator<String> memberKey = memberList.iterator();
        String scoreBoard = "<html> 최종 점수 <br>";
        while (memberKey.hasNext()) {
            String key = memberKey.next();
            String score = String.valueOf(memberMap.get(key));
            scoreBoard = scoreBoard + key + "님 점수 : " + score + "<br/>";
        }
        result.setText(scoreBoard + "</html>");

        frm.setContentPane(panel);
        frm.setVisible(true);
    }

}