package formFields;

import com.github.javafaker.Faker;

import java.util.concurrent.ThreadLocalRandom;


public class RandomValue<phone> {

    Faker faker = new Faker();

    public String  firstName = faker.name().firstName();
    public String lastName = faker.name().lastName();
    public String streetAddress = faker.address().streetAddress();
    public String email = faker.internet().emailAddress();

    public static String getRandomPhone(){
        return "9"+ getRandomLong(111111111L,999999999L);
    }
    private static long getRandomLong(long min, long max) {
        return ThreadLocalRandom.current().nextLong(min,max);
    }

    public String phone = getRandomPhone();

    public String   hobby1 = "Sports",
                    hobby2 = "Reading",
                    hobby3 = "Music";

    public String gender = "Male";
    public String subjectsInput = "Computer Science";

    public String state = "Rajasthan";
    public String city = "Jaiselmer";


}
