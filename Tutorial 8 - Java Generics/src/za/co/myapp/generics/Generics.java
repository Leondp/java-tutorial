package za.co.myapp.generics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import za.co.myapp.domain.Container;
import za.co.myapp.domain.GenericContainer;
import za.co.myapp.domain.InvestoPolicy;
import za.co.myapp.domain.MyriadPolicy;
import za.co.myapp.domain.Policy;

public class Generics {

    public static void main(String[] args) {
        polymorphism();
        generics();
        genericsExtends();
        genericsExtendsWildCart();
        genericsContainer();
        genericsGenericContainer();
    }
    
    
    private static void polymorphism() {

        Policy policy = null;
        MyriadPolicy myriadPolicy = new MyriadPolicy();
        InvestoPolicy investoPolicy = new InvestoPolicy();

        policy = myriadPolicy;

        System.out.println("Myriad Benefit Name: " + myriadPolicy.getMyriadBenefitName());
        
        printPolicy(policy);
        printPolicy(investoPolicy);
    }

    private static void printPolicy(Policy policy) {
        System.out.println("Name of Policy:" + policy.getName());
    }
    
    
    private static void generics() {

        List<Policy> policyList = new ArrayList<>();
        
        MyriadPolicy myriadPolicy = new MyriadPolicy();
        InvestoPolicy investoPolicy = new InvestoPolicy();
        
        policyList.add(myriadPolicy);
        policyList.add(investoPolicy);

        printPolicyList(policyList);
    }
    
    private static void printPolicyList(List<Policy> policyList) {
        policyList.forEach((policy) -> System.out.println("Name of Policy: " + policy.getName()));
    }
 
    private static void genericsExtends() {

        List<MyriadPolicy> policyList = new ArrayList<>();
        
        MyriadPolicy myriadPolicy1 = new MyriadPolicy();
        MyriadPolicy myriadPolicy2 = new MyriadPolicy();
        
        policyList.add(myriadPolicy1);
        policyList.add(myriadPolicy2);

        printAnyPolicyList(policyList);
    }
    
    private static <E extends Policy> void printAnyPolicyList(List<E> policyList) {
        policyList.forEach((policy) -> System.out.println("Name of Policy: " + policy.getName()));
    }
    
    
    private static void genericsExtendsWildCart() {

        List<MyriadPolicy> policyList = new ArrayList<>();
        
        MyriadPolicy myriadPolicy1 = new MyriadPolicy();
        MyriadPolicy myriadPolicy2 = new MyriadPolicy();
        
        policyList.add(myriadPolicy1);
        policyList.add(myriadPolicy2);

        printAnyPolicyListWildcart(policyList);
    }
    
    private static void printAnyPolicyListWildcart(List<? extends Policy> policyList) {
        policyList.forEach((policy) -> System.out.println("Name of Policy: " + policy.getName()));
    }
    
    
    private static void genericsContainer() {
        Container container = new Container("John", "Mary");
        List<String> values = container.getValues();
    }

    private static void genericsGenericContainer() {
        GenericContainer<Double, Integer> container = new GenericContainer<>(7.7, 4.4, 3);
        List<Double> values = container.getValues();
        container.getValue3();
    }
    
}
