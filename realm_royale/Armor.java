import interfaces.Chest;
import interfaces.Greaves;
import interfaces.Hands;
import interfaces.Helmet;

public class Armor implements Helmet, Chest, Hands, Greaves{

    public boolean helmet;
    
    public boolean chest;

    public boolean hands;

    public boolean greaves;

    public Armor(boolean helmet, boolean chest, boolean hands, boolean greaves){

        this.helmet=helmet;
        this.chest=chest;
        this.hands=hands;
        this.greaves=greaves;

    }

//-----------------------helmet----------------------------------------------------------

    public int use_helmet(){

        double random = Math.random()*12;

        byte number = (byte) random;

        helmet=true;
        
        if(number<=2 && number>0){

            return Helmet.common_helmet;

        }else if(number<=4){

            return Helmet.rare_helmet;

        }else if(number<=6){

            return Helmet.ultrarare_helmet;

        }else if(number<=8){

            return Helmet.epic_helmet;

        }else if(number<=10){

            return Helmet.legendary_helmet;

        }else{

            helmet=false;
            return 0;

        }

    }

//-----------------------chest----------------------------------------------------------

    public int use_chest(){

        double random = Math.random()*12;

        byte number = (byte) random;

        chest=true;

        if(number<=2 && number>0){

            return Chest.common_chest;

        }else if(number<=4){

            return Chest.rare_chest;

        }else if(number<=6){

            return Chest.ultrarare_chest;

        }else if(number<=8){

            return Chest.epic_chest;

        }else if(number<=10){

            return Chest.legendary_chest;

        }else{

            chest=false;
            return 0;

        }

    }

//-----------------------hands----------------------------------------------------------

    public int use_hands(){

        double random = Math.random()*12;

        byte number = (byte) random;

        hands=true;

        if(number<=2 && number>0){

            return Hands.common_hands;

        }else if(number<=4){

            return Hands.rare_hands;

        }else if(number<=6){

            return Hands.ultrarare_hands;

        }else if(number<=8){

            return Hands.epic_hands;

        }else if(number<=10){

            return Hands.legendary_hands;

        }else{

            hands=false;
            return 0;

        }

    }

//-----------------------greaves----------------------------------------------------------

    public int use_greaves(){

        double random = Math.random()*12;

        byte number = (byte) random;

        greaves=true;

        if(number<=2 && number>0){

            return Greaves.common_greaves;

        }else if(number<=4){

            return Greaves.rare_greaves;

        }else if(number<=6){

            return Greaves.ultrarare_greaves;

        }else if(number<=8){

            return Greaves.epic_greaves;

        }else if(number<=10){

            return Greaves.legendary_greaves;

        }else{

            greaves=false;
            return 0;

        }

    }

}