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

public class RememberMe {
    public static void main(String[] args) {
        StartRememberMe rememberme = new StartRememberMe(); // 리맴버미 실행
    }
}

class StartRememberMe extends JFrame {
    private JTextField field;
    private JLabel insert, result;
    private JPanel panel, panel2;
    private JButton button, next;
    static JFrame frm;
    String text;
    
    // event 등록하는 함수
    private ActionListener action = new action();
    class action implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == button) {
                text = String.valueOf(field.getText());
                if (text.equals("1")||text.equals("2")||text.equals("3")||text.equals("4")||text.equals("5")) {
                    result.setText("현재 참여 인원 : " + text + "명");
                } else {
                    result.setText("1~5 만 입력 가능합니다.");
                }
                
            } else if (e.getSource() == next) {
                NextRememberMe rememberme = new NextRememberMe();
            }
        }
    }

    
    public StartRememberMe() {
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
        GridBagConstraints[] gbc = new GridBagConstraints[5]; // 컴포넌트
        GridBagLayout gbl = new GridBagLayout();
        panel = new JPanel();
        panel.setLayout(gbl);
        
        // 자식 컴포넌트
        insert = new JLabel("인원 수를 입력하세요!");
        gbc[0] = new GridBagConstraints();
        gbc[0].gridx = 3;
        gbc[0].gridy = 1;
        gbc[0].gridwidth = 3;
//        gbc[0].gridheight = 2;
//        gbc[0].fill = GridBagConstraints.BOTH;
//        gbc[0].weightx = 1;
//        gbc[0].weighty = 1;
        panel.add(insert, gbc[0]);
        
        field = new JTextField(5);
        field.setText("");
        gbc[1] = new GridBagConstraints();
        gbc[1].gridx = 3;
        gbc[1].gridy = 4;
        panel.add(field, gbc[1]);
        
        button = new JButton("입력");
        button.addActionListener(action);
        gbc[2] = new GridBagConstraints();
        gbc[2].gridx = 4;
        gbc[2].gridy = 4;
        panel.add(button, gbc[2]);
        
        result = new JLabel("현재 참여 인원 : 0명");
        gbc[3] = new GridBagConstraints();
        gbc[3].gridx = 3;
        gbc[3].gridy = 7;
        gbc[3].gridwidth = 3;
        panel.add(result, gbc[3]);
        
        next = new JButton("다음");
        next.addActionListener(action);
        gbc[4] = new GridBagConstraints();
        gbc[4].gridx = 3;
        gbc[4].gridy = 9;
        gbc[4].gridwidth = 3;
        panel.add(next, gbc[4]);
        
        frm.setContentPane(panel);
        frm.setVisible(true);
    }
    
    
}

class NextRememberMe extends JFrame {
    private JTextField field;
    private JLabel insert, result;
    private JPanel panel, panel2;
    private JButton button, next;
    JFrame frm = StartRememberMe.frm;
    String text;
    
    // event 등록하는 함수
    private ActionListener action = new action();
    class action implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == button) {
                text = String.valueOf(field.getText());
                result.setText(result.getText() + "\n" + text);
            }
        }
    }
    public NextRememberMe() {
        // 부모 프레임 타이틀 설정
        frm.setTitle("RememberMe");
        // 부모 프레임 사이즈 설정
        frm.setSize(300, 300);
        // 부모 프레임을 화면 가운데 배치
        frm.setLocationRelativeTo(null);
        // 부모 프레임을 닫으면 메모리에서 제거 되도록 (프로그램 종료 하도록) 설정
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 레이아웃
        GridBagConstraints[] gbc = new GridBagConstraints[5]; // 컴포넌트
        GridBagLayout gbl = new GridBagLayout();
        panel = new JPanel();
        panel.setLayout(gbl);
        
        // 자식 컴포넌트
        insert = new JLabel("단어를 입력하세요!");
        gbc[0] = new GridBagConstraints();
        gbc[0].gridx = 3;
        gbc[0].gridy = 1;
        gbc[0].gridwidth = 3;
//        gbc[0].gridheight = 2;
//        gbc[0].fill = GridBagConstraints.BOTH;
//        gbc[0].weightx = 1;
//        gbc[0].weighty = 1;
        panel.add(insert, gbc[0]);
        
        field = new JTextField(5);
        field.setText("");
        gbc[1] = new GridBagConstraints();
        gbc[1].gridx = 3;
        gbc[1].gridy = 4;
        panel.add(field, gbc[1]);
        
        button = new JButton("입력");
        button.addActionListener(action);
        gbc[2] = new GridBagConstraints();
        gbc[2].gridx = 4;
        gbc[2].gridy = 4;
        panel.add(button, gbc[2]);
        
        result = new JLabel("");
        gbc[3] = new GridBagConstraints();
        gbc[3].gridx = 3;
        gbc[3].gridy = 7;
        gbc[3].gridwidth = 3;
        panel.add(result, gbc[3]);
        
        next = new JButton("다음");
        next.addActionListener(action);
        gbc[4] = new GridBagConstraints();
        gbc[4].gridx = 3;
        gbc[4].gridy = 9;
        gbc[4].gridwidth = 3;
        panel.add(next, gbc[4]);
        
        frm.setContentPane(panel);
        frm.setVisible(true);
    }
    
    
}