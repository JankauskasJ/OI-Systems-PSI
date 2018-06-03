package oi_systems.h4h;

import android.app.Application;

import java.util.ArrayList;
import java.util.ListIterator;

/**
 * Created by Šarūnas on 2018-06-03.
 */

public class Database extends Application{
    public ArrayList<Account> accounts;
    public ArrayList<Job> jobs;

    @Override
    public void onCreate() {
        super.onCreate();

        accounts = new ArrayList<Account>();
        SeedAcounts();

        jobs = new ArrayList<Job>();
        SeedJobs();
    }

    private void SeedAcounts(){
        accounts.add(new Account(
                "Jonas",
                "Jonaitis",
                "jonukas@gmail.com",
                "qwerty",
                "Didlaukio 59",
                "866852696"
        ));
        accounts.add(new Account(
                "Ona",
                "Onute",
                "xxxxxxx@gmail.com",
                "12345",
                "Naugarduko g. 24",
                "867891235"
        ));
        accounts.add(new Account(
                "Example",
                "Example",
                "example@gmail.com",
                "example",
                "Example ex",
                "869999999"
        ));
        accounts.add(new Account(
                "a",
                "a",
                "a",
                "a",
                "a",
                "869999999"
        ));
    }

    private void SeedJobs(){
        jobs.add(new Job(
                "Išnešti šiukšles",
                "",
                "Laukiama pagalbos"
        ));
        jobs.add(new Job(
                "Pavedžioti šunį",
                "",
                "Laukiama pagalbos"
        ));
        jobs.add(new Job(
                "Nuplauti mašiną",
                "",
                "Laukiama pagalbos"
        ));
        jobs.add(new Job(
                "Nupirkti prekių",
                "",
                "Laukiama pagalbos"
        ));
        jobs.add(new Job(
                "Sutvarkyti namus",
                "",
                "Laukiama pagalbos"
        ));
        jobs.add(new Job(
                "Pakeisti lemputę",
                "",
                "Laukiama pagalbos"
        ));
        jobs.add(new Job(
                "Nuvežti į miestą",
                "",
                "Laukiama pagalbos"
        ));

    }

    public boolean findAccountEmail(String email){
        ListIterator<Account> list = accounts.listIterator();
        while(list.hasNext()){
            if(list.next().getEmail().equals(email))
                return true;
        }
        return false;
    }

    public int getIdByEmail(String email){
        ListIterator<Account> list = accounts.listIterator();
        while(list.hasNext()){
            if(list.next().getEmail().equals(email))
                return list.next().getId();
        }
        return -1;
    }

    public boolean checkPassword(int id, String password){
        if(accounts.get(id).getPassword().equals(password))
            return true;
        else return false;
    }
}
