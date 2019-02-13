/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsonexample;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import org.json.simple.*;
import org.json.simple.parser.*;

/**
 *
 * @author melissamoore
 */
public class JsonExample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, Exception {
        // creating JSONObject
        JSONObject person = new JSONObject();
        //JsonObject person = new JsonObject();

        //putting data to JSONObject
        person.put("lName", "Johnson");
        person.put("fName", "Miranda");

        //address data, create LinkedHashMap
        Map addMap = new LinkedHashMap(4);
        addMap.put("streetAddress", "2100 South 3rd Street");
        addMap.put("city", "Elkhorn");
        addMap.put("state", "NE");
        addMap.put("postalCode", "68088");

        //putting address to JSONObject
        person.put("address", addMap);

        // for phone numbers, create JSONAarray
        JSONArray phone = new JSONArray();
        //JsonArray phone = new JsonArray();

        addMap = new LinkedHashMap(2);
        addMap.put("type", "home");
        addMap.put("number", "555-555-5555");

        //adding map to list
        phone.add(addMap);

        //putting phoneNumbers to JsonObject
        person.put("phoneNumbers", phone);

        try (FileWriter file = new FileWriter("JsonPerson")) {
            file.write(person.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //parsing file need .json file 
        Object readObj = new JSONParser().parse(new FileReader("JsonPerson"));

        //typecasting obj to JSONObject
        JSONObject persons = (JSONObject) readObj;

        // getting lName and fName
        String lName = (String) persons.get("lName");
        String fName = (String) persons.get("fName");

        System.out.println(lName);
        System.out.println(fName);

        //getting address
        Map addresses = ((Map) persons.get("address"));

        // getting address
        Iterator<Map.Entry> itr1 = addresses.entrySet().iterator();
        while (itr1.hasNext()) {
            Map.Entry pair = itr1.next();
            System.out.println(pair.getKey() + " : " + pair.getValue());
        }

        //getting phoneNumbers
        JSONArray phones = (JSONArray) persons.get("phoneNumbers");

        //iterating phoneNumbers
        Iterator itr2 = phones.iterator();

        while (itr2.hasNext()) {

            itr1 = ((Map) itr2.next()).entrySet().iterator();
            while (itr1.hasNext()) {
                Map.Entry pair = itr1.next();
                System.out.println(pair.getKey() + " : " + pair.getValue());
            }
        }

    }

}
