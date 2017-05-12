package model;

import model.file.CSVFile;
import model.file.JSONFile;
import model.hero.Hero;

import java.util.ArrayList;
import java.util.Observable;

public class Model extends Observable {

    //VARIABLES
    private ArrayList<Hero> heroesList; //List that contains datas of each hero (see Hero class)
    private String heroSelected;

    //CONSTRUCTOR
    public Model() {
        createListHeroesJSON();
    }

    private void createListHeroesJSON() {
        CSVFile metadata = new CSVFile("res/meta.csv");
        heroesList = new ArrayList<>(metadata.getTable().size());
        for(int i=0 ; i<metadata.getTable().size() ; ++i) {
            JSONFile json = new JSONFile("res/heroes/"+metadata.getValue(i,0)+"/data.json");
            heroesList.add(json.getHero());
        }
    }

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
