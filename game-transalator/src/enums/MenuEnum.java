package enums;

public enum MenuEnum {

    START(1,"Start"),
    ADD_WORD(2,"Add word"),
    SEE_HISTORY(3,"See history"),
    EXIT(0,"Exit");

    private int id;
    private String status;

     MenuEnum(int id,String status){
        this.id=id;
        this.status=status;
    }

    public  int getId() {
        return id;
    }

    public  String getStatus() {
        return status;
    }

}
