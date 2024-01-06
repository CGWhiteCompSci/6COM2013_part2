package src;

public class Name {
    private String fullName;
    private String firstName;
    private String middleName;
    private String lastName;

    public Name(String fullName) {
        this.fullName = fullName;

        String[] names = fullName.split(" ");
        if (names.length > 2) {
            this.middleName = names[1];

        }
        if (names.length > 3){

            for (int i = 2; i < (names.length-2); i++){
                this.middleName = this.middleName + " " + names[i];
            }
        }


        try {
            this.lastName = names[names.length-1];
        }
        finally {
            this.firstName = names[0];

        }


    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String genIntials(){
        String intials = "";
        String[] names = fullName.split(" ");
        for (int i = 0; i < (names.length); i++){
            intials = intials + names[i].charAt(0);
        }
        return intials;
    }


}






