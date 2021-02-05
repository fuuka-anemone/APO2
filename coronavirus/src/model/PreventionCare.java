package model;

public class PreventionCare {

    private int careNumber;

    public PreventionCare(){}

    public void setCareNumber(int careNumber) {
        this.careNumber = careNumber;
    }

    public String getTextCare(){
        String textCare = null;
        switch (careNumber){
            case 1:
                textCare = "Wash your hands with soap frequently";
                break;
            case 2:
                textCare = "Sneeze or cough into your flexed elbow";
                break;
            case 3:
                textCare = "Avoid touching your eyes, nose and mouth";
                break;
            case 4:
                textCare = "Keep spaces well ventilated";
                break;
            case 5:
                textCare = "Disinfect frequently used objects";
                break;
        }
        return textCare;
    }

}
