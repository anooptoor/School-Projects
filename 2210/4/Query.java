import java.io.BufferedReader;
import java.io.FileReader;


public class Query {
	
	 public static void main(String args[])
	    {
		 
		 	String filename = args[0]; // takes filename input
	        String fileword;  
	        String filedefine;
	        // init objects
		    OrderedDictionary dict = new OrderedDictionary();
	        StringReader input = new StringReader();
	        SoundPlayer sound = new SoundPlayer();
	        PictureViewer picture = new PictureViewer();
	       
	        int filetype;
	        int i = 0;
	        String command;
	        String word; 
	        String list = "aaa";
	        String list2;
	        String line;
	        boolean end = true; 
	       

	        try(BufferedReader br = new BufferedReader(new FileReader(filename)))
	        {
	            line = br.readLine();

	            while (line != null)
	            {
	                fileword = line;

	                line = br.readLine();

	                filedefine = line;
	                // decides on filetype
	                if(filedefine.endsWith("wav")) {
	                	//System.out.println(tempDefine); 
	                	filetype = 2; 
	                }
	                else if(filedefine.endsWith("jpg")) {
	                	//System.out.println(tempDefine); 
	                	filetype = 3;
	                }
	                else{
	                	filetype = 1; 
	                }
	                try{
	                    dict.insert(fileword,filedefine,filetype);
	                    
	                }catch(DictionaryException d){System.out.println(d);}

	                line = br.readLine();
	            }
	            
	            
	        }catch(java.io.IOException e) {System.out.println(e);}
	        	        
	        while(end){
	        	line = input.read("Enter next Command: ");//reads input
	        	i = line.indexOf(' ');
	        	command = line.substring(0, i); // breaks up input
	        	word = line.substring(i + 1);
	        	// calls according methods from dict
	        	if(command.startsWith("define")){
	        		if(dict.findType(word) == 1)
	        			System.out.println(dict.findWord(word));
	        		else if(dict.findType(word) == 2){
	        			try {
							sound.play(dict.findWord(word));
						} catch (MultimediaException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
	        		}
	 
	        		else if(dict.findType(word) == 3){
	        			try {
							picture.show(dict.findWord(word));
						} catch (MultimediaException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
	        		}
	        	}
	        	else if(command.startsWith("delete")){
	        		try {
						dict.remove(word);
						System.out.println(word + " has been removed"); 
					} catch (DictionaryException e) {
						System.out.print(word + " not in dictionary");
						e.printStackTrace();
					}
	        	}
	        	else if(command.startsWith("list")){
	        		list2 = word;
	        		while(list.equals("") == false){
	        			list = dict.successor(list2);
	        			if(list.startsWith(word)){
	        				System.out.print(word);
	        			}
	        			list2 = list;
	        		}
	        	}
	        	else if(command.startsWith("next")){
	        		System.out.println(dict.successor(word));
	        	}
	        	else if(command.startsWith("previous")){
	        		System.out.println(dict.predecessor(word));
	        	}
	        	else if(command.startsWith("end")){
	        		end = false;  
	        	}
	        	
	        	
	        	
	        }
		
	    }
}
