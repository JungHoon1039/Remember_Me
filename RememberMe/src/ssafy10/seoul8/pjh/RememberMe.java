package ssafy10.seoul8.pjh;

import java.awt.*;
import javax.swing.*;

public class RememberMe extends JFrame{
	//chk3
    RememberMe() {
        setTitle("RememberMe"); // 프레임 이름
        setSize(300,400); // 프레임 사이즈 설정
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //창을 닫으면 프로그램 종료
        Container c = getContentPane(); // 컴포넌트를 어디에다가 부착할지 지정
        c.setLayout(new FlowLayout()); // 이 위치에 부착 - 기본적인 창화면
        
        JButton j1 = new JButton("확인");
        JButton j2 = new JButton("취소");
        
        c.add(j1);
        c.add(j2);
        
        JLabel l1 = new JLabel("이름");
        c.add(l1);
        
        setVisible(true); // 프레임 보이는지 여부
        
    }
    
    public static void main(String[] args) {
        new RememberMe();
    }
}
