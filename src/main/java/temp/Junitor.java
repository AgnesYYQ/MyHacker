package temp;// You are given a collection of person objects (in a natural manner for the
// language you're writing in) with three fields:

// {firstName, lastName, age} e.g. {Jane, Smith, 14}

// We want to know which family has the longest line of "juniors".
// A family has "juniors" when multiple family members have the same full name.

// Consider the following example.
// [
//     {firstName: "John",  lastName: "Doe",   age: 13},
//     {firstName: "John",  lastName: "Doe",   age: 32},
//     {firstName: "John",  lastName: "Doe",   age: 62},
//     {firstName: "Janet", lastName: "Doe",   age: 14},
//     {firstName: "Jenny", lastName: "Smith", age: 34},
//     {firstName: "Jenny", lastName: "Smith", age: 12},
// ]

// In this example, the Doe family has the longest line of juniors.

// Let’s talk about your plan of attack before you start coding, and remember
// to keep talking me through what you are doing as you code.

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class Junitor {
    class Person {
        String firstName;
        String lastName;
        int age;
    }

    public String findMaxJunitor(ArrayList<Person> info) {
        HashMap<String, Integer> map = new HashMap<>();
        int max = 0;
        String res = "";

        for (Person person : info) {
            String fullName = person.firstName + " " + person.lastName;
            if (map.containsKey(fullName)) {
                int count = map.get(fullName) + 1;
                map.put(fullName, count);
                if (count > max) {
                    res = person.lastName;
                    max = count;
                }
            } else {
                map.put(fullName, 1);
                if (max < 1) {
                    max = 1;
                    res = person.lastName;
                }
            }
        }
        return res;

        /*for (Map.Entry<String, Integer> entry : map.entrySet()) {
            int count = entry.getValue();
            if (count > max) {
                res = entry.getKey();
                max = count;
            }
        }
        String[] strs = res.split(" ");
        return strs[1]; */
    }

    public static void main(String[] args) {
        System.out.println("Hello Java");
    }
}
