import javax.swing.JFrame;
import javax.swing.JOptionPane;
import interfaces.Chest;
import interfaces.Greaves;
import interfaces.Hands;
import interfaces.Helmet;

public class Actions {
    
    public static void character_changes(Character character, String name, int health, int mana, String weapon, int damage){

        character.change_name_character(name);
        character.change_health_character(health);
        character.change_mana(mana);
        character.change_weapon(weapon);
        character.change_damage(damage);

    }

    public static void enemy_changes(Enemy enemy, String name, int damage, int health, int protection){

        enemy.change_name_enemy(name);
        enemy.change_damage_enemy(damage);
        enemy.change_health_enemy(health);
        enemy.change_protection_enemy(protection);

    }

    public static int fight(Character character, Enemy enemy, byte inventory[], int first_health, int first_mana, int e_ultradamage, int heal, int mana, int power){

        byte round = 1;
        int level = character.level();
        String action, object_action, special_action;
        int character_health = character.health_character() + character.protection_character();
        int character_mana = character.mana();
        int character_damage = character.damage();
        int character_protection = character.protection_character();
        String character_action = "";
        String enemy_action="";
        String enemy_name = enemy.name_enemy();
        int enemy_health = enemy.health_enemy() + enemy.protection_enemy();
        int enemy_damage = enemy.damage_enemy();
        int enemy_ultradamage = enemy.damage_enemy() + e_ultradamage;      
        int total_damage = 0;                     

        while(character_health>0 && enemy_health>0){        

            byte random_attack = enemy.random_attack();
            
            System.out.println(".........................................................................................................");
            System.out.println("Round " + round + "!\n");
        
            //-----------------------------enemy-action-------------------------------------------------------------------------------------------------------------------------------------

            if(enemy_health<=(enemy_health/2)){

                if(random_attack==1){

                    character_health -= enemy_damage;
                    enemy_action = enemy_name + " made " + enemy_damage + " of damage\nYour current mana: " + character_mana + ". Your current health: " + character_health;
    
                }else if(random_attack==2){

                    enemy_health += (400 - heal);         
                    enemy_action = enemy_name + " healed itself, its current health is " + enemy_health; 

                }else{

                    character_health -= enemy_ultradamage;
                    enemy_action = enemy_name + " made " + enemy_ultradamage + " of ultradamage\nYour current mana: " + character_mana + ". Your current health: " + character_health;

                }

            }else{

                if(random_attack==1){

                    character_health -= enemy_damage;
                    enemy_action = enemy_name + " made " + enemy_damage + " of damage\nYour current mana: " + character_mana + ". Your current health: " + character_health;
    
                }else if(random_attack==2){

                    character_health -= enemy_ultradamage;
                    enemy_action = enemy_name + " made " + enemy_ultradamage + " of ultradamage\nYour current mana: " + character_mana + ". Your current health: " + character_health;

                }else{
                    
                    enemy_action = enemy_name + " has failed";

                }

            }
            
            if(character_health>0){

                System.out.println(enemy_action);

            }else{

                Window window = new Window(character.score(), 2);
                window.setVisible(true);
                window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                JOptionPane.showMessageDialog(null, "You were defeated!!!", "WTF!!!", 2);

                System.out.println("You were defeated");
                System.out.println(".........................................................................................................");
                System.exit(0);

            }

            System.out.println("------------------------");

            //-----------------------------character-action-----------------------------------------------------------------------------//

            do{

                action = JOptionPane.showInputDialog("What do you want to do?\n.Attack - A\n.Special attack - S\n.Objects - O\n.Pass - P");

            }while(action.equalsIgnoreCase("a")==false && action.equalsIgnoreCase("o")==false && action.equalsIgnoreCase("s")==false && action.equalsIgnoreCase("p")==false);

            if(action.equalsIgnoreCase("a")){                                                //attack

                enemy_health -= character_damage;
                character_action = "You made " + character_damage + " of damage\nEnemy health: " + enemy_health;
                character.scores(50);
                total_damage += character_damage;

            }else if(action.equalsIgnoreCase("o")){                                //potions

                do{

                    object_action = JOptionPane.showInputDialog("Choose one object:\nHealth potion - HP\nMana potion - MP");

                }while(object_action.equalsIgnoreCase("hp")==false && object_action.equalsIgnoreCase("mp")==false);

                if(object_action.equalsIgnoreCase("hp")){                   //health potion

                    if(inventory[0]>0){

                        inventory[0] -= 1;
                        character_health += (800 - heal);          
                        if(character_health>=(first_health + character_protection)){

                            character_health = (first_health + character_protection);

                        }
                        character_action = "You healed yourself\nYour current mana: " + character_mana + ". Your current health: " + character_health + ". Health potions left: " + inventory[0];

                    }else{

                        character_action = "You cannot heal you";

                    }

                }else if(object_action.equalsIgnoreCase("mp")){             //mana potion

                    if(inventory[1]>0){

                        inventory[1] -= 1;
                        character_mana += (70 - mana);        
                        if(character_mana>=first_mana){

                            character_mana = first_mana;

                        }
                        character_action = "You got more mana\nYour current mana: " + character_mana + ". Your current health: " + character_health + ". Mana potions left: " + inventory[1];

                    }else{

                        character_action = "You cannot get more mana";

                    }

                }

            }else if(action.equalsIgnoreCase("s")){                         //special attack      

                do{
                    if(level==1){

                        special_action = JOptionPane.showInputDialog("Choose one special attack:\n.Fire - F (40 mana)\n.Ice - I (30 mana)");

                    }else if(level==2){

                        special_action = JOptionPane.showInputDialog("Choose one special attack:\n.Fire - F (40 mana)\n.Ice - I (30 mana)\n.Light - L (60 mana)");

                    }else if(level==3){

                        special_action = JOptionPane.showInputDialog("Choose one special attack:\n.Fire - F (40 mana)\n.Ice - I (30 mana)\n.Light - L (60 mana)\n.Dark - D (90 mana)");

                    }else{

                        special_action = JOptionPane.showInputDialog("Choose one special attack:\n.Fire - F (40 mana)\n.Ice - I (30 mana)\n.Light - L (60 mana)\n.Dark - D (90 mana)\n.Nuke - N (120 mana)");

                    }
                    
    
                }while(special_action.equalsIgnoreCase("f")==false && special_action.equalsIgnoreCase("i")==false && special_action.equalsIgnoreCase("l")==false && special_action.equalsIgnoreCase("d")==false && special_action.equalsIgnoreCase("n")==false); 

                if(special_action.equalsIgnoreCase("f")){         //fire

                    if(character_mana>=40){

                        character_mana -= 40;
                        enemy_health -= (400 + power);          //power empieza siendo 0, se suma de a 250
                        character.scores(120);
                        total_damage += (400 + power);
                        character_action = "You made " + (400 + power) + " of damage with fire\nYour current mana: " + character_mana + ". Enemy health: " + enemy_health;

                    }else{

                        character_action = "You dont have enough mana to use this special attack";

                    }
                    
                }else if(special_action.equalsIgnoreCase("i")){          //ice

                    if(character_mana>=30){

                        character_mana -= 30;
                        enemy_health -= (350 + power);         //power empieza siendo 0, se suma de a 250
                        character.scores(100);
                        total_damage += (350 + power);
                        character_action = "You made " + (350 + power) + " of damage with ice\nYour current mana: " + character_mana + ". Enemy health: " + enemy_health;

                    }else{

                        character_action = "You dont have enough mana to use this special attack";

                    }

                }else if(special_action.equalsIgnoreCase("l")){         //light

                    if(character_mana>=60){

                        character_mana -= 60;
                        enemy_health -= (800 + power);        //power empieza siendo 0, se suma de a 250
                        character.scores(160);
                        total_damage += (800 + power);
                        character_action = "You made " + (800 + power) + " of damage with light\nYour current mana: " + character_mana + ". Enemy health: " + enemy_health;

                    }else{

                        character_action = "You dont have enough mana to use this special attack";

                    }

                }else if(special_action.equalsIgnoreCase("d")){          //dark

                    if(character_mana>=90){

                        character_mana -= 90;
                        enemy_health -= (1300 + power);        //power empieza siendo 0, se suma de a 250
                        character.scores(210);
                        total_damage += (1300 + power);
                        character_action = "You made " + (1300 + power) + " of damage with dark\nYour current mana: " + character_mana + ". Enemy health: " + enemy_health;

                    }else{

                        character_action = "You dont have enough mana to use this special attack";

                    }

                }else if(special_action.equalsIgnoreCase("n")){          //nuke

                    if(character_mana>=120){

                        character_mana -= 120;
                        enemy_health -= (2200 + power);
                        character.scores(240);
                        total_damage += (2200 + power);
                        character_action = "You made " + (2200 + power) + " of damage with nuke\nYour current mana: " + character_mana + ". Enemy health: " + enemy_health;

                    }else{

                        character_action = "You dont have enough mana to use this special attack";

                    }

                }

            }else if(action.equalsIgnoreCase("p")){

                character_action = "You ignored the enemy";

            }

            round++;

            if(enemy_health>0){

                System.out.println(character_action);

            }else{

                System.out.println(enemy_name + " was defeated");

            }
        }

        return total_damage;

    }
    

//----------------------box-actions-------------------------------------------------------------------------------//

    public static void box_helmet(byte number){

        if(number==Helmet.common_helmet){

            System.out.println("-You have a common helmet that has " + number + " of protection");

        }else if(number==Helmet.rare_helmet){

            System.out.println("-You have a rare helmet that has " + number + " of protection");

        }else if(number==Helmet.ultrarare_helmet){

            System.out.println("-You have an ultrarare helmet that has " + number + " of protection");

        }else if(number==Helmet.epic_helmet){

            System.out.println("-You have an epic helmet that has " + number + " of protection");

        }else if(number==Helmet.legendary_helmet){

            System.out.println("-You have a legendary helmet that has " + number + " of protection");

        }else{

            System.out.println("You dont have a helmet");

        }


    }

    public static void box_chest(byte number){

        if(number==Chest.common_chest){

            System.out.println("-You have a common chest that has " + number + " of protection");
            

        }else if(number==Chest.rare_chest){

            System.out.println("-You have a rare chest that has " + number + " of protection");
            

        }else if(number==Chest.ultrarare_chest){

            System.out.println("-You have an ultrarare chest that has " + number + " of protection");
            

        }else if(number==Chest.epic_chest){

            System.out.println("-You have an epic chest that has " + number + " of protection");
            

        }else if(number==Chest.legendary_chest){

            System.out.println("-You have a legendary chest that has " + number + " of protection");


        }else{

            System.out.println("You dont have a chest");

        }

    }

    public static void box_hands(byte number){

        if(number==Hands.common_hands){

            System.out.println("-You have a common hands that have " + number + " of protection");
            

        }else if(number==Hands.rare_hands){

            System.out.println("-You have a rare hands that have " + number + " of protection");

        }else if(number==Hands.ultrarare_hands){

            System.out.println("-You have an ultrarare hands that have " + number + " of protection");

        }else if(number==Hands.epic_hands){

            System.out.println("-You have an epic hands that have " + number + " of protection");

        }else if(number==Hands.legendary_hands){

            System.out.println("-You have a legendary hands that have " + number + " of protection");

        }else{

            System.out.println("You dont have hands");

        }

    }

    public static void box_greaves(byte number){

        if(number==Greaves.common_greaves){

            System.out.println("-You have a common greaves that have " + number + " of protection");
            

        }else if(number==Greaves.rare_greaves){

            System.out.println("-You have a rare greaves that have " + number + " of protection");

        }else if(number==Greaves.ultrarare_greaves){

            System.out.println("-You have an ultrarare greaves that have " + number + " of protection");

        }else if(number==Greaves.epic_greaves){

            System.out.println("-You have an epic greaves that have " + number + " of protection");

        }else if(number==Greaves.legendary_greaves){

            System.out.println("-You have a legendary greaves that have " + number + " of protection");

        }else{

            System.out.println("You dont have greaves");

        }

    }

}
