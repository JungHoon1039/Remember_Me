package ssafy10.seoul8.pjh;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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
    private JPanel panel1, panel2, panel3, panel4;
    private JButton button;
    String text;
    // event 등록하는 함수
    private ActionListener action = new action();
    class action implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == button) {
                text = String.valueOf(field.getText());
                result.setText(text);
            }
        }

    }
    
    public StartRememberMe() {
        // 부모 프레임 생성
        JFrame frm = new JFrame("layout");
        // 부모 프레임 타이틀 설정
        frm.setTitle("RememberMe");
        // 부모 프레임 사이즈 설정
        frm.setSize(500, 500);
        // 부모 프레임을 화면 가운데 배치
        frm.setLocationRelativeTo(null);
        // 부모 프레임을 닫으면 메모리에서 제거 되도록 (프로그램 종료 하도록) 설정
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 부모 프레임 레이아웃
        frm.getContentPane().setLayout(null);   
        
        // 자식 컴포넌트
        insert = new JLabel("인원 수를 입력하세요!");
        panel1 = new JPanel();
        panel1.add(insert);
        // 가로위치, 세로위치, 가로길이, 세로길이
        panel1.setBounds(175, 25, 150, 50);
        
        field = new JTextField(5);
        field.setText("");
        panel2 = new JPanel();
        panel2.add(field);
        
        
        result = new JLabel("0명");
        panel3 = new JPanel();
        panel3.add(result);
        
        
        button = new JButton("입력");
        button.addActionListener(action);
        panel4 = new JPanel();
        panel4.add(button);
        

        frm.add(panel1);
        frm.add(panel2);
        frm.add(panel3);
        frm.add(panel4);
        frm.setVisible(true);
    }
}