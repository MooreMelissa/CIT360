/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javacollections;

import java.util.*;



/**
 *
 * @author melissamoore
 */
public class JavaCollections {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // run all of the java collection in here
      JavaCollections.arrayListExample();
      JavaCollections.treeSetExample();
      JavaCollections.hashMapExample(); 
      JavaCollections.treeMapExample();
      JavaCollections.queueExample();
      
    } 
    
        // Java Collection ArrayList
    public static void arrayListExample() {
        
        System.out.println("\nStarting ArrayList Examples\n");
        
        //Make a new array list
        List<String> names = new ArrayList<>();
        
        //add to the list
        names.add("Steve");
        names.add("Tim");
        names.add("Lucy");
        names.add("Pat");
        names.add("Angela");
        names.add("Tom");
        
        // display list
        System.out.println(names);
        
        //get size of array
        System.out.println("The size of the array is: " + names.size());
        
        //Adding "Rachel" at the 3rd position
        names.add(3, "Rachel"); 
        //adding a duplicate to see how it handles it
        names.add("Steve");
        
        //get size of array, after adding a duplicate name to the list
        //The arraylist doesn't care if there are duplicates, because in a Java List 
        //the same element can occur more than once.
        System.out.println("The size of the array is: " + names.size());
                   
        // Removing "Steve" and "Angela"
        names.remove("Lucy");
        names.remove("Angela");
        
        //displaying elements now
        System.out.println(names);
        
        // Removing 1st element in array list
        names.remove(0);
        
        // displaying elements
        System.out.println(names);
        
        
    }
    
    public static void treeSetExample() {
        System.out.println("\nStarting TreeSet Examples\n");
        
        // make a new Tree Set of String Type
        Set<String> treeStr = new TreeSet<>();
        
        //Adding elements to TreeSet<String>
        treeStr.add("XYZ");
        treeStr.add("Pink");
        treeStr.add("Test");
        treeStr.add("Pen");
        treeStr.add("Paper");
        treeStr.add("Ink");
        treeStr.add("Ginger");
        
        // will add to tree set a duplicate to see what it does. In a Java Set 
        // the same element cannot occur more than once.
        treeStr.add("Paper");
        
        //get size of set, it removes duplicates
        System.out.println("The set size is: " + treeStr.size());
        
        //Display TreeSet
        System.out.println(treeStr);
        
        
        //TreeSet of Integer Type
        Set<Integer> treeInt = new TreeSet<>();
        
        // add elements to TreeSet<Integer>
        treeInt.add(99);
        treeInt.add(3);
        treeInt.add(200);
        treeInt.add(0);
        treeInt.add(24);
        treeInt.add(99); //duplicate 
        
        
        // is the set empty? (returns a boolean)
        System.out.println("Is the set empty? " + treeInt.isEmpty());
        
        //display Tree Set
        System.out.println("The set size is: " + treeInt.size());
        
        // clear the list
        treeInt.clear();
        
        //get size of set
        System.out.println("The set size is now: " + treeInt.size());
        
    }
    
    public static void hashMapExample() {
        
        System.out.println("\nStarting HashMap Examples\n");
        
        // make a new hash map
        Map<String, Integer> promap = new HashMap<>();
        
        // adding elements into the hash map (name, age)
        promap.put("Barbara", 30);
        promap.put("Sammy", 5);
        promap.put("Ruth", 10);
        promap.put("Simon", 8);
        promap.put("Randy", 50);
        promap.put("Randy", 18); // duplicate name see what it does
        promap.put("John", 18);
        
        //Display content using Iterator
        Set set = promap.entrySet();
        Iterator iterator = set.iterator();
        while(iterator.hasNext()) {
            Map.Entry mapentry = (Map.Entry)iterator.next();
            System.out.print("Name: " + mapentry.getKey() + " Age: ");
            System.out.println(mapentry.getValue());
        }
        
        // getting age from map for Randy, notice how it removes a duplicate key 
        //and uses the latest value put in
        System.out.println("\nWhat is the age of Randy: " + promap.get("Randy"));
        
        //check to see if the map contains Rachel, (returns a boolean) 
        System.out.println("The hash map contains Rachel: " + promap.containsKey("Rachel"));
        
        // check to see if the map contains the value (example using age) in the hash map
        // returns a boolean
        System.out.println("Does the hash map contain the value of 18? " + promap.containsValue(18));
    }
    
    public static void treeMapExample(){
        System.out.println("\nStarting TreeMap Examples\n");
        
        // make a new tree map 
        Map<Integer, String> sidmap = new TreeMap<>();
        
       //Adding elements to the tree map (student id number , name)
       sidmap.put(345, "Marjorie");
       sidmap.put(7, "Gary");
       sidmap.put(445, "Susan");
       sidmap.put(987, "Bart");
       sidmap.put(55, "Brennan");
       sidmap.put(345, "Sally"); //duplicate to see how it handles it
       
       //display content using Iterator, notice that it removes the duplicate and uses the latest value
       Set names = sidmap.entrySet();
       Iterator iterator = names.iterator();
       while(iterator.hasNext()) {
           Map.Entry mapentry = (Map.Entry)iterator.next();
           System.out.print("Student ID: " + mapentry.getKey() + " Name: ");
           System.out.println(mapentry.getValue());
       }
       
       //get the size of the map
       System.out.println("The size of the tree map is: " + sidmap.size());
       
       //see if map contains "Tim" (returns a boolean)
       System.out.println("Does this tree map contain the name Tim? " + sidmap.containsValue("Tim"));
       
       // see if map contains student id 55 (returns boolean)
       System.out.println("Does the tree map contain the Student ID 55? " + sidmap.containsKey(55));
       
       // remove element mapped to 987
       Object removedElement = sidmap.remove(987);
       System.out.println("Remove Student: " + removedElement);
       
       // display size of tree map after removed element
       System.out.println("The size of the tree map after removing element is " + sidmap.size());
       
       //display treemap after removed element
       System.out.println("Display Map after Element moved: " + sidmap.entrySet());
       
       //clear tree map and get size
       sidmap.clear();
       System.out.println("The size of the tree map after clearing it is " + sidmap.size());
    }
    
    public static void queueExample() {
        System.out.println("\nStarting Queue Example");
        
        //we can't create instance of a Queue as it is an interface
        //we can create instance of LinkList or Priority Queue and assign it to Queue
        Queue<String> namque = new LinkedList<>();
        
        //Adding elements to the Queue
        namque.add("Rick");
        namque.add("Maggie");
        namque.add("Sam");
        namque.add("Amber");
        namque.add("Rebekah");
        namque.add("Maggie"); //duplicate name 
        
        // Display size of queue
        System.out.println("The size of queue: " + namque.size());
        
        //Display elements in the Queue, notice it will accept duplicate  it is put in order received
        System.out.println("Elements in Queue:" + namque);
       
        
        //remove element from Queue using remove() method, it would remove first element from Queue
        System.out.println("Removed element: " + namque.remove());
        
        // display who is first or head in Queue using element()
        System.out.println("Display Head of Queue: " + namque.element());
        
        // poll() removes and returns the head of Queue. return null is queue is empty
        System.out.println("Remove and return the head of the Queue using poll(): " + namque.poll());
        
        // peek() works same as element() method, except it returns null if the queue is empty
        System.out.println("Display who is head of Queue using peek(): " + namque.peek());
        
        //Display queue elements now
        System.out.println("Elements in Queue:" + namque);
       
    } 
}
