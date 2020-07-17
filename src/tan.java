import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class tan extends JFrame implements ActionListener {
    private JButton btn;
    private JButton btn1;
    public static boolean flag = true;

    public tan() {
        this.setLayout(new FlowLayout());

        this.setSize(500, 300); //frame 사이즈
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //창 닫기 설정
        this.setTitle("!!tan그래프!!"); //프로그램 표기이름

        //탄젠트버튼
        btn = new JButton("tan그리기");
        btn.addActionListener(this);
        this.add(btn);

        //닫기버튼
        btn1 = new JButton("창닫기");
        btn1.addActionListener(new tan.Listener(this));
        this.add(btn1);

        //화면위치
        Dimension frameSize = this.getSize();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation((screenSize.width - frameSize.width) / 3, (screenSize.height - frameSize.height) / 3);

        System.out.println("[+] 화면로딩완료_tan");
        this.setVisible(true);
        this.setResizable(false);
    }

    //탄젠트그리기버튼클릭시
    public void actionPerformed(ActionEvent e) {
        if (flag) {
            System.out.println("[+] 그리기_tan");
            Graphics g = this.getGraphics();

            //중심좌표
            g.translate(this.getWidth() / 2, this.getHeight() / 2);


            //x축
            g.drawLine(-this.getWidth() / 2, 0, this.getWidth() / 2, 0);
            //y축
            g.drawLine(0, -this.getHeight() / 2, 0, this.getHeight() / 2);

            // Tan그리기
            g.setColor(Color.MAGENTA);
            g.drawString("Tan함수 그래프", 150, 120);
            for (int j = -2; j <= 2; j++) {
                for (int i = -180 + j * 180 + 1; i <= 180 + j * 180 - 1; i++) {
                    g.drawOval(i/3, (int) (80 * -Math.tan(Math.toRadians(i))), 2, 1);
                }
            }
            flag = false;
        }
        else {
            repaint();
            System.out.println("[+] 지우기_tan");
            flag = true;
        }
    }

    //창닫기버튼클릭시
    class Listener implements ActionListener {

        JFrame frame;

        public Listener(JFrame f) {
            frame = f;
        }


        @Override
        public void actionPerformed(ActionEvent e) {
            dispose(); //창닫기
        }
    }


}