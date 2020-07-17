import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class sin extends JFrame implements ActionListener {
    private JButton btn;
    private JButton btn1;

    public static boolean flag = true;

    public sin() {
        this.setLayout(new FlowLayout());

        this.setSize(500, 300); //frame 사이즈
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //창 닫기 설정
        this.setTitle("!!sin그래프!!"); //프로그램 표기이름

        //sin버튼
        btn = new JButton("sin그리기");
        btn.addActionListener(this);
        this.add(btn);

        //닫기버튼
        btn1 = new JButton("창닫기");
        btn1.addActionListener(new sin.Listener(this));
        this.add(btn1);

        //화면위치
        Dimension frameSize = this.getSize();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation((screenSize.width - frameSize.width) / 4, (screenSize.height - frameSize.height) / 4);

        System.out.println("[+] 화면로딩완료_sin");
        this.setVisible(true);
        this.setResizable(false);
    }

    //사인그리기버튼클릭
    public void actionPerformed(ActionEvent e) {
        if (flag) {
            System.out.println("[+] 그리기_sin");
            Graphics g = this.getGraphics();

            //중심좌표
            g.translate(this.getWidth() / 2, this.getHeight() / 2);

            //x축
            g.drawLine(-this.getWidth() / 2, 0, this.getWidth() / 2, 0);
            //y축
            g.drawLine(0, -this.getHeight() / 2, 0, this.getHeight() / 2);

            // Sin그리기
            g.setColor(Color.BLUE);
            g.drawString("Sin함수 그래프", 20, 120);
            for (int i = -1000; i <= 1000; i++) {
                g.drawOval(i/3, (int) (80 * -Math.sin(Math.toRadians(i))), 1, 1);
            }
            flag = false;
        }
        else {
            repaint();
            System.out.println("[+] 지우기_sin");
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