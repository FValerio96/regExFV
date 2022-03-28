/* QUESTA E' UNA MODIFICA
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.espregolaremail;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Flavio Valerio
 */
public class EspRegolareMail {

    public static void main(String[] args) {
        String mail = "pippo@gmail.it";
        String mailNotMatch1 = "lol@it";
        String multipleMail = "io@tu.com lol@.it wwflnuhdi pippo@cocacola.com e@buona.comma";
        
        //flag per il match
        boolean b;
        //creo l'espressione regoalare
        //Nelle stringhe devi usare il doppio backslash al posto del singolo perche sei in una stringa
        //gruppo 1 nome, gruppo 2 servizio di mailing, gruppo 3 dominio
        String regEx = "([a-zA-Z0-9_.]+)@([a-zA-Z]+)\\.([a-zA-Z]{2,3})";
        
        /*le istanze della classe pattern contengo espressioni regolari specificate come String, 
          le quali vengono compilate(compile)come istanza di questa classe,
          il pattern che ne risultera' verrà usato per creare un oggetto di tipo Matcher,
          i quali sono in grado di confrontare una sequenza di caratteri con una regEX            
        */
        //questo pattern quindi processa la stringa regEX 
        Pattern pattern = Pattern.compile(regEx);
        
        //il metodo matches va invocato sul pattern, mi dice se una stringa appartiene ad una regEx
        //pattern.matches(espressioneregolare, stringa);
        b = pattern.matches(regEx, mail);
        if(b){
            System.out.println("accepted");
        }
        else {
            System.out.println("refused");
        } 
        
        b = pattern.matches(regEx, mailNotMatch1);
        if(b){
            System.out.println("accepted");
        }
        else {
            System.out.println("refused");
        } 
        
        //Creates a matcher that will match the given input against this pattern.
        //N.B. in pattern.matcher, "matcher" non è un instanza della classe Matcher ma un metodo della classe Pattern!
        //pattern è il pattern da noi creato al quale abbiamo fatto compilare regEX
        //multipleMain è l'input con il quale m si occupa di controllare se vi è match
        Matcher m = pattern.matcher(multipleMail);
       
        //DOMANDA: ?LA REGION CORRISPONDE ALL'INTERO INPUT?
        //RISPOSTA: la regione è un sottoinsieme dell'input ricevuto dal matcher        
        
        /* The find method scans the input sequence looking for the next subsequence that matches the pattern. 
           inoltre find funge da iteratore        
        */
        /*The explicit state of a matcher includes the start and end indices of the most recent successful match.
          ergo so dove inizia e finisce un match, ottenendo quindi la/le sottostring che rispettano il pattern
          contiene inoltre un conteggio del numero di sottesequenze (immagino al fine di poter iterare)
        */
        while (m.find())
            //Restituisce la sottosequenza di input corrispondente alla corrispondenza precedente.
            System.out.println(m.group()); 
        
        //SECONDA PARTE: RAGGRUPA NOME E DOMINIO E PROVA AD ACQUISIRLI 
        String e_mail = "lol@lollo.it";
        Matcher m2 = pattern.matcher(e_mail);
        int gc = m2.groupCount();
        System.out.println(gc);
        String nome, servizioMailing, dominio;
        //group(numero del gruppo che mi interessa) mi da il match di quel gruppo
        while(m2.find()) {
            nome = m2.group(1);
            servizioMailing = m2.group(2);
            dominio = m2.group(3);
            System.out.println("nome: " + nome + " Mailing: " + servizioMailing + " dominio: "
                    + dominio);
        }  
    
    }//fine mail
    
}
