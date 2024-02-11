package realm_royale;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

//---------------------window------------------------------------------------

class Window extends JFrame{

    public Window(int score){

        Toolkit mywindow = Toolkit.getDefaultToolkit();
        Dimension window_dimension = mywindow.getScreenSize();

        int window_height = window_dimension.height;
        int window_width = window_dimension.width;

        setSize(window_width/2, window_height/2);
        setLocation(window_width/4, window_height/4);
        setTitle("Realm royale");
        setResizable(true);
        add(new Sheet(score)); 
          
    }

    private class Sheet extends JPanel{
    
        private Image image;
        private String score_str;
    
        public Sheet(int score){                        //sheet
    
            setBackground(Color.GREEN);

            Exit_properties exit = new Exit_properties("Exit");
            
            add(new JButton(exit));

            score_str = "Score: " + score;

            JButton score_button = new JButton(score_str);
            score_button.setEnabled(false);
            add(score_button);
    
            try{
    
                image = ImageIO.read(new File("realm_royale/chicken.png"));
    
            }catch(IOException e){
    
                System.out.println("Couldnt find the image");
    
            }

            InputMap map = getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
            map.put(KeyStroke.getKeyStroke("ctrl X"), "exit");
            ActionMap map_action = getActionMap();
            map_action.put("exit", exit);
    
        }
    
        public void paintComponent(Graphics g){            //writing, font and image
    
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
    
            Font change_font = new Font("Arial", Font.BOLD, 40);
            g2.setFont(change_font);
            g2.drawString("Congratulations", 100, 100);
            g2.drawString("You defeated the enemy", 100, 200);
            g2.drawImage(image, 400, 0, null);
    
        }

        private class Exit_properties extends AbstractAction{          //exit action and properties

            public Exit_properties(String name){

                putValue(Action.NAME, name);
                putValue(Action.SHORT_DESCRIPTION, " Press ctrl + x to exit");

            }

            public void actionPerformed(ActionEvent e) {
                
                dispose();
                Toolkit.getDefaultToolkit().beep();

            }

        }

    }

}






