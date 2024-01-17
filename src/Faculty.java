public class Faculty extends Person{
    private String occupation;

    public Faculty(String firstName, String lastName, String phoneNumber, String occupation) {
        super(firstName, lastName, phoneNumber);
        this.occupation = occupation;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }
    @Override
    public String toString() {
        return super.toString() + " Occupation: " + occupation;
    }

}
