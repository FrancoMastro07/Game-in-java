package realm_royale;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
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
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

//---------------------window------------------------------------------------

class Window extends JFrame{

    public Window(int health, int mana, int score, int damage){

        Toolkit mywindow = Toolkit.getDefaultToolkit();
        Dimension window_dimension = mywindow.getScreenSize();

        int window_height = window_dimension.height;
        int window_width = window_dimension.width;

        setSize(window_width/2, window_height/2);
        setLocation(window_width/4, window_height/4);
        setTitle("Realm royale");
        setResizable(true);
        add(new Sheet(health, mana, score, damage)); 
          
    }

    private class Sheet extends JPanel{

        private Image image;
        private JTextField c_properties;
        JLabel ask_lab;
        private String properties, health, mana, score, damage;
        private JSlider slider;
        
        public Sheet(int health, int mana, int score, int damage){                        
    
//---------------------------sheet-center-----------------------------------------------------

            this.health="" + health;
            this.mana="" + mana;
            this.score="" + score;
            this.damage="" + damage;

            setLayout(new BorderLayout());

            JPopupMenu popup = new JPopupMenu();

            JMenuItem popup_health = new JMenuItem("Health");
            JMenuItem popup_mana = new JMenuItem("Mana");
            JMenuItem popup_score = new JMenuItem("Score");
            JMenuItem popup_damage = new JMenuItem("Damage");
            JMenuItem popup_ask = new JMenuItem("Ask");
            JMenuItem popup_exit = new JMenuItem("Exit");

            popup_health.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, InputEvent.CTRL_DOWN_MASK));
            popup_mana.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, InputEvent.CTRL_DOWN_MASK));
            popup_score.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));
            popup_damage.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, InputEvent.CTRL_DOWN_MASK));
            popup_ask.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_DOWN_MASK));
            popup_exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_DOWN_MASK));

            popup.add(popup_health);
            popup.add(popup_mana);
            popup.add(popup_score);
            popup.add(popup_damage);
            popup.addSeparator();
            popup.add(popup_ask);
            popup.add(popup_exit);

            setComponentPopupMenu(popup);

//--------------------------sheet-north---------------------------------------------------------------

            JPanel sheet_north = new JPanel(new FlowLayout());                
            add(sheet_north, BorderLayout.NORTH);

            Exit_properties exit = new Exit_properties("Exit");
            sheet_north.add(new JButton(exit));

            JLabel properties = new JLabel("Consult Your properties: ");
            sheet_north.add(properties);
            
            c_properties = new JTextField("Ask about: health, mana, score or damage", 30);
            sheet_north.add(c_properties);

            JButton ask_prop = new JButton("Ask");
            Properties_button ask_but = new Properties_button();
            ask_prop.addActionListener(ask_but);
            sheet_north.add(ask_prop);

            ask_lab = new JLabel("");
            sheet_north.add(ask_lab);

            Ask_health ask_h = new Ask_health();
            Ask_mana ask_m = new Ask_mana();
            Ask_score ask_s = new Ask_score();
            Ask_damage ask_d = new Ask_damage();

            InputMap map = getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
            map.put(KeyStroke.getKeyStroke("ctrl E"), "exit");
            map.put(KeyStroke.getKeyStroke("ctrl A"), "ask");
            map.put(KeyStroke.getKeyStroke("ctrl H"), "ask health");
            map.put(KeyStroke.getKeyStroke("ctrl M"), "ask mana");
            map.put(KeyStroke.getKeyStroke("ctrl S"), "ask score");
            map.put(KeyStroke.getKeyStroke("ctrl D"), "ask damage");

            ActionMap map_action = getActionMap();
            map_action.put("exit", exit);
            map_action.put("ask", ask_but);
            map_action.put("ask health", ask_h);
            map_action.put("ask mana", ask_m);
            map_action.put("ask score", ask_s);
            map_action.put("ask damage", ask_d);

            try{
    
                image = ImageIO.read(new File("realm_royale/chicken.png"));
    
            }catch(IOException e){
    
                System.out.println("Couldnt find the image");
    
            }

//--------------------------------sheet-south-----------------------------------------------------------

            JPanel sheet_south = new JPanel(new FlowLayout());                
            add(sheet_south, BorderLayout.SOUTH);

            ButtonGroup buttongroup = new ButtonGroup();
            JRadioButton button1 = new JRadioButton("health", false);
            JRadioButton button2 = new JRadioButton("mana", false);
            JRadioButton button3 = new JRadioButton("score", false);
            JRadioButton button4 = new JRadioButton("damage", false);

            button1.addActionListener(ask_h);
            button2.addActionListener(ask_m);
            button3.addActionListener(ask_s);
            button4.addActionListener(ask_d);

            buttongroup.add(button1);
            buttongroup.add(button2); 
            buttongroup.add(button3); 
            buttongroup.add(button4);

            sheet_south.add(button1);
            sheet_south.add(button2);
            sheet_south.add(button3);
            sheet_south.add(button4);

//-------------------------------sheet-west-------------------------------------------------------

            JPanel sheet_west = new JPanel();          
            add(sheet_west, BorderLayout.WEST);

            slider = new JSlider(SwingConstants.VERTICAL, 0, 100, 1); 
            slider.setMajorTickSpacing(25);  
            slider.setMinorTickSpacing(0);
            slider.setPaintTicks(true);
            slider.setPaintLabels(true);
            slider.setSnapToTicks(true);
            slider.addChangeListener(new Slider_Event());
            sheet_west.add(slider);

        }
    
//----------------------------writing-zone----------------------------------------------------------

        public void paintComponent(Graphics g){            
    
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
    
            Font change_font = new Font("Arial", Font.BOLD, 40);
            g2.setFont(change_font);
            g2.drawString("Congratulations", 100, 100);
            g2.drawString("You finished the game", 100, 200);
            g2.drawImage(image, 400, 0, null);
    
        }

//-----------------------------actions-----------------------------------------------------------------------------------------------------------------

        private class Exit_properties extends AbstractAction{          

            public Exit_properties(String name){

                putValue(Action.NAME, name);
                putValue(Action.SHORT_DESCRIPTION, " Press ctrl + e to exit");

            }

            public void actionPerformed(ActionEvent e) {
                
                dispose();
                Toolkit.getDefaultToolkit().beep();

            }

        }

        private class Properties_button extends AbstractAction{
            
            public void actionPerformed(ActionEvent e) {
                
                properties = c_properties.getText().trim();

                if(properties.equalsIgnoreCase("health")){

                    ask_lab.setText(health);

                }else if(properties.equalsIgnoreCase("mana")){

                    ask_lab.setText(mana);

                }else if(properties.equalsIgnoreCase("score")){

                    ask_lab.setText(score);

                }else if(properties.equalsIgnoreCase("damage")){

                    ask_lab.setText(damage);

                }else{

                    ask_lab.setText("Incorrect command");

                }

            }    

        }

        private class Ask_health extends AbstractAction{

            public void actionPerformed(ActionEvent e) {
                
                c_properties.setText("health");

            }

        }

        private class Ask_mana extends AbstractAction{

            public void actionPerformed(ActionEvent e) {
                
                c_properties.setText("mana");

            }

        }

        private class Ask_score extends AbstractAction{

            public void actionPerformed(ActionEvent e) {
                
                c_properties.setText("score");

            }

        }

        private class Ask_damage extends AbstractAction{

            public void actionPerformed(ActionEvent e){

                c_properties.setText("damage");

            }

        }

        private class Slider_Event implements ChangeListener{

            public void stateChanged(ChangeEvent e) {

                if(slider.getValue()>0 && slider.getValue()<=25){

                    setBackground(Color.GREEN);

                }else if(slider.getValue()>25 && slider.getValue()<=50){

                    setBackground(Color.YELLOW);
                    
                }else if(slider.getValue()>50 && slider.getValue()<=75){
                
                    setBackground(Color.CYAN);

                }else if(slider.getValue()>75 && slider.getValue()<=100){

                    setBackground(Color.BLUE);

                }else{

                    setBackground(Color.WHITE);

                }

            }

        }

    }

}