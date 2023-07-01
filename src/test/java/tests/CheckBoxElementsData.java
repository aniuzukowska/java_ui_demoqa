package tests;

public class CheckBoxElementsData {
    public String[]
            desktop = {"desktop", "notes", "commands"};

    public String[] getCheckedBoxes(String value) {
        if (value.equalsIgnoreCase("desktop"))
            return desktop;
        else return null;
    }
}
