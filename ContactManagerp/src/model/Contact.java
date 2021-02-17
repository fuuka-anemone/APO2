package model;

public class Contact {

    private String name, email;
    private Integer num;

    public Contact(String ne, String em, Integer num){
        this.name = ne;
        this.email = em;
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Integer getNum(){
        return num;
    }
}
