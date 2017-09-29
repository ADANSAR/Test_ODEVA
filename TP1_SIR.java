/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;
import java.util.*;
import java.lang.String;

/**
 *
 * @author adansar
 */
public
class TP1_SIR {

    /**
     * @param args the command line arguments
     */
public
    static void main(String[] args) throws IOException
    {

        String filePath = "C:/Utilisateurs/A677095/Desktop/Workspace/TP1_SIR/src/Log-clients-themes.txt";
        try {

            BufferedReader buff = new BufferedReader(new FileReader(filePath));

            String line;
            
            List<String> users = new ArrayList<>();
            List<String> themes = new ArrayList<>();
            ArrayList<String> ans= new ArrayList<String>();

            FileWriter fichier = new FileWriter("C:/Utilisateurs/A677095/Desktop/Workspace/TP1_SIR/src/names.txt");
            FileWriter fichier2 = new FileWriter("C:/Utilisateurs/A677095/Desktop/Workspace/TP1_SIR/src/themes.txt");
            FileWriter fichier3 = new FileWriter("C:/Utilisateurs/A677095/Desktop/Workspace/TP1_SIR/src//matrice.txt");
            
            while ((line = buff.readLine()) != null) {
                if (line.split(";").length == 3) {
                	ans.add(line);
                    String user = line.split(";")[1];
                    String theme  = line.split(";")[2];
                    if (!users.contains(user)) {
                        users.add(user);
                        fichier.write(user + "\n");
                    }
                    if (!themes.contains(theme)) {
                        themes.add(theme);
                        fichier2.write(theme + "\n");
                    }
                }
            }
            
            for(String usr:users){
                for(String thm:themes){
                	int nbr=0;
                	for (String ligne: ans) {
                        if (ligne.split(";").length == 3) {
                            String user = ligne.split(";")[1];
                            String theme  = ligne.split(";")[2];
                            if(user.equals(usr) && theme.equals(thm)){
                            	nbr++;
                            	System.out.println("i'm here");
                            }
                        }
                    }
                    fichier3.write(nbr+"\t");
                }
                fichier3.write("\n");
            }
            
            fichier.close();
            fichier2.close();
            fichier3.close();
        }

        catch (IOException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
    }
}

