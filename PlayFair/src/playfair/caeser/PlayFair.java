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
public class PlayFair {
    static String PlayFair_Encrypt(String plaintext,String key)
    {
        String play="";
        String  ciphertext="";
        
        for(int i=0 ; i<key.length() ; i++)
        {
             if(play.indexOf(key.charAt(i)) == -1)
             {
                play += key.charAt(i);         
             }
        }
         
        for(char w='a' ; w<='z' ; w++)
        {
            if(w == 'j')
                continue;
            if(play.indexOf(w) == -1)
                play += w;
        }   
      
        //convert one dim to two dim
        //k index of one dim array
        //display matrix
        int k=0;
        char[][] matrix=new char[5][5];
        for(int i=0 ; i<5 ; i++)
        {
            for(int j=0 ; j<5 ; j++)
            {
                matrix[i][j] = play.charAt(k);  
                k++;
            }

        }
        //testing    
        for(int i=0 ; i<plaintext.length() ; i+=2)
        {
            if(plaintext.charAt(i) == plaintext.charAt(i+1))
            {
                plaintext = plaintext.substring(0, i + 1) + 'x' + plaintext.substring(i + 1);
            }
        
            if(plaintext.length()%2 != 0)
            {
             plaintext = plaintext + 'x';
            }
        }
        
        char c1,c2; 
        int i1=0, j1=0, i2=0, j2=0;
        
        for(int z=0 ; z<plaintext.length() ; z+=2)
        {
            c1 = plaintext.charAt(z);
            c2 = plaintext.charAt(z+1);
            
            
             for(int i=0 ; i<5 ; i++)
             {
                 for(int j=0 ; j<5 ; j++)
                 {
                     if(matrix[i][j] == c1)
                     {
                         i1 = i;
                         j1 = j;
                     }
                     if(matrix[i][j] == c2)
                     {
                         i2 = i;
                         j2 = j;
                     }
                 }
             }
             
             if(i1 == i2)
             { 
                  c1 = matrix[i1][(j1+1)%5]; 
                  c2 = matrix[i2][(j2+1)%5];
             }
             
             else  if(j1 == j2)
             {
                c1 = matrix[(i1+1)%5][j1];
                c2 = matrix[(i2+1)%5][j2];
             }
             
             else
             {
                 c1 = matrix[i1][j2];
                 c2 = matrix[i2][j1];
             }

              ciphertext = ciphertext+c1+c2;
               
        }
    return ciphertext;
    }
    
    static String PlayFair_Decrypt(String cipher_text,String key)
    {
        
        String plain_text = "";
        String play = "";
        
        for(int i=0 ; i<key.length() ; i++)
        {
            if(play.indexOf(key.charAt(i)) == -1)
            {
             play += key.charAt(i);         
            }
        }
         
        for(char w='a' ; w<='z' ; w++)
        {
            if(w == 'j')
                continue;
            if(play.indexOf(w) == -1)
                play += w;
        }   
      
        //convert one dim to two dim
        //k index of one dim array
        //display matrix
        int k=0;
        char[][] matrix = new char[5][5];
        for(int i=0 ; i<5 ; i++)
        {
            for(int j=0 ; j<5 ; j++)
            {
                matrix[i][j] = play.charAt(k);  
                k++;
            }
        }
        
        int i1=0,j1=0,i2=0,j2=0;
        char c1,c2;
        for(int z=0 ; z<cipher_text.length() ; z+=2)
        {
            c1 = cipher_text.charAt(z);
            c2 = cipher_text.charAt(z+1);

          
            for(int i=0 ; i<5 ; i++)
            {
                for(int j=0 ; j<5 ; j++)
                {
                     if(matrix[i][j] == c1)
                     {
                         i1 = i;
                         j1 = j;
                     }
                     if(matrix[i][j] == c2)
                     {
                         i2 = i;
                         j2 = j;
                     } 
                }
            }

            
            if(i1 == i2)
            {
                if(j1 == 0)
                    j1 = 5;
                if(j2 == 0)
                    j2 = 5;
                c1 = matrix[i1][j1-1];
                c2 = matrix[i2][j2-1];
            }
          
          else if(j1 == j2)
          {
              if(i1 == 0)
                  i1 = 5;
              if(i2 == 0)
                  i2 = 5;
              c1 = matrix[i1-1][j1];
              c2 = matrix[i2-1][j2];
          }

            
          else
          {
            c1 = matrix[i1][j2];
            c2 = matrix[i2][j1];
          }

        plain_text = plain_text+c1+c2;
      }
    return plain_text;
  }
}


