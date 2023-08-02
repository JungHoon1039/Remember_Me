package ssafy10.seoul8.startframe;

import javax.swing.JFrame;

import ssafy10.seoul8.page.startPage;

public class RememberMe extends JFrame {
    public static JFrame frm;

    public static void main(String[] args) {
        // 프레임 생성
        frm = new JFrame("layout");
        // 프레임 타이틀 설정
        frm.setTitle("RememberMe");
        // 프레임 사이즈 설정
        frm.setSize(300, 300);
        // 프레임을 화면 가운데 배치
        frm.setLocationRelativeTo(null);
        // 프레임을 닫으면 메모리에서 제거 되도록 (프로그램 종료 하도록) 설정
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        new startPage();
    }
}
