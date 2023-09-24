package enums;

public enum EnumException {
    ILLEGAL_CHARACTER_EXCEPTION("Yanlış simvol daxil edildi!"),
    ILLEGAL_POINT_EXCEPTION ("Point mənfi dəyər ala bilməz!");

    private String message;

    private EnumException(String message){
        this.message=message;
    }

    public String getMessage() {
        return message;
    }
}
