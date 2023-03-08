/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game;

/**
 *
 * @author Maanvith Sai
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
public class game extends javax.swing.JFrame{
    static JFrame game;
    static JLabel title, subtitle,hint,number,score1,score2,rule1,rule2;
    static JTextField input;
    static JButton check;
    static int i = 0,z;
    static String c;
    static int r,q,p;
    static Integer k;
    public game(){
        
        
        Random randomNumber = new Random();
        r = randomNumber.nextInt(50);
        
        q = randomNumber.nextInt(50);
        
        p = r+q;
        //System.out.println(p);
        
        game = new JFrame("NUMBER GUESSING GAME");
        game.setSize(4000,4000);
        game.setLayout(null);
        
        title = new JLabel("NUMBER GUESSING GAME");
        title.setBounds(450,50,800,80);
        Font f = new Font("Serif", Font.BOLD, 50);
        title.setFont(f);
        game.add(title);
        
        
        score1= new JLabel("");
        score1.setBounds(1100,175,500,80);
        Font fe = new Font("Serif", Font.BOLD, 30);
        score1.setFont(fe);
        game.add(score1);
        
        score2= new JLabel("");
        score2.setBounds(1100,225,300,80);
        score2.setFont(fe);
        game.add(score2);
        
        rule1= new JLabel("No.Of Attempts left : 10");
        rule1.setBounds(400,225,450,80);
        rule1.setFont(fe);
        game.add(rule1);
        

        number = new JLabel("Choose a Number :");
        number.setBounds(350,350,400,80);
        Font f1 = new Font("Serif", Font.BOLD, 40);
        number.setFont(f1);
        game.add(number);
        
        subtitle = new JLabel("(1-100)");
        subtitle.setBounds(430,410,400,80);
        Font f2 = new Font("Serif", Font.BOLD, 30);
        subtitle.setFont(f2);
        game.add(subtitle);
        
        hint = new JLabel("");
        hint.setBounds(500, 600, 800, 70);
        hint.setForeground(Color.BLACK);
        Font fonts = new Font("Serif", Font.BOLD, 40);
        hint.setFont(fonts);
        game.add(hint);
        
        input = new JTextField();
        input.setBounds(750,350,300,100);
        input.setFont(f1);
        game.add(input);
        
        check = new JButton("Check");
        check.setBounds(1200,370,150,80);
        check.setFont(f1);
        game.add(check);
        
        check.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                c = input.getText();
                if(c.isEmpty()){
                    JOptionPane.showMessageDialog(null,"Please Enter the Choice");    
                }
                else{
                    if(check()==1){
                       hint(); 
                    }
                    
                }
                
            }
        });
        
        game.setVisible(true);
        game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void hint(){
        i++;
        if(i<10){
            String cc = input.getText();
            Integer k = Integer.valueOf(cc);
            if(k<p){
                rule1.setText("No.of Attempts left : "+String.valueOf(10-i));
                hint.setText("Hint : The Number Entered is LOWER");  
            }
            else if(k>p){
                rule1.setText("No.of Attempts left : "+String.valueOf(10-i));
                hint.setText("Hint : The Number Entered is HIGHER");
            }
            else{
                hint.setText("S U C C E S S !!!");
                rule1.setText("No.of Attempts left : "+String.valueOf(10-i));
                score1.setText("No.of Attemps = "+String.valueOf(i));
                score2.setText("SCORE : "+String.valueOf(10-i));
                try{
                    int response = JOptionPane.showConfirmDialog(game,"Do you want to Play Again?", "confirm",JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE);
                    if(response == JOptionPane.YES_NO_OPTION){
                        i =0;
                        game g = new game();
                    }
                }catch (Exception e1){
                    System.out.println(e1);
                    JOptionPane.showMessageDialog(null, "something went wrong");
                }
            }
        }
        else{
            JOptionPane.showMessageDialog(null,"OUT OF CHANCES");
            game.dispose();
        }
        
    }
    public static int check(){
        try{
            k = Integer.valueOf(c);
            if(k<101 && k>0){
                z = 1;
            }
            else{
                JOptionPane.showMessageDialog(null,"Enter an Number Between 1- 100");
            }
        }catch(NumberFormatException E){
            JOptionPane.showMessageDialog(null,"Enter an Integer");
            z=0;
        }
        return z;
        
    }
}
