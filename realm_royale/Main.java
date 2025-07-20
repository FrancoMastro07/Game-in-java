import java.io.IOException;
import javax.swing.*;

public class Main {
    

    public static void main(String[] args) throws IOException{

        String option="";

        do{

            option = JOptionPane.showInputDialog("Choose your class\n.Warrior\n.Assassin\n.Hunter\n.Wizard\n.Engineer");

        }while(option.equalsIgnoreCase("warrior")==false && option.equalsIgnoreCase("assassin")==false && option.equalsIgnoreCase("hunter")==false && option.equalsIgnoreCase("wizard")==false && option.equalsIgnoreCase("engineer")==false);

        Character character = new Character("none", 0, 0, 0,"hand", 0, false, false, false, false);
        byte inventory[] = new byte[2];

        if(option.equalsIgnoreCase("warrior")){

            Actions.character_changes(character, "Warrior", 3500, 80, "Sword", 320);
        
        }else if(option.equalsIgnoreCase("assassin")){

            Actions.character_changes(character, "Assassin", 2900, 70, "Sniper", 250);

        }else if(option.equalsIgnoreCase("hunter")){

            Actions.character_changes(character, "Hunter", 2800, 100, "Arch", 210);

        }else if(option.equalsIgnoreCase("wizard")){

            Actions.character_changes(character, "Wizard", 2700, 150, "Cane", 190);

        }else if(option.equalsIgnoreCase("engineer")){

           Actions.character_changes(character, "Engineer", 3300, 90, "Rocket launcher", 270);

        }
        
        int first_health = character.health_character();
        int first_mana = character.mana();
        String character_name = character.name_character();
        int character_mana = character.mana();
        String character_weapon = character.weapon();
        int character_damage = character.damage();
        byte character_level = character.level;

        System.out.println(".You are at level " + character_level);
        System.out.println(".Your class is: " + character_name);
        System.out.println(".Your weapon is: " + character_weapon);

        String armored_character = "";

        do{

            armored_character = JOptionPane.showInputDialog("Open this box\nWrite 'OK' to open it.");

        }while(armored_character.equalsIgnoreCase("ok")==false);

        JOptionPane.showMessageDialog(null, "Congratulations you got some armor and inventory");    
        
        character.use_potions();
        byte character_potions_health = character.potions_health();
        byte character_potions_mana = character.potions_mana();
        inventory[0] = character_potions_health;
        inventory[1] = character_potions_mana;

        int total_protection_w=0;
                
//-----------------------------------armor-character-------------------------------------------------------------------------------

        byte helmet_armor_w = (byte) character.use_helmet();
        byte chest_armor_w = (byte) character.use_chest();
        byte hands_armor_w = (byte) character.use_hands();
        byte greaves_armor_w = (byte) character.use_greaves();

        Actions.box_helmet(helmet_armor_w);
        Actions.box_chest(chest_armor_w);
        Actions.box_hands(hands_armor_w);
        Actions.box_greaves(greaves_armor_w);

        total_protection_w += helmet_armor_w;
        total_protection_w += chest_armor_w;
        total_protection_w += hands_armor_w;
        total_protection_w += greaves_armor_w;
    
        
        character.change_protection_character(total_protection_w);
        int character_protection = character.protection_character();
        int character_health = character.health_character() + character_protection;

        System.out.println(".You have " + character_health + " of health plus protection and " + character_mana + " of mana");
        System.out.println(".You have " + character_damage + " of damage");
        System.out.println(".You have " + character_potions_health + " potions of health");
        System.out.println(".You have " + character_potions_mana + " potions of mana");
        System.out.println(".........................................................................");

//-------------------------------------------enemy----------------------------------------------------------------//

        JOptionPane.showMessageDialog(null, "There is an enemy in front of you");        

        Enemy enemy = new Enemy("none", 0, 0, 0);

        byte random_enemy = enemy.random_enemy();

        if(random_enemy==1){

            Actions.enemy_changes(enemy, "Ant", 125, 250, 70);

        }else if(random_enemy==2){

            Actions.enemy_changes(enemy, "Bot", 260, 1000, 250);

        }else{

            Actions.enemy_changes(enemy, "Necromancer", 300, 2500, 300);

        }   

        String enemy_name = enemy.name_enemy();
        int enemy_health = enemy.health_enemy() + enemy.protection_enemy();
        int enemy_damage = enemy.damage_enemy();
        int enemy_ultradamage = enemy.damage_enemy() + 120;

        JOptionPane.showMessageDialog(null, enemy_name + " has appeared", "Enemy appeared", 2);
        System.out.println(enemy_name + " Has " + enemy_health + " of health plus protection and make " + enemy_damage + " of damage");

//-------------------------------level-1---------------------------------------------------------------------------------------------------------------------------------------------------------------------------

        String action, object_action, special_action;

        String character_action="";

        String enemy_action="";

        int total_damage=0;

        byte round=1;

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

                    enemy_health += 400;
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

                Window window = new Window(character.score, 2);
                window.setVisible(true);
                window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                JOptionPane.showMessageDialog(null, "You were defeated!!!", "WTF!!!", 2);

                System.out.println("You were defeated");
                System.out.println(".........................................................................................................");
                System.exit(0);

            }

            System.out.println("------------------------");

            //--------------------------------character-action-----------------------------------------------------------------------------------------------------------------------------------------

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
                        character_health += 400;
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
                        character_mana += 30;
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

                    special_action = JOptionPane.showInputDialog("Choose one special attack:\n.Fire - F (40 mana)\n.Ice - I (30 mana)");
    
                }while(special_action.equalsIgnoreCase("f")==false && special_action.equalsIgnoreCase("i")==false); 

                if(special_action.equalsIgnoreCase("f")){

                    if(character_mana>=40){

                        character_mana -= 40;
                        enemy_health -= 400;
                        character.scores(120);
                        total_damage += 400;
                        character_action = "You made " + 400 + " of damage with fire\nYour current mana: " + character_mana + ". Enemy health: " + enemy_health;

                    }else{

                        character_action = "You dont have enough mana to use this special attack";

                    }
                    
                }else if(special_action.equalsIgnoreCase("i")){

                    if(character_mana>=30){

                        character_mana -= 30;
                        enemy_health -= 350;
                        character.scores(100);
                        total_damage += 350;
                        character_action = "You made " + 350 + " of damage with ice\nYour current mana: " + character_mana + ". Enemy health: " + enemy_health;

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

//-------------------------------------------level-2-----------------------------------------------------------------------------------------------------------------------------------------

        JOptionPane.showMessageDialog(null, "Congratulations, you defeated " + enemy_name + "\nYou made " + total_damage + " of damage and your score is " + character.score + " points", "Enemy defeated", 1);

        System.out.println(".........................................................................................................");
        System.out.println("Congratulations, you defeated " + enemy_name + "\nYou made " + total_damage + " of damage and your score is " + character.score + " points");
        System.out.println(".........................................................................................................");

        character.change_health_character(first_health);
        character.change_mana(first_mana);

        character_level++;
        character.levels(character_level);

        int second_health = character.health_character();
        int second_mana = character.mana();
        character_health = character.health_character();
        character_protection = character.protection_character();
        character_mana = character.mana();
        character_damage = character.damage();

        System.out.println("You level up!\nYou are at level " + character_level + ". Health, protection and damage upgraded");
        System.out.println("Health: " + character_health + "\nProtection: " + character_protection + "\nMana: " + character_mana + "\nDamage: " + character_damage);

        character_health += character_protection;

        random_enemy = enemy.random_enemy();

        if(random_enemy==1){

            Actions.enemy_changes(enemy, "Wolf", 315, 620, 120);

        }else if(random_enemy==2){

            Actions.enemy_changes(enemy, "Cyborg", 420, 1390, 270);

        }else{

            Actions.enemy_changes(enemy, "Ogre", 480, 2880, 380);

        }    

        enemy_name = enemy.name_enemy();
        enemy_health = enemy.health_enemy() + enemy.protection_enemy();
        enemy_damage = enemy.damage_enemy();
        enemy_ultradamage = enemy.damage_enemy() + 340;

        System.out.println(".........................................................................................................");
        JOptionPane.showMessageDialog(null, "More objects discovered", "Box", 1);
        character.use_potions();
        character_potions_health = character.potions_health();
        character_potions_mana = character.potions_mana();
        inventory[0] += character_potions_health;
        inventory[1] += character_potions_mana;

        System.out.println("Current potions:\nHealth potions: " + inventory[0] + "\nMana potions: " + inventory[1]);


        JOptionPane.showMessageDialog(null, enemy_name + " has appeared", "Enemy appeared", 2);
        System.out.println(enemy_name + " Has " + enemy_health + " of health plus protection and make " + enemy_damage + " of damage");

        character_action="";
        enemy_action="";
        total_damage=0;
        round=1;

//----------------------------------second-combat---------------------------------------------------------------------------------------------------------------------------------------------------------------
    
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

                    enemy_health += 500;
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

                Window window = new Window(character.score, 2);
                window.setVisible(true);
                window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                JOptionPane.showMessageDialog(null, "You were defeated!!!", "WTF!!!", 2);

                System.out.println("You were defeated");
                System.out.println(".........................................................................................................");
                System.exit(0);

            }

            System.out.println("------------------------");

            //--------------------------------character-action-----------------------------------------------------------------------------------------------------------------------------------------

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
                        character_health += 500;
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
                        character_mana += 40;
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

                    special_action = JOptionPane.showInputDialog("Choose one special attack:\n.Fire - F (40 mana)\n.Ice - I (30 mana)\n.Light - L (60 mana)");
    
                }while(special_action.equalsIgnoreCase("f")==false && special_action.equalsIgnoreCase("i")==false && special_action.equalsIgnoreCase("l")==false); 

                if(special_action.equalsIgnoreCase("f")){

                    if(character_mana>=40){

                        character_mana -= 40;
                        enemy_health -= 600;
                        character.scores(120);
                        total_damage += 600;
                        character_action = "You made " + 600 + " of damage with fire\nYour current mana: " + character_mana + ". Enemy health: " + enemy_health;

                    }else{

                        character_action = "You dont have enough mana to use this special attack";

                    }
                    
                }else if(special_action.equalsIgnoreCase("i")){

                    if(character_mana>=30){

                        character_mana -= 30;
                        enemy_health -= 550;
                        character.scores(100);
                        total_damage += 550;
                        character_action = "You made " + 550 + " of damage with ice\nYour current mana: " + character_mana + ". Enemy health: " + enemy_health;

                    }else{

                        character_action = "You dont have enough mana to use this special attack";

                    }

                }else if(special_action.equalsIgnoreCase("l")){

                    if(character_mana>=60){

                        character_mana -= 60;
                        enemy_health -= 800;
                        character.scores(160);
                        total_damage += 800;
                        character_action = "You made " + 800 + " of damage with light\nYour current mana: " + character_mana + ". Enemy health: " + enemy_health;

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

//-------------------------------------------level-3-----------------------------------------------------------------------------------------------------------------------------------------

        JOptionPane.showMessageDialog(null, "Congratulations, you defeated " + enemy_name + "\nYou made " + total_damage + " of damage and your score is " + character.score + " points", "Enemy defeated", 1);

        System.out.println(".........................................................................................................");
        System.out.println("Congratulations, you defeated " + enemy_name + "\nYou made " + total_damage + " of damage and your score is " + character.score + " points");
        System.out.println(".........................................................................................................");

        character.change_health_character(second_health);
        character.change_mana(second_mana);

        character_level++;
        character.levels(character_level);

        int third_health = character.health_character();
        int third_mana = character.mana();
        character_health = character.health_character();
        character_protection = character.protection_character();
        character_mana = character.mana();
        character_damage = character.damage();

        System.out.println("You level up!\nYou are at level " + character_level + ". Health, protection and damage upgraded");
        System.out.println("Health: " + character_health + "\nProtection: " + character_protection + "\nMana: " + character_mana + "\nDamage: " + character_damage);

        character_health += character_protection;

        random_enemy = enemy.random_enemy();

        if(random_enemy==1){

            Actions.enemy_changes(enemy, "Bear", 595, 1220, 500);

        }else if(random_enemy==2){

            Actions.enemy_changes(enemy, "Gargoyle", 660, 1900, 720);
            
        }else{

            Actions.enemy_changes(enemy, "Cerberus", 720, 2400, 800);

        }    

        enemy_name = enemy.name_enemy();
        enemy_health = enemy.health_enemy() + enemy.protection_enemy();
        enemy_damage = enemy.damage_enemy();
        enemy_ultradamage = enemy.damage_enemy() + 420;

        System.out.println(".........................................................................................................");
        JOptionPane.showMessageDialog(null, "More objects discovered", "Box", 1);
        character.use_potions();
        character_potions_health = character.potions_health();
        character_potions_mana = character.potions_mana();
        inventory[0] += character_potions_health;
        inventory[1] += character_potions_mana;

        System.out.println("Current potions:\nHealth potions: " + inventory[0] + "\nMana potions: " + inventory[1]);


        JOptionPane.showMessageDialog(null, enemy_name + " has appeared", "Enemy appeared", 2);
        System.out.println(enemy_name + " Has " + enemy_health + " of health plus protection and make " + enemy_damage + " of damage");

        character_action="";
        enemy_action="";
        total_damage=0;
        round=1;

//----------------------------------third-combat---------------------------------------------------------------------------------------------------------------------------------------------------------------
    
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

                    enemy_health += 600;
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

                Window window = new Window(character.score, 2);
                window.setVisible(true);
                window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                JOptionPane.showMessageDialog(null, "You were defeated!!!", "WTF!!!", 2);

                System.out.println("You were defeated");
                System.out.println(".........................................................................................................");
                System.exit(0);

            }

            System.out.println("------------------------");

            //--------------------------------character-action-----------------------------------------------------------------------------------------------------------------------------------------

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
                        character_health += 600;
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
                        character_mana += 50;
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

                    special_action = JOptionPane.showInputDialog("Choose one special attack:\n.Fire - F (40 mana)\n.Ice - I (30 mana)\n.Light - L (60 mana)\n.Dark - D (90 mana)");
    
                }while(special_action.equalsIgnoreCase("f")==false && special_action.equalsIgnoreCase("i")==false && special_action.equalsIgnoreCase("l")==false && special_action.equalsIgnoreCase("d")==false); 

                if(special_action.equalsIgnoreCase("f")){

                    if(character_mana>=40){

                        character_mana -= 40;
                        enemy_health -= 800;
                        character.scores(120);
                        total_damage += 800;
                        character_action = "You made " + 800 + " of damage with fire\nYour current mana: " + character_mana + ". Enemy health: " + enemy_health;

                    }else{

                        character_action = "You dont have enough mana to use this special attack";

                    }
                    
                }else if(special_action.equalsIgnoreCase("i")){

                    if(character_mana>=30){

                        character_mana -= 30;
                        enemy_health -= 750;
                        character.scores(100);
                        total_damage += 750;
                        character_action = "You made " + 750 + " of damage with ice\nYour current mana: " + character_mana + ". Enemy health: " + enemy_health;

                    }else{

                        character_action = "You dont have enough mana to use this special attack";

                    }

                }else if(special_action.equalsIgnoreCase("l")){

                    if(character_mana>=60){

                        character_mana -= 60;
                        enemy_health -= 1000;
                        character.scores(160);
                        total_damage += 1000;
                        character_action = "You made " + 1000 + " of damage with light\nYour current mana: " + character_mana + ". Enemy health: " + enemy_health;

                    }else{

                        character_action = "You dont have enough mana to use this special attack";

                    }

                }else if(special_action.equalsIgnoreCase("d")){

                    if(character_mana>=90){

                        character_mana -= 90;
                        enemy_health -= 1300;
                        character.scores(210);
                        total_damage += 1300;
                        character_action = "You made " + 1300 + " of damage with dark\nYour current mana: " + character_mana + ". Enemy health: " + enemy_health;

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

//-------------------------------------------level-4-----------------------------------------------------------------------------------------------------------------------------------------

        JOptionPane.showMessageDialog(null, "Congratulations, you defeated " + enemy_name + "\nYou made " + total_damage + " of damage and your score is " + character.score + " points", "Enemy defeated", 1);

        System.out.println(".........................................................................................................");
        System.out.println("Congratulations, you defeated " + enemy_name + "\nYou made " + total_damage + " of damage and your score is " + character.score + " points");
        System.out.println(".........................................................................................................");

        character.change_health_character(third_health);
        character.change_mana(third_mana);

        character_level++;
        character.levels(character_level);

        int fourth_health = character.health_character();
        int fourth_mana = character.mana();
        character_health = character.health_character();
        character_protection = character.protection_character();
        character_mana = character.mana();
        character_damage = character.damage();

        System.out.println("You level up!\nYou are at level " + character_level + ". Health, protection and damage upgraded");
        System.out.println("Health: " + character_health + "\nProtection: " + character_protection + "\nMana: " + character_mana + "\nDamage: " + character_damage);

        character_health += character_protection;

        random_enemy = enemy.random_enemy();

        if(random_enemy==1){

            Actions.enemy_changes(enemy, "Lion", 925, 1670, 800);

        }else if(random_enemy==2){

            Actions.enemy_changes(enemy, "Golem", 1030, 2390, 1000);
            
        }else{

            Actions.enemy_changes(enemy, "Leviatan", 1080, 3800, 1100);
            
        }    

        enemy_name = enemy.name_enemy();
        enemy_health = enemy.health_enemy() + enemy.protection_enemy();
        enemy_damage = enemy.damage_enemy();
        enemy_ultradamage = enemy.damage_enemy() + 500;

        System.out.println(".........................................................................................................");
        JOptionPane.showMessageDialog(null, "More objects discovered", "Box", 1);
        character.use_potions();
        character_potions_health = character.potions_health();
        character_potions_mana = character.potions_mana();
        inventory[0] += character_potions_health;
        inventory[1] += character_potions_mana;

        System.out.println("Current potions:\nHealth potions: " + inventory[0] + "\nMana potions: " + inventory[1]);


        JOptionPane.showMessageDialog(null, enemy_name + " has appeared", "Enemy appeared", 2);
        System.out.println(enemy_name + " Has " + enemy_health + " of health plus protection and make " + enemy_damage + " of damage");

        character_action="";
        enemy_action="";
        total_damage=0;
        round=1;

//----------------------------------fourth-combat---------------------------------------------------------------------------------------------------------------------------------------------------------------
    
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

                    enemy_health += 700;
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

                Window window = new Window(character.score, 2);
                window.setVisible(true);
                window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                JOptionPane.showMessageDialog(null, "You were defeated!!!", "WTF!!!", 2);

                System.out.println("You were defeated");
                System.out.println(".........................................................................................................");
                System.exit(0);

            }

            System.out.println("------------------------");

            //--------------------------------character-action-----------------------------------------------------------------------------------------------------------------------------------------

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
                        character_health += 700;
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
                        character_mana += 60;
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

                    special_action = JOptionPane.showInputDialog("Choose one special attack:\n.Fire - F (40 mana)\n.Ice - I (30 mana)\n.Light - L (60 mana)\n.Dark - D (90 mana)\n.Nuke - N (120 mana)");
    
                }while(special_action.equalsIgnoreCase("f")==false && special_action.equalsIgnoreCase("i")==false && special_action.equalsIgnoreCase("l")==false && special_action.equalsIgnoreCase("d")==false && special_action.equalsIgnoreCase("n")==false); 

                if(special_action.equalsIgnoreCase("f")){

                    if(character_mana>=40){

                        character_mana -= 40;
                        enemy_health -= 900;
                        character.scores(120);
                        total_damage += 900;
                        character_action = "You made " + 900 + " of damage with fire\nYour current mana: " + character_mana + ". Enemy health: " + enemy_health;

                    }else{

                        character_action = "You dont have enough mana to use this special attack";

                    }
                    
                }else if(special_action.equalsIgnoreCase("i")){

                    if(character_mana>=30){

                        character_mana -= 30;
                        enemy_health -= 850;
                        character.scores(100);
                        total_damage += 850;
                        character_action = "You made " + 850 + " of damage with ice\nYour current mana: " + character_mana + ". Enemy health: " + enemy_health;

                    }else{

                        character_action = "You dont have enough mana to use this special attack";

                    }

                }else if(special_action.equalsIgnoreCase("l")){

                    if(character_mana>=60){

                        character_mana -= 60;
                        enemy_health -= 1100;
                        character.scores(160);
                        total_damage += 1100;
                        character_action = "You made " + 1100 + " of damage with light\nYour current mana: " + character_mana + ". Enemy health: " + enemy_health;

                    }else{

                        character_action = "You dont have enough mana to use this special attack";

                    }

                }else if(special_action.equalsIgnoreCase("d")){

                    if(character_mana>=90){

                        character_mana -= 90;
                        enemy_health -= 1400;
                        character.scores(210);
                        total_damage += 1400;
                        character_action = "You made " + 1400 + " of damage with dark\nYour current mana: " + character_mana + ". Enemy health: " + enemy_health;

                    }else{

                        character_action = "You dont have enough mana to use this special attack";

                    }

                }else if(special_action.equalsIgnoreCase("n")){

                    if(character_mana>=120){

                        character_mana -= 120;
                        enemy_health -= 2200;
                        character.scores(240);
                        total_damage += 2200;
                        character_action = "You made " + 2200 + " of damage with nuke\nYour current mana: " + character_mana + ". Enemy health: " + enemy_health;

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

//------------------------------------------last-level------------------------------------------------------------------------------------------------------------------------------------------

        JOptionPane.showMessageDialog(null, "Congratulations, you defeated " + enemy_name + "\nYou made " + total_damage + " of damage and your score is " + character.score + " points", "Enemy defeated", 1);

        System.out.println(".........................................................................................................");
        System.out.println("Congratulations, you defeated " + enemy_name + "\nYou made " + total_damage + " of damage and your score is " + character.score + " points");
        System.out.println(".........................................................................................................");

        character.change_health_character(fourth_health);
        character.change_mana(fourth_mana);

        character_level++;
        character.levels(character_level);

        character_health = character.health_character();
        character_protection = character.protection_character();
        character_mana = character.mana();
        character_damage = character.damage();

        System.out.println("You level up!\nYou are at level " + character_level + ". Health, protection and damage upgraded");
        System.out.println("Health: " + character_health + "\nProtection: " + character_protection + "\nMana: " + character_mana + "\nDamage: " + character_damage);

        character_health += character_protection;

        JOptionPane.showMessageDialog(null, "Something is weird...", "...", 2);
        System.out.println(".........................................................................................................");

        Actions.enemy_changes(enemy, "Cthulhu", 1400, 6000, 1500);

        enemy_name = enemy.name_enemy();
        enemy_health = enemy.health_enemy() + enemy.protection_enemy();
        enemy_damage = enemy.damage_enemy();
        enemy_ultradamage = enemy.damage_enemy() + 600;

        JOptionPane.showMessageDialog(null, enemy_name + " has appeared", "Boss appeared", 2);
        System.out.println(enemy_name + " Has " + enemy_health + " of health plus protection and make " + enemy_damage + " of damage");

        character_action="";
        enemy_action="";
        total_damage=0;
        round=1;

//----------------------------------------------------------last-fight------------------------------------------------------------------------------------------------------------------------------

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

                    enemy_health += 800;
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

                Window window = new Window(character.score, 2);
                window.setVisible(true);
                window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                JOptionPane.showMessageDialog(null, "You were defeated!!!", "WTF!!!", 2);

                System.out.println("You were defeated");
                System.out.println(".........................................................................................................");
                System.exit(0);

            }

            System.out.println("------------------------");

            //--------------------------------character-action-----------------------------------------------------------------------------------------------------------------------------------------

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
                        character_health += 800;
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
                        character_mana += 70;
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

                    special_action = JOptionPane.showInputDialog("Choose one special attack:\n.Fire - F (40 mana)\n.Ice - I (30 mana)\n.Light - L (60 mana)\n.Dark - D (90 mana)\n.Nuke - N (120 mana)");
    
                }while(special_action.equalsIgnoreCase("f")==false && special_action.equalsIgnoreCase("i")==false && special_action.equalsIgnoreCase("l")==false && special_action.equalsIgnoreCase("d")==false && special_action.equalsIgnoreCase("n")==false); 

                if(special_action.equalsIgnoreCase("f")){

                    if(character_mana>=40){

                        character_mana -= 40;
                        enemy_health -= 1200;
                        character.scores(120);
                        total_damage += 1200;
                        character_action = "You made " + 1200 + " of damage with fire\nYour current mana: " + character_mana + ". Enemy health: " + enemy_health;

                    }else{

                        character_action = "You dont have enough mana to use this special attack";

                    }
                    
                }else if(special_action.equalsIgnoreCase("i")){

                    if(character_mana>=30){

                        character_mana -= 30;
                        enemy_health -= 1150;
                        character.scores(100);
                        total_damage += 1150;
                        character_action = "You made " + 1150 + " of damage with ice\nYour current mana: " + character_mana + ". Enemy health: " + enemy_health;

                    }else{

                        character_action = "You dont have enough mana to use this special attack";

                    }

                }else if(special_action.equalsIgnoreCase("l")){

                    if(character_mana>=60){

                        character_mana -= 60;
                        enemy_health -= 1500;
                        character.scores(160);
                        total_damage += 1500;
                        character_action = "You made " + 1500 + " of damage with light\nYour current mana: " + character_mana + ". Enemy health: " + enemy_health;

                    }else{

                        character_action = "You dont have enough mana to use this special attack";

                    }

                }else if(special_action.equalsIgnoreCase("d")){

                    if(character_mana>=90){

                        character_mana -= 90;
                        enemy_health -= 1900;
                        character.scores(210);
                        total_damage += 1900;
                        character_action = "You made " + 1900 + " of damage with dark\nYour current mana: " + character_mana + ". Enemy health: " + enemy_health;

                    }else{

                        character_action = "You dont have enough mana to use this special attack";

                    }

                }else if(special_action.equalsIgnoreCase("n")){

                    if(character_mana>=120){

                        character_mana -= 120;
                        enemy_health -= 2500;
                        character.scores(240);
                        total_damage += 2500;
                        character_action = "You made " + 2500 + " of damage with nuke\nYour current mana: " + character_mana + ". Enemy health: " + enemy_health;

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

        System.out.println(".........................................................................................................");
        System.out.println("Congratulations, you defeated " + enemy_name + " and finished the game." + "\nYou made " + total_damage + " of damage and your score is " + character.score + " points");
        System.out.println(".........................................................................................................");

        Window window = new Window(character_health, character_mana, character.score, total_damage, 1);
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Writing_file file = new Writing_file(character_name, character_weapon, character_health, character_mana, total_damage, character.score);
        file.writing();

    }
    
}


