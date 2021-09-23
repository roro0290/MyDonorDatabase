package com.bdd.donorDatabase;

public class DonorController {
    DonorService donorService; //= new DonorService();

    public String addDonor(Donor d){
        return donorService.addNewDonor(d);
    }

    public Donor findDonorUsingName(String s){ return donorService.findDonorUsingName(s);}

    public void setDonorService(DonorService donorService){
        this.donorService = donorService;
    }
}
