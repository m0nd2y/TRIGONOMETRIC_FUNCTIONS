import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class cos extends JFrame implements ActionListener {
    private JButton btn;
    private JButton btn1;
    public static boolean flag = true;

    public cos() {
        this.setLayout(new FlowLayout());

        this.setSize(500, 300); //frame 사이즈
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //창 닫기 설정
        this.setTitle("!!cos그래프!!"); //프로그램 표기이름

        //코싸인버튼
        btn = new JButton("cos그리기");
        btn.addActionListener(this);
        this.add(btn);


        //닫기버튼
        btn1 = new JButton("창닫기");
        btn1.addActionListener(new cos.Listener(this));
        this.add(btn1);

        //화면위치설정
        Dimension frameSize = this.getSize();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation((screenSize.width - frameSize.width) / 5, (screenSize.height - frameSize.height) / 5);

        System.out.println("[+] 화면로딩완료_cos");
        this.setVisible(true);
        this.setResizable(false);
    }

    //코싸인그리기클릭시
    public void actionPerformed(ActionEvent e) {
        if (flag) {
            System.out.println("[+] 그리기_cos");
            Graphics g = this.getGraphics();

            //중심좌표
            g.translate(this.getWidth() / 2, this.getHeight() / 2);

            //x축
            g.drawLine(-this.getWidth() / 2, 0, this.getWidth() / 2, 0);
            //y축
            g.drawLine(0, -this.getHeight() / 2, 0, this.getHeight() / 2);

            // Cos그리기
            g.setColor(Color.RED);
            g.drawString("Cos함수 그래프", 20, 120);
            for (int i = -1000; i <= 1000; i++) {
                g.drawOval(i/3, (int) (80 * -Math.cos(Math.toRadians(i))), 1, 1);
            }
            flag = false;
        }
        else {
            repaint();
            System.out.println("[+]지우기_cos");
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