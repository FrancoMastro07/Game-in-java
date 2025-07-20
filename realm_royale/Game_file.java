import java.io.FileWriter;
import java.io.IOException;
import java.util.GregorianCalendar;

class Writing_file{

    private String char_name, char_weapon;
    private int char_health, char_mana, char_damage, char_score;

    public Writing_file(String char_name, String char_weapon, int char_health, int char_mana, int char_damage, int char_score){

        this.char_name=char_name;
        this.char_weapon=char_weapon;
        this.char_health=char_health;
        this.char_mana=char_mana;
        this.char_damage=char_damage;
        this.char_score=char_score;

    }

    public void writing() throws IOException{

        FileWriter file = new FileWriter("realm_royale/game.txt", true);
    
        GregorianCalendar date = new GregorianCalendar();

        int day = date.get(GregorianCalendar.DAY_OF_MONTH);
        int month = date.get(GregorianCalendar.MONTH) + 1;
        int year = date.get(GregorianCalendar.YEAR);
        int hour = date.get(GregorianCalendar.HOUR_OF_DAY);
        int minute = date.get(GregorianCalendar.MINUTE);
        int second = date.get(GregorianCalendar.SECOND);

        String text = day + "/" + month + "/" + year + " at " + hour + ":" + minute + ":" + second + "\n.CHARACTER NAME: " + char_name + "\n.CHARACTER WEAPON: " + char_weapon + "\n.CHARACTER HEALTH: " + char_health
        + "\n.CHARACTER MANA: " + char_mana + "\n.CHARACTER DAMAGE: " + char_damage + "\n.CHARACTER SCORE: " + char_score + "\n-----------------------------\n";

        for(int i=0;i<text.length();i++){

            file.write(text.charAt(i));

        }

        file.close();

    }

}




    

