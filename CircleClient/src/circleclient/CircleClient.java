/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package circleclient;

import java.io.StringReader;
import java.util.Scanner;
import javax.xml.bind.JAXB;
import model.Result;
import util.CircleJerseyClient;

/**
 *
 * @author Storm
 */
public class CircleClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        double r = EnterData();
        Calculate(r);
    }
    static double EnterData(){
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter radius : ");
        double radius = scan.nextDouble();
        return radius;
    }
    static void Calculate(double radius){
        CircleJerseyClient obj = new CircleJerseyClient();
        String result = String.valueOf(radius);
        String xml = obj.getXml(result);
        Result res = JAXB.unmarshal(new StringReader(xml), Result.class);
        System.out.println("area is "+res.getArea());  
        System.out.println("circumference is "+res.getCircumference());
    }
}
