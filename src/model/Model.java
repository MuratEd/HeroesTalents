package model;

import javafx.scene.image.Image;
import model.file.CSVFile;
import model.file.JSONFile;
import model.hero.Ability;
import model.hero.Hero;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Observable;

public class Model extends Observable {

    //VARIABLES
    private ArrayList<Hero> heroesList; //List that contains datas of each hero (see Hero class)
    private String heroSelected;

    //CONSTRUCTOR
    public Model() {
        createListHeroesJSON();
        //Setup the list of spells
        //createListSpells();

        //Setup the list of heroes
        //createListHeroes();
    }

    private void createListHeroesJSON() {
        CSVFile metadata = new CSVFile("res/meta.csv");
        heroesList = new ArrayList<>(metadata.getTable().size());
        for(int i=0 ; i<metadata.getTable().size() ; ++i) {
            JSONFile json = new JSONFile("res/heroes/"+metadata.getValue(i,0)+"/data.json");
            heroesList.add(json.getHero());
        }
    }

    /*
    //Method dedicate to constructor of Model
    //Read the CSV of heroes and load it into heroesList variable
    private void createListHeroes() {
        //Reading of the CSV that contains Heroes datas with CSVFile object (see CSVFile class)
        CSVFile heroFile = new CSVFile("res/description/heroes.txt");

        //Add all of the list into heroesList (see Variables)
        heroesList = new ArrayList<>();
        for (int i = 0 ; i<heroFile.getTable().size() ; ++i) {
            String name = heroFile.getValue(i,0);
            String title = heroFile.getValue(i,1);
            Image img = new Image(heroFile.getValue(i,2));
            //SpellList spellList = new SpellList(this,name);
            heroesList.add(new Hero(name,title,img));
        }
    }

    //Method dedicate to constructor of Model
    //Read the CSVF of spells and load it into spellList variable
    private void createListSpells() {
        //Read the CSV that contains spells datas with CSVFile object (see CSVFile)
        CSVFile spellFile = new CSVFile("res/description/spells.txt");
        try {
            spellFile.readCSV();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //Add all spells into spellList variable (see Variables)
        spellList = new ArrayList<>();
        for (int i = 0 ; i<spellFile.getTable().size() ; ++i) {
            spellList.add(new Spell(
                    spellFile.getValue(i,0), //Hero name
                    spellFile.getValue(i,1), //Key affected
                    Integer.parseInt(spellFile.getValue(i,2))==1, //Primary spell (if 1, is Primary, else, is Secondary)
                    spellFile.getValue(i,3), //Spell name
                    new Image(spellFile.getValue(i,4)), //Spell icon
                    spellFile.getValue(i,5), //Spell description
                    Integer.parseInt(spellFile.getValue(i,6)), //Mana cost (if no cost, 0)
                    Integer.parseInt(spellFile.getValue(i,7)) //Cooldown (if no cooldown, 0)
            ));
        }
    }
    */

    //GETTER SETTER
    public ArrayList<Hero> getHeroesList() {
        return heroesList;
    }
    public String getHeroSelected() {
        return heroSelected;
    }
    public void setHeroSelected(String heroSelected) {
        this.heroSelected = heroSelected;
        setChanged();
        notifyObservers();
    }
}
