import java.io.IOException;
import javax.swing.*;

public class Main {

    public static void main(String[] args) throws IOException{

        int first_health, first_mana, character_mana, character_damage, total_protection_w, character_protection, character_health, enemy_health, enemy_damage, total_damage, second_health, second_mana;
        String option, character_name, character_weapon, armored_character, enemy_name;
        byte character_level, character_potions_health, character_potions_mana, helmet_armor_w, chest_armor_w, hands_armor_w, greaves_armor_w, random_enemy;
        Character character;
        Enemy enemy;
        byte inventory[];

        do{

            option = JOptionPane.showInputDialog("Choose your class\n.Warrior\n.Assassin\n.Hunter\n.Wizard\n.Engineer");

        }while(option.equalsIgnoreCase("warrior")==false && option.equalsIgnoreCase("assassin")==false && option.equalsIgnoreCase("hunter")==false && option.equalsIgnoreCase("wizard")==false && option.equalsIgnoreCase("engineer")==false);

        character = new Character("none", 0, 0, 0,"hand", 0, false, false, false, false);
        inventory = new byte[2];

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
        
        first_health = character.health_character();
        first_mana = character.mana();
        character_name = character.name_character();
        character_mana = character.mana();
        character_weapon = character.weapon();
        character_damage = character.damage();
        character_level = character.level();

        System.out.println(".You are at level " + character_level);
        System.out.println(".Your class is: " + character_name);
        System.out.println(".Your weapon is: " + character_weapon);

        armored_character = "";

        do{

            armored_character = JOptionPane.showInputDialog("Open this box\nWrite 'OK' to open it.");

        }while(armored_character.equalsIgnoreCase("ok")==false);

        JOptionPane.showMessageDialog(null, "Congratulations you got some armor and inventory");    
        
        character.use_potions();
        character_potions_health = character.potions_health();
        character_potions_mana = character.potions_mana();
        inventory[0] = character_potions_health;
        inventory[1] = character_potions_mana;

        total_protection_w = 0;
                
//-----------------------------------armor-character-------------------------------------------------------------------------------

        helmet_armor_w = (byte) character.use_helmet();
        chest_armor_w = (byte) character.use_chest();
        hands_armor_w = (byte) character.use_hands();
        greaves_armor_w = (byte) character.use_greaves();

        Actions.box_helmet(helmet_armor_w);
        Actions.box_chest(chest_armor_w);
        Actions.box_hands(hands_armor_w);
        Actions.box_greaves(greaves_armor_w);

        total_protection_w += helmet_armor_w;
        total_protection_w += chest_armor_w;
        total_protection_w += hands_armor_w;
        total_protection_w += greaves_armor_w;
    
        
        character.change_protection_character(total_protection_w);
        character_protection = character.protection_character();
        character_health = character.health_character() + character_protection;

        System.out.println(".You have " + character_health + " of health plus protection and " + character_mana + " of mana");
        System.out.println(".You have " + character_damage + " of damage");
        System.out.println(".You have " + character_potions_health + " potions of health");
        System.out.println(".You have " + character_potions_mana + " potions of mana");
        System.out.println(".........................................................................");

//-------------------------------------------enemy----------------------------------------------------------------//

        JOptionPane.showMessageDialog(null, "There is an enemy in front of you");        

        enemy = new Enemy("none", 0, 0, 0);

        random_enemy = enemy.random_enemy();

        if(random_enemy==1){

            Actions.enemy_changes(enemy, "Ant", 125, 250, 70);

        }else if(random_enemy==2){

            Actions.enemy_changes(enemy, "Bot", 260, 1000, 250);

        }else{

            Actions.enemy_changes(enemy, "Necromancer", 300, 2500, 300);

        }   

        enemy_name = enemy.name_enemy();
        enemy_health = enemy.health_enemy() + enemy.protection_enemy();
        enemy_damage = enemy.damage_enemy();

        JOptionPane.showMessageDialog(null, enemy_name + " has appeared", "Enemy appeared", 2);
        System.out.println(enemy_name + " Has " + enemy_health + " of health plus protection and make " + enemy_damage + " of damage");

//-------------------------------level-1---------------------------------------------------------------------------------------------------------------------------------------------------------------------------

        total_damage = Actions.fight(character, enemy, inventory, first_health, first_mana, 120, 400, 40, 0);

//-------------------------------------------level-2-----------------------------------------------------------------------------------------------------------------------------------------

        JOptionPane.showMessageDialog(null, "Congratulations, you defeated " + enemy_name + "\nYou made " + total_damage + " of damage and your score is " + character.score() + " points", "Enemy defeated", 1);

        System.out.println(".........................................................................................................");
        System.out.println("Congratulations, you defeated " + enemy_name + "\nYou made " + total_damage + " of damage and your score is " + character.score() + " points");
        System.out.println(".........................................................................................................");

        character.change_health_character(first_health);
        character.change_mana(first_mana);

        character_level++;
        character.levels(character_level);

        second_health = character.health_character();
        second_mana = character.mana();
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

//----------------------------------second-combat---------------------------------------------------------------------------------------------------------------------------------------------------------------
    
        total_damage = Actions.fight(character, enemy, inventory, first_health, first_mana, 240, 300, 30, 250);

//-------------------------------------------level-3-----------------------------------------------------------------------------------------------------------------------------------------

        JOptionPane.showMessageDialog(null, "Congratulations, you defeated " + enemy_name + "\nYou made " + total_damage + " of damage and your score is " + character.score() + " points", "Enemy defeated", 1);

        System.out.println(".........................................................................................................");
        System.out.println("Congratulations, you defeated " + enemy_name + "\nYou made " + total_damage + " of damage and your score is " + character.score() + " points");
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

//----------------------------------third-combat---------------------------------------------------------------------------------------------------------------------------------------------------------------
    
        total_damage = Actions.fight(character, enemy, inventory, first_health, first_mana, 360, 200, 20, 500);

//-------------------------------------------level-4-----------------------------------------------------------------------------------------------------------------------------------------

        JOptionPane.showMessageDialog(null, "Congratulations, you defeated " + enemy_name + "\nYou made " + total_damage + " of damage and your score is " + character.score() + " points", "Enemy defeated", 1);

        System.out.println(".........................................................................................................");
        System.out.println("Congratulations, you defeated " + enemy_name + "\nYou made " + total_damage + " of damage and your score is " + character.score() + " points");
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

//----------------------------------fourth-combat---------------------------------------------------------------------------------------------------------------------------------------------------------------
    
        total_damage = Actions.fight(character, enemy, inventory, first_health, first_mana, 480, 100, 10, 750);

//------------------------------------------last-level------------------------------------------------------------------------------------------------------------------------------------------

        JOptionPane.showMessageDialog(null, "Congratulations, you defeated " + enemy_name + "\nYou made " + total_damage + " of damage and your score is " + character.score() + " points", "Enemy defeated", 1);

        System.out.println(".........................................................................................................");
        System.out.println("Congratulations, you defeated " + enemy_name + "\nYou made " + total_damage + " of damage and your score is " + character.score() + " points");
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

        JOptionPane.showMessageDialog(null, enemy_name + " has appeared", "Boss appeared", 2);
        System.out.println(enemy_name + " Has " + enemy_health + " of health plus protection and make " + enemy_damage + " of damage");

//----------------------------------------------------------last-fight------------------------------------------------------------------------------------------------------------------------------

        total_damage = Actions.fight(character, enemy, inventory, first_health, first_mana, 600, 0, 0, 1000);

        System.out.println(".........................................................................................................");
        System.out.println("Congratulations, you defeated " + enemy_name + " and finished the game." + "\nYou made " + total_damage + " of damage and your score is " + character.score() + " points");
        System.out.println(".........................................................................................................");

        Window window = new Window(character_health, character_mana, character.score(), total_damage, 1);
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Writing_file file = new Writing_file(character_name, character_weapon, character_health, character_mana, total_damage, character.score());
        file.writing();

    }
    
}


