import java.util.*;
import java.util.HashMap;

 class exam{
    HashMap<String,Integer> ul= new HashMap <String,Integer>();
    Scanner scan =new Scanner(System.in);
    public void login()
    {
    	System.out.println("\n Welcome  \n");
        System.out.println("Enter User-Id: ");
        String userID = scan.nextLine();
        System.out.println("Enter Password: ");
        int password = scan.nextInt();
        ul.put("anish",333);
        
        if (ul.containsKey(userID) && ul.get(userID) == password)
        {
            System.out.println("Log-In Successful!");
            source();
        }
        else{
            System.out.println("Invalid!! ");
            login();
        }
    }



   

    


    public void source()
    {
        System.out.println("\n1.Update\n2.Start test\n3.Logout");
        System.out.println("Enter your choice: ");
        int op=scan.nextInt();
        switch(op){
            case 1 : 
            	ul = updatetonew();
            	source();
            	break;
            case 2 : 
            	resolve();
            	source();
            	break;
            case 3 : 
            	System.exit(0);
            	break;
            default: 
            	System.out.println("Invalid Choice!");
        }
    }
    
    public HashMap<String,Integer> updatetonew()
    {
        System.out.println("\n Update ");
        System.out.println("Enter Username: ");
        
        Scanner scan = new Scanner(System.in);
        String id = scan.nextLine();
        
        if (ul.containsKey(id))
        {
            System.out.println("Enter New Password: ");
            int newpd = scan.nextInt();
            ul.replace(id,newpd);
            System.out.println("Profile Update Success!");
        }
        else
        {
            System.out.println("User does not exist...");
            System.out.println("Profile Update Failed!");
        }
        return ul;
    }
    
    public void resolve(){
        long start = System.currentTimeMillis();
        long terminate = start + 60 * 1000;
        int score = 0;
        int c = 0, w = 0;
        char ans;
        System.out.println("\n Starting The Test ");
        System.out.println("each question contains 1 minutes so within that try to answer ");
        System.out.println("each question contains 2 marks and wrong answer contains -1 mark");
        
        
        while(System.currentTimeMillis() < terminate)
        {
            System.out.println("\nQ1. Which of the following below live on the heap in Java?");
            System.out.println("a.Class\nb.Instance Variable\nc.Object\nd.Method");
            System.out.println("Answer:");
            ans = scan.next().charAt(0);
            if(ans == 'c')
            {
                c += 1;
            }
            else
                w -= 1;
            
            System.out.println("\nQ2.Java follows ?");
            System.out.println("a.comp concept \nb.oakla concept \nc.opps concept\nd.Set concept");
            System.out.println("Answer:");
            ans = scan.next().charAt(0);
            if(ans == 'c'){
                c += 1;
            }
            else
                w -= 1;
            
            System.out.println("\nQ3.Indias capital is ____");
            System.out.println("a.new delhi\nb.odisha.\nc.gujrat.\nd.all the above.");
            System.out.println("Answer:");
            ans = scan.next().charAt(0);
            if(ans == 'a')
            {
                c += 1;
            }
            else
                w -= 1;
            
            System.out.println("\nQ4.in java swing is _______?");
            System.out.println("a.keyword\nb.Collection\nc.List\nd.framework");
            System.out.println("Answer:");
            ans = scan.next().charAt(0);
            if(ans == 'd')
            {
                c += 1;
            }
            else
                w -= 1;
            
            System.out.println("\nQ5.long has _____ bytes?");
            System.out.println("a.8\nb.4\nc.1\nd.6");
            System.out.println("Answer:");
            ans = scan.next().charAt(0);
            if(ans == 'a') 
            {
                c += 1;
            }
            else
                w -= 1;
            
        
            System.out.println("\nQ5.india has ");
            System.out.println("a.28 states\nb.30 states\nc.29 states\nd.60 states");
            System.out.println("Answer:");
            ans = scan.next().charAt(0);
            if(ans == 'c') 
            {
                c += 1;
            }
            else
                w -= 1;
            break;
        }
        
        System.out.println("Test Completed!");
        score = ((c * 2) + w);
        System.out.println("Number of correct answers: " + c);
        System.out.println("Congratulations!! Your score is " + score + ".");
    }
    
    public static void main(String args[]){
        exam t =new exam();
        t.login();


       
    }

 {
    
}
 }
   
