/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package playfair.caeser;

/**
 *
 * @author islam
 */
public class Caeser_Cipher {
    static String Ceaser_Encrypt(String Plain_Text,int Key)
    {
        String Cipher_Text = "";
        int temp;
        for(int i=0 ; i<Plain_Text.length() ; i++)
        {
            char x = Plain_Text.charAt(i);
            
                temp = x + Key;
               if(Character.isLowerCase(x) && temp > 'z')
                {
                    temp -= 26;
                }
                if(Character.isUpperCase(x) && temp > 'Z')
                {
                    temp -= 26;
                }
                Cipher_Text += (char)temp;
            }
          
        return Cipher_Text;
    }
    
    static String Ceaser_Decrypt(String Cipher_Text,int Key)
    {
        String Plain_Text = "";
        int temp;
        for(int i=0 ; i<Cipher_Text.length() ; i++)
        {
            char x = Cipher_Text.charAt(i);
                temp = x - Key;
                if(Character.isLowerCase(x) && temp < 'a')
                {
                    temp += 26;
                }
                if(Character.isUpperCase(x) && temp < 'A')
                {
                    temp += 26;
                }
                Plain_Text += (char)temp;
        }
        return Plain_Text;
    }
}
