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
