
public class A3Q3proteinDNA extends A3Q1DNASequence {
	String sequence= "";
	String[] k; 
	public A3Q3proteinDNA(A3Q1DNASequence dna, int startAt) {
		super(dna.sequence);
		String c = dna.baseString();
		sequence = c.substring(startAt);
		int i = 0;
		int j = 0;
		String b = c.substring(i, i + 3);
		k = new String[c.length()/3];
		while( i + 3 < c.length() && (b.equals("aga") == false && b.equals("agg") == false && b.equals("taa") == false && b.equals("tag") == false))  
		{
			b = c.substring(i, i + 3);
			k[j] = b;
			sequence = sequence + b;
			i = i + 3;
			j++;
			
		}
		
		
			
	}
	public int acidLength()  {
		int a = sequence.length()/3;
		return a;
	}      
	public char acidAt(int i) {
		
		if(k[i].equals("gct") || k[i].equals("gcc") || k[i].equals("gca") || k[i].equals("gcg") )
		{
			return 'A';
		}
		else if(k[i].equals("cgt") || k[i].equals("cgc") || k[i].equals("cga") || k[i].equals("cgg") )
		{
			return 'R';
		}
		else if(k[i].equals("aat") || k[i].equals("aac")) 
		{
			return 'N';
		}
		else if(k[i].equals("gat") || k[i].equals("gac"))
		{
			return 'D';
		}
		else if(k[i].equals("tgt") || k[i].equals("tgc"))
		{
			return 'C';
		}
		else if(k[i].equals("gaa") || k[i].equals("gag"))
		{
			return 'E';
		}
		else if(k[i].equals("caa") || k[i].equals("cag"))
		{
			return 'Q';
		}
		else if(k[i].equals("ggt") || k[i].equals("ggc") || k[i].equals("gga") || k[i].equals("ggg") )
		{
			return 'G';
		}
		else if(k[i].equals("cat") || k[i].equals("cac") )
		{
			return 'H';
		}
		else if(k[i].equals("ctt") || k[i].equals("ctc") || k[i].equals("ctg") || k[i].equals("tta") ||  k[i].equals("ttg"))
		{
			return 'L';
		}
		else if(k[i].equals("aaa") || k[i].equals("aag"))
		{
			return 'K';
		}
		else if(k[i].equals("ata") || k[i].equals("atg") )
		{
			return 'M';
		}
		else if(k[i].equals("ttt") || k[i].equals("ttc") )
		{
			return 'F';
		}
		else if(k[i].equals("cct") || k[i].equals("ccc") || k[i].equals("cca") || k[i].equals("ccg") )
		{
			return 'P';
		}
		else if(k[i].equals("act") || k[i].equals("acc") || k[i].equals("aca") || k[i].equals("acg") )
		{
			return 'T';
		}
		else if(k[i].equals("tga") || k[i].equals("tgg") )
		{
			return 'W';
		}
		else if(k[i].equals("tat") || k[i].equals("tac"))
		{
			return 'Y';
		}
		else if(k[i].equals("gtt") || k[i].equals("gtc") || k[i].equals("gta") || k[i].equals("gtg") )
		{
			return 'V';
		}
		return 'Z';
	}
			
		
 
	public String acidString()  {
		
		String protein = "";
		for(int i = 0; i < k.length; i++ )
		{
			if(k[i].equals("gct") || k[i].equals("gcc") || k[i].equals("gca") || k[i].equals("gcg") )
			{
				protein = protein + "A";
			}
			else if(k[i].equals("cgt") || k[i].equals("cgc") || k[i].equals("cga") || k[i].equals("cgg") )
			{
				protein = protein + "R";
			}
			else if(k[i].equals("aat") || k[i].equals("aac")) 
			{
				protein = protein + "N";
			}
			else if(k[i].equals("gat") || k[i].equals("gac"))
			{
				protein = protein + "D";
			}
			else if(k[i].equals("tgt") || k[i].equals("tgc"))
			{
				protein = protein + "C";
			}
			else if(k[i].equals("gaa") || k[i].equals("gag"))
			{
				protein = protein + "E";
			}
			else if(k[i].equals("caa") || k[i].equals("cag"))
			{
				protein = protein + "Q";
			}
			else if(k[i].equals("ggt") || k[i].equals("ggc") || k[i].equals("gga") || k[i].equals("ggg") )
			{
				protein = protein + "G";
			}
			else if(k[i].equals("cat") || k[i].equals("cac") )
			{
				protein = protein + "H";
			}
			else if(k[i].equals("ctt") || k[i].equals("ctc") || k[i].equals("ctg") || k[i].equals("tta") ||  k[i].equals("ttg"))
			{
				protein = protein + "L";
			}
			else if(k[i].equals("aaa") || k[i].equals("aag"))
			{
				protein = protein + "K";
			}
			
			else if(k[i].equals("ata") || k[i].equals("atg") )
			{
				protein = protein + "M";
			}
			
			else if(k[i].equals("ttt") || k[i].equals("ttc") )
			{
				protein = protein + "F";
			}
			else if(k[i].equals("cct") || k[i].equals("ccc") || k[i].equals("cca") || k[i].equals("ccg") )
			{
				protein = protein + "P";
			}
			
			else if(k[i].equals("act") || k[i].equals("acc") || k[i].equals("aca") || k[i].equals("acg") )
			{
				protein = protein + "T";
			}
			
			else if(k[i].equals("tga") || k[i].equals("tgg") )
			{
				protein = protein + "W";
			}
			
			else if(k[i].equals("tat") || k[i].equals("tac"))
			{
				protein = protein + "Y";
			}
			else if(k[i].equals("gtt") || k[i].equals("gtc") || k[i].equals("gta") || k[i].equals("gtg") )
			{
				protein = protein + "V";
			}
		
			
	}
	return protein;
		
}
	
}

