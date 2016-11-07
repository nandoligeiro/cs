package br.com.ligeiro.cs.dagger.scope;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by fernando.c.moreira on 04/11/2016.
 */

@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface PerFragment {

}
