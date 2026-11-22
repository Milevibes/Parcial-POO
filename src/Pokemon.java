public class Pokemon {
    private double id ;
    private String number;
    public String name;
    public String type;
    public String level;
    public String trainer;

    public Pokemon (String name){
        this.name = name;
        this.id = Math.random()*100;
    }
    public Pokemon()
    {}

    public String PokemonToCSV()
    {
        return this.name ;
    }
}
