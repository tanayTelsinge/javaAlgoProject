import com.test.model.Employee;
import com.test.model.LinkedListTest;
import com.test.model.Patient;
import com.test.utils.ArrayAlgoUtils;

import java.util.*;
import java.util.stream.Collectors;

import static com.test.model.LinkedListTest.*;

public class test {

    public static void main(String[] args) {
        System.out.println("running java app");
        LinkedListTest linkedListTest = new LinkedListTest();
        linkedListTest.setRoot(2);
        Node second = new Node(3);
        Node third = new Node(4);
        Node fourth = new Node(6);
        third.setNextNode(fourth);
        second.setNextNode(third);
        linkedListTest.getRoot().setNextNode(second);

        //delete last
        //linkedListTest.deleteLast();
        //linkedListTest.deleteFirst();
        linkedListTest.addFirst(22);
        linkedListTest.addAtPos(5, 42);
        linkedListTest.addLast(32);
        
        linkedListTest.print();
        System.out.println();
        List<Employee> employeeList = new ArrayList<Employee>();
        employeeList.add(new Employee("Ram",11000, 25, "Male", "HR"));
        employeeList.add(new Employee("Shyam",15000, 39, "Male","IT"));
        employeeList.add(new Employee("Kiran",13000, 22, "Female","Admin"));
        employeeList.add(new Employee("Pooja",12000, 29, "Female","HR"));


        List<Patient> patientList = new ArrayList<>();
        patientList.add(new Patient("p1",22, "Corona", 12000));
        patientList.add(new Patient("p2",32, "TB", 8000));
        patientList.add(new Patient("p3",25, "Corona", 19000));
        patientList.add(new Patient("p4",27, "Rabies", 1000));

        List<Integer> nums = new ArrayList<>(Arrays.asList(12,11,9,5,6,20,40,66,11,5));



        //get distinct depts
        //System.out.println(employeeList.stream().map(Employee::getDept).distinct().collect(Collectors.toList()));

        //get avg age acc to gender
        System.out.println(employeeList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingInt(Employee::getAge))));

        //reverse int
        int num = 12345;
        int palindrome = 123454321;
        int[] sortedArrWithDuplicates = {0,0,1,1,1,2,2,3,3,4,4};
        System.out.println(ArrayAlgoUtils.reverseInt(num));
        System.out.println(ArrayAlgoUtils.checkIfPalindrome(palindrome));
        //remove duplicates - returns length of remaining eg. above 0,1,2,3,4 ==> 5
        System.out.println(ArrayAlgoUtils.removeDuplicatesFromSortedArray(sortedArrWithDuplicates));

        String s = "anagram";
        String t = "naagram";

        System.out.println(ArrayAlgoUtils.isAnagram(s,t));

        //group anagrams together
        String[]strs = {"eat","tea","tan","ate","nat","bat"};
        for(List<String> strings : ArrayAlgoUtils.groupAnagrams(strs)) {
            strings.forEach(System.out::println);
        }


        //Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
        int[] arr = {1,1,1,2,2,3};
        int k = 2;

        System.out.println("k most frequent elements : " + ArrayAlgoUtils.topKFrequent(arr,k));



    }
}
