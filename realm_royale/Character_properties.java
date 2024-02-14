package realm_royale;

import javax.swing.*;

public class Character_properties {
    
    public static void main(String[] args){

        String option="";

        do{

            option = JOptionPane.showInputDialog("Choose your class\n.Warrior\n.Assassin\n.Hunter\n.Wizard\n.Engineer");

        }while(option.equalsIgnoreCase("warrior")==false && option.equalsIgnoreCase("assassin")==false && option.equalsIgnoreCase("hunter")==false && option.equalsIgnoreCase("wizard")==false && option.equalsIgnoreCase("engineer")==false);

        Character character = new Character("none", 0, 0, 0,"hand", 0, false, false, false, false);
        byte inventory[] = new byte[2];

        if(option.equalsIgnoreCase("warrior")){

            character.change_name_character("Warrior");
            character.change_health_character(3500);
            character.change_mana(80);
            character.change_weapon("Sword");
            character.change_damage(320);

        }else if(option.equalsIgnoreCase("assassin")){

            character.change_name_character("Assassin");
            character.change_health_character(2900);
            character.change_mana(70);
            character.change_weapon("Sniper");
            character.change_damage(250);

        }else if(option.equalsIgnoreCase("hunter")){

            character.change_name_character("Hunter");
            character.change_health_character(2800);
            character.change_mana(100);
            character.change_weapon("Arch");
            character.change_damage(210);

        }else if(option.equalsIgnoreCase("wizard")){

            character.change_name_character("Wizard");
            character.change_health_character(2700);
            character.change_mana(150);
            character.change_weapon("Cane");
            character.change_damage(190);

        }else if(option.equalsIgnoreCase("engineer")){

            character.change_name_character("Engineer");
            character.change_health_character(3300);
            character.change_mana(90);
            character.change_weapon("Rocket launcher");
            character.change_damage(270);

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
                
//-----------------------------------helmet-character-------------------------------------------------------------------------------

        byte helmet_armor_w = (byte) character.use_helmet();

        if(helmet_armor_w==Helmet.common_helmet){

            System.out.println("-You have a common helmet that has " + helmet_armor_w + " of protection");
            total_protection_w += helmet_armor_w;

        }else if(helmet_armor_w==Helmet.rare_helmet){

            System.out.println("-You have a rare helmet that has " + helmet_armor_w + " of protection");
            total_protection_w += helmet_armor_w;

        }else if(helmet_armor_w==Helmet.ultrarare_helmet){

            System.out.println("-You have an ultrarare helmet that has " + helmet_armor_w + " of protection");
            total_protection_w += helmet_armor_w;

        }else if(helmet_armor_w==Helmet.epic_helmet){

            System.out.println("-You have an epic helmet that has " + helmet_armor_w + " of protection");
            total_protection_w += helmet_armor_w;

        }else if(helmet_armor_w==Helmet.legendary_helmet){

            System.out.println("-You have a legendary helmet that has " + helmet_armor_w + " of protection");
            total_protection_w += helmet_armor_w;

        }else{

            System.out.println("You dont have a helmet");

        }

//-----------------------------------chest-character-------------------------------------------------------------------------------

        byte chest_armor_w = (byte) character.use_chest();

        if(chest_armor_w==Chest.common_chest){

            System.out.println("-You have a common chest that has " + chest_armor_w + " of protection");
            total_protection_w += chest_armor_w;

        }else if(chest_armor_w==Chest.rare_chest){

            System.out.println("-You have a rare chest that has " + chest_armor_w + " of protection");
            total_protection_w += chest_armor_w;

        }else if(chest_armor_w==Chest.ultrarare_chest){

            System.out.println("-You have an ultrarare chest that has " + chest_armor_w + " of protection");
            total_protection_w += chest_armor_w;

        }else if(chest_armor_w==Chest.epic_chest){

            System.out.println("-You have an epic chest that has " + chest_armor_w + " of protection");
            total_protection_w += chest_armor_w;

        }else if(chest_armor_w==Chest.legendary_chest){

            System.out.println("-You have a legendary chest that has " + chest_armor_w + " of protection");
            total_protection_w += chest_armor_w;

        }else{

            System.out.println("You dont have a chest");

        }

//-----------------------------------hands-character-------------------------------------------------------------------------------

        byte hands_armor_w = (byte) character.use_hands();

        if(hands_armor_w==Hands.common_hands){

            System.out.println("-You have a common hands that have " + hands_armor_w + " of protection");
            total_protection_w += hands_armor_w;

        }else if(hands_armor_w==Hands.rare_hands){

            System.out.println("-You have a rare hands that have " + hands_armor_w + " of protection");
            total_protection_w += hands_armor_w;

        }else if(hands_armor_w==Hands.ultrarare_hands){

            System.out.println("-You have an ultrarare hands that have " + hands_armor_w + " of protection");
            total_protection_w += hands_armor_w;

        }else if(hands_armor_w==Hands.epic_hands){

            System.out.println("-You have an epic hands that have " + hands_armor_w + " of protection");
            total_protection_w += hands_armor_w;

        }else if(hands_armor_w==Hands.legendary_hands){

            System.out.println("-You have a legendary hands that have " + hands_armor_w + " of protection");
            total_protection_w += hands_armor_w;

        }else{

            System.out.println("You dont have hands");

        }

//-----------------------------------greaves-character-------------------------------------------------------------------------------

        byte greaves_armor_w = (byte) character.use_greaves();

        if(greaves_armor_w==Greaves.common_greaves){

            System.out.println("-You have a common greaves that have " + greaves_armor_w + " of protection");
            total_protection_w += greaves_armor_w;

        }else if(greaves_armor_w==Greaves.rare_greaves){

            System.out.println("-You have a rare greaves that have " + greaves_armor_w + " of protection");
            total_protection_w += greaves_armor_w;

        }else if(greaves_armor_w==Greaves.ultrarare_greaves){

            System.out.println("-You have an ultrarare greaves that have " + greaves_armor_w + " of protection");
            total_protection_w += greaves_armor_w;

        }else if(greaves_armor_w==Greaves.epic_greaves){

            System.out.println("-You have an epic greaves that have " + greaves_armor_w + " of protection");
            total_protection_w += greaves_armor_w;

        }else if(greaves_armor_w==Greaves.legendary_greaves){

            System.out.println("-You have a legendary greaves that have " + greaves_armor_w + " of protection");
            total_protection_w += greaves_armor_w;

        }else{

            System.out.println("You dont have greaves");

        }
        
        character.change_protection_character(total_protection_w);
        int character_protection = character.protection_character();
        int character_health = character.health_character() + character_protection;

        System.out.println(".You have " + character_health + " of health plus protection and " + character_mana + " of mana");
        System.out.println(".You have " + character_damage + " of damage");
        System.out.println(".You have " + character_potions_health + " potions of health");
        System.out.println(".You have " + character_potions_mana + " potions of mana");
        System.out.println(".........................................................................");

        JOptionPane.showMessageDialog(null, "There is an enemy in front of you");        

        Enemy enemy = new Enemy("none", 0, 0, 0);

        byte random_enemy = enemy.random_enemy();

        if(random_enemy==1){

            enemy.change_name_enemy("Ant");
            enemy.change_damage_enemy(125);
            enemy.change_health_enemy(250);
            enemy.change_protection_enemy(70);

        }else if(random_enemy==2){

            enemy.change_name_enemy("Bot");
            enemy.change_damage_enemy(260);
            enemy.change_health_enemy(1000);
            enemy.change_protection_enemy(250);

        }else{

            enemy.change_name_enemy("Taquitos al pastor");
            enemy.change_damage_enemy(300);
            enemy.change_health_enemy(2500);
            enemy.change_protection_enemy(400);

        }   

        String enemy_name = enemy.name_enemy();
        int enemy_health = enemy.health_enemy() + enemy.protection_enemy();
        int enemy_damage = enemy.damage_enemy();
        int enemy_ultradamage = enemy.damage_enemy() + 120;

        JOptionPane.showMessageDialog(null, enemy_name + " has appeared");
        System.out.println(enemy_name + " Has " + enemy_health + " of health plus protection and make " + enemy_damage + " of damage");

//-------------------------------action---------------------------------------------------------------------------------------------------------------------------------------------------------------------------

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
 
        Window window = new Window(character_health, character_mana, character.score, total_damage);
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        System.out.println(".........................................................................................................");
        System.out.println("Congratulations, you defeated " + enemy_name + "\nYou made " + total_damage + " of damage and your score is " + character.score + " points");
        System.out.println(".........................................................................................................");

        character.change_health_character(first_health);
        character.change_mana(first_mana);
        total_damage = 0;

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

    }
    
}


