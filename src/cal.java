import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class cal extends JFrame {
    JLabel label;
    JButton bNum[] = new JButton[10];	
    JButton plus, minus, multi, div, equal, mod, clear; 

    String inputValue;	
    int result;		
    char lastOp;		
    public static void main(String[] args) {
        new cal();
    }

    public cal() {
        super("Calcurator");
        setBounds(300, 300, 300, 300);
        setResizable(false);	
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        label = new JLabel("0", JLabel.RIGHT);
        add(label, BorderLayout.NORTH);
        JPanel p = new JPanel(new GridLayout(4, 4, 1, 1));
        add(p, BorderLayout.CENTER);
        plus = new JButton("+");	
        minus = new JButton("-");
        multi = new JButton("*");
        div = new JButton("/");
        equal = new JButton("=");
        mod = new JButton("%");
        clear = new JButton("C");

        int i;
        for( i=0;i<bNum.length;i++ ) {		
        	bNum[i] = new JButton(Integer.toString(i));
        }
        p.add(clear); p.add(bNum[7]); p.add(bNum[8]); p.add(bNum[9]); 
        p.add(multi);  p.add(div); p.add(bNum[4]); p.add(bNum[5]); p.add(bNum[6]);
        p.add(plus); p.add(minus);  p.add(bNum[1]); p.add(bNum[2]); p.add(bNum[3]); 
        p.add(mod);   p.add(equal);  p.add(bNum[0]);   

    }
    class NumberHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String s = e.getActionCommand();
            if(inputValue == null) {	
                if( s.equals("0")) 
                   return ;
                else inputValue = new String();	

            }
            if( inputValue.length() >= 9)	  
               return;
            inputValue = inputValue + s;  
            label.setText(inputValue);  
        }
    }


    class CalcHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JButton source = (JButton)e.getSource();
            int value;
            
            if( source == clear ) {	
                label.setText("0");
                inputValue = null;
                lastOp = 0;
                result = 0;
                return ;
            }

            if( inputValue != null ) {
		
                value = Integer.parseInt(inputValue);	
                switch(lastOp) {	  
                    case '+': 
                       result = result + value;
                       break;
                    case '-': 
                       result = result - value;
                       break;
                    case '*':
                       result = result * value;
                       break;
                    case '/': 
                       result = result / value;
                       break;
                    case '%':
                       result = result % value;
                       break;
                    default : 
                       result = value;
                       break;
                }
                label.setText(Integer.toString(result));  
            }
            inputValue = null;	
            lastOp = source.getText().charAt(0);
        }
    }
}
