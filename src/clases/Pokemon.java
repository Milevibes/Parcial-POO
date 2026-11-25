package clases;
import java.util.UUID;

public class Pokemon {
    private String id ;
    private String number;
    private String name;
    private String type;
    private String level;
    public String trainer;

    public Pokemon (String name, String number, String type, String level){
        this.setId();
        this.name = name;
        this.number = number;
        this.type = type;
        this.level = level;
        this.trainer = "Sin entrenador";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public void setId() {
        this.id = UUID.randomUUID().toString().substring(0, 4);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getNumber() {
        return number;
    }
    public void setNumber(String number) {
        this.number = number;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    public String getLevel() {
        return level;
    }
    public void setLevel(String level) {
        this.level = level;
    }

    public String getTrainer() {
        return trainer;
    }

    public void setTrainer(String trainer) {
        this.trainer = trainer;
    }

    public Pokemon()
    {}
    public String PokemonToCSV()
    {
        return id + "," + name + "," + number +"," + type + "," + level + "," + trainer;
    }
    @Override
    public String toString() {
        return "#" + number + " " + name + " - " + type + " Nv." + level;
    }
    
}
