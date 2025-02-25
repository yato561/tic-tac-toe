import java.io.*;
import java.nio.file.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class EmployeeExp{
    private static final String File_Path="employee.txt";
    private static final DateTimeFormatter DATE_FORMATTER=DateTimeFormatter.ofPattern("MM/dd/yyyy");
    
    public static void main(String[] args){
        List<Employee> emp=readEmp(File_Path);
        if(emp!=null){
            updateEmp(emp);
            writeEmp(File_Path,emp);
        }
    }
    private static List<Employee> readEmp(String filePath){
        List<Employee> emp= new ArrayList<>();
        try{
            List<String> lines=Files.readAllLines(Paths.get(filePath));
            for(String line:lines){
                String[] details=line.split(",");
                if(details.length==6){
                    String empId=details[0].trim();
                    String empName=details[1].trim();
                    LocalDate dateOfJoining = LocalDate.parse(details[2].trim(),DATE_FORMATTER);
                    String currentOrg = details[3].trim();
                    String role = details[4].trim();
                    LocalDate roleMovementDate = LocalDate.parse(details[5].trim(),DATE_FORMATTER);

                    emp.add(new Employee(empId,empName,dateOfJoining,currentOrg,role,roleMovementDate));
                }else{
                    System.out.println("Incorrect File Format");
                    return null;
                }
            }
        }catch(IOException e){
            System.out.println("Error occured while reading the file:" + e.getMessage());
            return null;
        }
        return emp;
    }
    private static void updateEmp(List<Employee> emp){
        LocalDate today=LocalDate.now();
        for(Employee obj:emp){
            long totalExp=ChronoUnit.YEARS.between(obj.getDateOfJoining(),today);
            long roleTenure=ChronoUnit.YEARS.between(obj.getRoleMovementDate(),today);

            System.out.println("%s has overall years of experience and working in %s from last %d years.%n", obj.getEmployeeName(),totalExp,emp.getCurrentOrg(),roleTenure);
            obj.setOverallExp(totalExp);
            obj.setRoleTenure(roleTenure);
        }

    }
    private static void writeEmp(String filePath,List<Employee> emp){
        try(BufferedWriter writer= new BufferedWriter(new FileWriter(filePath))){
            for(Employee obj:emp){
                writer.write(String.format("%s,%s,%s,%s,%s,%s, Overall Experience: %d years, Role Tenure: %d years%n",obj.getEmployeeId(), obj.getEmployeeName(), obj.getDateOfJoining.format(DATE_FORMATTER), 
                obj.getCurrentOrg(), obj.getOverallExp(), obj.getRoleTenure()));
            }
        }catch(IOException e){
              System.out.println("Error occured while writing to the file:"+e.getMessage());
        }
    }

    public static String getFile_Path() {
        return File_Path;
    }
}

class Employee{
    public Object getDateOfJoining;
    private String empId;
    private String empName;
    private LocalDate dateOfJoining;
    private String currentOrg;
    private String role;
    private LocalDate roleMovementDate;
    private long overallExp;
    private long roleTenure;

    public Employee(String empId, String empName, LocalDate dateOfJoining,String currentOrg, String role,LocalDate roleMovementDate){
        this.empId=empId;
        this.empName=empName;
        this.dateOfJoining=dateOfJoining;
        this.currentOrg=currentOrg;
        this.role=role;
        this.roleMovementDate=roleMovementDate;
    }
    public String getEmployeeId(){
        return empId;
    }
    public String getEmployeeName(){
        return empName;
    }
    public LocalDate getDateOfJoining(){
        return dateOfJoining;
    }
    public String getCurrentOrg(){
        return currentOrg;
    }
    public String getRole(){
        return role;
    }
    public LocalDate getRoleMovementDate(){
        return roleMovementDate;
    }
    public long getOverallExp(){
        return overallExp;
    }
    public void setOverallExp(long totalExp){
        this.overallExp= overallExp;
    }
    public long getRoleTenure(){
        return roleTenure;
    }
    public void setRoleTenure(long roleTenure2){
          this.roleTenure=roleTenure;
    }
}