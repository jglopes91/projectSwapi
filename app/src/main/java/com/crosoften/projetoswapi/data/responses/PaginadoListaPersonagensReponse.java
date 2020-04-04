package com.crosoften.projetoswapi.data.responses;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PaginadoListaPersonagensReponse {
    @SerializedName("count")
    private Integer count;
    @SerializedName("next")
    private String next;
    @SerializedName("previous")
    private String previous;
    @SerializedName("results")
    private List<ListaPersonagensRespose> results;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    public List<ListaPersonagensRespose> getResults() {
        return results;
    }

    public void setResults(List<ListaPersonagensRespose> results) {
        this.results = results;
    }
}
