
package schedule;

import java.util.Scanner;


public class Schedule {
    public void addSchedule(){
        Scanner sc = new Scanner(System.in);
        config conf = new config();
        System.out.print("Day of Week: ");
        String fname = sc.next();
        System.out.print("Start Time: ");
        String lname = sc.next();
        System.out.print("End Time: ");
        String email = sc.next();
        

        String sql = "INSERT INTO tbl_schedule (day_week, start_time, end_time) VALUES (?,?,?)";


        conf.addRecord(sql,fname, lname, email);


    }
    
    private void viewSchedule() {
        String cqry = "SELECT * FROM tbl_schedule";
        String[] votersHeaders = {"ID", "Day of Week", "Start Time", "End Time"};
        String[] votersColumns = {"schedule_id", "day_week", "start_time", "end_time"};
        config conf = new config();
        conf.viewRecords(cqry, votersHeaders, votersColumns);
    }
    
    private void updateSchedule(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Car ID ");
        int id = sc.nextInt();
        
        System.out.println("Enter the new Day of Week");
        String condition = sc.next();
        
        System.out.println("Enter the new Start time");
        String availability = sc.next();
        
        System.out.println("Enter the new End Time");
        String rcp = sc.next();
        
        String qry = "UPDATE tbl_schedule SET day_week = ?, start_time = ?, end_time = ? WHERE schedule_id = ?";
        
        config conf = new config();
        conf.updateRecord(qry, condition, availability, rcp, id);
    }
    
     private void deleteSchedule(){
        
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter the ID to Delete: ");
        int id = sc.nextInt();
        
        String qry = "DELETE FROM tbl_schedule WHERE schedule_id = ?";
        
        config conf = new config();
        conf.deleteRecord(qry, id);
    
    }


    
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
    String response;

    do {
        System.out.println("1. Add");
        System.out.println("2. View");
        System.out.println("3. Update");
        System.out.println("4. Delete");
        System.out.println("5. Exit");

        System.out.println("Enter Action: ");
        int action = sc.nextInt();
        Schedule demo = new Schedule();

        switch (action) {
            case 1:              
                demo.addSchedule();
                break;
            case 2:              
                demo.viewSchedule();
                break;
            case 3:
                demo.updateSchedule();
                break;
            case 4:
                demo.viewSchedule();
                demo.deleteSchedule();
                demo.viewSchedule();
                break;
        }

        System.out.println("Continue (yes/no): ");
        response = sc.next();
    } while (response.equals("yes"));

    System.out.println("Thank you, See you soon!");
    }
    
    
}
