package br.com.ligeiro.cs.domain.model;



import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;


/**
 * Created by Fernando on 01/11/16.
 */

public class Repository {

    @SerializedName("total_count")
    @Expose
    private Double totalCount;
    @SerializedName("incomplete_results")
    @Expose
    private Boolean incompleteResults;
    @SerializedName("items")
    @Expose
    private List<Item> items = new ArrayList<Item>();


    /**
     *
     * @return
     * The totalCount
     */
    public double getTotalCount() {
        return totalCount;
    }

    /**
     *
     * @param totalCount
     * The total_count
     */
    public void setTotalCount(double totalCount) {
        this.totalCount = totalCount;
    }

    /**
     *
     * @return
     * The incompleteResults
     */
    public Boolean getIncompleteResults() {
        return incompleteResults;
    }

    /**
     *
     * @param incompleteResults
     * The incomplete_results
     */
    public void setIncompleteResults(Boolean incompleteResults) {
        this.incompleteResults = incompleteResults;
    }

    /**
     *
     * @return
     * The items
     */
    public List<Item> getItems() {
        return items;
    }

    /**
     *
     * @param items
     * The items
     */
    public void setItems(List<Item> items) {
        this.items = items;
    }


}
