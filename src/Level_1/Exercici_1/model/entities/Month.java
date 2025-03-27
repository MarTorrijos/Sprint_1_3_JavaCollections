package Level_1.Exercici_1.model.entities;


public class Month {

    private final String name;

    public Month(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

    // Esto hace que el identificador de un objeto Month sea su nomnre
    @Override
    public int hashCode() {
        return name.hashCode();
    }

    // Y si el nombre es el mismo, no se añade al HashSet
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Month other = (Month) obj;
        return name.equals(other.name);
    }

}
