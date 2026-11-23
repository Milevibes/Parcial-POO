package clases;

public class Pokemon {
    private int id ;
    private String number;
    public String name;
    public String type;
    public String level;
    public String trainer;

    public Pokemon (String name, String number, String type, String level){
        this.id = (int) (Math.random()*900) +100;
        this.name = name;
        this.number = number;
        this.type = type;
        this.level = level;
        this.trainer = "Sin entrenador";
    }
    public Pokemon()
    {}

    public String PokemonToCSV()
    {
        return id + "," + name + "," + number +"," + type + "," + level + "," + trainer;
    }
}
