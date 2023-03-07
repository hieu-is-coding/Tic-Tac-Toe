import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class Main extends JFrame implements ItemListener, ActionListener{
    int i,j,ii,jj,x,y;
    int a[][]={{10,1,2,3,11},{10,1,4,7,11},{10,1,5,9,11},{10,2,5,8,11},
            {10,3,5,7,11},{10,3,6,9,11},{10,4,5,6,11},{10,7,8,9,11} };

    boolean state,type,set;

    Icon ic1,ic2,icon,ic11,ic22;
    Checkbox c1;
    JButton b[]=new JButton[9];
    JButton reset;

    public void showButton(){

        x=10; y=10;j=0;
        for(i=0;i<=8;i++,x+=100,j++){
            b[i]=new JButton();
            if(j==3) {j=0; y+=100; x=10;}
            b[i].setBounds(x,y,100,100);
            add(b[i]);
            b[i].addActionListener(this);
        }//eof for

        reset = new JButton("RESET");
        reset.setBounds(100,350,100,50);
        add(reset);
        reset.addActionListener(this);

    }

    /*********************************************************/
    public  void check(int num1){
        for(ii=0;ii<=7;ii++){
            for(jj=1;jj<=3;jj++){
                if(a[ii][jj]==num1){
                    a[ii][4]=11;
                }
            }//eof for jj
        }//eof for ii
    }//eof check
    /**********************************************************/

    Main(){
        super("tic tac toe");

        CheckboxGroup cbg=new CheckboxGroup();
        c1=new Checkbox("Play",cbg,false);
        c1.setBounds(140,80,100,200);
        add(c1);
        c1.addItemListener(this);

        state=true;type=true;set=true;
        ic1=new ImageIcon("D:\\Code\\Java\\tictactoe\\src\\ic1.jpg");
        ic2=new ImageIcon("D:\\Code\\Java\\tictactoe\\src\\ic2.jpg");
        ic11=new ImageIcon("D:\\Code\\Java\\tictactoe\\src\\ic11.jpg");
        ic22=new ImageIcon("D:\\Code\\Java\\tictactoe\\src\\ic22.jpg");

        setLayout(null);
        setSize(330,450);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

//        for(int i=0;i<=7;i++)
//            System.out.printf("%d %d %d\n",a[i][1],a[i][2],a[i][3]);
    }//eof constructor

    public void itemStateChanged(ItemEvent e){
        remove(c1);
        repaint(0,0,330,450);
        showButton();
    }//eof itemstate
    /************************************************************/

    public void actionPerformed(ActionEvent e) {
        /********************************/
        if (e.getSource() == reset) {
            for (i = 0; i <= 8; i++) {
                b[i].setIcon(null);
            }//eof for
            state = true;
        } else {
            for (i = 0; i <= 8; i++) {
                if (e.getSource() == b[i]) {
                    if (b[i].getIcon() == null) {
                        if (state == true) {
                            icon = ic2;
                            state = false;
                        } else {
                            icon = ic1;
                            state = true;
                        }
                        b[i].setIcon(icon);
                    }
                }
            }//eof for
        }//eof else

        for (i = 0; i <= 7; i++) {
            Icon icon1 = b[(a[i][1] - 1)].getIcon();
            Icon icon2 = b[(a[i][2] - 1)].getIcon();
            Icon icon3 = b[(a[i][3] - 1)].getIcon();
            System.out.print(icon1+" ");
            System.out.print(icon2+" ");
            System.out.println(icon1==icon2);
            if ((icon1 == icon2) && (icon2 == icon3) && (icon1 != null)) {
                if (icon1 == ic1) {
                    b[(a[i][1] - 1)].setIcon(ic11);
                    b[(a[i][2] - 1)].setIcon(ic11);
                    b[(a[i][3] - 1)].setIcon(ic11);
                    JOptionPane.showMessageDialog(Main.this, "!!!Player x won!!!");
                    break;
                } else if (icon1 == ic2) {
                    b[(a[i][1] - 1)].setIcon(ic22);
                    b[(a[i][2] - 1)].setIcon(ic22);
                    b[(a[i][3] - 1)].setIcon(ic22);
                    JOptionPane.showMessageDialog(Main.this, "!!!Player o won!!!");
                    break;
                }
            }
        }


    }

    public static void main(String []args){
        new Main();
    }
}