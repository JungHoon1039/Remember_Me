package ssafy10.seoul8.pjh;

import java.awt.*;
import javax.swing.*;

class RememberMe2 extends JFrame {
    Container c;
    JButton button_list[] = new JButton[4];
    String str_list[] = {"확인", "취소", "뒤로가기", "앞으로가기"};
    
    RememberMe2(){
        setTitle("RememberMe");
        setSize(300,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setButton();
        setVisible(true);
    }
    
    void setButton() {
        c=getContentPane();
        c.setLayout(new FlowLayout());
        JLabel la = new JLabel("나의 프로그램");
        c.add(la);
        for (int i = 0; i < 4; i++) {
            button_list[i] = new JButton(str_list[i]);
            c.add(button_list[i]);
        }
    }
    
    
    
}
public class button {
    public static void main(String[] args) {
        new RememberMe2();
    }
}
