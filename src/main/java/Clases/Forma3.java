/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.nio.file.Files;
import java.util.HashSet;
import javax.swing.JOptionPane;

/**
 *
 * @author goku3
 */
public class Forma3 
{
    //Atributo
    Nodo head, end;
    //Metodos
    
    public Forma3()//constructor
    {
        head=null;
        end=null;
    }//Fin constructor

    public void setHead(Nodo head) {
        this.head = head;
    }

    public void setEnd(Nodo end) {
        this.end = end;
    }

    public Nodo getHead() {
        return head;
    }

    public Nodo getEnd() {
        return end;
    }
    
    public  void InsertarFinal(int c, int e, Forma3 a)
    {
        //Nodo x = new Nodo(c,e);
       Nodo x = new Nodo(c, e);
       
        if (head == null) {
            setHead(x);
            setEnd(x);
        } else {
            Nodo p = new Nodo();
            Nodo Aux = new Nodo();
            p = getHead();
            while (p.getLiga() != null && p.getExp() > e) {
                Aux = p;
                p = p.getLiga();
            }
            if (p.getExp() == e) {
                p.setCoe(c + p.getCoe());
            } else if (p == getHead()) {
                if (e < p.getExp()) {
                    p.setLiga(x);
                    end = x;
                } else {
                    x.setLiga(getHead());
                    setHead(x);
                }
            }//cierre del if
            else if (p == end) {
                if (e > p.getExp()) {
                    Aux.setLiga(x);
                    x.setLiga(p);
                }//cierre del if
                else {
                    p.setLiga(x);
                    end = x;
                }
            }//cierre del else
            else {
                Aux.setLiga(x);
                x.setLiga(p);
            }
        }
                     
    }//Fin insertar ordenado
    public Forma3 borrarLista(Forma3 a)
    {
        a.head= null;
        a.end=null;
        return a;
    }
    public void evaluar(Forma3 a)
    {
        //-x+37x^4+101-218x^2-x^7
        Nodo p = a.getHead();
        int x,resul=0;
        x= Integer.parseInt(JOptionPane.showInputDialog("Ingrese un valor para la X: "));
        while (p!=null)
        {
            resul+=p.getCoe()*(Math.pow(x,p.getExp()));
            p=p.getLiga();
        }
        System.out.println("El resultado es: ");
        System.out.println(resul);
    }
    public void sumar(Forma3 a, Forma3 b)//Sumar BUENO
    {
        Nodo p=a.head,q=b.head;
        end =null;
        int c =0;
        while(p!=null && q!=null)
        {
            if(p.getExp()==q.getExp())
            {
                c = p.getCoe() + q.getCoe();
                if (c!=0)
                {
                    InsertarFinal(c,q.getExp(),this);
                }
                p=p.getLiga();
                q=q.getLiga();
            }
            else
            {
                if (p.getExp()>q.getExp())
                {
                    InsertarFinal(p.getCoe(),p.getExp(),this);
                    p=p.getLiga();
                }
                else
                {
                    InsertarFinal(q.getCoe(),q.getExp(),this);
                    q=q.getLiga();
                }
            }
        }
        while (p!=null)
        {
            InsertarFinal(p.getCoe(),p.getExp(),this);
            p=p.getLiga();
        }
        while (q!=null)
        {
            InsertarFinal(q.getCoe(),q.getExp(),this);
            q=q.getLiga();
        }
    }//Fin sumar
    public void insertarTermino(Forma3 a)
    {
        int c=0, e=0;
        c=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el coeficiente: "));
        e=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el exponente: "));
        a.InsertarFinal(c, e, a);
    }
    public void borrarTermino(Forma3 a)
    {
        Nodo p=a.getHead();
        Nodo q=p.getLiga();
        int c=0, e=0, encontro=0;
        c=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el coeficiente: \n"));
        e=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el exponente: \n"));
        while (q!=null)
        {
            if(p.getCoe()==c && p.getExp()==e)
            {
                a.setHead(p.getLiga());            
                encontro = 1;
            }
            else if(q.getCoe()==c && q.getExp()==e)
            {
                q.setLiga(p.getLiga());
                encontro = 1;
            }
            p=p.getLiga();
            q=q.getLiga();           
        }
        if (encontro ==0)
        {
            System.out.println("\nEl termino insertado no fue encontrado.");
        }
        else
        {
            System.out.println("\n El termino fue eliminado correctamente.");
        }
    }
    public void mostrar(Forma3 a)//Mostrar
    {
        Nodo p=a.head;
        while (p!=null)
        {            
            System.out.print("|"+p.getCoe()+"|"+p.getExp()+"|");   
            p=p.getLiga();
        }     
    }//Fin Mostrar

    public void reconstruir(Forma3 a)//Reconstruir
    {
        Nodo p=a.head;
        String s="";
        while (p != null) {
             int exp = p.getExp();
             int coef = p.getCoe();
             if (exp != 0) {
                 if (coef == 1) {
                     if (exp != 1) {
                         s +=  "+" + "x^" + String.valueOf(exp);
                     } else {
                         s +="+" + "x";
                     }
                 } else if (coef == -1) {
                     if (exp != 1) {
                         s += "-x^" + String.valueOf(exp);
                     } else {
                         s += "-x";
                     }
                 } else if (coef > 0) {
                     if (exp != 1) {
                         s += "+" + String.valueOf(coef) + "x^" + String.valueOf(exp);
                     } else {
                         s +="+" + String.valueOf(coef) + "x";
                     }
                 } else if (coef < 0) {
                     if (exp != 1) {
                         s +=String.valueOf(coef) + "x^" + String.valueOf(exp);
                     } else {
                         s +=String.valueOf(coef) + "x";
                     }
                 }
             } else {
                 if (coef > 0) {
                     s += "+" + String.valueOf(coef);
                 } else if (coef < 0) {
                     s +=String.valueOf(coef);
                 }
             }
             p = p.getLiga();
         }
         System.out.println("\n Polinomio Reconstruido: ");

         System.out.println(s);
    }//Fin reconstruir
}//Fin class
    
    


