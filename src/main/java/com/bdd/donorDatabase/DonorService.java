package com.bdd.donorDatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DonorService {
    static List<Donor> donorList; //= new ArrayList<Donor>();

    public String addNewDonor(Donor d){
        String result ="";
        if(!checkIfDonorExist(d)){
            donorList.add(d);
            result="added";
        }else{
            //throw donor exist exception
            result="existing";
        }
        return result;
    }

    public Donor findDonorUsingName(String name){
        Optional<Donor> d = donorList.stream()
                //check for full name match. doesn't provide partial match
                .filter(donor -> donor.getName().toLowerCase().contains(name.toLowerCase()))
                .findFirst(); //Note: if 2 people of same name, will return the first
        if(d.isPresent()){
            return d.get();
        }else{
            return null;
            //log error donor not found
        }
    }
    private static boolean checkIfDonorExist(Donor d){
        return donorList.contains(d);
    }

    public static void setDonorList(List<Donor> donorList) {
        DonorService.donorList = donorList;
    }
}
