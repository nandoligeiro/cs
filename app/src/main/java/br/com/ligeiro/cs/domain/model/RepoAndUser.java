package br.com.ligeiro.cs.domain.model;

import java.util.ArrayList;

import br.com.ligeiro.cs.domain.model.repo.Item;
import br.com.ligeiro.cs.domain.model.repo.Repository;
import br.com.ligeiro.cs.domain.model.repo.User;

/**
 * Created by fernando.c.moreira on 06/11/2016.
 */

public class RepoAndUser {


    public ArrayList<Item> items;
    public ArrayList<User> users;


    public RepoAndUser(ArrayList<Item> items, ArrayList<User> users) {
        this.items = items;
        this.users = users;
    }

}
