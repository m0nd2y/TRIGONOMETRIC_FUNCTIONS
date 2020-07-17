import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class MyFrame extends JFrame {

    MyFrame() {
        this.setSize(400, 105); //프로그램 크기
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //닫기 옵션
        this.setTitle("삼각함수 그리기"); //프로그램 표기이름

        //레이어 설정
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        JPanel panel4 = new JPanel();

        //화면 중앙에 표시되게하기
        Dimension frameSize = this.getSize();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);


        //사인그래프
        JButton button1 = new JButton("sin그래프");
        button1.addActionListener(new MyFrame.sinbutton(this));
        panel1.add(button1);

        //코사인그래프
        JButton button2 = new JButton("cos그래프");
        button2.addActionListener(new MyFrame.cosbutton(this));
        panel2.add(button2);

        //탄젠트그래프
        JButton button3 = new JButton("tan그래프");
        button3.addActionListener(new MyFrame.tanbutton(this));
        panel3.add(button3);

        //제작자표기
        JLabel label2 = new JLabel("mady by 2522_이동준");
        label2.setHorizontalAlignment(JLabel.CENTER);
        panel4.add(label2);

        //패널 정리
        panel1.add(panel2);
        panel1.add(panel3);
        panel1.add(panel4);
        this.add(panel1);


        //마무리설정
        this.setVisible(true);
        this.setResizable(false);

    }

    //"사인버튼" 버튼 클릭시 이벤트
    class sinbutton implements ActionListener {

        JFrame frame;

        public sinbutton(JFrame f) {
            frame = f;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            new sin();
        }
    }

    //"코싸인" 버튼 클릭시 이벤트
    class cosbutton implements ActionListener {

        JFrame frame;

        public cosbutton(JFrame f) {
            frame = f;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            new cos();
        }
    }

    //"탄젠트" 버튼 클릭시 이벤트
    class tanbutton implements ActionListener {

        JFrame frame;

        public tanbutton(JFrame f) {
            frame = f;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            new tan();
        }
    }
}