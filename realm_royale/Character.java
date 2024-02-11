package realm_royale;

public class Character extends Armor{

    private String name;

    private int health;

    private int protection;

    private int mana;

    private String weapon;

    private byte potions_health;

    private byte potions_mana;

    private int damage;

    public byte level;

    public int score;

    public Character(String name, int health, int protection, int mana, String weapon, int damage, boolean helmet, boolean chest, boolean hands, boolean greaves){

        super(helmet, chest, hands, greaves);

        this.name=name;
        this.health=health;
        this.protection=protection;
        this.mana=mana;
        this.weapon=weapon;
        potions_health=0;
        potions_mana=0;
        this.damage=damage;
        level=1;
        score=0;
        
    }

//----------------------name---------------------------------

    public String name_character(){

        return name;

    }

    public void change_name_character(String name){

        this.name=name;

    }

//--------------------health---------------------------------

    public int health_character(){

        return health;

    }

    public void change_health_character(int health){

        this.health=health;

    }

//--------------------protection-----------------------------

    public int protection_character(){

        return protection;

    }

    public void change_protection_character(int protection){

        this.protection=protection;

    }

//---------------------mana---------------------------------

    public int mana(){

        return mana;

    }

    public void change_mana(int mana){

        this.mana=mana;

    }

//---------------------weapon-------------------------------

    public String weapon(){

        return weapon;

    }

    public void change_weapon(String weapon){

        this.weapon=weapon;

    }

//---------------------potions-------------------------------

    public byte potions_health(){

        return potions_health;

    }

    public void change_potions_health(byte potions_health){

        this.potions_health=potions_health;

    }

    public byte potions_mana(){

        return potions_mana;

    }

    public void change_potions_mana(byte potions_mana){

        this.potions_mana=potions_mana;

    }

    public void use_potions(){

        double random = Math.random()*10;
        byte number = (byte) random;
        
        if(number>0 && number<=4){

            potions_health=3;
            potions_mana=1;

        }else if(number<=7){

            potions_health=5;
            potions_mana=2;

        }else if(number<=10){

            potions_health=1;
            potions_mana=3;

        }

    }

//---------------------damage--------------------------------

    public int damage(){

        return damage;

    }

    public void change_damage(int damage){

        this.damage=damage;

    }

//----------------------levels-------------------------------

    public void levels(byte level){

        this.level=level;

        if(level==2){

            health += 500;
            protection += 300;
            mana += 50;
            damage += 200;

        }else if(level==3){

            health += 600;
            protection += 400;
            mana += 60;
            damage += 200;

        }else if(level==4){

            health += 700;
            protection += 500;
            mana += 70;
            damage += 300;

        }else if(level==5){

            health += 800;
            protection += 600;
            mana += 80;
            damage += 400;

        }

    }

//-----------------scores-------------------------------------------

    public void scores(int score){

        this.score += score;

    }

}


