/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.util.HashSet;
import javax.swing.JOptionPane;

/**
 *
 * @author goku3
 */
public class Forma1 {
    //Atributos.
    private int Vpf1[], Du, n;
    
     //metodos.
    public Forma1(int tam)//Constructor 
    {
        
        n = tam;
        Du=n-1;
        Vpf1 = new int[n];                     
    }   
    
    public Forma1()//Sobrecarga de Constructor 
    {       
        Du=n-1;
        Vpf1 = new int[n];               
        
    }   
    public int[] getVpf1() {
        return Vpf1;
    }

    public int getDu() {
        return Du;
    }

    public int getN() {
        return n;
    }

    public void setVpf1(int[] Vpf1) {
        this.Vpf1 = Vpf1;
    }

    public void setDu(int Du) {
        this.Du = Du;
    }

    public void setN(int n) {
        this.n = n;
    }
    
    public int getVpf1(int pos) {
        return Vpf1[pos]; 
    }
    
    public void setVpf1(int pos, int d) {
        Vpf1[pos] = d;
    }
    public  Forma1 ConvertirF1(String Vs[], Forma1 pf1)//convertir BUENO
    {     
        int i = 0 ,Grado=0, K=0 , Pos , h=0 ;   
        int Aux[]=new int[Vs.length];
        for(int j=0;Vs[i]!=null;j++){
            Aux[j]=Integer.parseInt(Vs[i]);
            i++;            
        }
        for(int p=1;p <=Aux.length-2 ;p+=2)
        {
            if(Grado < Aux[p]){
                Grado=Aux[p];
            }            
        }                      
        pf1.setN(Grado+2);
        pf1.setDu(Grado+1);
        pf1.Vpf1 = new int [Grado+2];        
        pf1.setVpf1(0, Grado);
        for(int j=0;Aux[j] !=0 ;j+=2){
            Pos=pf1.Du-Aux[j+1];
            pf1.setVpf1(Pos, Aux[j]);
        }      
        return pf1;        
    }//Fin COnvertirF1
    
    public Forma1 redimensionar(Forma1 a)//por probar
    {
        Forma1 newVpf1;
        newVpf1 = new Forma1(a.getDu());
        newVpf1.setDu(a.getDu());
        for (int i = 0; i <newVpf1.getDu(); i++)
        {
            newVpf1.setVpf1(i,getVpf1(i));          
        }
        return newVpf1;
    }
    
    public void evaluarPolinomiof1(Forma1 a)//Evaluar BUENO!!!
    {
        int i =1,x,exp  , resul=0;
        x = Integer.parseInt((JOptionPane.showInputDialog(null, "Ingrese un valor para x: ")));
        while(i<=a.getDu())
        {
            exp=a.getDu()-i;
            if(a.getVpf1(i)==1 && a.getVpf1(i)==-1)
            {
                resul+=x;
            }
            if (exp ==0)
            {
                resul = resul + a.getVpf1(i);
            }
            else 
            {      
                resul =(int) (resul +  (a.getVpf1(i)*(Math.pow(x,exp))));
            }
            i++;
        }
        System.out.println("\nEl resultado del polinomio evaluado es: \n"+resul);
    }//Evaluar polinomio
   
    public Forma1 sumar(Forma1 a, Forma1 b, Forma1  c)//MALO
    {   
        int i=1, k=1,j=1, expA, expB;
        if (a.getDu()<b.getDu())
        {
            c.Du=b.Du;
            c.setVpf1(0,c.getDu()-1);
        }
        else
        {
            if (b.getDu()<a.getDu())
            {
                c.setDu(a.getDu());
                c.setVpf1(0,c.getDu()-1);
            }
        }
        while(k<=c.getDu())
        {   
            expA=a.getDu()-i;
            expB=b.getDu()-j;
            if(expA==expB)
            {
                c.setVpf1(k,a.getVpf1(i)+b.getVpf1(j));
                i++;
                j++;
                k++;
            }
            else
            {
                if(expA>expB)
                {

                    c.setVpf1(k, a.getVpf1(i));
                    i++;
                    k++;
                }
                else
                {
                    c.setVpf1(k, b.getVpf1(j));
                    i++;
                    k++;
                }
            }
        }
        c.Ajustar(c);
        return c;
    }//Fin suma  
    
    public Forma1 Ajustar(Forma1 a)//Por probar
    {
        int cont=0, i=1;
        if(this.getVpf1(1)==0)
        {
             while(i<=a.getDu()-1)
            {
                if(a.getVpf1(i)==0)
                {
                    cont++;
                }
                else
                {
                    
                }
                i++;       
            }
            for (int j = 0; j <a.getDu()-1; j++) {
                a.setVpf1(a.getVpf1(j), j-cont);
            }
            a.setDu(a.getDu()-cont);
            a.setVpf1(a.getDu()-2,0);
        }else{
            System.out.println("No es apto para Ajustarse.");
        }      
        return a;
    }//Fin ajustar
    
    public void mostrar(Forma1 a)//Mostrar BUENO
    {      
        for (int i = 0; i <= a.getDu(); i++)
        {
            System.out.print("|" + a.getVpf1(i));
        }//Fin for     
    }//Fin mostrar
    
    public  void reconstruir()//BUENO
    {//Reconstruir polinomio en forma 1
        int Exp;        
        for (int i = 1; i <= getN() - 1; i++) {
            if (getVpf1(i) != 0) {
                if (getVpf1(i) < 0) {
                    if (getVpf1(i) < 0 && getVpf1(i) != -1) {
                        System.out.print(getVpf1(i));
                        Exp = getDu() - i;
                        if (Exp != 0) {
                            if (Exp == 1) {
                                System.out.print("x");
                            } else {
                                System.out.print("x^" + Exp);
                            }
                        } 
                    } else {
                        Exp = getDu() - i;
                        if (Exp != 0) {
                            if (Exp == 1) {
                                System.out.print("-x");
                            } else {
                                System.out.print("-x^" + Exp);
                            }
                        }else{
                            System.out.print(getVpf1(i));
                        }                  
                    }
                } else {
                    if (i != 1) {
                        if (getVpf1(i) > 0 && getVpf1(i) != 1) {
                            System.out.print("+" + getVpf1(i));
                            Exp = getDu() - i;
                            if (Exp != 0) {
                                if (Exp == 1) {
                                    System.out.print("x");
                                } else {
                                    System.out.print("x^" + Exp);
                                }//else
                            } /*else {
                                System.out.print("+" + getVpF1(i));
                            }*/
                        } else {
                            Exp = getDu() - i;
                            if (Exp != 0) {
                                if (Exp == 1) {
                                    System.out.print("x");
                                } else {
                                    System.out.print("x^" + Exp);
                                }//else
                            } else {
                                System.out.print("+" + getVpf1(i));
                            }
                        }
                    } else {
                        if (getVpf1(i) > 0 && getVpf1(i) != 1) {
                            System.out.print(getVpf1(i));
                            Exp = getDu() - i;
                            if (Exp != 0) {
                                if (Exp == 1) {
                                    System.out.print("x");
                                } else {
                                    System.out.print("x^" + Exp);
                                }//else
                            } else {
                                System.out.print("+" + getVpf1(i));
                            }
                        } else {
                            Exp = getDu() - i;
                            if (Exp != 0) {
                                if (Exp == 1) {
                                    System.out.print("x");
                                } else {
                                    System.out.print("x^" + Exp);
                                }//else
                            } else {
                                System.out.print("+" + getVpf1(i));
                            }
                        }
                    }
                }//else
            }
        }//fin for
        System.out.println("\n");
    }//fin reconstruir.            
    public static Forma1 insertarTermino(Forma1 a,int coe, int exp)//Fredi momento
    {
        if(a.getDu()==exp)
        {
            a.setVpf1(coe, a.getDu()-exp-1);
        }else if(a.getDu()-2>=exp)
        {
            a.setVpf1(coe, a.getDu()-exp-1);
        }else{
            System.out.println("");
        }
        if(a.getVpf1(1)==0){
            a.Ajustar(a);
        }
        return a;
    }//Fin Insertar termino
    
    public Forma1 borrarTermino(int coe, int exp)
    {
        Forma1 aux=null;
        int  i=1, expA=0, x=0, pos=0;
        x=exp-this.getVpf1(0);
        //2x^2+x+1
        if(exp > this.Vpf1[0])
        {
            System.out.println("");
        }
        else
        {
            for (int j = 0; j < this.getDu(); j++)
            {
                expA=this.getDu()-j;
                if(expA==exp) //en el caso de que exponen sea igual al grado
                {
                    //buscar y sumar
                    while(i<=this.getDu())
                    {
                        expA=this.getDu()-i;
                        if(expA==exp)
                        {
                            this.setVpf1(i, this.getVpf1(i)+coe);
                        }
                        i++;
                    }
                    System.out.println("");
                    System.out.println("El nuevo forma 1 es:");
                    for(i=0; i<=this.getDu(); i++)
                    {
                        System.out.print("|"+this.getVpf1(i));
                    }
                 }
            }      
            
        }//FIn else
        return this;
    }//Fin BorrarTermino
    public Forma1 multiplicacionF1(Forma1 a, Forma1 b)//Mala
    {        
        int expA=0, expB=0, expR=0, posR=0;
        int coe;
        Forma1 c = new Forma1(a.getVpf1(0)+b.getVpf1(0));
        
        for (int i = 1; i <(b.getVpf1(0)+2); i++) 
        {
            expB=b.getDu()-i;
            for (int j = 1; j<(a.getVpf1(0)+2); j++) 
            {
                expA=a.getDu()-j;
                expR=expA+expB;
                c.setN(expR+1);
                coe=a.getVpf1(j)*b.getVpf1(i);
                posR=c.getDu()-expR;
                c.Vpf1[posR]=posR+coe;
            }
        }
        return c;
 
    }//FIn multiplicacion

    private void pow() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}//Fin class

