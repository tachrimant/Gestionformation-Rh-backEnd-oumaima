package com.example.demo.zynerator.criteria;

public class BaseCriteriaEnhanced extends BaseCriteria {

    /**
     * Fields.
     */

    protected boolean actif;
    protected boolean actifLike;

    protected String ordreLike;
    protected String ordre;


    /**
     * Methods.
     */

    public boolean isActif() {
        return actif;
    }

    public void setActif(boolean actif) {
        this.actif = actif;
    }

    public boolean isActifLike() {
        return actifLike;
    }

    public void setActifLike(boolean actifLike) {
        this.actifLike = actifLike;
    }

    public String getOrdreLike() {
        return ordreLike;
    }

    public void setOrdreLike(String ordreLike) {
        this.ordreLike = ordreLike;
    }

    public String getOrdre() {
        return ordre;
    }

    public void setOrdre(String ordre) {
        this.ordre = ordre;
    }
}
