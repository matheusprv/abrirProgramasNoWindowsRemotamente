/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package executar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author mathe
 */
public class executarPrograma {
    public static void executar(String programa){
        //https://www.netjstech.com/2016/10/running-dos-windows-commands-from-java.html
        
        String abrir = null;
        if(programa.equals("cod")){
            abrir = " \"\" \"D:\\Call of Duty Modern Warfare\\Modern Warfare Launcher.exe\" ";
        }
        else if(programa.equals("f1")){
            abrir = "steam://rungameid/737800";
        }
        else if(programa.equals("gta")){
            abrir = "steam://rungameid/271590";
        }
        else if(programa.equals("forza")){
            abrir = " \"\" \"C:\\Users\\mathe\\Desktop\\Forza Horizon 4.lnk\"";
        }
        
        
        Process p;
        try {
            //cmd -> Inicia o prompt de comando
            // /c -> inicia e finaliza o processo
          p = Runtime.getRuntime().exec("cmd /c start "+abrir);

          p.waitFor(); 
          BufferedReader reader=new BufferedReader(new InputStreamReader(
                      p.getInputStream())); 
          String line; 
          while((line = reader.readLine()) != null) { 
            System.out.println(line);
          } 
        } catch (IOException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        } catch (InterruptedException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
    }
        
}
