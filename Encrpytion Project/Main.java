/*
	Process

	1) Scramble 
	2) Substitute
	3) Replace
	
*/
import java.util.HashMap;

class Main {
  public static void main(String[] args) {
    (new Main()).init();
  }

  void init(){
	String TEST1 = Input.readFile("Decrypted.txt");
	
	// Encrypting
	Input.writeFile("Encrypt1.txt",scramble(TEST1)); // ackAtt
	
	String TEST2 = Input.readFile("Encrypt1.txt");
	
	Input.writeFile("Encrypt2.txt",substitute(TEST2)); // mkcmtt
	
	String TEST3 = Input.readFile("Encrypt2.txt");
	
	Input.writeFile("Encrypt3.txt",replace(TEST3)); // ⍤kc⍤⊶⊶
	
//  ----------------------------------------------------------------

	String RUN1 = Input.readFile("Encrypted.txt");

	// Decrypting
	Input.writeFile("Decrypt1.txt",replaceD(RUN1));

	String RUN2 = Input.readFile("Decrypt1.txt");

	Input.writeFile("Decrypt2.txt",substituteD(RUN2));

	String RUN3 = Input.readFile("Decrypt2.txt");

	Input.writeFile("Decrypt3.txt",scrambleD(RUN3));
	
		
  }	
	
	/*
		[Encrypting code for scramble]
		
		Scrambled test 1 : Odd / Even split and switch
		
	*/
	
	String scramble(String text){	
		String[] textSplit = text.split("\\s+|\\R");
		String scrambled = "";
		for (int i = 0; i<textSplit.length;i++){

			// If the string is even
			if (textSplit[i].length()%2 == 0){
				scrambled += textSplit[i].substring(textSplit[i].length()/2);
				scrambled += textSplit[i].substring(0,textSplit[i].length()/2);
				if (i%25==0 && !(i==0)){
					scrambled += "\n";
				} else{
					scrambled+= " ";
				}
			} else{  // If the string is odd
				if (textSplit[i].length() == 3){
					scrambled += textSplit[i].substring(1,2);
					scrambled += textSplit[i].substring(0,1);
					scrambled += textSplit[i].substring(2);
					if (i%25==0 && !(i==0)){
						scrambled += "\n";
					} else{
						scrambled+= " ";
					}
				} else if(textSplit[i].length()==1){
					scrambled+=textSplit[i];
					if (i%25==0 && !(i==0)){
						scrambled += "\n";
					} else{
						scrambled+= " ";
					}
				} else{
					scrambled += textSplit[i].substring(textSplit[i].length()/2-1,textSplit[i].length()/2+2);
					scrambled += textSplit[i].substring(0,textSplit[i].length()/2-1);
					scrambled += textSplit[i].substring(textSplit[i].length()/2+2);
					if (i%25==0 && !(i==0)){
						scrambled += "\n";
					} else{
						scrambled+= " ";
					}
				}
			}
		}
		return scrambled;
	}
	
	/*
		[DEcrypting code scramble]
		
		Unscrambled test 1: Odd/Even return to normal
	
	*/
	
	String scrambleD(String text){
		String[] textSplit = text.split("\\s+|\\R");
		String normal = "";
		for (int i = 0; i<textSplit.length;i++){

			// If the string is even
			if (textSplit[i].length()%2 == 0){
				normal += textSplit[i].substring(textSplit[i].length()/2);
				normal += textSplit[i].substring(0,textSplit[i].length()/2);
				if (i%25==0 && !(i==0)){
					normal += "\n";
				} else{
					normal+= " ";
				}
				
			} else{  // If the string is odd
				if (textSplit[i].length() == 3){
					normal += textSplit[i].substring(1,2);
					normal += textSplit[i].substring(0,1);
					normal += textSplit[i].substring(2);
					if (i%25==0 && !(i==0)){
						normal += "\n";
					} else{
						normal+= " ";
					}
				} else if (textSplit[i].length()==1){
					normal+=textSplit[i];
					if (i%25==0 && !(i==0)){
						normal += "\n";
					} else{
						normal+= " ";
					}		
				}else{
					// fended!
					normal += textSplit[i].substring(3,((textSplit[i].substring(3).length())/2)+3);
					normal += textSplit[i].substring(0,3);
					normal += textSplit[i].substring(((textSplit[i].substring(3).length())/2)+3);
					if (i%25==0 && !(i==0)){
						normal += "\n";
					} else{
						normal+= " ";
					}
				}
			}
		}
		return normal;
	}
	
	/* 
		[Encrypting code for substitution]
	
		Substitute test 2 : Encrpty the new text with a given formula (hashmap)
		
		mlkjihgfedcbazyxwvutsrqpon
		abcdefghijklmnopqrstuvwxyz
	*/
	
	String substitute(String text){
        // Map.of

		HashMap<String,String> decodeKey = new HashMap<String, String>();
		decodeKey.put("a","m");
		decodeKey.put("b","l");
		decodeKey.put("c","k");
		decodeKey.put("d","j");
		decodeKey.put("e","i");
		decodeKey.put("f","h");
		decodeKey.put("g","g");
		decodeKey.put("h","f");
		decodeKey.put("i","e");
		decodeKey.put("j","d");
		decodeKey.put("k","c");
		decodeKey.put("l","b");
		decodeKey.put("m","a");
		decodeKey.put("n","z");
		decodeKey.put("o","y");
		decodeKey.put("p","x");
		decodeKey.put("q","w");
		decodeKey.put("r","v");
		decodeKey.put("s","u");
		decodeKey.put("t","t");
		decodeKey.put("u","s");
		decodeKey.put("v","r");
		decodeKey.put("w","q");
		decodeKey.put("x","p");
		decodeKey.put("y","o");
		decodeKey.put("z","n");
		
		String scrambled = "";
		String textNew = "";
		boolean exist = true;
		
		for (int i = 0; i<text.length();i++){
			textNew = text.substring(i,i+1);
			textNew = textNew.toLowerCase();
			
			for (String x : decodeKey.keySet()) {
				if (x.equals(textNew)){
					scrambled += decodeKey.get(x);
					exist = true;
					break;
				} else{
					exist = false;
				}
			}
			if (!exist){
				scrambled+=textNew;
			}
		}
		return scrambled; // mttmkc
	}
	
	/*
		[ DEcrypting code for substitution ]
		
		Substitute test 2: Revert the key
		
	*/
	
	String substituteD(String text){
		HashMap<String,String> decodeKey = new HashMap<String, String>();
		decodeKey.put("a","m");
		decodeKey.put("b","l");
		decodeKey.put("c","k");
		decodeKey.put("d","j");
		decodeKey.put("e","i");
		decodeKey.put("f","h");
		decodeKey.put("g","g");
		decodeKey.put("h","f");
		decodeKey.put("i","e");
		decodeKey.put("j","d");
		decodeKey.put("k","c");
		decodeKey.put("l","b");
		decodeKey.put("m","a");
		decodeKey.put("n","z");
		decodeKey.put("o","y");
		decodeKey.put("p","x");
		decodeKey.put("q","w");
		decodeKey.put("r","v");
		decodeKey.put("s","u");
		decodeKey.put("t","t");
		decodeKey.put("u","s");
		decodeKey.put("v","r");
		decodeKey.put("w","q");
		decodeKey.put("x","p");
		decodeKey.put("y","o");
		decodeKey.put("z","n");
		
		String normal = "";
		String textNew = "";
		boolean exist = true;
		
		for (int i = 0; i<text.length();i++){
			textNew = text.substring(i,i+1);
			textNew = textNew.toLowerCase();
			
			for (String x : decodeKey.keySet()) {
				if (decodeKey.get(x).equals(textNew)){
					normal += x;
					exist = true;
					break;
				} else{
					exist = false;
				}
			}
			if (!exist){
				normal+=textNew;
			}
		}
		return normal; // mttmkc
	}
	
	
	/*
		[ Encrypting code for replacing ] 
	
		A > ⍡		O > ⍩
		H > ⍢		T > ⊶
		I > ⍣		U > ⊷
		M > ⍤		V > ⊸
		W > ⍥		Y > ⋒
		X > ⍨
	*/
  
	String replace(String text){
		HashMap<String,String> symmetrical = new HashMap<String, String>();
		symmetrical.put("A","⍡");
		symmetrical.put("H","⍢");
		symmetrical.put("I","⍣");
		symmetrical.put("M","⍤");
		symmetrical.put("W","⍥");
		symmetrical.put("X","⍨");
		symmetrical.put("O","⍩");
		symmetrical.put("T","▩");
		symmetrical.put("U","▥");
		symmetrical.put("V","◩");
		symmetrical.put("Y","◲");
		
		String scrambled = "";
		String textNew = "";
		boolean exist = true;
		
		for (int i = 0; i<text.length();i++){
			textNew = text.substring(i,i+1);
			textNew = textNew.toUpperCase();
			
			for (String x : symmetrical.keySet()) {
				if (x.equals(textNew)){
					scrambled += symmetrical.get(x);
					exist = true;
					break;
				} else{
					exist = false;
				}
			}
			if (!exist){
				scrambled+=textNew.toLowerCase();
			}
		}
		return scrambled;
	}
	
	/*
		[DEcrypting code for replacing]

		Replace test 3: revert the symbols into its corresponding letters
		
	*/
	
	String replaceD(String text){
		HashMap<String,String> symmetrical = new HashMap<String, String>();
		symmetrical.put("A","⍡");
		symmetrical.put("H","⍢");
		symmetrical.put("I","⍣");
		symmetrical.put("M","⍤");
		symmetrical.put("W","⍥");
		symmetrical.put("X","⍨");
		symmetrical.put("O","⍩");
		symmetrical.put("T","▩");
		symmetrical.put("U","▥");
		symmetrical.put("V","◩");
		symmetrical.put("Y","◲");
		
		String normal = "";
		String textNew = "";
		boolean exist = true;
		
		for (int i = 0; i<text.length();i++){
			textNew = text.substring(i,i+1);
			
			for (String x : symmetrical.keySet()) {
				if (symmetrical.get(x).equals(textNew)){
					normal += x;
					exist = true;
					break;
				} else{
					exist = false;
				}
			}
			if (!exist){
				normal+=textNew;
			}
		}
		return normal;
	}
	
} 