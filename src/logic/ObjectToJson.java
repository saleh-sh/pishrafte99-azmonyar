package logic;

import java.io.IOException;
import org.codehaus.jackson.map.ObjectMapper;

public class ObjectToJson {

    public static void main(String[] args) {

        // Creating object of Organisation 
        Organisation org = new Organisation();

        // Insert the data into the object 
        org = getObjectData(org);

        // Creating Object of ObjectMapper define in Jakson Api 
        ObjectMapper Obj = new ObjectMapper();

        try {

            // get Oraganisation object as a json string 
            String jsonStr = Obj.writeValueAsString(org);

            // Displaying JSON String 
            System.out.println(jsonStr);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Get the data to be inserted into the object 
    public static Organisation getObjectData(Organisation org) {

        // Insert the data 
        org.setOrganisation_name("GeeksforGeeks");
        org.setDescription("A computer Science portal for Geeks");
        org.setEmployees(2000);

        // Return the object 
        return org;
    }
}





class Organisation {

    private String organisation_name;
    private String description;
    private int Employees;

    // Calling getters and setters 
    public String getOrganisation_name() {
        return organisation_name;
    }

    public void setOrganisation_name(String organisation_name) {
        this.organisation_name = organisation_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getEmployees() {
        return Employees;
    }

    public void setEmployees(int employees) {
        Employees = employees;
    }

    // Creating toString 
    @Override
    public String toString() {
        return "Organisation [organisation_name="
                + organisation_name
                + ", description="
                + description
                + ", Employees="
                + Employees + "]";
    }
}
