package com.example.demo.zynerator.converter;


import com.example.demo.zynerator.audit.AuditBusinessObjectEnhanced;
import com.example.demo.zynerator.bean.BusinessObject;
import com.example.demo.zynerator.dto.AuditBaseDtoEnhanced;
import com.example.demo.zynerator.util.StringUtil;

public abstract class AbstractConverterEnhanced<T extends AuditBusinessObjectEnhanced, DTO extends AuditBaseDtoEnhanced, H extends BusinessObject> extends AbstractConverter<T,DTO,H>{

    protected AbstractConverterEnhanced(Class<T> itemType, Class<DTO> dtoType, Class<H> historyType) {
                super(itemType,dtoType,historyType);
    }


    public void convertRefentielAttribute(DTO dto, T item) {
        if (dto.getActif() != null) {
            item.setActif(dto.getActif());
        }
        if (StringUtil.isNotEmpty(dto.getHl7())) {
            item.setHl7(dto.getHl7());
        }
        if (StringUtil.isNotEmpty(dto.getOrdre())) {
            item.setOrdre(dto.getOrdre());
        }
    }

    public void convertRefentielAttribute(T item, DTO dto) {
        if (item.getActif() != null) {
            dto.setActif(item.getActif());
        }
        if (StringUtil.isNotEmpty(item.getHl7())) {
            dto.setHl7(item.getHl7());
        }
        if (StringUtil.isNotEmpty(item.getOrdre())) {
            dto.setOrdre(item.getOrdre());
        }
    }

}
