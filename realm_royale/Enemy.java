package realm_royale;

public class Enemy{

    private int damage_e, health_e, protection_e;

    private String name_e;

    public Enemy(String name_e, int damage_e, int health_e, int protection_e){

        this.name_e=name_e;

        this.damage_e=damage_e;

        this.health_e=health_e;

        this.protection_e=protection_e;

    }

//------------------name-------------------------

    public String name_enemy(){

        return name_e;

    }

    public void change_name_enemy(String name_e){

        this.name_e=name_e;

    }

//-----------------damage--------------------------

    public int damage_enemy(){

        return damage_e;

    }

    public void change_damage_enemy(int damage_e){

        this.damage_e=damage_e;

    }

//-----------------health--------------------------

    public int health_enemy(){

        return health_e;

    }

    public void change_health_enemy(int health_e){

        this.health_e=health_e;

    }

//--------------------protection--------------------

    public int protection_enemy(){

        return protection_e;

    }

    public void change_protection_enemy(int protection_e){

        this.protection_e=protection_e;

    }

//--------------------random-------------------------

    public byte random_enemy(){

        double random = Math.random()*10;

        byte random_num = (byte)random;

        if(random_num<=2 && random_num>0){

            return 1;

        }else if(random_num<=5){

            return 2;

        }else{                                                          

            return 3;

        }
        
    }

    public byte random_attack(){

        double random = Math.random()*100;

        byte random_num = (byte) random;

        if(random_num>0 && random_num<=60){

            return 1;                          //attack

        }else if(random_num<=80){

            return 2;                          //ultraattack

        }else{

            return 3;                          //heal

        }

    }
    
}
