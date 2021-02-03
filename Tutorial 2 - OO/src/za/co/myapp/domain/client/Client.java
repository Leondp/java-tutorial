package za.co.myapp.domain.client;

import za.co.myapp.domain.policy.Policy;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Client extends Object {
    private String idNumber;
    private String name;
    private String surname;
    private boolean smoking;
    int age;

    List<Policy> policyList = new ArrayList<Policy>();

    public Client(String idNumber, String name, String surname, boolean smoking, int age) {
        this.idNumber = idNumber;
        this.name = name;
        this.surname = surname;
        this.smoking = smoking;
        this.age = age;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public boolean isSmoking() {
        return smoking;
    }

    public void setSmoking(boolean smoking) {
        this.smoking = smoking;
    }

    public void addPolicy(Policy... policy) {
        this.policyList.addAll(Arrays.asList(policy));
    }

    public void removePolicy(Policy policy) {
        this.policyList.remove(policy);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public BigDecimal getPremium() {
        BigDecimal premium = BigDecimal.ZERO;

        for (Policy policy: this.policyList) {
            premium = premium.add(policy.getPremium());
        }

        return premium;
    }

    public BigDecimal getPremiumWithStreamingApi() {
        return this.policyList.stream()
                .map(Policy::getPremium)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Client: ");
        sb.append(this.name);
        sb.append(" ");
        sb.append(this.surname);
        sb.append(System.lineSeparator());

        sb.append("Policies");
        sb.append(System.lineSeparator());
        for (Policy policy : policyList) {
            sb.append(policy);
            sb.append(System.lineSeparator());
        }

        sb.append(System.lineSeparator());

        return sb.toString();
    }

}
