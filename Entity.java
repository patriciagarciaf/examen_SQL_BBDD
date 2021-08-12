import java.util.UUID;

public abstract class Entity{
    private UUID id;
    Entity entity;

    public UUID getId() {
        return this.id;
    }

    public void setId(UUID uuid) {
        this.id=uuid;
    }
    
    public void validate(){
    }
    

    //OVERRIDE DEL METODO EQUALS PARA QUE NO HAYAN OBJETOS CON EL MISMO ID AL METERLOS EN HASHSET
    @Override
    public boolean equals(Object obj){ 
        if (!(obj instanceof Entity)){ //SI EL OBJETO NO ES INSTACIA DE ENTIDAD, DAR FALSE 
            return false;       //NO HACE FALTA AFIRMAR, DIRECTAMENTE SE NIEGA
        }
        Entity entidad=(Entity) obj; //CAST EXPLICITO, OBJETO DE NIVEL INFERIOR ENTITY A NIVEL SUPERIOR OBJETO
        return entidad.getId().equals(this.getId());
    }

    @Override
    public int hashCode(){
        return this.getId().hashCode();
    }


}