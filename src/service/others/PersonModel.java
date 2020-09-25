package service.others;


public class PersonModel {
    private String name;
    private String age;
    private String applicationId;
    public PersonModel() {

    }
    public PersonModel(String name , String age, String applicationId) {
         this.name = name;
         this.age = age;
         this.applicationId = applicationId;
    }
    public String toString () {
        return this.name + "::" +this.age + "::" +this.applicationId;
    }


    public void setName(String name) {
        this.name = name;
    }
    public void setAge(String age) {
        this.age = age;
    }
    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    public String getName() {
        return name;
    }
    public String getAge() {
        return age;
    }
    public String getApplicationId() {
        return applicationId;
    }

    public  void updateName(String name) {
        this.name = name;
    }
}
