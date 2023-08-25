package africa.QuadKing.Blogger.dtos.requests;

public class RegisterRequest {
    
    private String lastName;
    private String userName;
    private String firstName;
    private String password;
    
    @Override
    public String toString(){
        return "RegisterRequest{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" +  lastName + '\'' +
                ", lastName='" +  userName + '\'' +
                ", lastName='" +  password + '\'' +
                '}';
    }
    
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    public String setFirstName() {
        return firstName;
    }
    
    
    
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    public String getLastName() {
        return lastName;
    }


    public void setUserName(String userName){
        this.userName = userName;
    }
    public String getUserName() {
        return userName;
    }

    public void setPassword(String password){
        this.password = password;
    }
    public String getPassword() {
        return password;
    }

    public void lastName(String lastName) {
    }

    public void firstName(String firstName) {
    }

    public void userName(String userName) {
    }
}
