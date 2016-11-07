package br.com.ligeiro.cs.domain.model;

import java.util.ArrayList;

import br.com.ligeiro.cs.domain.model.pulls.Pull;
import br.com.ligeiro.cs.domain.model.repo.User;

/**
 * Created by fernando.c.moreira on 04/11/2016.
 */

public class PullAndUser {

    public ArrayList<Pull> pulls;
    public ArrayList<User> users;

    public PullAndUser(ArrayList<Pull> pulls, ArrayList<User> users) {

        this.pulls = pulls;
        this.users = users;

    }
}
