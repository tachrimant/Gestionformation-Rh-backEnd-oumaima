package com.example.demo.zynerator.service;

import com.example.demo.zynerator.audit.AuditBusinessObjectEnhanced;
import com.example.demo.zynerator.criteria.BaseCriteria;
import com.example.demo.zynerator.history.HistBusinessObject;
import com.example.demo.zynerator.history.HistCriteria;
import com.example.demo.zynerator.repository.AbstractHistoryRepository;
import com.example.demo.zynerator.repository.AbstractRepository;

public abstract class AbstractReferentielServiceImpl<T extends AuditBusinessObjectEnhanced, H extends HistBusinessObject, CRITERIA extends BaseCriteria, HC extends HistCriteria, REPO extends AbstractRepository<T, Long>, HISTREPO extends AbstractHistoryRepository<H, Long>> extends AbstractServiceImpl<T, H, CRITERIA, HC, REPO, HISTREPO> {

    public AbstractReferentielServiceImpl(REPO dao, HISTREPO historyRepository) {
        super(dao, historyRepository);
    }

}