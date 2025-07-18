package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private String memberId;
    private String name;
    private List<Loan> loanList;

    public User(String name){
        this.memberId = UUID.randomUUID().toString();
        this.name = name;
        loanList = new ArrayList<>();
    }

    public int getBorrowedCount(){
        return loanList.size();
    }

    public void addLoan(Loan loan){
        loanList.add(loan);
    }

    public void removeLoan(Loan loan){
        loanList.remove(loan);
    }

}
