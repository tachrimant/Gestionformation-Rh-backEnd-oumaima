package com.example.demo.zynerator.specification;


import com.example.demo.zynerator.audit.AuditBusinessObjectEnhanced;
import com.example.demo.zynerator.criteria.BaseCriteriaEnhanced;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractSpecificationEnhanced<Criteria extends BaseCriteriaEnhanced, T extends AuditBusinessObjectEnhanced> extends AbstractSpecification<Criteria, T> {


    public AbstractSpecificationEnhanced(Criteria criteria) {
        super(criteria);
    }

    public AbstractSpecificationEnhanced(Criteria criteria, boolean distinct) {
        super(criteria, distinct);
    }


    @Override
    public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
        List<Predicate> predicates = new ArrayList<>();
        attachSearchElement(root, query, builder, predicates);
        if (criteria != null) {
            addEnhacedPredicate();
            constructPredicates();
            addOrderAndFilter();
        }
        return getResult();
    }

    private void addEnhacedPredicate() {
        addPredicateBool("actif", criteria.isActif());
        addPredicate("ordre", criteria.getOrdre(), criteria.getOrdreLike());
    }


}
