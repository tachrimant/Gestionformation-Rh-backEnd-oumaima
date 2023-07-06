package com.example.demo.zynerator.specification;


import com.example.demo.zynerator.audit.AuditBusinessObject;
import com.example.demo.zynerator.criteria.BaseCriteria;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractSpecification<Criteria extends BaseCriteria, T extends AuditBusinessObject> extends SpecificationHelper<Criteria, T> implements Specification<T> {

    @Override
    public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
        List<Predicate> predicates = new ArrayList<>();
        attachSearchElement(root, query, builder, predicates);
        if (criteria != null) {
            constructPredicates();
            addOrderAndFilter();
        }
        return getResult();
    }


    public abstract void constructPredicates();

    public AbstractSpecification(Criteria criteria) {
        this.criteria = criteria;
    }

    public AbstractSpecification(Criteria criteria, boolean distinct) {
        this.criteria = criteria;
        this.distinct = distinct;
    }


}
